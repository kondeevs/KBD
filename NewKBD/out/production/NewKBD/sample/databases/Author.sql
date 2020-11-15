CREATE TABLE author
(
    author_id        int,
    author_lastname  VARCHAR(10),
    author_firstname VARCHAR(15),
    author_country   VARCHAR(10),
    birthday         VARCHAR(10)
) CHARACTER SET utf8
  COLLATE utf8_unicode_ci;

INSERT author (author_id, author_lastname, author_firstname, author_country, birthday)
VALUES (1, 'Tsimafeyenko', 'Dzianis', 'Belarus', '31.08.2001');

INSERT author (author_id, author_lastname, author_firstname, author_country, birthday)
VALUES (2, 'Klevcevich', 'Alexandre', 'Belarus', '22.04.2001');