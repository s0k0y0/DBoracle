create table product(
num number primary key,
name varchar2(30),
price number
);

create sequence reno
start with 0
increment by 1
minvalue 0;

delete from product;

insert into product(num) values(reno.nextval);

select*from product;