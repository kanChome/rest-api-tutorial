CREATE EXTENSION pgcrypto;

CREATE TABLE IF NOT EXISTS member (
  id serial PRIMARY KEY,
  first_name varchar(32) NOT NULL,
  last_name varchar(32) NOT NULL
);