DROP TABLE shipping;

DROP TABLE transactions;

CREATE TABLE transactions (
tr_id int NOT NULL AUTO_INCREMENT,
order_id int,
user_id int,
tr_amt float,
cc_number int,
cc_exp_date date,
cc_name varchar(50),
status varchar(10),
PRIMARY KEY(tr_id),
FOREIGN KEY (user_id) REFERENCES user(id)
);

SELECT * FROM transactions;
INSERT INTO transactions VALUES (1, 101, 1, 54,1,DATE '2015-12-17', 'abc','success' );

INSERT INTO transactions VALUES (2, 102, 8, 60,1,DATE '2015-12-17', 'abcsdfs','success' );

INSERT INTO transactions VALUES (3, 103, 4, 140,1,DATE '2015-12-17', 'abdsdc','success' );

INSERT INTO transactions VALUES (4, 104, 2, 1056,1,DATE '2015-12-17', 'sdfsabc','success' );

INSERT INTO transactions VALUES (5, 105, 16, 67,1,DATE '2015-12-17', 'afdgbc','success' );

INSERT INTO transactions VALUES (6, 106, 134, 940,1,DATE '2015-12-17', 'adfgbc','success' );

INSERT INTO transactions VALUES (7, 107, 11, 50,1,DATE '2015-12-17', 'adfgbc','success' );

INSERT INTO transactions VALUES (8, 108, 12, 102,1,DATE '2015-12-17', 'aghjgjbc','success' );

INSERT INTO transactions VALUES (9, 109, 104, 70,1,DATE '2015-12-17', 'abeec','success' );

INSERT INTO transactions VALUES (10, 110, 94, 60,1,DATE '2015-12-17', 'atyrtbc','success' );

INSERT INTO transactions VALUES (11, 123, 23, 1000,1,DATE '2015-12-17', 'afgbc','success' );