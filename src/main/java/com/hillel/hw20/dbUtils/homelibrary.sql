
drop table IF EXISTS `actor`;
create TABLE `actor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `actor` WRITE;

insert into `actor` VALUES (1,'Angelina Jolie','1975'),(2,'Kris Evans','1981'),(3,'Eric Bana','1970'),(4,'Bruno Mars','1960'),(5,'Robert Downey Jr.','1965');
UNLOCK TABLES;

drop table IF EXISTS `director`;
create TABLE `director` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `director` WRITE;
insert into `director` VALUES (1,'Angelina Karol','1995'),(2,'Marta Stuart','1980'),(3,'Roger Alkin','1979'),(4,'Bob Stan','1930'),(5,'Robert Downey Jr.','1965');
UNLOCK TABLES;

drop table IF EXISTS `film`;
create TABLE `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `date_of_release` varchar(45) DEFAULT NULL,
  `country_of_release` varchar(45) DEFAULT NULL,
  `director_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`director_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `film` WRITE;
insert into `film` VALUES (1,'Avengers','2010','America',5),(2,'Tor','2011','America',2),(3,'Godfather','1980','Italy',1),(4,'Three Canoes','1920','Ukraine',3);
UNLOCK TABLES;

drop table IF EXISTS `films_and_actors`;
create TABLE `films_and_actors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`film_id`,`actor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `films_and_actors` WRITE;
insert into `films_and_actors` VALUES (1,1,1),(2,2,2),(3,3,3),(4,1,2);
UNLOCK TABLES;

 SET NAMES utf8 ;

drop table IF EXISTS `User`;
 SET character_set_client = utf8mb4 ;
create TABLE `User` (
  `idUser` int(11) NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `User` WRITE;
insert into `User` VALUES (1,'vasya','user','1'),(2,'kiril','admin','666'),(3,'jorge','bog','9');
UNLOCK TABLES;
 SET TIME_ZONE=@
