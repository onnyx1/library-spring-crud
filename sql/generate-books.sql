CREATE USER 'librarian'@'localhost' IDENTIFIED BY 'IloveBooks!';

GRANT ALL PRIVILEGES ON * . * TO 'librarian'@'localhost';



CREATE DATABASE  IF NOT EXISTS `library`;
USE `library`;



DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `number_of_pages` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `books` VALUES 
	(1,'The Great Gatsby','F. Scott Fitzgerald','Scribner','Historical Fiction',208),
	(2,'Moby Dick','Herman Melville','Harper & Brothers','Adventure fiction',378),
	(3,'To Kill a Mockingbird','Harper Lee','J. B. Lippincott & Co.','Southern Gothic fiction', 281),
	(4,'Don Quixote','Miguel de Cervantes','Francisco de Robles','Novel',1072),
	(5,'Lord of the Flies','William Golding','Faber and Faber','Allegorical novel',224);

