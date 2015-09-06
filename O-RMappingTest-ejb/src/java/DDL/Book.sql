create table book (
    book_id integer generated always as identity,
    book_type varchar(10),
    book_name varchar(50),
    stock_count integer,
    primary key(book_id)
)