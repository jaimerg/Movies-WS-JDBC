# Dumping database structure for bookdatabase
DROP DATABASE IF EXISTS `moviesDB`;
CREATE DATABASE IF NOT EXISTS `moviesDB` DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
USE `moviesDB`;

DROP TABLE IF EXISTS `tematica`;
CREATE TABLE IF NOT EXISTS `tematica` (
  id       SERIAL,
  tematica VARCHAR(255) UNIQUE,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
  COMMENT ='Contains information about tematics';

DROP TABLE IF EXISTS `movies`;
CREATE TABLE IF NOT EXISTS `movies` (
  id            SERIAL,
  title         VARCHAR(255),
  id_tematica   BIGINT UNSIGNED NOT NULL,
  numSells      INT(11),
  publishedDate DATE,
  PRIMARY KEY (`id`),
  CONSTRAINT `foreign key movies tematica` FOREIGN KEY (id_tematica) REFERENCES tematica (id)
)
  ENGINE =InnoDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
  COMMENT ='Contains information about movies';


DROP TABLE IF EXISTS `actors`;
CREATE TABLE IF NOT EXISTS `actors` (
  id          SERIAL,
  first_name  VARCHAR(255),
  second_name VARCHAR(255),
  sex         VARCHAR(255),
  birth_date  DATE,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
  COMMENT ='Contains information about actors';

DROP TABLE IF EXISTS `actors_movies`;
CREATE TABLE IF NOT EXISTS `actors_movies` (
  id       SERIAL,
  actor_id BIGINT UNSIGNED NOT NULL,
  movie_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `foreign key actors i relacio_a_m` FOREIGN KEY (actor_id) REFERENCES actors (id),
  CONSTRAINT `foreign key movies i relacio_a_m` FOREIGN KEY (movie_id) REFERENCES movies (id)
)
  ENGINE =InnoDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
  COMMENT ='Contains information about relacio_a_m';

DROP TABLE IF EXISTS `nationality`;
CREATE TABLE IF NOT EXISTS `nationality` (
  id       SERIAL,
  nacionalidad VARCHAR(255) UNIQUE,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
  COMMENT ='Contains information about relacio_n_m';

DROP TABLE IF EXISTS `nationality_movies`;
CREATE TABLE IF NOT EXISTS `nationality_movies` (
  id       SERIAL,
  nationality_id BIGINT UNSIGNED NOT NULL,
  movie_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `foreign key nationality i relacio_nat_mov` FOREIGN KEY (nationality_id) REFERENCES nationality (id),
  CONSTRAINT `foreign key movies i relacio_nat_mov` FOREIGN KEY (movie_id) REFERENCES movies (id)
)
  ENGINE =InnoDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
  COMMENT ='Contains information about relacio_nat_mov';

# INSERT TEMATICS

INSERT INTO tematica (tematica) VALUES ("Familia");
INSERT INTO tematica (tematica) VALUES ("Humor");
INSERT INTO tematica (tematica) VALUES ("Terror");
INSERT INTO tematica (tematica) VALUES ("Intriga");
INSERT INTO tematica (tematica) VALUES ("Ficcion");
INSERT INTO tematica (tematica) VALUES ("Guerra");

# INSERT MOVIES

INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Cosins Bruch", 1, 56, "2005-11-13");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Happy Family", 2, 59, "2008-01-16");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("How I kill your mother", 3, 849083493, "2013-12-25");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Lost", 4, 567, "2005-11-13");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Loosers", 2, 765, "2005-11-13");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Luck", 2, 234, "2005-11-13");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Democracy", 5, 76, "2005-11-13");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Tanques", 6, 569, "2005-11-13");
INSERT INTO movies (title, id_tematica, numSells, publishedDate) VALUES ("Primos de madre", 2, 196, "2005-11-13");

#ISNERT ACTORS

INSERT INTO actors (first_name, second_name, sex, birth_date) VALUES ("alex", "bruch", "male", "1993-01-14");
INSERT INTO actors (first_name, second_name, sex, birth_date) VALUES ("joan", "patsy", "male", "1994-11-24");
INSERT INTO actors (first_name, second_name, sex, birth_date) VALUES ("sança", "romero", "female", "1990-01-14");
INSERT INTO actors (first_name, second_name, sex, birth_date) VALUES ("andreu", "waza", "male", "1899-09-09");

# INSERT actors_movies

INSERT INTO actors_movies (actor_id, movie_id) VALUES (1, 1);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (2, 2);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (3, 5);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (4, 4);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (3, 8);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (4, 3);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (1, 6);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (2, 9);
INSERT INTO actors_movies (actor_id, movie_id) VALUES (1, 7);

