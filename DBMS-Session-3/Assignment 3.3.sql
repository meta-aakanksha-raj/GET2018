#Q1
SELECT USERS.UserID, USERS.FirstName, USERS.Email, COUNT(ORDERS.OrderID) AS TotalOrders FROM ORDERS
LEFT JOIN USERS
ON ORDERS.UserID = USERS.USERID
GROUP BY USERS.UserID;

#q2
CREATE VIEW ORDERS_COSTS
AS
SELECT PRODUCTS_ORDERS.OrderID, SUM(PRODUCTS.Cost) AS TotalCost 
FROM PRODUCTS_ORDERS
LEFT JOIN PRODUCTS
ON PRODUCTS_ORDERS.ProductID = PRODUCTS.ProductID 
GROUP BY OrderID; 

SELECT * FROM ORDERS_COSTS;

describe orders;

SELECT ORDERS.UserID, SUM(ORDERS_COSTS.TotalCost) As Revenue 
FROM ORDERS
LEFT JOIN ORDERS_COSTS
ON
ORDERS.OrderID = ORDERS_COSTS.OrderID
WHERE ORDERS.PlacedDate between CURRENT_DATE - INTERVAL '5' MONTH AND CURRENT_DATE
GROUP BY ORDERS.UserID
ORDER BY (Revenue) DESC 
LIMIT 5;

#q3
SELECT PRODUCTS_ORDERS.ProductID ,COUNT(PRODUCTS_ORDERS.OrderID) AS Numbers
FROM PRODUCTS_ORDERS
LEFT JOIN ORDERS
ON
PRODUCTS_ORDERS.OrderID = ORDERS.OrderID
WHERE ORDERS.PlacedDate > CURRENT_DATE - INTERVAL '60' DAY 
GROUP BY PRODUCTS_ORDERS.ProductID
ORDER BY Numbers DESC;  

#q4
CREATE VIEW ORDER_COST_DATE
AS
SELECT ORDERS_COSTS.OrderID, ORDERS_COSTS.TotalCost, Orders.PlacedDate 
FROM ORDERS_COSTS
LEFT JOIN ORDERS
ON ORDERS_COSTS.OrderID = ORDERS.OrderID
WHERE ORDERS.PlacedDate > CURRENT_DATE - INTERVAL 6 MONTH AND ORDERS.PlacedDate < CURRENT_DATE + INTERVAL 1 DAY;

SELECT * FROM ORDER_COST_DATE;

SELECT SUM(ORDER_COST_DATE.TotalCost) AS REVENUE, 
CASE
  WHEN (ORDER_COST_DATE.PlacedDate  BETWEEN  (CURRENT_DATE - INTERVAL '6' Month) AND (CURRENT_DATE - INTERVAL '5' Month) )THEN 'First Month'
  WHEN (ORDER_COST_DATE.PlacedDate  BETWEEN  (CURRENT_DATE - INTERVAL '5' Month) AND (CURRENT_DATE - INTERVAL '4' Month) )THEN 'Second Month'
  WHEN (ORDER_COST_DATE.PlacedDate  BETWEEN  (CURRENT_DATE - INTERVAL '4' Month) AND (CURRENT_DATE - INTERVAL '3' Month) )THEN 'Third Month'
  WHEN (ORDER_COST_DATE.PlacedDate  BETWEEN  (CURRENT_DATE - INTERVAL '3' Month) AND (CURRENT_DATE - INTERVAL '2' Month) )THEN 'Fourth Month'
  WHEN (ORDER_COST_DATE.PlacedDate  BETWEEN  (CURRENT_DATE - INTERVAL '2' Month) AND (CURRENT_DATE - INTERVAL '1' Month) )THEN 'Fifth Month'
  WHEN (ORDER_COST_DATE.PlacedDate  BETWEEN  (CURRENT_DATE - INTERVAL '1' Month) AND (CURRENT_DATE - INTERVAL '0' Month) )THEN 'Sixth Month'
END AS Ranges 
FROM ORDER_COST_DATE GROUP BY Ranges;

DROP VIEW ORDER_COST_DATE;

#Q5
update PRODUCTS 
set IsActive = '1'
WHERE 1;

SELECT *FROM PRODUCTS;

UPDATE PRODUCTS
SET PRODUCTS.IsActive = 0
WHERE PRODUCTS.ProductID NOT IN(
SELECT DISTINCT PRODUCTS_ORDERS.ProductID 
FROM ORDERS
JOIN PRODUCTS_ORDERS
ON ORDERS.OrderID=PRODUCTS_ORDERS.OrderID
WHERE ORDERS.PlacedDate > CURRENT_DATE - INTERVAL '3' MONTH AND ORDERS.PlacedDate < CURRENT_DATE + INTERVAL '1' DAY
ORDER BY PRODUCTS_ORDERS.ProductID);

SELECT *FROM PRODUCTS;

#Q6
SELECT PRODUCTS.NAME , L.ProductID , L.Type FROM
(SELECT PRODUCTS_CATEGORIES.ProductID, T.CategoryID , T.Type FROM
(SELECT CATEGORIES.Type, CATEGORIES.CategoryId
FROM CATEGORIES
WHERE CATEGORIES.Type LIKE '%Fashion%') AS T
JOIN PRODUCTS_CATEGORIES 
ON PRODUCTS_CATEGORIES.CategoryID = T.CategoryID) AS L
JOIN PRODUCTS
ON PRODUCTS.ProductID = L.ProductID;

#q7
SELECT PRODUCTS.Name, T.ProductID FROM 
(SELECT PRODUCTS_ORDERS.ProductID, PRODUCTS_ORDERS.State 
FROM PRODUCTS_ORDERS
WHERE PRODUCTS_ORDERS.State LIKE '%Cancelled%') AS T
LEFT JOIN PRODUCTS
ON PRODUCTS.ProductID = T.ProductID
GROUP BY T.ProductID;
