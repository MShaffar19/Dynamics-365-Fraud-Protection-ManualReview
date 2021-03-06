// Copyright (c) Microsoft Corporation.
// Licensed under the MIT license.

/* eslint-disable react/prop-types */

import React from 'react';
import { Text } from '@fluentui/react/lib/Text';
import { ActionButton } from '@fluentui/react/lib/Button';
import { FontIcon } from '@fluentui/react/lib/Icon';
import { Queue } from '../../../models';
import { formatToLocaleDateString } from '../../../utils/date';
import './console-header.scss';

interface DeletedQueue {
    queueId?: string;
    viewId?: string;
    shortId?: string;
    name?: string;
    size?: number;
    created?: string;
}

interface ConsoleHeaderProps {
    queue: Queue | DeletedQueue |null;
    onClickCallback(): void;
    inactiveItem?: boolean;
    backButtonHint?: string;
}

const CN = 'console-header';

export const ConsoleHeader: React.FC<ConsoleHeaderProps> = ({
    queue,
    onClickCallback,
    inactiveItem,
    backButtonHint,
}) => {
    function renderQueueData(queueItem: Queue | DeletedQueue) {
        return (
            <div className={`${CN}__queue-data`}>
                <div className={`${CN}__queue-name`}>
                    <div className={`${CN}__queue-name-queue`}>
                        <Text variant="small">{inactiveItem ? 'Labeled from queue: ' : 'Queue: '}</Text>
                    </div>
                    <div className={`${CN}__queue-name-name`}>
                        <Text variant="small">{queueItem?.name}</Text>
                    </div>
                </div>
                <div>
                    <Text className={`${CN}__meta-title`}>Queue ID:&nbsp;</Text>
                    <div className={`${CN}__queue-id`}>
                        <Text>{ queueItem?.shortId }</Text>
                        <FontIcon iconName="Info" title={queueItem?.viewId} className={`${CN}__queue-id-icon`} />
                    </div>
                    <Text className={`${CN}__meta-title`}>Orders:&nbsp;</Text>
                    <Text className={`${CN}__meta-value`}>
                        { queueItem.size !== undefined ? queueItem.size : 'N/A' }
                    </Text>
                    <Text className={`${CN}__meta-title`}>Created:&nbsp;</Text>
                    <Text className={`${CN}__meta-value`}>
                        { formatToLocaleDateString(queueItem.created, 'N/A') }
                    </Text>
                </div>
            </div>
        );
    }

    return (
        <div className={`${CN}__header`}>
            <ActionButton
                className={`${CN}__back-to-queues-btn`}
                iconProps={{ iconName: 'ChevronLeftSmall', className: `${CN}__back-to-queues-btn-icon` }}
                title={backButtonHint}
                onClick={onClickCallback}
            >
                Back
            </ActionButton>
            { queue ? renderQueueData(queue) : null }
        </div>
    );
};
