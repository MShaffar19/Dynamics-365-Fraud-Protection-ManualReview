// Copyright (c) Microsoft Corporation.
// Licensed under the MIT license.

package com.griddynamics.msd365fp.manualreview.queues.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class WebClientConfig {

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService clientService) {

        OAuth2AuthorizedClientProvider authorizedClientProvider =
                OAuth2AuthorizedClientProviderBuilder.builder()
                        .refreshToken()
                        .clientCredentials()
                        .build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(
                        clientRegistrationRepository, clientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        return authorizedClientManager;
    }

    @Bean
    @Primary
    WebClient azureDFPAPIWebClient(OAuth2AuthorizedClientManager authorizedClientManager, ObjectMapper mapper) {
        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client =
                new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth2Client.setDefaultClientRegistrationId(Constants.CLIENT_REGISTRATION_AZURE_DFP_API);
        Consumer<ClientCodecConfigurer> clientCodecConfigurerConsumer = clientCodecConfigurer -> clientCodecConfigurer
                        .defaultCodecs()
                        .jackson2JsonEncoder(new Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON));
        return WebClient.builder()
                .filter(logRequestFilter())
                .apply(oauth2Client.oauth2Configuration())
                .exchangeStrategies(ExchangeStrategies
                        .builder()
                        .codecs(clientCodecConfigurerConsumer)
                        .codecs(configurer -> configurer.customCodecs().registerWithDefaultConfig(new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_OCTET_STREAM)))
                        .build())
                .build();
    }

    @Bean
    WebClient azureDFPLAAPIWebClient(OAuth2AuthorizedClientManager authorizedClientManager, ObjectMapper mapper) {
        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client =
                new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth2Client.setDefaultClientRegistrationId(Constants.CLIENT_REGISTRATION_AZURE_DFP_LA_API);
        Consumer<ClientCodecConfigurer> clientCodecConfigurerConsumer = clientCodecConfigurer -> clientCodecConfigurer
                .defaultCodecs()
                .jackson2JsonEncoder(new Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON));
        return WebClient.builder()
                .filter(logRequestFilter())
                .apply(oauth2Client.oauth2Configuration())
                .exchangeStrategies(ExchangeStrategies
                        .builder()
                        .codecs(clientCodecConfigurerConsumer)
                        .codecs(configurer -> configurer.customCodecs().registerWithDefaultConfig(new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_OCTET_STREAM)))
                        .build())
                .build();
    }

    @Bean
    WebClient nonAuthorizingWebClient() {
        return WebClient.builder()
                .build();
    }

    private static ExchangeFilterFunction logRequestFilter() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Calling Azure DFP API via Web Client: {} {}", clientRequest.method(), clientRequest.url());
            return Mono.just(clientRequest);
        });
    }
}
