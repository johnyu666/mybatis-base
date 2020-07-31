insert Blog(title,author_id) values ('Happy Bird',1);
insert Blog(title,author_id) values ('前行中的牛',1);
insert Blog(title,author_id) values ('无果咖啡因',2);
insert Blog(title,author_id) values ('丢失了作者的blog',9999);

insert Author(username,password,bio,favourite_section) values ('john','123','一个纯粹的人，一颗执着的心','文创');
insert Author(username,password,bio,favourite_section) values ('tomson','123','高级装X师','文创,music');
insert Author(username,password,bio,favourite_section) values ('jackson','123','没有博客的作者','只是看看');


insert into Post(title,created_on,section,subject,draft,body,author_id,blog_id)
values ('吃亏是经验','2020/07/01','生命生活','主题1','草稿1','这是一个关于吃亏和占便宜的话题',1,1);

insert into Post(title,created_on,section,subject,draft,body,author_id,blog_id)
values ('保持驿动的心','2019/12/12 15:33:12','前行与奋进','向前','草稿2','永远年轻的秘密',2,1);