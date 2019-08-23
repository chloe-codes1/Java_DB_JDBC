*********************
 게시판  관련 SQL 작성
********************
users 테이블 생성 구문 
     id             --pk
     password   
     name        
     role            -- default는 user로, 한명만 admin

board 테이블 생성 구문 
     seq             --sequence로 pk 
     title        
     content      
     regdate          --글 올린 날짜
     cnt         	  --조회수
     id      		  --올린사람 id
     

회원등록

회원정보수정  --비밀번호 변경

로그인

게시판 글등록

글수정

게시판 글 삭제

데이터검색(Query)

전체 등록글 수

사용자별 등록글수      --group by

월별개시글수			--group by

사용자별 게시글 검색  

제목으로 게시글 검색

===========================================





create user admin identified by 1234
default tablespace bit;

grant connect, resource to admin;

show linesize;
set linesize 300;

show pagesize;
set pagesize 20;

conn admin/1234;

=================
users 테이블 생성 구문 
     id          
     password   
     name        
     role       
=================

create table users(
	id varchar2(30) constraint users_pk primary key,
	password varchar2(30) constraint password_not_null not null,
	name varchar2(30),
	role varchar2(30) default 'user' check(role in ('user','admin'))
);


=================
board 테이블 생성 구문 
     seq             --sequence로 pk 
     title        
     content      
     regdate          --글 올린 날짜
     cnt         	  --조회수
     id      		  --올린사람 id     
=================     

create table board(
	seq number(5) constraint board_pk primary key,
	title varchar2(100) contraint title_not_null not null,
	content varchar2(1000),
	regdate date default sysdate,
	cnt number(5) default 0,
	id varchar2(30)
);

--fk 추가하기
alter table board add constraint board_fk1 foreign key(id) references users;


--그냥 보기 편하려고..--
col id for a14;
col password for a14;
col name for a14;
col role for a14;



회원등록
insert into users(id, password,name,role) values('user1','1234','김주현',default);
insert into users(id, password,name,role) values('user2','1234','이주현',default);
insert into users(id, password,name,role) values('user3','1234','박주현',default);
insert into users(id, password,name,role) values('user4','1234','임주현',default);
insert into users(id, password,name,role) values('user5','1234','최주현',default);

회원정보수정
update users set password = '0000' where id = 'user1';
update users set name = '권주현' where id = 'user3';
update users set id ='admin' where name = '김주현';
update users set role = 'admin' where id = 'admin';

로그인
select id, name
from users
where password = '0000';


--그냥 보기 편하려고..--
col seq for 9999;
col title for a20;
col content for a50;
col regdate for a14;
col cnt for 9999;

--일단 sequence 만들어봄
create sequence seq_01;



게시판 글등록
insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '안녕하세요', '환영합니다아아아아아','95/08/25', 0, 'admin');

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '배고파', '배고프다아아아아앙',default, 10, 'user2');

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '가나다', '가나다라마바사아',default, 20, 'user3');		
	
insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, 'abc', 'abcdefghijklmnop',default, 5, 'user4');		

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '123', '456789',default, 0, 'user5');
		
insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '글', '이것은 글이다','19/04/22', 0, 'user5');		

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '또다른 글', '이것 또한 글이다','19/04/22', 0, 'user5');	
		
		
--현재 sequence의 value 상태 확인		
select seq_01.currval from dual;		

글수정
update board set cnt=0 where seq=1;
update board set content = '와하하하하하하' where seq=1;
update board set regdate = '2019/01/01' where seq=1;
update board set title = '가나다라' where id = 'user3';
update board set cnt=0 where seq=3;


게시판 글 삭제
delete from board where id = 'user3';


데이터검색(Query)   -> lower / upper 기억하기!!!!!
select*from board where lower(id) = lower('user2');
select*from board where lower(title) = lower('abc');
select*from board where lower(id) = lower('user5');


전체 등록글 수
select count(seq) as "전체 등록글 수" from board;


사용자별 등록글수 
select count(seq) as "사용자별 등록글 수" from board where id = 'user2';
select count(seq) as "사용자별 등록글 수" from board where id = 'user4';
select count(seq) as "사용자별 등록글 수" from board where id = 'user5';
select count(seq) as "사용자별 등록글 수" from board where id = 'admin';


월별개시글수
select to_char(regdate, 'mm') 월, count(*) "게시글 수" 
from board
group by to_char(regdate, 'mm')
order by 1;

사용자별 게시글 검색
select*from board where id = 'admin';
select*from board where id = 'user2';
select*from board where id = 'user4';
select*from board where id = 'user5';

제목으로 게시글 검색
select*from board where title = '배고파';
select*from board where title = '또다른 글';
select*from board where title = 'abc';
select*from board where title = '123';
select*from board where title = '글';
select*from board where title = '안녕하세요';

