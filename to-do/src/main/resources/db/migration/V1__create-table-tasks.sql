CREATE TABLE tasks(
  id VARCHAR(255) PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  date TIMESTAMP NOT NULL,
  duration BIGINT NOT NULL
);