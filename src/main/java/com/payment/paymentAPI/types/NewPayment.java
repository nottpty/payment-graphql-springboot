package com.payment.paymentAPI.types;

import com.payment.paymentAPI.enums.PaymentMethodEnum;
import com.payment.paymentAPI.model.Payment;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Data
public class NewPayment {
    private Long id;
    private PaymentMethodEnum paymentMethod;
    private BigDecimal finalPrice;
    private BigInteger points;
    private OffsetDateTime datetime;

    public NewPayment(Payment payment) {
        this.id = payment.getId();
        this.paymentMethod = payment.getPaymentMethod();
        this.finalPrice = payment.getFinalPrice();
        this.points = payment.getPoints();
        this.datetime = payment.getDatetime();
    }
}
