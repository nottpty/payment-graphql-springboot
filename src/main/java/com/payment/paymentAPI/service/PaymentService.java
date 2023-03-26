package com.payment.paymentAPI.service;

import com.payment.paymentAPI.enums.ListOrder;
import com.payment.paymentAPI.enums.PaymentMethodEnum;
import com.payment.paymentAPI.model.Payment;
import com.payment.paymentAPI.model.PaymentMethod;
import com.payment.paymentAPI.repository.PaymentMethodRepository;
import com.payment.paymentAPI.repository.PaymentRepository;
import com.payment.paymentAPI.types.NewPayment;
import com.payment.paymentAPI.types.PaymentInput;
import com.payment.paymentAPI.types.Sale;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@AllArgsConstructor
public class PaymentService {

    PaymentRepository paymentRepository;
    PaymentMethodRepository paymentMethodRepository;

    public NewPayment createPayment(PaymentInput paymentInput) {
        PaymentMethod paymentMethod = paymentMethodRepository.findByName(paymentInput.getPaymentMethod()).orElseThrow(() -> new IllegalArgumentException("Invalid payment method"));

        Payment paymentIn = new Payment();
        paymentIn.setPaymentMethod(paymentInput.getPaymentMethod());
        paymentIn.setDatetime(paymentInput.getDatetime());
        paymentIn.setPrice(paymentInput.getPrice());
        paymentIn.setPriceModifier(paymentInput.getPriceModifier());
        BigDecimal finalPrice = paymentInput.getPrice().multiply(paymentInput.getPriceModifier()).setScale(2, RoundingMode.HALF_UP);
        BigInteger points = paymentInput.getPrice().multiply(paymentMethod.getPoints()).setScale(0, RoundingMode.HALF_UP).toBigInteger();
        paymentIn.setFinalPrice(finalPrice);
        paymentIn.setPoints(points);
        Payment paymentOut = paymentRepository.save(paymentIn);
        return new NewPayment(paymentOut);
    }

    public Iterable<Sale> getSaleByStartDateTimeToEndDateTime(OffsetDateTime startDateTime,
                                                              OffsetDateTime endDateTime,
                                                              ListOrder order) {
        List<Payment> payments = paymentRepository.findByDatetimeBetween(startDateTime, endDateTime);
        Map<OffsetDateTime, Sale> salesMap = new LinkedHashMap<>();

        payments.forEach(payment -> {
            OffsetDateTime hourStart = payment.getDatetime().truncatedTo(ChronoUnit.HOURS);
            Sale sale = salesMap.computeIfAbsent(hourStart, key -> {
                Sale newSale = new Sale();
                newSale.setDatetime(key);
                newSale.setSales(BigDecimal.ZERO);
                newSale.setPoints(BigInteger.ZERO);
                return newSale;
            });

            sale.setSales(sale.getSales().add(payment.getFinalPrice()));
            sale.setPoints(sale.getPoints().add(payment.getPoints()));
        });
        List<Sale> sales = new ArrayList<>(salesMap.values());
        if (order != null) {
            switch (order) {
                case ASC -> sales.sort(Comparator.comparing(Sale::getDatetime));
                case DESC -> sales.sort(Comparator.comparing(Sale::getDatetime).reversed());
            }
        }
        return sales;
    }

    public Iterable<Payment> getAllPayment() {return paymentRepository.findAll();}

    public Iterable<Payment> getPaymentByPaymentMethod(PaymentMethodEnum paymentMethodEnum) {
        return paymentRepository.findPaymentByPaymentMethod(paymentMethodEnum);
    }
}
