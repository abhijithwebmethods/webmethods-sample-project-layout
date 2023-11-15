--------------------------------------------------------
--  File created - Sunday-November-12-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table EMPLOYEEDETAILS
--------------------------------------------------------

  CREATE TABLE "EMPLOYEEDETAILS" 
   (	"NAME" VARCHAR2(30 BYTE), 
	"EMPID" VARCHAR2(10 BYTE), 
	"DEPT" VARCHAR2(10 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into EMPLOYEEDETAILS
SET DEFINE OFF;
Insert into EMPLOYEEDETAILS (NAME,EMPID,DEPT) values ('Rakesh','1234','GCS');
Insert into EMPLOYEEDETAILS (NAME,EMPID,DEPT) values ('Ganesh','1235','GCS');
Insert into EMPLOYEEDETAILS (NAME,EMPID,DEPT) values ('Suresh','1236','GCS');
Insert into EMPLOYEEDETAILS (NAME,EMPID,DEPT) values ('Mahesh','1237','GCS');
Insert into EMPLOYEEDETAILS (NAME,EMPID,DEPT) values ('Rajesh','1238','GCS');
