CREATE TABLE  products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR (255),
    price VARCHAR(255) NOT NULL,
    current_Stock INT
);

CREATE TABLE orders (
    id INT PRIMARY KEY,
    product_id INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);