--table create
--oracle 대소문자 구분함. 비밀번호,영문자 검색은 제외

create table member2(
id varchar2(15) primary key,--괄호 안 숫자는 들어갈 수 있는 글자, number빼고 전부 문자열
password varchar2(10),
name varchar2(10),
age number,
gender varchar2(5),
email varchar2(30)
);

--테이블에 데이터 넣기
insert into member2 values('hong','1234','hongkil',20,'남','@korea.kr');

select *from member2;

drop table member3;


---------------------------------
create table goodsinfo(
	code char(5) not null primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
);

insert into goodsinfo values('10001','digiter TV',35000,'LG');
insert into goodsinfo values('10002','LCD TV',135000,'LG');
insert into goodsinfo values('10003','LED TV',235000,'LG');
insert into goodsinfo values('10004','UHD TV',335000,'LG');
insert into goodsinfo values('10005','OLED TV',435000,'LG');

commit;

select*from goodsinfo

