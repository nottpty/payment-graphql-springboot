package com.payment.paymentAPI.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomGraphQLError implements GraphQLError {

    private String message;
    private List<SourceLocation> locations;
    private List<Object> path;

    public CustomGraphQLError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return locations;
    }

    @Override
    public List<Object> getPath() {
        return path;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return null;
    }

    @Override
    public Map<String, Object> toSpecification() {
        Map<String, Object> spec = new HashMap<>();
        spec.put("error", message);
        return spec;
    }
}