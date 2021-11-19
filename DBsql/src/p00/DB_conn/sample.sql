create table book(
id varchar2(10) primary key,
name varchar2(10),
price number
);

insert into book values('aaaa','hong',1000);
insert into book values('bbbb','alphago',2000);
insert into book values('cccc','beta',3000);

delete from book where id='cccc';

select*from book;


