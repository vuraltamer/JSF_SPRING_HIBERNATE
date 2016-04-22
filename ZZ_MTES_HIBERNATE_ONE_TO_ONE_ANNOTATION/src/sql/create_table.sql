/*==============================================================*/
/* CREATE ONE TO ONE TABLE EXAMPLE                              */
/*==============================================================*/
DROP SCHEMA IF EXISTS OTO_TEST;
CREATE SCHEMA OTO_TEST;

/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/
CREATE TABLE OTO_TEST.PERSON (
    PERSON_ID 					BIGINT(10) NOT NULL AUTO_INCREMENT,
    PERSON_NAME 				VARCHAR(50) NULL DEFAULT NULL,
    PERSON_SURNAME 				VARCHAR(50) NULL DEFAULT NULL,
    
	PRIMARY KEY (PERSON_ID)
);

/*==============================================================*/
/* Table: PERSON_DETAIL                                         */
/*==============================================================*/
CREATE TABLE OTO_TEST.PERSON_DETAIL (
    PERSON_ID 					BIGINT(20) NOT NULL AUTO_INCREMENT,
    BIRTH_DATE 					VARCHAR(50) NULL DEFAULT NULL,
    BIRTH_PLACE 				VARCHAR(50) NULL DEFAULT NULL,
    CITY 						VARCHAR(50) NULL DEFAULT NULL,
    IDENTITY_NO 				VARCHAR(50) NULL DEFAULT NULL,
    
	PRIMARY KEY (PERSON_ID),
    CONSTRAINT FKPDETAILTOPERSON FOREIGN KEY (PERSON_ID) REFERENCES PERSON (PERSON_ID)
);