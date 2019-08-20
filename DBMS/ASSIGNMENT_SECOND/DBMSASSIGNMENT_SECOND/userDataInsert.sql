SHOW tables;    

INSERT INTO user (
                name,
                password,
                date_of_birth,
                gender,
                user_type,
                email_id
        ) 
VALUES (
                'Ramesh Kumar Sharma',
                '1234',
                '1998-01-02',
                'm',
                'shopper',
                'ramesh@gmail.com'
    ),(
                'Reena Kumari Sharma',
                '2345',
                '1997-11-02',
                'f',
                'shopper',
                'reenasharma@gmail.com'
    ),(
                'Reena Kumari Sharma',
                '2345',
                '1997-11-02',
                'f',
                'shopper',
                'reenasharma@gmail.com'
    ),(
    		'Ankit Jaishwal',
    		'4567',
    		'1998-11-15',
    		'm',
    		'shopper',
    		'ankit@gmail.com'
    ),(
    		'Nitesh Kumar',
    		'347695',
    		'1995-12-12',
    		'm',
    		'shopper',
    		'nitesh@gmail.com'
    ),(
    		'Mukesh Kumar',
    		'34567',
    		'1996-03-12',
    		'm',
    		'admin',
    		'mukeshkumar@gmail.com'
    );
    
    
    
   



INSERT INTO address(
                    user_id,
                    street,
                    city,
                    state,
                    pin_code
                    ) 
			        VALUES(
                    1,
                    '1 LalKothi',
                    'Jaipur',
                    'Rajasthan',
                    '331112'
                    ),(
                    2,
                    '21 Gandhipath',
                    'Jaipur',
                    'Rajasthan',
                    '334220'
                    ),(
                    3,
                    '20 Gandhipath',
                    'Jaipur',
                    'Rajasthan',
                    '335220'
                    ),(
                    4,
                    '45 Gandhipath',
                    'Jaipur',
                    'Rajasthan',
                    '331820'
                    ),(
                    4,
                    '78 Nagar Nigam',
                    'Jaipur',
                    'Rajasthan',
                    '331227'
                    ),(
                    4,
                    '29 Gandhipath',
                    'Jaipur',
                    'Rajasthan',
                    '331280'
                    );


INSERT INTO category(
                    category_name,
                    parent_id
                    ) 
			        VALUES(
                    'Clothes',
                    0
                    ),(
                    'T-shirt',
                    1
                    ),(
                    'Electronic',
                    0
                    ),(
                    'Mobile',
                    3
                    );


INSERT INTO contact_number_of_user(
                                   user_id,
                                   contact_number
                                  ) 
			                       VALUES(
                                       1,
								                       '7845124578'
								                   ),(
                                       2,
                                       '8965245758'
                                    ),(
                                       2,
                                       '7875124578'
                                    ),(
                                       3,
                                       '7889784578'
                                    ),(
                                       4,
                                       '7845235678'
                                    ),(
                                       5,
                                       '7845124456'
                                    ),(
                                       4,
                                       '9987824578'
                                    ),(
                                       3,
                                       '7845855278'
                                    );


INSERT INTO product(
    		category_id,
    		product_name,
    		price,
    		description,
    		stock
    		) 
	VALUES(
    		 2,
    		'Reebok T-Shirt M',
    		999,
    		'Medium size T-shirt, Red Color',
    		100
    ),(
    		 2,
    		'Reebok T-Shirt L',
    		999,
    		'Large size T-shirt, Black Color',
    		200
    ),(
    		 2,
    		'Reebok T-Shirt XL',
    		1299,
    		'Extra Large size T-shirt, Blue Color',
    		50
    ),(
    		 4,
    		'Vivo Z1 Pro',
    		14990,
    		'4GB,64GB , Red Color',
    		1000
    ),(
    		 4,
    		'Vivo Z1 Pro',
    		14990,
    		'4GB,64GB , Black Color',
    		2000
    ),(
    		 4,
    		'Vivo Z1 Pro',
    		16990,
    		'6GB,64GB , Black Color',
    		800
    ),(
    		 4,
    		'Vivo Z1 Pro',
    		17990,
    		'6GB,128GB , Red Color',
    		200
    ),(
    		 4,
    		'Vivo Z1 Pro',
    		17990,
    		'6GB,128GB , Black Color',
    		300
    ),(
    		 4,
    		'Redmi Note 7 Pro',
    		13999,
    		'4GB,64GB , Blue Color',
    		1000
    ),(
    		 4,
    		'Redmi Note 7 Pro',
    		13999,
    		'4GB,64GB , Black Color',
    		2000
    ),(
    		 4,
    		'Redmi Note 7 Pro',
    		15999,
    		'6GB,128GB , Blue Color',
    		50
    ),(
    		 4,
    		'Redmi Note 7 Pro',
    		15999,
    		'6GB,128GB , Black Color',
    		200
    ),(
    		 4,
    		'Honor 10 Lite',
    		12999,
    		'4GB,64GB , Gold Color',
    		10
    );
    
