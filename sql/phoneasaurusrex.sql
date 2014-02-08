create database if not exists phoneasaurusrex;

use phoneasaurusrex;

create table user (
  id int,
  user_name varchar(50),
  password varchar(50),
  primary key (id)
);

create table game_data (
  user_id int,
  score int
);
