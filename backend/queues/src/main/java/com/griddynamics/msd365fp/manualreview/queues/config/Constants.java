// Copyright (c) Microsoft Corporation.
// Licensed under the MIT license.

package com.griddynamics.msd365fp.manualreview.queues.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("java:S2386")
public class Constants {

    public static final int TOP_ELEMENT_IN_CONTAINER_PAGE_SIZE = 1;
    public static final String TOP_ELEMENT_IN_CONTAINER_CONTINUATION = null;

    public static final OffsetDateTime ELDEST_APPLICATION_DATE =
            OffsetDateTime.ofInstant(Instant.ofEpochMilli(0), ZoneId.systemDefault());
    public static final Duration DEFAULT_CACHE_INVALIDATION_INTERVAL = Duration.ZERO;
    public static final long DEFAULT_CACHE_SIZE = 0;

    public static final String DEFAULT_QUEUE_PAGE_SIZE_STR = "20";
    public static final int DEFAULT_QUEUE_PAGE_SIZE = 20;
    public static final String DEFAULT_QUEUE_VIEW_PARAMETER_STR = "REGULAR";
    public static final String DEFAULT_ITEM_PAGE_SIZE_STR = "20";
    public static final int DEFAULT_ITEM_PAGE_SIZE = 20;
    public static final int DEFAULT_ITEM_INFO_PAGE_SIZE = 100;

    public static final String ITEMS_CONTAINER_NAME = "Items";
    public static final String QUEUES_CONTAINER_NAME = "Queues";
    public static final String TASK_CONTAINER_NAME = "Tasks";
    public static final String LINK_ANALYSIS_CONTAINER_NAME = "LinkAnalysis";
    public static final String HEALTH_CHECK_CONTAINER_NAME = "HealthChecks";
    public static final String DICTIONARIES_CONTAINER_NAME = "Dictionaries";
    public static final String SETTINGS_CONTAINER_NAME = "ConfigurableAppSettings";
    public static final String SEARCH_QUERIES_CONTAINER_NAME = "SearchQueries";
    public static final String EMAIL_DOMAINS_CONTAINER_NAME = "EmailDomains";

    public static final int DEFAULT_CACHE_CONTROL_SECONDS = 1800;

    public static final String ADMIN_MANAGER_ROLE
            = "ADMIN_MANAGER";
    public static final String SENIOR_ANALYST_ROLE
            = "SENIOR_ANALYST";
    public static final String ANALYST_ROLE
            = "ANALYST";
    public static final String[] USER_ROLES_ALLOWED_FOR_QUEUE_PROCESSING
            = new String[]{ADMIN_MANAGER_ROLE, SENIOR_ANALYST_ROLE, ANALYST_ROLE};
    public static final String[] ROLES_ALLOWED_FOR_ACCESS
            = new String[]{ADMIN_MANAGER_ROLE, SENIOR_ANALYST_ROLE, ANALYST_ROLE};

    public static final long TASK_RUNNER_RATE_MS = 30000L;

    public static final int DIGITS_MAX_VALID_INTEGER = 17;
    public static final int DIGITS_MAX_VALID_FRACTION = 16;

    public static final String MESSAGE_QUEUE_NOT_FOUND = "Queue not found";
    public static final String MESSAGE_ITEM_NOT_FOUND = "Item not found";
    public static final String MESSAGE_NOT_FOUND = "Not found";
    public static final String MESSAGE_ITEM_IS_EMPTY = "Item is empty";
    public static final String MESSAGE_INCORRECT_USER = "Incorrect user";
    public static final String MESSAGE_NO_SUPERVISORS = "No one supervisor is found";
    public static final String MESSAGE_INCORRECT_QUEUE_ASSIGNMENT = "The same person can't be a reviewer and a supervisor";
    public static final String MESSAGE_ITEM_LOCKING_IN_ABSTRACT_QUEUE = "Item can't be locked under an abstract queue";
    public static final String MESSAGE_ITEM_IS_NOT_LOCKED_IN_QUEUE = "Item isn't locked in provided queue";
    public static final String MESSAGE_ITEM_IS_NOT_LOCKED = "Item isn't locked";

    public static final String RESIDUAL_QUEUE_TASK_NAME = "residual-queue-reconciliation-task";
    public static final String QUEUE_SIZE_TASK_NAME = "queue-size-calculation-task";
    public static final String OVERALL_SIZE_TASK_NAME = "overall-size-calculation-task";
    public static final String ITEM_ASSIGNMENT_TASK_NAME = "item-assignment-reconciliation-task";
    public static final String ITEM_UNLOCK_TASK_NAME = "item-unlock-task";
    public static final String DICTIONARY_TASK_NAME = "dictionary-reconciliation-task";
    public static final String ENRICHMENT_TASK_NAME = "item-enrichment-task";
    public static final String QUEUE_ASSIGNMENT_TASK_NAME = "queue-assignment-reconciliation-task";
    public static final String RESOLUTION_SENDING_TASK_NAME = "resolution-sending-task";
    public static final String PRIM_HEALTH_ANALYSIS_TASK_NAME = "prim-health-analysis-task";
    public static final String SEC_HEALTH_ANALYSIS_TASK_NAME = "sec-health-analysis-task";

    public static final String SECURITY_SCHEMA_IMPLICIT = "mr_user_auth";
    public static final String CLIENT_REGISTRATION_AZURE_DFP_API = "azure-dfp-api";
    public static final String CLIENT_REGISTRATION_AZURE_DFP_LA_API = "azure-dfp-la-api";

    public static final String RESIDUAL_QUEUE_NAME = "# Residual Queue";

    public static final int INCORRECT_CONFIG_STATUS = 1;
}
