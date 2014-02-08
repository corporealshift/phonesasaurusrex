create database if not exists phoneasaurusrex;

use phoneasaurusrex;

create table user (
  user_name varchar(50),
  password varchar(50),
  score int,
  primary key (user_name)
);
