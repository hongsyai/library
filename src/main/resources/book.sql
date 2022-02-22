drop table reservation;
drop table book;
drop sequence bookseq;
drop sequence rv_seq;

create sequence bookseq;
create sequence rv_seq;


CREATE TABLE book
(
    bookseq   NUMBER primary key,
    isbn      VARCHAR2(50) not null,
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
    returnBook number(1) default 0  -- 1 = 대여가능 , 0= 대여x
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


insert into book
(bookseq, isbn, booktitle, writer, publisher, descrip, stock)
values
(BOOKSEQ.nextval,9791167900869,'조인계획','히가시노 게이고', '현대문학','전 세계 누적 판매 1300만 부를 기록한 『나미야 잡화점의 기적』을 비롯해 발표하는 작품마다 베스트셀러에 오르며 이름 자체가 하나의 장르가 된 작가,
현존하는 일본 추리소설계 최고의 거장 히가시노 게이고의 초기 걸작 『조인계획』이 현대문학에서 출간되었다.
이 소설은 ‘동계 스포츠의 꽃’이라 불리는 스키점프를 소재로 인간의 신체적 한계를 뛰어넘고자 하는 욕망과 승리를 향한 광기를 그렸다.
스포츠와 과학을 아우르는 폭넓은 지식을 바탕으로 놀라운 트릭과 반전을 선사하는 한편, ‘인간성과 맞바꾼 승리가 인간다움을 잃지 않는 패배보다 가치 있는가?’라는 질문을 던진다.', 0);

commit;
