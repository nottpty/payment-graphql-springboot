package com.payment.paymentAPI.exception;

import graphql.GraphQLError;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
class RequestErrorInterceptor implements WebGraphQlInterceptor {

    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {

        return chain.next(request).map(response -> {
            if (response.isValid()) {
                return response;
            }

            List<GraphQLError> errors = response.getErrors().stream()
                    .map(error -> new CustomGraphQLError(error.getMessage()))
                    .collect(Collectors.toList());

            return response.transform(builder -> builder.errors(errors).build());
        });
    }
}