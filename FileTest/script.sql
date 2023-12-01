
--FileTest

-- 장소 등록
create table tblPlace (
    seq number primary key,
    subject varchar2(500) not null,
    content varchar2(1000) not null,
    regdate date default sysdate not null
);


create table tblPic(
    seq number primary key,
    filename varchar2(300) not null,
    pseq number references tblPlace(seq) not null
);

create sequence seqPlace;
create sequence seqPic;

select * from tblplace;
select * from tblPic;

--게시물의 등록된 첨부파일 갯수 확인용
select a.*, (select count(*) from tblPic where pseq = a.seq) as picCount from tblPlace a order by seq desc;



