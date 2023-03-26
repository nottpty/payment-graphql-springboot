package com.payment.paymentAPI.repository;

import com.payment.paymentAPI.enums.PaymentMethodEnum;
import com.payment.paymentAPI.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    Optional<PaymentMethod> findByName(PaymentMethodEnum name);
}
