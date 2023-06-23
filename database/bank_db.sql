create database bank;

use bank;

create table personalDetails(
formno varchar(20) PRIMARY KEY,
name varchar(25),
fname varchar(25),
dob varchar(20),
gender varchar(20),
email varchar(30),
marital varchar(20),
address varchar(40),
city varchar(25),
pinCode varchar(15),
state varchar(25),
religion varchar(15),
inc varchar(20),
cat varchar(15),
education varchar(20),
occupation varchar(20),
panNo varchar(20),
aadharNo varchar(20),
seniorCitizen varchar(10),
existingAccount varchar(10),
accType varchar(15),
services varchar(50));
 
create table login(
formno varchar(20),
cardNo varchar(20) PRIMARY KEY,
pin varchar(15));

create table bank(
cardNo varchar(20),
date varchar(40),
type varchar(15),
amount varchar(15));
