-- Create Schema By Sys as DBA
-- USER SQL
-- CREATE USER openlab IDENTIFIED BY open123 ;

-- ROLES
-- GRANT "CONNECT" TO openlab ;
-- GRANT "RESOURCE" TO openlab ;

-- drop table users;
CREATE TABLE T_USER 
(
  ID NUMt_dept_wangxiname VARCHAR2(50) ,
  mgr NUMBER(7, 0),  
  hiredate DATE, 
  sal NUMBER(7, 2),
  comm NUMBER(7, 2),
  deptno NUMBER(7, 0),
  PRIMARY KEY (empno)
);
--drop SEQUENCE SEQ_T_EMP;
CREATE SEQUENCE SEQ_T_EMP;   

CREATE TABLE t_dept_wangxin 
(
  deptno NUMBER(7, 0) , 
  dname VARCHAR2(50) ,
  loc VARCHAR2(50),  
  PRIMARY KEY (deptno)
);
drop table t_dept_wangxin
--drop SEQUENCE SEQ_T_EMP;
CREATE SEQUENCE SEQ_T_DEPT;   
select * from t_dept_wangxin