
DROP TABLE IF EXISTS Transaction_details;

DROP TABLE IF EXISTS Account_Details;

DROP TABLE IF EXISTS BRANCH_DETAILS;

DROP TABLE IF EXISTS Customer_details;



CREATE TABLE Customer_details (
    Customer_id    INT NOT NULL,
    First_Name    VARCHAR(255),
    Last_Name     VARCHAR(255),
	City     VARCHAR(255),
	country   VARCHAR(20),
	Zip   VARCHAR(6),
    Phone_number  VARCHAR(11) NOT NULL,
    Email   VARCHAR(255) NOT NULL,
   Customer_PASSWORD VARCHAR(60) NOT NULL,
    PRIMARY KEY (Customer_id)
);


CREATE TABLE BRANCH_DETAILS( 
Branch_CODE    INT NOT NULL,
Branch     VARCHAR(255),
PRIMARY KEY (Branch_CODE),
Customer_id int  REFERENCES Customer_details (Customer_id) 
);

CREATE TABLE Account_Details (
    Account_Id         INT NOT NULL,
    Type    VARCHAR(255) NOT NULL,
    Balance Number(18,2) NOT NULL,
    Create_Date  Date,
    PRIMARY KEY ( Account_Id ),
	Customer_id int  REFERENCES Customer_details (Customer_id)
);

CREATE TABLE Transaction_details (
    Tx_id         INT NOT NULL,
    Tx_Type    VARCHAR(255),
	To_Tx_Account_id INT NOT NULL,
    Transfered_amount Number(8,2) NOT NULL,
    Tx_Date  Date,
    PRIMARY KEY ( Tx_id,To_Tx_Account_id ),
	Account_Id int  REFERENCES Account_Details (Account_Id)
);
