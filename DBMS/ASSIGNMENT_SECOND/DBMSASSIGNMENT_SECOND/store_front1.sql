CREATE DATABASE store_front;

SHOW DATABASEs;

USE store_front;

CREATE TABLE user (
    user_id INT NOT NULL auto_increment,
    name VARCHAR(100),
    password VARCHAR(15),
    date_of_birth date,
    gender char(1),
    user_type VARCHAR(10),
    email_id VARCHAR(50),
    PRIMARY KEY(user_id)
    );
    
    
CREATE TABLE contact_number_of_user(
    user_id INT NOT NULL,
    contact_number VARCHAR(12),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
    );
    
    
CREATE TABLE address(
    address_id INT NOT NULL auto_increment,
    user_id INT NOT NULL,
    street VARCHAR(20),
    city VARCHAR(20),
    state VARCHAR(20),
    pin_code VARCHAR(6),
    PRIMARY KEY(address_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
    );
    
   
CREATE TABLE category(
    category_id INT NOT NULL auto_increment,
    category_name VARCHAR(40),
    parent_id INT NOT NULL default 0,
    PRIMARY KEY(category_id)
    );


CREATE TABLE product(
    product_id INT NOT NULL auto_increment,
    category_id INT NOT NULL,
    product_name VARCHAR(50),
    price DOUBLE,
    description VARCHAR(200),
    stock INT NOT NULL,
    PRIMARY KEY(product_id),
    FOREIGN KEY(category_id) REFERENCES category(category_id)
    );
    
    
CREATE TABLE product_image(
    product_id INT NOT NULL,
    image_url VARCHAR(100),
    FOREIGN KEY(product_id) REFERENCES product(product_id)
    );
    
    
CREATE TABLE cart(
    product_id INT NOT NULL,
    user_id INT NOT NULL,
    quantity int,
    total_price DOUBLE,
    FOREIGN KEY(product_id) REFERENCES product(product_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
    );
    
    
CREATE TABLE orders(
    order_id INT NOT NULL auto_increment,
    user_id INT NOT NULL,
    address_id INT NOT NULL,
    order_date date,
    delivery_date date,
    total_price DOUBLE,
    PRIMARY KEY(order_id),
    FOREIGN KEY(address_id) REFERENCES address(address_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
    );
    
    
    
CREATE TABLE status(
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    status VARCHAR(12) CHECK(status IN ('Shipped', 'Cancelled', 'Returned', 'Not Shipped')),
    FOREIGN KEY(order_id) REFERENCES orders(order_id),
    FOREIGN KEY(product_id) REFERENCES product(product_id)
    );
    
    
CREATE TABLE orderedProducts(
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_id,product_id),
    FOREIGN KEY(order_id) REFERENCES orders(order_id),
    FOREIGN KEY(product_id) REFERENCES product(product_id)
    );



SHOW TABLEs;
   
    
