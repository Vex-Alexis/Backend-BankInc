INSERT INTO user (DOCUMENT_ID, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES ('1233499868', '123456', 'Alexis', 'Chavarria', 'alexis.chavarria@gmail.com', '3222614015');
INSERT INTO user (DOCUMENT_ID, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES ('987654321', 'password2', 'Laura', 'González', 'laura@example.com', '3219876543');
INSERT INTO user (DOCUMENT_ID, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES ('456789012', 'password3', 'Andrés', 'Ramírez', 'andres@example.com', '3001234567');
INSERT INTO user (DOCUMENT_ID, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES ('567890123', 'password4', 'Marcela', 'Díaz', 'marcela@example.com', '3109876543');
INSERT INTO user (DOCUMENT_ID, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES ('678901234', 'password5', 'Sandra', 'López', 'sandra@example.com', '3151234567');

INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('510510', '5105105105105100', 'Alexis Chavarria', '2026-10-01 10:00:00', 'USD', 1000.00, 'CREDITO', '2023-10-01 10:00:00', 1);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('543212', '5432123456788765', 'Alexis Chavarria', '2026-10-01 10:00:00', 'USD', 1000.00, 'DEBITO', '2023-10-01 10:00:00', 1);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('527123', '5271234567890123', 'Laura González', '2025-08-01 08:00:00', 'USD', 700.00, 'CREDITO', '2022-08-01 08:00:00', 2);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('555555', '5555555555554444', 'Laura González', '2025-08-01 08:00:00', 'USD', 700.00, 'DEBITO', '2022-08-01 08:00:00', 2);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('401288', '4012888888881881', 'Andrés Ramírez', '2024-08-01 08:00:00', 'USD', 3300.00, 'CREDITO', '2021-08-01 08:00:00', 3);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('455656', '4556569878541528', 'Andrés Ramírez', '2024-08-01 08:00:00', 'USD', 3300.00, 'DEBITO', '2021-08-01 08:00:00', 3);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('491777', '4917777777777777', 'Marcela Díaz', '2022-03-01 08:00:00', 'USD', 2400.00, 'CREDITO', '2022-03-01 08:00:00', 4);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('378282', '378282246310005', 'Marcela Díaz', '2022-03-01 08:00:00', 'USD', 2400.00, 'DEBITO', '2022-03-01 08:00:00', 4);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('349512', '349512345678912', 'Sandra López', '2026-03-01 08:00:00', 'USD', 1800.00, 'CREDITO', '2023-03-01 08:00:00', 5);
INSERT INTO Card (product_id, card_number, card_holder_name, expiration_date, currency, balance, card_type, created_at, user_id) VALUES ('371449', '371449635398431', 'Sandra López', '2026-03-01 08:00:00', 'USD', 1800.00, 'DEBITO', '2023-03-01 08:00:00', 5);

INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (100.00, '2023-06-15 14:30:00', 'EXITOSA', 1, 1);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (200.00, '2023-08-15 14:30:00', 'EXITOSA', 1, 2);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (300.00, '2023-10-15 14:30:00', 'RECHAZADA', 1, 1);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (400.00, '2023-12-15 14:30:00', 'ANULADA', 1, 2);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (100.00, '2023-06-15 14:30:00', 'EXITOSA', 2, 3);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (200.00, '2023-08-15 14:30:00', 'EXITOSA', 2, 4);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (300.00, '2023-10-15 14:30:00', 'RECHAZADA', 2, 3);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (400.00, '2023-12-15 14:30:00', 'ANULADA', 2, 4);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (100.00, '2023-06-15 14:30:00', 'EXITOSA', 3, 5);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (200.00, '2023-08-15 14:30:00', 'EXITOSA', 3, 6);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (300.00, '2023-10-15 14:30:00', 'RECHAZADA', 3, 5);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (400.00, '2023-12-15 14:30:00', 'ANULADA', 3, 6);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (100.00, '2023-06-15 14:30:00', 'EXITOSA', 4, 7);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (200.00, '2023-08-15 14:30:00', 'EXITOSA', 4, 8);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (300.00, '2023-10-15 14:30:00', 'RECHAZADA', 4, 7);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (400.00, '2023-12-15 14:30:00', 'ANULADA', 4, 8);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (100.00, '2023-06-15 14:30:00', 'EXITOSA', 5, 9);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (200.00, '2023-08-15 14:30:00', 'EXITOSA', 5, 10);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (300.00, '2023-10-15 14:30:00', 'RECHAZADA', 5, 9);
INSERT INTO Transaction (amount, transaction_date, status, user_id, card_id) VALUES (400.00, '2023-12-15 14:30:00', 'ANULADA', 5, 10);




















