/* Display Id, Title, Category Title, Price of the products which are Active and recently added products    should be at top.
*/
SELECT product.product_id AS "Id",
	   product.product_name AS "Title",
       category.category_name AS "Category Title",
       product.price AS "Price" 
       FROM product,category 
       WHERE product.category_id = category.category_id AND product.stock > 0 
       ORDER BY product.product_id Desc;


/* Display the list of products which do not have any images*/

SELECT product.product_id AS "Id",
	   product.product_name AS "Title" 
       FROM product 
       WHERE product.product_id NOT IN(SELECT product_image.product_id FROM product_image);    


/* Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title*/

SELECT  category.category_id AS "Id",
        category.category_name AS "Category Title",
        IF(category.parent_id > 0,category.category_name,"Top Category") AS "Parent Category Title" 
        FROM category ORDER BY "Parent Category Title",category.category_name;



/*Display Id, Title, Parent Category Title of all the leaf Categories*/


SELECT  category.category_id,category.category_name,category.parent_id
FROM category
where category.category_id NOT IN(SELECT DISTINCT category.parent_id  FROM category );







/*Display Product Title, Price & Description which falls into particular category Title */
SELECT product.product_name AS Name,
       product.price AS Price,
       product.description AS Description 
       FROM product WHERE product.category_id =(SELECT category.category_id FROM category WHERE category.category_name='Mobile');




/*Display the list of Products whose Quantity on hand (Inventory) is under 50*/
SELECT product.product_name AS Name,
       product.price AS Price,
       product.description AS Description 
       FROM product WHERE product.stock<50;





/*Display Recent 50 Orders placed (Id, Order Date, Order Total).*/

SELECT orders.order_id AS "Order Id", 
       orders.order_date AS "Order Date", 
       orders.total_price AS "Order Total" 
       FROM orders ORDER BY orders.order_id DESC LIMIT 50;



/*Display 10 most expensive Orders.
*/
SELECT orders.order_id AS "Order Id",
       orders.order_date AS "Order Date", 
       orders.total_price AS "Order Total" 
       FROM orders ORDER BY orders.total_price DESC LIMIT 10;



/*Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
*/
SELECT orders.order_id AS "Order Id",
       orders.address_id AS "Address Id", 
       orders.order_date AS "Order Date" 
       FROM orders where orders.order_date < DATE_SUB(CURDATE(), INTERVAL 10 DAY) 
       AND orders.order_id 
       IN (SELECT status.order_id FROM status where status.status = "Not Shipped");




/*Display list of shoppers which haven't ordered anything since last month.
*/
SELECT user.user_id AS "User Id", 
       user.name AS "Shopper Name", 
       user.email_id AS "Shopper Email"
       from user where  user.user_id 
       NOT IN(SELECT DISTINCT orders.user_id 
       from orders where MONTH(orders.order_date) >= (MONTH(NOW())-1) AND YEAR(orders.order_date) = YEAR(NOW())
       );

/*Display list of shopper along with orders placed by them in last 15 days. 
*/
SELECT user.user_id AS "User Id", 
       user.name AS "Shopper Name", 
       user.email_id AS "Shopper Email",
       orders.order_id,
       orders.address_id,
       orders.order_date,
       orders.delivery_date,
       orders.total_price
       FROM user INNER JOIN orders
       ON user.user_id=orders.user_id AND orders.order_date IN (SELECT orders.order_date FROM orders where orders.order_date >= DATE_SUB(NOW(), INTERVAL 15 DAY));
       
       
/*Display list of order items which are in “shipped” state for particular Order Id (i.e.: 9))
*/
SELECT product.product_name AS Title,
       product.price AS Price,
       product.description AS Description
       from product where product.product_id IN(
       SELECT status.product_id 
       FROM status 
       WHERE status.order_id = 9);
       
  


/*Display list of order items along with order placed date which fall between Rs 800 to Rs 15000 price.*/  
 SELECT product.product_name AS Title,
       orders.order_date AS "Order Date",
       product.price 
       FROM product, orders 
       WHERE product.price BETWEEN 800 AND 15000 
       AND (product.product_id, orders.order_id) 
       IN (SELECT product_id, order_id FROM status);
       