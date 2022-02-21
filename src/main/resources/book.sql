drop table reservation;
drop table book;
drop sequence bookseq;
drop sequence rv_seq;

create sequence bookseq;
create sequence rv_seq;

CREATE TABLE book
(
    bookseq   NUMBER primary key,
    isbn      NUMBER not null,
    booktitle VARCHAR2(100) NOT NULL,
    writer    VARCHAR2(50) NOT NULL,
    publisher VARCHAR2(50) NOT NULL,
    descrip   VARCHAR2(1000),
    stock     NUMBER default 0,
    bookphoto VARCHAR2(500)     -- 책 사진 파일명
);
CREATE TABLE reservation
(
    rvseq   NUMBER  PRIMARY KEY, -- 예약번호
    usrid   VARCHAR2(20)REFERENCES "member"(USRID) ON DELETE CASCADE,
    bookseq    NUMBER      REFERENCES book(bookseq) ON DELETE CASCADE,
    rvStartDate date default sysdate, -- 대여 시작 날짜
    rvEndDate date default sysdate + 5 , -- 대여 끝 날짜
    returnBook number(1) default 0  -- 1 = 대여중 , 0= 대여x
);


insert into book
(bookseq, isbn, booktitle, writer, publisher, descrip, stock)
values
(BOOKSEQ.nextval,1,'눈먼자들의 도시','주제 사라마구', '기린출판','모든 사람이 눈을 멀게된다 단 한사람만 빼고.', 3);

insert into book
(bookseq, isbn, booktitle, writer, publisher, descrip, stock)
values
(BOOKSEQ.nextval,2345,'장미의 이름','움베르트 에코', '사우르스 출판','중세 수도사 제임스의 수사물', 12);

insert into book
(bookseq, isbn, booktitle, writer, publisher, descrip, stock)
values
(BOOKSEQ.nextval,55,'아Q정전','루', '아기새 출판','싸이코 아Q', 2);

insert into reservation
(rvseq, usrid, bookseq,returnbook)
values
(rv_seq.nextval, 'aaa', 41, 0);

commit;
