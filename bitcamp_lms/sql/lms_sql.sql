DROP TABLE score;
DROP TABLE atte;
DROP TABLE appl;
DROP TABLE state;
DROP TABLE cls_bbs;
DROP TABLE job_bbs;
DROP TABLE faq_bbs;
DROP TABLE ntc_bbs;
DROP TABLE recr_bbs;
DROP TABLE lec;
DROP TABLE info;
DROP TABLE emp;
DROP TABLE dept;
DROP TABLE mb;
DROP TABLE cate;
DROP SEQUENCE mb_seq;
DROP SEQUENCE emp_seq;
DROP SEQUENCE recr_seq;
DROP SEQUENCE ntc_seq;
DROP SEQUENCE faq_seq;
DROP SEQUENCE job_seq;
DROP SEQUENCE cls_seq;
CREATE TABLE cate(
   cate_no               NUMBER  NOT NULL ,
   cate_name             VARCHAR2(30)  NOT NULL ,
   CONSTRAINT cate_pk PRIMARY KEY(cate_no)
);
CREATE TABLE mb(
   mb_no                 NUMBER  NOT NULL ,
   mb_id                 VARCHAR2(30)  NOT NULL ,
   mb_pw                 VARCHAR2(20)  NOT NULL ,
   mb_name               VARCHAR2(30)  NOT NULL ,
   mb_tel                VARCHAR2(13)  NOT NULL ,
   mb_question           VARCHAR2(100)  NOT NULL ,
   mb_answer             VARCHAR2(100)  NOT NULL ,
   cate_no               NUMBER  DEFAULT 0  NOT NULL ,
   CONSTRAINT mb_pk PRIMARY KEY(mb_no) ,
   CONSTRAINT mb_cateno_fk FOREIGN KEY(cate_no) references cate(cate_no)
);
CREATE SEQUENCE mb_seq start with 10000;
CREATE TABLE dept(
   dept_no               NUMBER  NOT NULL ,
   dept_name             VARCHAR2(30)  NOT NULL ,
   CONSTRAINT dept_pk PRIMARY KEY(dept_no)
);
CREATE TABLE emp(
   mb_no                 NUMBER  NOT NULL ,
   emp_no                NUMBER  NOT NULL ,
   dept_no               NUMBER  DEFAULT 0  NOT NULL ,
   CONSTRAINT emp_pk PRIMARY KEY(mb_no , emp_no) ,
   CONSTRAINT emp_mbno_fk FOREIGN KEY(mb_no) references mb(mb_no) ,
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
   lec_lecnum            NUMBER(2)  NOT NULL ,
   lec_applnum           NUMBER(2)  NOT NULL ,
   CONSTRAINT lec_pk PRIMARY KEY(lec_code) , 
   CONSTRAINT lec_lecnum_ck check(lec_lecnum <= 30) 
);
CREATE TABLE recr_bbs(
   recr_no               NUMBER  NOT NULL ,
   mb_no                 NUMBER  NOT NULL ,
   emp_no                NUMBER  NOT NULL ,
   recr_count            NUMBER  NOT NULL ,
   recr_date             DATE  NOT NULL ,
   lec_code              VARCHAR2(10)  NOT NULL ,
   CONSTRAINT recr_pk PRIMARY KEY(recr_no) ,
   CONSTRAINT recr_mbno_fk FOREIGN KEY(mb_no , emp_no) references emp(mb_no , emp_no) , 
   CONSTRAINT recr_leccode_fk FOREIGN KEY(lec_code) references lec(lec_code)
);
CREATE SEQUENCE recr_seq;
CREATE TABLE ntc_bbs(
   ntc_no                NUMBER  NOT NULL ,
   mb_no                 NUMBER  NOT NULL ,
   emp_no                NUMBER  NOT NULL ,
   ntc_subject           VARCHAR2(100)  NOT NULL ,
   ntc_content           VARCHAR2(4000)  NOT NULL ,
   ntc_count             NUMBER  NOT NULL ,
   ntc_date              DATE  NOT NULL ,
   CONSTRAINT ntc_pk PRIMARY KEY(ntc_no) ,
   CONSTRAINT ntc_mbno_fk FOREIGN KEY(mb_no , emp_no) references emp(mb_no , emp_no)
);
CREATE SEQUENCE ntc_seq;
CREATE TABLE faq_bbs(
   faq_no                NUMBER  NOT NULL ,
   mb_no                 NUMBER  NOT NULL ,
   emp_no                NUMBER  NOT NULL ,
   faq_subject           VARCHAR2(100)  NOT NULL ,
   faq_content           VARCHAR2(4000)  NOT NULL ,
   faq_count             NUMBER  NOT NULL ,
   faq_date              DATE  NOT NULL ,
   CONSTRAINT faq_pk PRIMARY KEY(faq_no) ,
   CONSTRAINT faq_mbno_fk FOREIGN KEY(mb_no , emp_no) references emp(mb_no , emp_no)
);
CREATE SEQUENCE faq_seq;
CREATE TABLE job_bbs(
   job_no                NUMBER  NOT NULL ,
   mb_no                 NUMBER  NOT NULL ,
   emp_no                NUMBER  NOT NULL ,
   job_compname          VARCHAR2(60)  NOT NULL ,
   job_loc               VARCHAR2(30)  NOT NULL ,
   job_recrnum           NUMBER  NOT NULL ,
   job_emptype           VARCHAR2(30)  NOT NULL ,
   job_enddate           VARCHAR2(30)  NOT NULL ,
   job_content           VARCHAR2(4000)  NOT NULL ,
   job_count             NUMBER  NOT NULL ,
   job_date              DATE  NOT NULL ,
   CONSTRAINT job_pk PRIMARY KEY(job_no) ,
   CONSTRAINT job_mbno_fk FOREIGN KEY(mb_no , emp_no) references emp(mb_no , emp_no)
);
CREATE SEQUENCE job_seq;
CREATE TABLE cls_bbs(
   cls_no                NUMBER  NOT NULL ,
   mb_no                 NUMBER  NOT NULL ,
   emp_no                NUMBER  NOT NULL ,
   cls_subject           VARCHAR2(100)  NOT NULL ,
   cls_content           VARCHAR2(4000)  NOT NULL ,
   cls_count             NUMBER  NOT NULL ,
   cls_date              DATE  NOT NULL ,
   CONSTRAINT cls_pk PRIMARY KEY(cls_no) ,
   CONSTRAINT cls_mbno_fk FOREIGN KEY(mb_no , emp_no) references emp(mb_no , emp_no)
);
CREATE SEQUENCE cls_seq;
CREATE TABLE state(
   sta_code              NUMBER  NOT NULL ,
   sta_name              VARCHAR2(20)  NOT NULL ,
   CONSTRAINT sta_pk PRIMARY KEY(sta_code)
);
CREATE TABLE appl(
   mb_no                 NUMBER  NOT NULL ,
   sta_code              NUMBER  DEFAULT 0  NOT NULL ,
   lec_code              VARCHAR2(10) ,
   appl_date             DATE ,
   CONSTRAINT appl_pk PRIMARY KEY(mb_no) ,
   CONSTRAINT appl_mbno_fk FOREIGN KEY(mb_no) references mb(mb_no) ,
   CONSTRAINT appl_stacode_fk FOREIGN KEY(sta_code) references state(sta_code) ,
   CONSTRAINT appl_leccode_fk FOREIGN KEY(lec_code) references lec(lec_code)
);
CREATE TABLE atte(
   mb_no                 NUMBER  NOT NULL ,
   atte_date             VARCHAR2(8)  NOT NULL ,
   atte_in               VARCHAR2(8)  NOT NULL ,
   atte_out              VARCHAR2(8) ,
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
INSERT INTO  cate VALUES(0, '�л�');
INSERT INTO  cate VALUES(1, '������');
INSERT INTO  dept VALUES(0, '���');
INSERT INTO  dept VALUES(1, '������');
INSERT INTO  dept VALUES(2, '������');
INSERT INTO  dept VALUES(3, 'ȸ����');
INSERT INTO  dept VALUES(4, '�����');
INSERT INTO  dept VALUES(5, '������');
INSERT INTO  state VALUES(0,'���ԿϷ�');
INSERT INTO  state VALUES(1,'��û���');
INSERT INTO  state VALUES(2,'�������');
INSERT INTO  state VALUES(3,'������');
INSERT INTO  state VALUES(4,'����');
INSERT INTO  mb VALUES(mb_seq.nextval, 'admin1@bit.com', 'admin111', '������', '010-9999-9999', '���� �����ϴ� ĳ���ʹ�?', '�����', 1);
INSERT INTO  mb VALUES(mb_seq.nextval, 'admin2@bit.com', 'admin222', '������', '010-8888-8888', '���� �����ϴ� ĳ���ʹ�?', '�ö���', 1);
INSERT INTO  mb VALUES(mb_seq.nextval, 'admin3@bit.com', 'admin333', '������', '010-7777-7777', '���� �����ϴ� ĳ���ʹ�?', '�Ѹ�', 1);
INSERT INTO  mb VALUES(mb_seq.nextval, 'admin4@bit.com', 'admin444', '������', '010-6666-6666', '���� �����ϴ� ĳ���ʹ�?', '��ī��', 1);
INSERT INTO  mb VALUES(mb_seq.nextval, 'admin5@bit.com', 'admin555', '������', '010-5555-5555', '���� �����ϴ� ĳ���ʹ�?', '���̸�', 1);
INSERT INTO  emp VALUES(10000,emp_seq.nextval,1);
INSERT INTO  emp VALUES(10001,emp_seq.nextval,2);
INSERT INTO  emp VALUES(10002,emp_seq.nextval,3);
INSERT INTO  emp VALUES(10003,emp_seq.nextval,4);
INSERT INTO  emp VALUES(10004,emp_seq.nextval,5);
INSERT INTO  mb VALUES(mb_seq.nextval, 'mb01@bit.com', 'mb111111', '�л���', '010-6666-6666', '�ٽ� �¾�� �ǰ� ���� ����?', '���α�', DEFAULT);
INSERT INTO  mb VALUES(mb_seq.nextval, 'mb02@bit.com', 'mb222222', '�л���', '010-5555-5555', '�ٽ� �¾�� �ǰ� ���� ����?', '�����', DEFAULT);
INSERT INTO  mb VALUES(mb_seq.nextval, 'mb03@bit.com', 'mb333333', '�л���', '010-4444-4444', '�ٽ� �¾�� �ǰ� ���� ����?', '������', DEFAULT);
INSERT INTO lec VALUES('A1000','�������������� ��� �ڹ� Open Source Web application ���� ������ �缺���� - 2��','���μ�','����ð��ƴմϴ�','19/12/27','20/01/31','20/02/01','20/04/30',3,30,0);
INSERT INTO lec VALUES('B1000','�������������� ��� �ڹ� Open Source Web application ���� ������ �缺���� - 3��','������','����ð��ƴմϴ�','20/01/27','20/02/29','20/03/01','20/05/31',2,30,0);
INSERT INTO lec VALUES('C1000','�������������� ��� �ڹ� Open Source Web application ���� ������ �缺���� - 4��','���¼�','����ð��ƴմϴ�','20/02/27','20/03/31','20/04/01','20/06/30',1,30,0);
INSERT INTO lec VALUES('D1000','�������������� ��� �ڹ� Open Source Web application ���� ������ �缺���� - 5��','���μ�','����ð��ƴմϴ�','20/03/27','20/04/30','20/05/01','20/07/31',3,30,0);
INSERT INTO lec VALUES('E1000','�������������� ��� �ڹ� Open Source Web application ���� ������ �缺���� - 6��','������','����ð��ƴմϴ�','20/04/27','20/05/31','20/06/01','20/08/31',2,30,0);
INSERT INTO lec VALUES('F1000','�������������� ��� �ڹ� Open Source Web application ���� ������ �缺���� - 7��','���¼�','����ð��ƴմϴ�','20/05/27','20/06/30','20/07/01','20/09/30',1,30,0);
INSERT INTO recr_bbs VALUES(recr_seq.nextval,10001,1001,0,sysdate,'A1000');
INSERT INTO recr_bbs VALUES(recr_seq.nextval,10001,1001,0,sysdate,'B1000');
INSERT INTO recr_bbs VALUES(recr_seq.nextval,10001,1001,0,sysdate,'C1000');
INSERT INTO recr_bbs VALUES(recr_seq.nextval,10001,1001,0,sysdate,'D1000');
INSERT INTO recr_bbs VALUES(recr_seq.nextval,10001,1001,0,sysdate,'E1000');
INSERT INTO recr_bbs VALUES(recr_seq.nextval,10001,1001,0,sysdate,'F1000');
select * from mb;
commit;
-- BIN$ ���̺� ����
-- PURGE RECYCLEBIN;