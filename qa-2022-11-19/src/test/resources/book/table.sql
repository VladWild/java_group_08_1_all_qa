create table if not exists BOOKS (
    id  integer not null primary key auto_increment,
    title varchar(255),
    constraint BOOK_PK primary key (id)
);