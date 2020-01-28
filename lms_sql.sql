DROP TABLE score;
DROP TABLE atte;
DROP TABLE appl;
DROP TABLE lec;
DROP TABLE state;
DROP TABLE cls_bbs;
DROP TABLE job_bbs;
DROP TABLE faq_bbs;
DROP TABLE ntc_bbs;
DROP TABLE recr_bbs;
DROP TABLE info;
DROP TABLE emp;
DROP TABLE dept;
DROP TABLE mb;
DROP SEQUENCE mb_seq;
DROP SEQUENCE emp_seq;
DROP SEQUENCE recr_seq;
DROP SEQUENCE ntc_seq;
DROP SEQUENCE faq_seq;
DROP SEQUENCE job_seq;
DROP SEQUENCE cls_seq;
CREATE TABLE mb(
	mb_no                 NUMBER  NOT NULL ,
	mb_id                 VARCHAR2(30)  NOT NULL ,
	mb_pw                 VARCHAR2(20)  NOT NULL ,
	mb_name               VARCHAR2(30)  NOT NULL ,
	mb_tel                VARCHAR2(13)  NOT NULL ,
	mb_question           VARCHAR2(100)  NOT NULL ,
	mb_answer             VARCHAR2(100)  NOT NULL ,
	CONSTRAINT mb_no_pk PRIMARY KEY(mb_no)
);
CREATE SEQUENCE mb_seq start with 10000;
CREATE TABLE dept(
	dept_no               NUMBER  NOT NULL ,
	dept_name             VARCHAR2(30)  NOT NULL ,
	CONSTRAINT dept_no_pk PRIMARY KEY(dept_no)
);
CREATE TABLE emp(
	emp_no                NUMBER  NOT NULL ,
	emp_id                VARCHAR2(30)  NOT NULL ,
	emp_pw                VARCHAR2(20)  NOT NULL ,
	emp_name              VARCHAR2(30)  NOT NULL ,
	emp_tel               VARCHAR2(13)  NOT NULL ,
	emp_question          VARCHAR2(100)  NOT NULL ,
	emp_answer            VARCHAR2(100)  NOT NULL ,
	dept_no               NUMBER  DEFAULT 0 ,
	CONSTRAINT emp_no_pk PRIMARY KEY(emp_no) ,
	CONSTRAINT emp_deptno_fk FOREIGN KEY(dept_no) references dept(dept_no)
);
CREATE SEQUENCE emp_seq start with 1000;
CREATE TABLE info(
	info_acadname         VARCHAR2(30) ,
	info_repname          VARCHAR2(15) ,
	info_acadaddr         VARCHAR2(100) ,
	info_tel              VARCHAR2(20) ,
	info_fex              VARCHAR2(20) ,
	info_license          VARCHAR2(20) ,
	info_headname         VARCHAR2(15)   
);
CREATE TABLE recr_bbs(
	recr_no               NUMBER  NOT NULL ,
	emp_no                NUMBER  NOT NULL ,
	recr_subject          VARCHAR2(100)  NOT NULL ,
	recr_content          VARCHAR2(4000)  NOT NULL ,
	recr_count            NUMBER  NOT NULL ,
	recr_date             DATE  NOT NULL ,
	CONSTRAINT recr_no_pk PRIMARY KEY(recr_no) ,
	CONSTRAINT recr_empno_fk FOREIGN KEY(emp_no) references emp(emp_no)
);
CREATE SEQUENCE recr_seq;
CREATE TABLE ntc_bbs(
	ntc_no                NUMBER  NOT NULL ,
	emp_no                NUMBER  NOT NULL ,
	ntc_subject           VARCHAR2(100)  NOT NULL ,
	ntc_content           VARCHAR2(4000)  NOT NULL ,
	ntc_count             NUMBER  NOT NULL ,
	ntc_date              DATE  NOT NULL ,
	CONSTRAINT ntc_no_pk PRIMARY KEY(ntc_no) ,
	CONSTRAINT ntc_empno_fk FOREIGN KEY(emp_no) references emp(emp_no)
);
CREATE SEQUENCE ntc_seq;
CREATE TABLE faq_bbs(
	faq_no                NUMBER  NOT NULL ,
	emp_no                NUMBER  NOT NULL ,
	faq_subject           VARCHAR2(100)  NOT NULL ,
	faq_content           VARCHAR2(4000)  NOT NULL ,
	faq_count             NUMBER  NOT NULL ,
	faq_date              DATE  NOT NULL ,
	CONSTRAINT faq_no_pk PRIMARY KEY(faq_no) ,
	CONSTRAINT faq_empno_fk FOREIGN KEY(emp_no) references emp(emp_no)
);
CREATE SEQUENCE faq_seq;
CREATE TABLE job_bbs(
	job_no                NUMBER  NOT NULL ,
	emp_no                NUMBER  NOT NULL ,
	job_subject           VARCHAR2(100)  NOT NULL ,
	job_content           VARCHAR2(4000)  NOT NULL ,
	job_count             NUMBER  NOT NULL ,
	job_date              DATE  NOT NULL ,
	CONSTRAINT job_no_pk PRIMARY KEY(job_no) ,
	CONSTRAINT job_empno_fk FOREIGN KEY(emp_no) references emp(emp_no)
);
CREATE SEQUENCE job_seq;
CREATE TABLE cls_bbs(
	cls_no                NUMBER  NOT NULL ,
	emp_no                NUMBER  NOT NULL ,
	cls_subject           VARCHAR2(100)  NOT NULL ,
	cls_content           VARCHAR2(4000)  NOT NULL ,
	cls_count             NUMBER  NOT NULL ,
	cls_date              DATE  NOT NULL ,
	CONSTRAINT cls_no_pk PRIMARY KEY(cls_no) ,
	CONSTRAINT cls_empno_fk FOREIGN KEY(emp_no) references emp(emp_no)
);
CREATE SEQUENCE cls_seq;
CREATE TABLE state(
	sta_code              NUMBER  NOT NULL ,
	sta_name              VARCHAR2(20)  NOT NULL ,
	CONSTRAINT sta_code_pk PRIMARY KEY(sta_code)
);
CREATE TABLE lec(
	lec_code              VARCHAR2(10)  NOT NULL ,
	lec_name              VARCHAR2(100)  NOT NULL ,
	lec_instructor        VARCHAR2(30)  NOT NULL ,
	lec_content           VARCHAR2(4000)  NOT NULL ,
	lec_appl_start        DATE  NOT NULL ,
	lec_appl_end          DATE ,
	lec_start             DATE ,
	lec_end               DATE  NOT NULL ,
	lec_roomno            NUMBER(1)  NOT NULL ,
	lec_people            NUMBER(2)  NOT NULL ,
	CONSTRAINT lec_code_pk PRIMARY KEY(lec_code)
);
CREATE TABLE appl(
	mb_no                 NUMBER  NOT NULL ,
	sta_code              NUMBER  DEFAULT 0,
	lec_code              VARCHAR2(10) ,
	appl_date             DATE ,
	CONSTRAINT appl_pk PRIMARY KEY(mb_no) ,
	CONSTRAINT appl_mbno_fk FOREIGN KEY(mb_no) references mb(mb_no) ,
	CONSTRAINT appl_stacode_fk FOREIGN KEY(sta_code) references state(sta_code) ,
	CONSTRAINT appl_leccode_fk FOREIGN KEY(lec_code) references lec(lec_code)
);
CREATE TABLE atte(
	mb_no                 NUMBER  NOT NULL ,
	atte_date             DATE  NOT NULL ,
	atte_in               DATE  NOT NULL ,
	atte_out              DATE ,
	atte_result           VARCHAR2(6) ,
	CONSTRAINT atte_mbno_fk FOREIGN KEY(mb_no) references appl(mb_no)
);
CREATE TABLE score(
	mb_no                 NUMBER  NOT NULL ,
	score_java            NUMBER(3) ,
	score_fw              NUMBER(3) ,
	score_db              NUMBER(3) ,
	score_jdate           DATE ,
	score_fdate           DATE ,
	score_ddate           DATE ,
	CONSTRAINT score_pk PRIMARY KEY(mb_no) ,
	CONSTRAINT score_mbno_fk FOREIGN KEY(mb_no) references appl(mb_no) ,
	CONSTRAINT score_java_ck check(score_java between 1 and 100) ,
	CONSTRAINT score_fw_ck check(score_fw between 1 and 100) ,
	CONSTRAINT score_db_ck check(score_db between 1 and 100) 
);
insert into dept values(0, '대기');
insert into dept values(1, '행정팀');
insert into dept values(2, '영업팀');
insert into dept values(3, '회계팀');
insert into dept values(4, '취업팀');
insert into dept values(5, '강사팀');
insert into state values(0,'가입완료');
insert into state values(1,'등록대기');
insert into state values(2,'신청대기');
insert into state values(3,'수강중');
insert into state values(4,'수료');
insert into emp values(emp_seq.nextval, 'admin', 'admin123', '관리자', '010-9999-9999', '내가 좋아하는 캐릭터는?', '토토로', '');
insert into emp values(emp_seq.nextval, 'emp01', 'emp01123', '직원일', '010-8888-8888', '가장 기억에 남는 선생님 성함은?', '김영조', '');
insert into emp values(emp_seq.nextval, 'emp02', 'emp02123', '직원이', '010-7777-7777', '기억에 남는 추억의 장소는?', '3강의실', '');
insert into mb values(mb_seq.nextval, 'mb01', 'mb011234', '학생일', '010-6666-6666', '다시 태어나면 되고 싶은 것은?', '돌맹이');
insert into mb values(mb_seq.nextval, 'mb02', 'mb021234', '학생이', '010-5555-5555', '유년시절 가장 생각나는 친구 이름은?', '둘리');
insert into mb values(mb_seq.nextval, 'mb03', 'mb031234', '학생삼', '010-4444-4444', '추억하고 싶은 날짜가 있다면?', '2월6일');
commit;