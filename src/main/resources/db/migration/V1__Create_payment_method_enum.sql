-- Create the payment_method_enum type
CREATE TYPE payment_method_enum AS ENUM('CASH', 'CASH_ON_DELIVERY', 'VISA', 'MASTERCARD', 'AMEX', 'JCB');