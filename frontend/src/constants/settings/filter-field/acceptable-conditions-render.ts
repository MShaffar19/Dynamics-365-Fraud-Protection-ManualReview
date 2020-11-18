// Copyright (c) Microsoft Corporation.
// Licensed under the MIT license.

import { ACCEPTABLE_CONDITIONS } from './acceptable-conditions';

/**
 * Represents all available conditions group types,
 * this enum is treated as mapper for rendering:
 *
 * e.g.: condition group --> render(Component)
 */

export enum ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE {
    NUMERIC,
    TEXT,
    DATE,
    RANGE_NUMERIC,
    RANGE_TEXT,
    RANGE_DATE,
    IN,
    IS_TRUE
}

/**
 * Represents groups of similar "view" (render components) of
 * acceptable conditions (difference between components)
 */
export const ACCEPTABLE_CONDITIONS_RENDER_GROUPS = {
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.NUMERIC]: [
        ACCEPTABLE_CONDITIONS.EQUAL,
        ACCEPTABLE_CONDITIONS.GREATER,
        ACCEPTABLE_CONDITIONS.GREATER_OR_EQUAL,
        ACCEPTABLE_CONDITIONS.LESS,
        ACCEPTABLE_CONDITIONS.LESS_OR_EQUAL,
        ACCEPTABLE_CONDITIONS.NOT_EQUAL,
    ],
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.TEXT]: [
        ACCEPTABLE_CONDITIONS.CONTAINS,
        ACCEPTABLE_CONDITIONS.REGEXP,
        ACCEPTABLE_CONDITIONS.EQUAL_ALPH,
        ACCEPTABLE_CONDITIONS.LESS_ALPH,
        ACCEPTABLE_CONDITIONS.GREATER_ALPH,
        ACCEPTABLE_CONDITIONS.LESS_OR_EQUAL_ALPH,
        ACCEPTABLE_CONDITIONS.GREATER_OR_EQUAL_ALPH,
        ACCEPTABLE_CONDITIONS.NOT_EQUAL_ALPH,
    ],
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.IN]: [
        ACCEPTABLE_CONDITIONS.IN,
    ],
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.DATE]: [
        ACCEPTABLE_CONDITIONS.GREATER_DATE,
        ACCEPTABLE_CONDITIONS.GREATER_OR_EQUAL_DATE,
        ACCEPTABLE_CONDITIONS.LESS_DATE,
        ACCEPTABLE_CONDITIONS.LESS_OR_EQUAL_DATE,
    ],
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.RANGE_NUMERIC]: [
        ACCEPTABLE_CONDITIONS.BETWEEN,
        ACCEPTABLE_CONDITIONS.NOT_BETWEEN,
    ],
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.RANGE_TEXT]: [
        ACCEPTABLE_CONDITIONS.BETWEEN_ALPH,
        ACCEPTABLE_CONDITIONS.NOT_BETWEEN_ALPH,
    ],
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.RANGE_DATE]: [
        ACCEPTABLE_CONDITIONS.BETWEEN_DATE,
        ACCEPTABLE_CONDITIONS.NOT_BETWEEN_DATE
    ],
    [ACCEPTABLE_CONDITIONS_RENDER_GROUP_TYPE.IS_TRUE]: [
        ACCEPTABLE_CONDITIONS.IS_TRUE,
    ]
};