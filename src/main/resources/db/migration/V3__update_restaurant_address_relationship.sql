ALTER TABLE address DROP CONSTRAINT fk_restaurant;

ALTER TABLE address DROP COLUMN restaurant_id;

ALTER TABLE restaurant ADD COLUMN address_id INTEGER UNIQUE;

ALTER TABLE restaurant
ADD CONSTRAINT fk_address
FOREIGN KEY (address_id)
REFERENCES address(id);