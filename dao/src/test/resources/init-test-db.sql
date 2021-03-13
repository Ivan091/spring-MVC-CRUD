INSERT INTO director (name, surname, birth_date)
VALUES ('John', 'Smith', '1960-07-25'),
       ('Steven', 'Spielberg', '1976-01-06'),
       ('Quentin', 'Tarantino', '1963-03-27');

INSERT INTO title(name, budget, premiere_date, runtime, box_office, director_id)
VALUES ('Bridge to Therabithia', 50000000, '2005-03-16', '2:10', 10000000, 1),
       ('Saving Private Ryan', 200000000, '1998-07-24', '2:48', 700000000, 2),
       ('Kill Bill Vol. 1', 100000000, '2001-06-11', '2:24', 500000000, 3),
       ('Kill Bill Vol. 2', 200000000, '2003-01-24', '2:24', 700000000, 3)