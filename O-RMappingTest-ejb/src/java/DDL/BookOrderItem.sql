create table book_order_item (
    book_order_item_id integer generated always as identity,
    book_order_id integer,
    item_order integer,
    book_id integer,
    shipping_date timestamp,
    primary key(book_order_item_id)
)