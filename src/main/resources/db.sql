create table trainer
(
    id   bigint auto_increment primary key,
    name varchar(64) not null,
    groupid bigint
)DEFAULT CHARSET=utf8mb4;
create table `group`
(
    id   bigint auto_increment primary key,
    name varchar(64) not null
)DEFAULT CHARSET=utf8mb4;
create table trainee
(
    id   bigint auto_increment primary key,
    name varchar(64) not null,
    groupid bigint
)DEFAULT CHARSET=utf8mb4;