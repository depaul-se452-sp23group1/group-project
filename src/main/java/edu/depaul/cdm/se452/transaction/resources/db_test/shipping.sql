CREATE TABLE shipping(
shp_id int NOT NULL AUTO_INCREMENT,
shp_method varchar(10),
shp_status varchar(15),
address_1 varchar(50),
address_2 varchar(50),
city varchar(25),
state varchar(2),
zip varchar(5),
tr_id int,

PRIMARY KEY(shp_id),
FOREIGN KEY (tr_id) REFERENCES transactions(tr_id)

);

SELECT * FROM shipping;
INSERT INTO shipping VALUES (1, 'express', 'delivered', '555 w abc st', 'apt 123', 'chicago', 'IL', '60601', 1);

INSERT INTO shipping VALUES (2, 'express', 'delivered', '625 w abc st', 'apt 1808', 'chicago', 'IL', '60601', 2);

INSERT INTO shipping VALUES (3, 'standard', 'delivered', '440 n def st', 'apt 2203', 'chicago', 'IL', '60601', 3);

INSERT INTO shipping VALUES (4, 'standard', 'pending', '455 s ghi st', 'apt 3311', 'chicago', 'IL', '60601', 4);

INSERT INTO shipping VALUES (5, 'express', 'delivered', '400 n jkl st', 'apt 3306', 'chicago', 'IL', '60601', 5);

INSERT INTO shipping VALUES (6, 'standard', 'pending', '1 e mno st', 'apt 404', 'chicago', 'IL', '60601', 6);

INSERT INTO shipping VALUES (7, 'express', 'delivered', '640 w pqr st', 'apt 3604', 'chicago', 'IL', '60601', 7);

INSERT INTO shipping VALUES (8, 'standard', 'pending', '475 n stu st', 'apt 3123', 'chicago', 'IL', '60601', 8);
