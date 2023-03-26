package com.payment.paymentAPI.enums;

import graphql.ErrorClassification;

public enum ErrorTypes implements ErrorClassification {
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND ,
    INTERNAL_ERROR
}
