CREATE DATABASE EMPLOYEE_FORUM;

USE EMPLOYEE_FORUM;

CREATE TABLE Employees (
 id INT auto_increment PRIMARY KEY,
 firstName VARCHAR(200)NOT NULL,
 lastName VARCHAR(200)NOT NULL,
 email VARCHAR(200) unique KEY NOT NULL,
 age INT NOT NULL
);

INSERT INTO Employees (firstName,lastName,email,age) VALUES ("Aakanksha","Raj","aakanksha@gmail.com",22);

INSERT INTO Employees (firstName,lastName,email,age) VALUES ("Kritika","Singh","kritikaa@gmail.com",23),
("Kajal","Rai","kajal@gmail.com",24);

SELECT * FROM Employees;
