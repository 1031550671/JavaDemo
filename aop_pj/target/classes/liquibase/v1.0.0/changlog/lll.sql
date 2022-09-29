create table pl_test_demo
(
id INT NOT NULL AUTO_INCREMENT primary key,
notice_type int2 not null,
languge_type int2 not null,
content varchar(255),
created_by VARCHAR(36),
created_date timestamp,
last_modified_by VARCHAR(36),
last_modified_date timestamp,
deleted boolean
);