-- Create the payment_method table
CREATE TABLE IF NOT EXISTS payment_method (
                                              id SERIAL PRIMARY KEY,
                                              name payment_method_enum NOT NULL,
                                              price_modifier_min DECIMAL(4, 2) NOT NULL,
    price_modifier_max DECIMAL(4, 2) NOT NULL,
    points DECIMAL(4, 2) NOT NULL
    );
CREATE INDEX idx_payment_method_name ON payment_method(name);