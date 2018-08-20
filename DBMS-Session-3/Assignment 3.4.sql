USE storefront;
SHOW Tables;

# SQL Query to consider a form where providing a Zip Code populates associated City and State. 
CREATE TABLE CITIES (
   ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   City varchar(55),
   State varchar(55)
);
CREATE TABLE ZIPCODES (
   ZipCode int NOT NULL PRIMARY KEY,
   Area varchar(100),
   City_Code int,
   FOREIGN KEY (City_Code) REFERENCES CITIES(ID)
);

INSERT INTO CITIES (City,State) VALUES
   ('Ajmer','Rajasthan'),
   ('Bhilwara','Rajasthan'),
   ('jaipur','Rajasthan'),
   ('Kota','Rajasthan'),
   ('Udaipur','Rajasthan'),
   ('Bhopal','M.P.'),
   ('Indore','M.P.'),
   ('Varanasi','U.P.'),
   ('Mumbai','Maharashtra');

INSERT INTO ZIPCODES values
   ('324001','Mahaveer Nagar','4'),
   ('324002','DADABARI','4'),
   ('311001','R.K. Colony','2'),
   ('311002','Sindhu Nagar','2'),
   ('302011','Pratap Nagar','3'),
   ('302022','Sitapura','3'),
   ('324009','Mahaveer Nagar','4'),
   ('394004','Thane','9'),
   ('324008','Teachers colony','7');
   
SELECT z.ZipCode,c.City,c.State
FROM ZIPCODES z
LEFT JOIN
CITIES c
ON z.City_Code = c.Id
ORDER BY c.State, c.City;