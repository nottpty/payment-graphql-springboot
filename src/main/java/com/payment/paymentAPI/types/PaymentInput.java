package com.payment.paymentAPI.types;

import com.payment.paymentAPI.enums.PaymentMethodEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class PaymentInput {
    private BigDecimal price;
    private BigDecimal priceModifier;
    private PaymentMethodEnum paymentMethod;
    private OffsetDateTime datetime;
}
