DROP TABLE IF EXISTS director;
CREATE TABLE director
(
    director_id INT         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    surname     VARCHAR(50) NOT NULL,
    birth_date  DATE        NOT NULL,
    PRIMARY KEY (director_id)
);