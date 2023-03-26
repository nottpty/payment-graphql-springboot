-- Insert data into payment_method
INSERT INTO payment_method (name, price_modifier_min, price_modifier_max, points)
VALUES
    ('CASH', 0.9, 1, 0.05),
    ('CASH_ON_DELIVERY', 1, 1.02, 0.05),
    ('VISA', 0.95, 1, 0.03),
    ('MASTERCARD', 0.95, 1, 0.03),
    ('AMEX', 0.98, 1.01, 0.02),
    ('JCB', 0.95, 1, 0.05);