INSERT INTO product_image(
    		product_id,
    		image_url
    		) 
	VALUES(
    		 1,
    		'mywebsite/img1.jpg'
    ),(
    		 1,
    		'mywebsite/img2.jpg'
    ),(
    		 1,
    		'mywebsite/img3.jpg'
    ),(
    		 3,
    		'mywebsite/img1.jpg'
    ),(
    		 3,
    		'mywebsite/img2.jpg'
    ),(
    		 4,
    		'mywebsite/img1.jpg'
    ),(
    		 5,
    		'mywebsite/img1.jpg'
    ),(
    		 5,
    		'mywebsite/img2.jpg'
    ),(
    		 7,
    		'mywebsite/img1.jpg'
    ),(
    		 6,
    		'mywebsite/img1.jpg'
    ),(
    		 10,
    		'mywebsite/img1.jpg'
    ),(
    		 8,
    		'mywebsite/img1.jpg'
    ),(
    		 10,
    		'mywebsite/img2.jpg'
    ),(
    		 10,
    		'mywebsite/img3.jpg'
    ),(
    		 10,
    		'mywebsite/img4.jpg'
    ),(
    		 11,
    		'mywebsite/img1.jpg'
    ),(
    		 12,
    		'mywebsite/img1.jpg'
    ),(
    		 12,
    		'mywebsite/img1.jpg'
    );
    
    

INSERT INTO orders(
      user_id,
    		address_id,
    		order_date,
            delivery_date,
            total_price
    		) 
	VALUES(
       1,
    		 1,
    		'2019-08-18',
            '2019-08-20',
            999
    ),
   (
       2,
    		 2,
    		'2019-07-18',
            '2019-07-20',
            999
    ),
    (
       3,
    		 3,
    		'2019-07-19',
            '2019-07-21',
            1998
    ),
    (
       4,
    		 4,
    		'2019-08-11',
            '2019-08-15',
            1299
    ),
    (
       4,
    		 4,
    		'2019-08-16',
            '2019-08-20',
            2598
    ),
(
       4,
    		 6,
    		'2019-08-16',
            '2019-08-18',
            14990
    ),
    (
       4,
    		 6,
    		'2019-08-11',
            '2019-08-25',
            29980
    ),
(
       1,
    		 1,
    		'2019-08-13',
            '2019-08-16',
            17990
    ),
 (
       1,
    		 1,
    		'2019-08-19',
            '2019-08-21',
            15989
    );
    
    
INSERT INTO orderedProducts(
    		order_id,
    		product_id,
      quantity
    		) 
	VALUES(
    		 1,
    		 1,
        1
    ),
    (
    		 2,
    		 2,
        1
    ),
    (
    		 3,
    		 2,
        2
    ),
    (   
    		 4,
    		 3,
        1
    ),
    (
    		 5,
    		 3,
        2
    ),
(
    		 6,
    		 4,
        1
    ),
    (
    		 7,
    		 5,
        2
    ),
    (
    		 8,
    		 7,
        1
    ),
    (
    		 9,
    		 1,
        1
    ),
   (   
    		 9,
    		 4,
        1
    );
    
    
INSERT INTO status(
    		order_id,
      product_id,
    		status
    		) 
	VALUES(
    		 1,
       1,
    		 'Not Shipped'
    );
    
INSERT INTO status(
    		order_id,
      product_id,
    		status
    		) 
	VALUES(
    		 2,
       2,
    		 'Shipped'
    ),
(
    		 3,
       2,
    		 'Shipped'
    ),
(
    		 4,
       3,
    		 'Shipped'
    ),
(
    		 5,
       3,
    		 'Shipped'
    ),
(
    		 6,
       4,
    		 'Shipped'
    ),
(
    		 7,
       5,
    		 'Shipped'
    ),
(
    		 8,
       7,
    		 'Shipped'
    ),
(
    		 9,
       1,
    		 'Shipped'
    ),
 
 (
    		 9,
       4,
    		 'Shipped'
    );
    
    SELECT * FROM orders;