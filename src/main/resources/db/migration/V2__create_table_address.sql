CREATE TABLE address(
    id serial PRIMARY KEY,
    street VARCHAR(250) NOT NULL,
    number VARCHAR(100) NOT NULL,
    complement VARCHAR(100),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(2) NOT NULL,
    cep VARCHAR(150) NOT NULL,
    restaurant_id INTEGER NOT NULL UNIQUE,

    CONSTRAINT fk_restaurant
        FOREIGN KEY (restaurant_id)
        REFERENCES restaurant (id)
        ON DELETE CASCADE



);