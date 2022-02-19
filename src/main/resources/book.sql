DROP TABLE book;
DROP TABLE bookreply;
DROP SEQUENCE bookreply_seq;
DROP TABLE rating;
DROP SEQUENCE rating_seq;
DROP TABLE reservation;

--책 테이블
CREATE TABLE book
(
    bookseq   NUMBER,
    isbn      NUMBER PRIMARY KEY,
    booktitle VARCHAR2(100) NOT NULL,
    writer    VARCHAR2(50) NOT NULL,
    publisher VARCHAR2(50) NOT NULL,
    descrip   VARCHAR2(1000),
    stock     NUMBER default 0,
    bookphoto VARCHAR2(500)     -- 책 사진 파일명
);

--책 서평 테이블
CREATE TABLE bookreply
(
    replyseq NUMBER PRIMARY KEY,
    boardseq NUMBER NOT NULL,
    usrid    VARCHAR2(20) NOT NULL,
    replytext VARCHAR2(1000) NOT NULL,
    starcount number(3,1) default 4,
    regdate  DATE default sysdate,
        constraint bookreply_fk FOREIGN KEY(boardseq) REFERENCES book(isbn) ON DELETE CASCADE
);
CREATE SEQUENCE bookreply_seq;


-- 책의 총 별점 및 좋아요 테이블
CREATE TABLE rating
(
    ratingseq number PRIMARY KEY,
    bookseq number constraint rating_bookseq_fk REFERENCES book (isbn),
    likecount number DEFAULT 3,
    starcount number(3,1) default 0
);
CREATE SEQUENCE rating_seq;

--예약테이블
CREATE TABLE reservation
(
    rvseq   NUMBER  PRIMARY KEY, -- 예약번호
    usrid   VARCHAR2(20)REFERENCES "member"(USRID) ON DELETE CASCADE,
    isbn    NUMBER      REFERENCES book(isbn) ON DELETE CASCADE,
    rvStartDate date default sysdate, -- 대여 시작 날짜
    rvEndDate date default sysdate + 5 , -- 대여 끝 날짜
    returnBook number(1) default 0  -- 1 = 대여중 , 0= 대여x
);