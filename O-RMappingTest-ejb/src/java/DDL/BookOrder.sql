create table book_order (
    book_order_id integer generated always as identity,
    customer_name varchar(16),
    order_date timestamp,
    primary key(book_order_id)
)