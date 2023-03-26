package com.payment.paymentAPI.types;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Data
public class Sale {
    private OffsetDateTime datetime;
    private BigDecimal sales;
    private BigInteger points;
}
