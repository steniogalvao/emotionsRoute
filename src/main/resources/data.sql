--loading standard data 

INSERT INTO agency (id, deleted, email, name, password, rate, user_role, user_type, address_id, cnpj) VALUES(1, 0, 'agency@agency.com', 'agency', 'pass', 0, 'ADMIN','AGENCY', 1, '123879871231');
INSERT INTO person (id, deleted, email, name, password, rate, user_role, user_type, address_id, doc_number, doc_type) VALUES(2, 0, 'steniogalvao@gmail.com', 'stenio galvao', 'realSeriousPassword$1', 0, 'ADMIN','PERSON', 2, '12345678985', 'CPF');
INSERT INTO equipament (id, deleted, value, description, name, rented) VALUES(3, 0, 50.50, 'gopro 7', 'gopro', 0);
INSERT INTO user_phones (user_id, phones) VALUES(1, '17823991');
INSERT INTO user_phones (user_id, phones) VALUES(2, '++558688888888');
INSERT INTO user_phones (user_id, phones) VALUES(2, '+400545645645');
INSERT INTO address (id, country, city, neighborhood, `number`, street) VALUES(1, 'Romania', 'Bucharest', 'Sector 1', '177', 'Strata');
INSERT INTO address (id, country, city, neighborhood, `number`, street) VALUES(2, 'Romania', 'Bucharest', 'Sector 2', '999', 'Strata');
INSERT INTO tour (id, city, deleted, description, name, rate) VALUES(1, 'Parnaiba', 0, 'Passeio pelo delta do parnaiba', 'delta', 0);
INSERT INTO tour_item (id, deleted, value, duration, included_description, responsable_id, tour_id) VALUES(1, 0, 150.00, '50', 'what is included ', 1, 1);
INSERT INTO transfer (id, deleted, destiny, origin, transfer_type, tour_id) VALUES(1, 1, 'THE', 'PHB', 'CITY', 1);
