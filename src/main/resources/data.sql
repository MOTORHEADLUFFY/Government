DROP TABLE IF EXISTS OCCUPATION;

DROP TABLE IF EXISTS PERSON;

DROP TABLE IF EXISTS EMPLOYEMENT;

CREATE TYPE genderType as ENUM('M', 'F', 'T');

CREATE TABLE OCCUPATION (
	ID INTEGER PRIMARY KEY,
	NAME VARCHAR(30) NOT NULL,
	AVERAGE_SALARY INTEGER
);

CREATE TABLE EMPLOYEMENT (
	PERSON_ID VARCHAR(20) NOT NULL,
	JOB_ID INTEGER,
	OCCUPATION_ID VARCHAR(30),
	PRIMARY KEY(PERSON_ID, JOB_ID, OCCUPATION_ID),
	FOREIGN KEY (OCCUPATION_ID) REFERENCES OCCUPATION(ID)
);	

CREATE TABLE PERSON (
	ID VARCHAR(20) PRIMARY KEY,
	FIRST_NAME VARCHAR(20),
	LAST_NAME VARCHAR(20),
	AGE INTEGER,
	SALARY INTEGER,
	GENDER genderType,
	PARENT_ID_1 VARCHAR(20),
	PARENT_ID_2 VARCHAR(20)
);
	
INSERT INTO OCCUPATION VALUES 
(1, 'Software Engineer', 80000),
(2, 'Plumber', 24000),
(3, 'President', 120000),
(4, 'Carpenter', 15000),
(5, 'Gardener', 7500),
(6, 'YouTuber/Streamer', 35000),
(7, 'Cook', 30000),
(8, 'Business owner', 250000),
(9, 'Chartered Accountant', 70000),
(10, 'Clerk', 18500),
(11, 'Priest', 17250),
(12, 'Banker', 45000);

INSERT INTO EMPLOYEMENT VALUES
('HAXFSABDAS', 1, 10),
('HAXFSABDAS', 2, 4),
('DGPDFPSSDF', 1, 7),
('SDFSEFSEER', 1, 9),
('MNFBDXFBFD', 1, 1),
('AWDASFADSA', 1, 2),
('ADHGTYHJNM', 1, 1);


INSERT INTO PERSON VALUES
('HAXFSABDAS', 'Shivam', 'Pal', 23, 37450,'M', 'AWDASFADSA', 'SDEFSDSDFB'),
('AWDASFADSA', 'Ramnath', 'Pal', 55, 24000,'M', 'XVDFFGDFDV', 'MNGHFGDDRT'),
('SDEFSDSDFB', 'Shivani', 'Pal', 51, 0 ,'F', 'YUJTFFGHFG', 'PUYJTFDRGW'),
('QWEQWEQQWW', 'GopalNath', 'Srivastava', 73, 0 ,'M','', ''),
('SDFSEFSEER', 'Arvind', 'Srivastava', 50, 78000,'M', 'QWEQWEQQWW', 'VSDDWEFDSD'),
('MNFBDXFBFD', 'RaviKanth', 'Srivastava', 48, 52000,'M', 'QWEQWEQQWW', 'DGPDFPSSDF'),
('VSDDWEFDSD', 'Lakshita', 'Saxena', 47, 0,'F', 'SDGVXDCSDEF', 'WERTYHGFRD'),
('DGPDFPSSDF', 'Ramita', 'Krishnan', 44, 27500,'F', 'NRGDBSVSDD', 'XDFSEFSDFS'),
('ADHGTYHJNM', 'Arpit', 'Srivastava', 22, 55000,'M', 'SDFSEFSEER', 'VSDDWEFDSD'),
('UUGJMNVGHH', 'Aarohi', 'Srivastava', 18, 0,'F', 'MNFBDXFBFD', 'DGPDFPSSDF'),
('POIUYTFBNN', 'Manisha', 'Srivastava', 12, 0,'F', 'MNFBDXFBFD', 'DGPDFPSSDF'),
('RTYCVGUUUB', 'Narendra', 'Modi', 66, 275000,'M', 'OUIGUKJNJB', 'WERETCVGHH');























