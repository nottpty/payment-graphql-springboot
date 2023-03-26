package com.payment.paymentAPI.model;

import com.payment.paymentAPI.enums.PaymentMethodEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum name;

    @Column(nullable = false)
    private BigDecimal priceModifierMin;

    @Column(nullable = false)
    private BigDecimal priceModifierMax;

    @Column(nullable = false)
    private BigDecimal points;
}
