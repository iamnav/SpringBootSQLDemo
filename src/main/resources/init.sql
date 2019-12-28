CREATE TABLE album
(
    id int(11) NOT NULL,
    userId int(11) NOT NULL,
    title varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE photo (
    albumId int NOT NULL,
    id int NOT NULL,
    title varchar(100),
    url varchar(100),
	thumbnailUrl varchar(100),
    PRIMARY KEY (id),
    FOREIGN KEY (albumId) REFERENCES album(id)
);