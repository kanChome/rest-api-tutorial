CREATE EXTENSION pgcrypto;

CREATE TABLE IF NOT EXISTS member (
  id uuid PRIMARY KEY DEFAULT public.gen_random_uuid(),
  first_name varchar(32) NOT NULL,
  last_name varchar(32) NOT NULL
);