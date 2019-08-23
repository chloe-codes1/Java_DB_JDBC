--user table
drop table users;

create table users(
	id varchar2(30) constraint users_pk primary key,
	password varchar2(30) constraint password_not_null not null,
	name varchar2(30),
	role varchar2(30) default 'user' check(role in ('user','admin'))
);

drop table board;

create table board(
	seq number(5) constraint board_pk primary key,
	title varchar2(100) constraint title_not_null not null,
	content varchar2(1000),
	regdate date default sysdate,
	cnt number(5) default 0,
	id varchar2(30)
);

--회원 등록
insert into users(id, password,name,role) values('user1','1234','김주현',default);
insert into users(id, password,name,role) values('user2','1234','이주현',default);
insert into users(id, password,name,role) values('user3','1234','박주현',default);
insert into users(id, password,name,role) values('user4','1234','임주현',default);
insert into users(id, password,name,role) values('user5','1234','최주현',default);

--회원 정보 수정
update users set password = '0000' where id = 'user1';
update users set name = '권주현' where id = 'user3';
update users set id ='admin' where name = '김주현';
update users set role = 'admin' where id = 'admin';

commit;
    --> dml을 쓰면 trasaction이 시작되므로 commit이나 rollback으로 끝내야함!

--로그인
(로그인 성공하면 정보 출력됨)
select*from users
where id='user5' and password ='1234';

select nvl(id,'실패') as ID from users
where id='user5' and password='1234';


--게시판 글 등록
create sequence seq_01;

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '안녕하세요', '환영합니다아아아아아','95/08/25', 0, 'admin');

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '배고파', '배고프다아아아아앙',default, default, 'user2');

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '가나다', '가나다라마바사아',default, default, 'user3');		
	
insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, 'abc', 'abcdefghijklmnop',default, 5, 'user4');		

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '123', '456789',default, default, 'user5');
		
insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '글', '이것은 글이다','19/04/22', default, 'user5');		

insert into board(seq, title, content, regdate, cnt, id)
		values(seq_01.nextval, '또다른 글', '이것 또한 글이다','19/04/22', default, 'user5');

--sequence 말고 함수 사용해서 pk 설정
insert into board(seq, title, content, regdate, cnt, id)
values((select nvl(max(seq),0)+1 from board), '글입니다', '글이에요', '19/07/29', default, 'user3');
		
		
		
--다시 할꺼야
drop sequence seq_01;
delete from board;


--글수정
update board set cnt=0 where seq=1;
update board set content = '와하하하하하하' where seq=1;
update board set regdate = '2019/01/01' where seq=1;
update board set title = '가나다라' where id = 'user3';
update board set cnt=0 where seq=3;


--게시판 글 삭제
delete from board where id = 'user3';


--데이터검색(Query)   -> lower / upper 기억하기!!!!!
select*from board where lower(id) = lower('user2');
select*from board where lower(title) = lower('abc');
select*from board where lower(id) = lower('user5');

--전체 등록글 수
select count(seq) as "전체 등록글 수" from board;


--사용자별 등록글수 
select count(seq) as "사용자별 등록글 수" from board where id = 'user2';
select count(seq) as "사용자별 등록글 수" from board where id = 'user4';
select count(seq) as "사용자별 등록글 수" from board where id = 'user5';
select count(seq) as "사용자별 등록글 수" from board where id = 'admin';


--월별개시글수
select to_char(regdate, 'mm') 월, count(*) "게시글 수" 
from board
group by to_char(regdate, 'mm')
order by 1;

--사용자별 게시글 검색
select*from board where id = 'admin';
select*from board where id = 'user2';
select*from board where id = 'user4';
select*from board where id = 'user5';

--제목으로 게시글 검색
select*from board where title = '배고파';
select*from board where title = '또다른 글';
select*from board where title = 'abc';
select*from board where title = '123';
select*from board where title = '글';
select*from board where title = '안녕하세요';



