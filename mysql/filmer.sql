INSERT INTO Personer (id, navn, bursdag, land)
VALUES
(1, 'Christopher Nolan', '1970-07-30', 'England'),
(2, 'Leonardo DiCaprio','1974-11-11','USA'),
(3, 'Joseph Gordon-Levitt','1981-02-17','USA'),
(4, 'Ellen Page','1987-02-21','Canada'),
(5, 'Hans Zimmer','1957-09-12','Tyskland'),
(6, 'Emily Mortimer', '1971-12-01', 'England'),
(7, 'Mark Ruffalo', '1967-11-22', 'USA'),
(8, 'Martin Scorsese', '1942-11-17', 'USA'),
(9, 'Laeta Kalogridis', '1965-08-30', 'USA')
;

INSERT INTO Kategorier (id, navn, beskrivelse)
VALUES
(1, 'Action','Yes'),
(2, 'Adventure','Yes'),
(3, 'Sci-Fi','Yes'),
(4, 'Thriller','Yes'),
(5, 'Mystery','Yes')
;

INSERT INTO Selskaper (id, navn, adresse, land, nettside)
VALUES
(1, 'Warner Bros.','3400 Warner Blvd, Burbank, CA 91505','USA','www.warnerbros.com/'),
(2, 'Paramount Pictures','5555 Melrose Avenue, Hollywood, California','USA','www.paramount.com/')
;

INSERT INTO Titler (id, tittel, lanseringsdato, laget_for, lengde, beskrivelse, utgiver_id)
VALUES
(1, 'Inception','2010-07-13','Kino',148,
    'Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb''s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.',
    1),
(2, 'Shutter Island','2010-02-19','Kino',138,
    'In 1954, up-and-coming U.S. marshal Teddy Daniels is assigned to investigate the disappearance of a patient from Boston''s Shutter Island Ashecliffe Hospital. He''s been pushing for an assignment on the island for personal reasons, but before long he thinks he''s been brought there as part of a twisted plot by hospital doctors whose radical treatments range from unethical to illegal to downright sinister. Teddy''s shrewd investigating skills soon provide a promising lead, but the hospital refuses him access to records he suspects would break the case wide open. As a hurricane cuts off communication with the mainland, more dangerous criminals "escape" in the confusion, and the puzzling, improbable clues multiply, Teddy begins to doubt everything - his memory, his partner, even his own sanity.',
    2)
;

INSERT INTO Roller (tittel_id, skuespiller_id, rollenavn)
VALUES
(1,2,'Cobb'),
(1,3,'Arthur'),
(1,4,'Ariadne'),
(2,2,'Teddy Daniels'),
(2,6,'Rachel 1'),
(2,7,'Chuck Aule')
;

INSERT INTO Komponister (komponist_id, tittel_id)
VALUES
(5,1)
;

INSERT INTO Regissorer (regissor_id, tittel_id)
VALUES
(1,1),
(8,2)
;

INSERT INTO Manusforfattere (forfatter_id, tittel_id)
VALUES
(1,1),
(9,2)
;

INSERT INTO Tittel_i_kategori (tittel_id, kategori_id)
VALUES
(1,2),
(1,3),
(1,4),
(2,4),
(2,5)
;
