create table authors (id bigserial primary key, name varchar(255));
insert into authors (name)
values
('Rowling'),
('Tolstoy');

create table books (id bigserial primary key, title varchar(255), year int, author_id bigint references authors (id));
insert into books (title, year, author_id)
values
('Harry Potter and the Goblet of Fire', 1998, 1),
('Harry Potter and the Half-Blood Prince', 2000, 1),
('War and Peace 1', 1863, 2),
('War and Peace 2', 1870, 2)

