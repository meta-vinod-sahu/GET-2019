create database books;

use books;
 
create table book(
id  int auto_increment, 
title Varchar(50),
writer Varchar(50), 
publisher Varchar(50),
published_year int,
primary key(id)
);

insert into book (title,writer,publisher,published_year) values('vinod3','ashok sahu','nilkanth',2018);

drop table book;
select * from book;
update book set title ='vina' and published_year= 2018 where id=1;