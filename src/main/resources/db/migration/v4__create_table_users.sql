CREATE TABLE users(
id serial PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(260) NOT NULL,
address_id INTEGER UNIQUE

CONSTRAINT fk_address
FOREIGN KEY (address_id)
REFERENCES (address(id))

);