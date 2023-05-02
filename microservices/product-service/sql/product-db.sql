create database product;
create user 'productUser'@'%' identified by 'test';
grant all on product.* to 'productUser'@'%';