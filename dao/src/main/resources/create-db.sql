DROP TABLE IF EXISTS title;
DROP TABLE IF EXISTS director;
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
    runtime       TIME        NOT NULL,
    box_office    REAL        NOT NULL,
    director_id   INT,
    CONSTRAINT fk_director_id FOREIGN KEY (director_id)
        REFERENCES director (director_id)
        ON DELETE SET NULL
)