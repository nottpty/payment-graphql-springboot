package com.payment.paymentAPI.model;

import com.payment.paymentAPI.enums.PaymentMethodEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "payment_transaction")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private BigDecimal priceModifier;

    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    @Column(nullable = false)
    private OffsetDateTime datetime;

    @Column(nullable = false)
    private BigDecimal finalPrice;

    @Column(nullable = false)
    private BigInteger points;
}
