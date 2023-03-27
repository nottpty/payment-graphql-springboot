package com.payment.paymentAPI.exception;

public class PaymentValidationException extends RuntimeException {

    public PaymentValidationException(String errorMessage) {
        super(errorMessage);
    }

}