package com.payment.paymentAPI.queryresolvers;

import com.payment.paymentAPI.service.PaymentService;
import com.payment.paymentAPI.types.NewPayment;
import com.payment.paymentAPI.types.PaymentInput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@Slf4j
public class PaymentMutation {

    PaymentService paymentService;

    @MutationMapping
    public NewPayment createPayment(@Argument("input") PaymentInput paymentInput) {
        return paymentService.createPayment(paymentInput);
    }
}
