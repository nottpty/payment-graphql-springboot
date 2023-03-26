package com.payment.paymentAPI.repository;

import com.payment.paymentAPI.enums.PaymentMethodEnum;
import com.payment.paymentAPI.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findPaymentByPaymentMethod(PaymentMethodEnum paymentMethod);
    List<Payment> findByDatetimeBetween(OffsetDateTime startDateTime, OffsetDateTime endDateTime);
}
