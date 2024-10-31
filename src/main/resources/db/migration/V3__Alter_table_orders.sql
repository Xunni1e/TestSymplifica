ALTER TABLE orders
DROP CONSTRAINT orders_pkey;

ALTER TABLE orders
ADD PRIMARY KEY (id, product_id);
