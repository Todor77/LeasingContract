INSERT INTO leasing_db.brand (id, name) VALUES (1, 'BMW');
INSERT INTO leasing_db.brand (id, name) VALUES (2, 'AUDI');
INSERT INTO leasing_db.brand (id, name) VALUES (3, 'VW');

INSERT INTO leasing_db.model (id, name, brand_id) VALUES (1, '320d', 1);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (2, '530d', 1);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (3, '750i', 1);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (4, 'A4', 2);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (5, 'A5', 2);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (6, 'A7', 2);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (7, 'Golf', 3);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (8, 'Passat', 3);
INSERT INTO leasing_db.model (id, name, brand_id) VALUES (9, 'Arteon', 3);


INSERT INTO leasing_db.customer (id, birth_date, first_name, last_name) VALUES (1, '1980-01-01 01:00:00.000000', 'Max', 'Musterman');
INSERT INTO leasing_db.customer (id, birth_date, first_name, last_name) VALUES (2, '1990-10-14 01:00:00.000000', 'Maria', 'Musterfrau');
INSERT INTO leasing_db.customer (id, birth_date, first_name, last_name) VALUES (3, '1980-01-01 01:00:00.000000', 'Ericka', 'Musterman');


INSERT INTO leasing_db.vehicle (id, available, brand, model, price, vin, year) VALUES (1, false, 'BMW', '320d', 32000, 'vvwsukeoe8dsh3', 2018);
INSERT INTO leasing_db.vehicle (id, available, brand, model, price, vin, year) VALUES (2, false, 'AUDI', 'A7', 27000, 'ezwid74iufkci83', 2022);
INSERT INTO leasing_db.vehicle (id, available, brand, model, price, vin, year) VALUES (3, true, 'VW', 'GOLF', 32000, 'ruewiofkw87', 2021);
INSERT INTO leasing_db.vehicle (id, available, brand, model, price, vin, year) VALUES (4, true, 'BMW', '530d', 32000, 'ruewiofkw87', 2021);
INSERT INTO leasing_db.vehicle (id, available, brand, model, price, vin, year) VALUES (5, true, 'AUDI', 'A5', 32000, 'ruewiofkw87', 2021);


INSERT INTO leasing_db.leasing_contract (id, contract_number, monthly_rate, customer_id, vehicle_id) VALUES (1, 123567, 350, 1, 1);
INSERT INTO leasing_db.leasing_contract (id, contract_number, monthly_rate, customer_id, vehicle_id) VALUES (2, 123568, 365, 2, 2);