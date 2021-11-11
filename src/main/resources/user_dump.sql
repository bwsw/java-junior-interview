create table "user" (
    id bigint,
    login varchar(20)
);

create table login_history (
    id int,
    user_id int,
    date_time timestamp without time zone
);

insert into "user" (id,login) values
(1,'user1'),
(2,'user2');

insert into "login_history"(id,user_id,date_time) values
(1,1,'2020-12-31 23:00:00'),
(2,1,'2021-01-01 02:00:00'),
(3,2,'2021-01-10 09:00:00'),
(4,2,'2021-01-11 09:00:00'),
(4,2,'2021-01-12 09:00:00');
