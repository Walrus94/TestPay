drop table if exists USER;

create table user (
	ID BIGINT(19) PRIMARY KEY NOT NULL AUTOINCREMENT,
	EMAIL VARCHAR(255) NOT NULL
);