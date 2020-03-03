INSERT INTO Personer(navn, bursdag, land)
VALUES
('Christopher Nolan', '1970-07-30', 'England'),
('Leonardo DiCaprio','1974-11-11','USA'),
('Joseph Gordon-Levitt','1981-02-17','USA'),
('Ellen Page','1987-02-21','Canada'),
('Hans Zimmer','1957-09-12','Tyskland'),
('Emily Mortimer', '1971-12-01', 'England'),
('Mark Ruffalo', '1967-11-22', 'USA'),
('Martin Scorsese', '1942-11-17', 'USA'),
('Laeta Kalogridis', '1965-08-30', 'USA');

INSERT INTO Kategorier (navn, beskrivelse)
VALUES
('Action','Yes'),
('Adventure','Yes'),
('Sci-Fi','Yes'),
('Thriller','Yes'),
('Mystery','Yes');

INSERT INTO Selskaper (navn, adresse, land, nettside)
VALUES
('Warner Bros.','3400 Warner Blvd, Burbank, CA 91505','USA','www.warnerbros.com/'),
('Paramount Pictures','5555 Melrose Avenue, Hollywood, California','USA','www.paramount.com/');


INSERT INTO Titler (tittel, lanseringsdato, laget_for, lengde, beskrivelse, utgiver_id)
VALUES
('Inception','2010-07-13','Kino',148,
    'Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb''s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.',
    1),
('Shutter Island','2010-02-19','Kino',138,
    'In 1954, up-and-coming U.S. marshal Teddy Daniels is assigned to investigate the disappearance of a patient from Boston''s Shutter Island Ashecliffe Hospital. He''s been pushing for an assignment on the island for personal reasons, but before long he thinks he''s been brought there as part of a twisted plot by hospital doctors whose radical treatments range from unethical to illegal to downright sinister. Teddy''s shrewd investigating skills soon provide a promising lead, but the hospital refuses him access to records he suspects would break the case wide open. As a hurricane cuts off communication with the mainland, more dangerous criminals "escape" in the confusion, and the puzzling, improbable clues multiply, Teddy begins to doubt everything - his memory, his partner, even his own sanity.',
    2);

INSERT INTO Roller
VALUES
(1,2,'Cobb'),
(1,3,'Arthur'),
(1,4,'Ariadne'),
(2,2,'Teddy Daniels'),
(2,6,'Rachel 1'),
(2,7,'Chuck Aule');

INSERT INTO Komponister
VALUES
(5,1);

INSERT INTO Regissorer
VALUES
(1,1),
(8,2);

INSERT INTO Manusforfattere
VALUES
(1,1),
(9,2);

INSERT INTO Tittel_i_kategori
VALUES
(1,2),
(1,3),
(1,4),
(2,4),
(2,5);
