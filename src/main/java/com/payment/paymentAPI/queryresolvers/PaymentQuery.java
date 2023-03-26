package com.payment.paymentAPI.queryresolvers;

import com.payment.paymentAPI.enums.ListOrder;
import com.payment.paymentAPI.model.Payment;
import com.payment.paymentAPI.service.PaymentService;
import com.payment.paymentAPI.types.PaymentFilter;
import com.payment.paymentAPI.types.Sale;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.OffsetDateTime;

@Controller
@AllArgsConstructor
public class PaymentQuery {
    PaymentService paymentService;

    @QueryMapping
    public Iterable<Payment> getAllPayment() {return paymentService.getAllPayment();}

    @QueryMapping
    public Iterable<Payment> getPaymentByPaymentMethod(@Argument("filter") PaymentFilter paymentFilter) {
        return paymentService.getPaymentByPaymentMethod(paymentFilter.getPaymentMethod());
    }

    @QueryMapping
    public Iterable<Sale> getSaleByStartDateTimeToEndDateTime(@Argument("startDateTime") OffsetDateTime startDateTime,
                                                              @Argument("endDateTime") OffsetDateTime endDateTime,
                                                              @Argument("order") ListOrder order) {
        return paymentService.getSaleByStartDateTimeToEndDateTime(startDateTime, endDateTime, order);
    }
}