# INSERT nationality

INSERT INTO nationality (nacionalidad) VALUES ("Spain");
INSERT INTO nationality (nacionalidad) VALUES ("Germany");
INSERT INTO nationality (nacionalidad) VALUES ("U.K.");
INSERT INTO nationality (nacionalidad) VALUES ("Brasil");
INSERT INTO nationality (nacionalidad) VALUES ("Argentina");
INSERT INTO nationality (nacionalidad) VALUES ("France");
INSERT INTO nationality (nacionalidad) VALUES ("Italy");
INSERT INTO nationality (nacionalidad) VALUES ("Portugal");
INSERT INTO nationality (nacionalidad) VALUES ("Greece");
INSERT INTO nationality (nacionalidad) VALUES ("Canada");
INSERT INTO nationality (nacionalidad) VALUES ("Arab Emirates");
INSERT INTO nationality (nacionalidad) VALUES ("India");
INSERT INTO nationality (nacionalidad) VALUES ("China");
INSERT INTO nationality (nacionalidad) VALUES ("Japan");
INSERT INTO nationality (nacionalidad) VALUES ("New Zealand");
INSERT INTO nationality (nacionalidad) VALUES ("Australia");
INSERT INTO nationality (nacionalidad) VALUES ("Ireland");
INSERT INTO nationality (nacionalidad) VALUES ("Russia");

# INSERT nationality_movies
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (1, 1);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (2, 2);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (3, 3);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (4, 4);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (5, 5);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (6, 6);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (7, 7);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (8, 8);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (9, 9);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (10, 1);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (11, 2);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (12, 7);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (13, 4);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (14, 5);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (15, 2);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (16, 7);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (17, 5);
INSERT INTO nationality_movies (nationality_id,movie_id) VALUES (18, 9);

# Consultas SQL

#1. Datos actor y película dado nombre;
SELECT * FROM actors AS a
  INNER JOIN actors_movies AS am ON a.id = am.actor_id
  INNER JOIN movies AS m ON am.movie_id = m.id
  INNER JOIN tematica AS t ON t.id = m.id_tematica
  INNER JOIN nationality_movies AS nm ON nm.movie_id = m.id
  INNER JOIN nationality AS n ON n.id = nm.nationality_id
WHERE a.first_name LIKE '%Joan%' ORDER BY m.numSells DESC;
### Sin nacionalidades
SELECT * FROM actors AS a
  INNER JOIN actors_movies AS am ON a.id = am.actor_id
  INNER JOIN movies AS m ON am.movie_id = m.id
  INNER JOIN tematica AS t ON t.id = m.id_tematica
WHERE a.first_name LIKE '%Joan%' ORDER BY m.numSells DESC;

#2. Películas con temática comedia
SELECT * FROM movies AS m
  INNER JOIN tematica AS t ON t.id = m.id_tematica
WHERE t.tematica LIKE '%humor%';

#3. Nacionalidad Francesa y Genero Humor
SELECT * FROM movies AS m
  INNER JOIN tematica AS t ON t.id = m.id_tematica
  INNER JOIN nationality_movies AS nm ON nm.movie_id = m.id
  INNER JOIN nationality AS n ON n.id = nm.nationality_id
WHERE t.tematica LIKE '%humor%' AND n.nacionalidad LIKE '%france%';

#4.  Nacionalidad Francesa y Genero Humor entre la decada del 90 al 2005
SELECT * FROM movies AS m
  INNER JOIN tematica AS t ON t.id = m.id_tematica
  INNER JOIN nationality_movies AS nm ON nm.movie_id = m.id
  INNER JOIN nationality AS n ON n.id = nm.nationality_id
WHERE t.tematica LIKE '%humor%' AND n.nacionalidad LIKE '%france%' AND m.publishedDate BETWEEN '1990-01-01' AND '2005-12-31';

#5. Desde los 90 a la actualidad, genero humor , nacionalidad francesa y actor Jean Reno
SELECT * FROM movies AS m
  INNER JOIN tematica AS t ON t.id = m.id_tematica
  INNER JOIN nationality_movies AS nm ON nm.movie_id = m.id
  INNER JOIN nationality AS n ON n.id = nm.nationality_id
  INNER JOIN actors_movies AS am ON m.id = am.movie_id
  INNER JOIN actors AS a ON a.id = am.actor_id
WHERE t.tematica LIKE '%humor%'
      AND n.nacionalidad LIKE '%france%'
      AND a.first_name LIKE '%jean%'
      AND a.second_name LIKE '%reno%'
      AND m.publishedDate BETWEEN '1990-01-01' AND CURRENT_DATE;