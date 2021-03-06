CREATE TABLE ACCOUNT (
ID BIGINT IDENTITY PRIMARY KEY, OWNER_NAME VARCHAR(255), BALANCE DOUBLE,
ACCESS_TIME TIMESTAMP,
LOCKED BOOLEAN
);

DROP TABLE IF EXISTS CONTACT;
CREATE TABLE CONTACT (
    ID INT NOT NULL AUTO_INCREMENT
  , FIRST_NAME VARCHAR(60) NOT NULL
  , LAST_NAME VARCHAR(40) NOT NULL
  , BIRTH_DATE DATE
  , VERSION INT NOT NULL DEFAULT 0
  , UNIQUE UQ_CONTACT_1 (FIRST_NAME, LAST_NAME)
  , PRIMARY KEY (ID)
);