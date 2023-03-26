package com.payment.paymentAPI.types;

import com.payment.paymentAPI.enums.PaymentMethodEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentFilter {
    private PaymentMethodEnum paymentMethod;
}
