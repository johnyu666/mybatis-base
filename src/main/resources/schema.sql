drop table if exists Blog;
drop table if exists Author;
drop table if exists Post;
drop table if exists Comment;
drop table if exists Tag;
drop table if exists Post_Tag;


create table Blog(id int auto_increment,title varchar(128),author_id int,primary key(id));
create table Author(id int auto_increment,username varchar(32),password varchar(64),bio varchar(255),favourite_section varchar(32),primary key(id));
create table Post(id int auto_increment,title varchar(128),
created_on timestamp ,
section varchar (32),
subject varchar (64),
draft varchar (16),
body text,
author_id int,blog_id int,primary key(id));

create table Comment(id int auto_increment,name varchar(16),comment varchar(64),post_id int,primary key(id));

create table Tag(id int auto_increment,name varchar(16),primary key(id));




