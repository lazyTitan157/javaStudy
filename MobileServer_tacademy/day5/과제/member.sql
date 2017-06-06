USE MYSQL;

DROP TABLE ANMEMBER;

CREATE TABLE ANMEMBER(
	NUM INT(10) NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(20) NOT NULL,
	ID VARCHAR(20) NOT NULL,
	PW VARCHAR(20) NOT NULL,
	TEL VARCHAR(20) NOT NULL,
	ADDRESS VARCHAR(50) NOT NULL,
	comment text,
	idate datetime,
	PRIMARY KEY(NUM)
);
	
insert into ANMEMBER values(null, '김재웅', 'abc', '1234', '01037926917', '경기도 성남시 중원구', '모바일 서버 예제', now() );

select * from ANMEMBER;
commit;
select user();


drop table product;
create table product (
	num  int(7)  not null AUTO_INCREMENT,
	title varchar(30) not null,
	count varchar(10) not null,
	price int(7),
	image varchar(20),
	category char(1),
	PRIMARY key( num)

);

insert into product values(null,'카톡', '100000', 0, 'icon01.png' , '2');
insert into product values(null,'애니팡', '230000', 0, 'icon02.png' , '1');
insert into product values(null,'TWorld', '1200000', 0, 'icon03.png' , '1');
insert into product values(null,'스마트풀','12000', 2500, '' , '1');
insert into product values(null,'리버스', '120000', 1000, 'icon04.png' , '1');
insert into product values(null,'팔라독', '129', 3000, 'icon02.png' , '2');
insert into product values(null,'바운스볼2.5D', '123444', 0, '' , '2');
insert into product values(null,'다음-Daum', '121112', 0, 'icon02.png' , '1');
insert into product values(null,'뷰티풀위젯', '122214', 2890, 'icon01.png' , '1');
insert into product values(null,'아스팔트7', '120000', 1000, 'icon02.png' , '2');
insert into product values(null,'카메라줌FX', '300000', 3049, 'icon05.png' , '1');
insert into product values(null,'리얼당구', '79000', 3900, 'icon03.png' , '2');
insert into product values(null,'네이버', '384111', 0, '' , '1');
insert into product values(null,'윈드러너', '678000', 0, 'icon03.png' , '2');
insert into product values(null,'편한가계부', '33121', 2900, 'icon03.png' , '1');
insert into product values(null,'페이스북', '7890000', 0, '' , '1');
insert into product values(null,'쉬운사진합치기', '72292', 1000, 'icon03.png' , '1');
insert into product values(null,'도전 가요왕', '9800', 0, '' , '2');
insert into product values(null,'갓피플성경', '20000', 3500, 'icon01.png' , '1');


select * from product;