-- Create the payment_transaction table
CREATE TABLE IF NOT EXISTS payment_transaction (
                                                   id SERIAL PRIMARY KEY,
                                                   price DECIMAL(16, 2) NOT NULL,
    price_modifier DECIMAL(4, 2) NOT NULL,
    payment_method payment_method_enum NOT NULL,
    datetime TIMESTAMP NOT NULL,
    final_price DECIMAL(16, 2) NOT NULL,
    points INTEGER NOT NULL
    );
CREATE INDEX idx_payment_transaction_datetime ON payment_transaction(datetime);