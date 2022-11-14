create table mydb.user_table
(
    id       int auto_increment
        primary key,
    username varchar(255) null,
    password varchar(255) null,
    age      varchar(255) null,
    sex      varchar(255) null,
    hobby    varchar(255) null,
    constraint id
        unique (id)
)
    engine = InnoDB;

