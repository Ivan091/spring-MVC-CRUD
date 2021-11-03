DROP TABLE IF EXISTS title;
DROP TABLE IF EXISTS director;
DROP TABLE IF EXISTS user;
CREATE TABLE director
(
    director_id INT         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    surname     VARCHAR(50) NOT NULL,
    birth_date  DATE        NOT NULL,
    PRIMARY KEY (director_id)
);

CREATE TABLE title
(
    title_id      INT         NOT NULL AUTO_INCREMENT,
    name          VARCHAR(50) NOT NULL,
    budget        REAL        NOT NULL,
    premiere_date DATE        NOT NULL,
    runtime       INT         NOT NULL,
    box_office    REAL        NOT NULL,
    director_id   INT,
    FOREIGN KEY (director_id) REFERENCES director (director_id) ON DELETE SET NULL
);

CREATE TABLE user
(
    login    VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (login)
);