INSERT INTO Personer (id, navn, bursdag, land)
VALUES
( 1, 'Christopher Nolan', '1970-07-30', 'England'),
( 2, 'Leonardo DiCaprio','1974-11-11','USA'),
( 3, 'Joseph Gordon-Levitt','1981-02-17','USA'),
( 4, 'Ellen Page','1987-02-21','Canada'),
( 5, 'Hans Zimmer','1957-09-12','Tyskland'),
( 6, 'Emily Mortimer', '1971-12-01', 'England'),
( 7, 'Mark Ruffalo', '1967-11-22', 'USA'),
( 8, 'Martin Scorsese', '1942-11-17', 'USA'),
( 9, 'Laeta Kalogridis', '1965-08-30', 'USA'),
(10, 'Jonathan Nolan', '1976-06-06', 'England'),
(11, 'Christian Bale', '1974-01-30', 'Wales'),
(12, 'Heath Ledger', '1979-04-04', 'Australia'),
(13, 'Aaron Eckhart', '1968-03-12', 'USA'),
(14, 'James Newton Howard', '1951-06-09', 'USA'),
(15, 'Quentin Tarantino', '1963-03-27', 'USA'),
(16, 'Roger Avary', '1965-08-23', 'Canada'),
(17, 'John Travolta', '1954-02-18', 'USA'),
(18, 'Uma Thurman', '1970-04-29', 'USA'),
(19, 'Samuel L. Jackson', '1948-12-21', 'USA'),
(20, 'Ethan Coen', '1957-09-21', 'USA'),
(21, 'Joel Coen', '1954-11-29', 'USA'),
(22, 'Tommy Lee Jones', '1946-09-15', 'USA'),
(23, 'Javier Bardem', '1969-03-01', 'Spania'),
(24, 'Josh Brolin', '1968-02-12', 'USA'),
(25, 'Carter Burwell', '1954-11-18', 'USA')
;

INSERT INTO Kategorier (id, navn, beskrivelse)
VALUES
(1, 'Action','Yes'),
(2, 'Adventure','Yes'),
(3, 'Sci-Fi','Yes'),
(4, 'Thriller','Yes'),
(5, 'Mystery','Yes'),
(6, 'Crime','Yes'),
(7, 'Drama','Yes')
;

INSERT INTO Selskaper (id, navn, adresse, land, nettside)
VALUES
(1, 'Warner Bros.','3400 Warner Blvd, Burbank, CA 91505','USA','www.warnerbros.com/'),
(2, 'Paramount Pictures','5555 Melrose Avenue, Hollywood, California','USA','www.paramount.com/'),
(3, 'Miramax','Los Angeles, California','USA','www.miramax.com'),
(4, 'Home Box Office', 'New York City, New York', 'USA', 'www.hbo.com'),
(5, 'Netflix', 'Los Gatos, California', 'USA', 'www.netflix.com')
;

INSERT INTO Titler (id, tittel, lanseringsdato, laget_for, lengde, beskrivelse, utgiver_id)
VALUES
(1, 'Inception','2010-07-13','Kino',148,
    'Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb''s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.',
    1),
(2, 'Shutter Island','2010-02-19','Kino',138,
    'In 1954, up-and-coming U.S. marshal Teddy Daniels is assigned to investigate the disappearance of a patient from Boston''s Shutter Island Ashecliffe Hospital. He''s been pushing for an assignment on the island for personal reasons, but before long he thinks he''s been brought there as part of a twisted plot by hospital doctors whose radical treatments range from unethical to illegal to downright sinister. Teddy''s shrewd investigating skills soon provide a promising lead, but the hospital refuses him access to records he suspects would break the case wide open. As a hurricane cuts off communication with the mainland, more dangerous criminals "escape" in the confusion, and the puzzling, improbable clues multiply, Teddy begins to doubt everything - his memory, his partner, even his own sanity.',
    2),
(3, 'The Dark Knight','2008-07-18','Kino',152,
    'Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, and new District Attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City, until a mysterious and sadistic criminal mastermind known only as "The Joker" appears in Gotham, creating a new wave of chaos. Batman''s struggle against The Joker becomes deeply personal, forcing him to "confront everything he believes" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes.',
    1),
(4, 'Pulp Fiction','1994-10-04','Kino',154,
    'Jules Winnfield (Samuel L. Jackson) and Vincent Vega (John Travolta) are two hit men who are out to retrieve a suitcase stolen from their employer, mob boss Marsellus Wallace (Ving Rhames). Wallace has also asked Vincent to take his wife Mia (Uma Thurman) out a few days later when Wallace himself will be out of town. Butch Coolidge (Bruce Willis) is an aging boxer who is paid by Wallace to lose his fight. The lives of these seemingly unrelated people are woven together comprising of a series of funny, bizarre and uncalled-for incidents.',
    3),
(5, 'No Country for Old Men','2007-11-21','Kino',122,
    'In rural Texas, welder and hunter Llewelyn Moss (Josh Brolin) discovers the remains of several drug runners who have all killed each other in an exchange gone violently wrong. Rather than report the discovery to the police, Moss decides to simply take the two million dollars present for himself. This puts the psychopathic killer, Anton Chigurh (Javier Bardem), on his trail as he dispassionately murders nearly every rival, bystander and even employer in his pursuit of his quarry and the money. As Moss desperately attempts to keep one step ahead, the blood from this hunt begins to flow behind him with relentlessly growing intensity as Chigurh closes in. Meanwhile, the laconic Sheriff Ed Tom Bell (Tommy Lee Jones) blithely oversees the investigation even as he struggles to face the sheer enormity of the crimes he is attempting to thwart.',
    3),
    (6, 'Winter is Coming', '2011-05-04', 'TV', 62, 'Eddard Stark is torn between his family and an old friend when asked to serve at the side of King Robert Baratheon; Viserys plans to wed his sister to a nomadic warlord in exchange for an army.', 4),
    (7, 'The Kingsroad', '2011-05-11', 'TV', 56, 'While Bran recovers from his fall, Ned takes only his daughters to King''s Landing. Jon Snow goes with his uncle Benjen to the Wall. Tyrion joins them.', 4),
    (8, 'Lord Snow', '2011-05-01', 'TV', 58, 'Jon begins his training with the Night''s Watch; Ned confronts his past and future at King''s Landing; Daenerys finds herself at odds with Viserys.', 4),
    (9, 'Cripples, Bastards, and Broken Things', '2011-05-08', 'TV', 56, 'Eddard investigates Jon Arryn''s murder. Jon befriends Samwell Tarly, a coward who has come to join the Night''s Watch.', 4),
    (10, 'The Wolf and the Lion', '2011-05-15', 'TV', 55, 'Catelyn has captured Tyrion and plans to bring him to her sister, Lysa Arryn, at the Vale, to be tried for his, supposed, crimes against Bran. Robert plans to have Daenerys killed, but Eddard refuses to be a part of it and quits.', 4),
    (11, 'A Golden Crown', '2011-05-22', 'TV', 53, 'While recovering from his battle with Jaime, Eddard is forced to run the kingdom while Robert goes hunting. Tyrion demands a trial by combat for his freedom. Viserys is losing his patience with Drogo.', 4),
    (12, 'You Win or You Die', '2011-05-29', 'TV', 58, 'Robert has been injured while hunting and is dying. Jon and the others finally take their vows to the Night''s Watch. A man, sent by Robert, is captured for trying to poison Daenerys. Furious, Drogo vows to attack the Seven Kingdoms.', 4),
    (13, 'The Pointy End', '2011-06-05', 'TV', 59, 'The Lannisters press their advantage over the Starks; Robb rallies his father''s northern allies and heads south to war; The White Walkers attack the Wall; Tyrion returns to his father with some new friends.', 4),
    (14, 'Baelor', '2011-06-12', 'TV', 57, 'Robb goes to war against the Lannisters. Jon finds himself struggling on deciding if his place is with Robb or the Night''s Watch. Drogo has fallen ill from a fresh battle wound. Daenerys is desperate to save him.', 4),
    (15, 'Fire and Blood', '2011-06-19', 'TV', 53, 'Robb vows to get revenge on the Lannisters. Jon must officially decide if his place is with Robb or the Night''s Watch. Daenerys says her final goodbye to Drogo.', 4),
    (16, 'Currahee', '2001-09-09', 'TV', 70, 'Easy Company goes through training under the leadership of a captain who relentlessly pushes them to their limits but may be limited as a leader in the field.', 4),
    (17, 'Day of Days', '2001-09-09', 'TV', 64, 'Easy Company paratroopers jump behind enemy lines in Normandy on D-Day and struggle to reunite in hostile territory.', 4),
    (18, 'Carentan', '2001-09-16', 'TV', 62, 'Easy Company takes on German troops in the French town of Carentan, and the battle takes its toll on one soldier who is badly traumatized by the experience.', 4),
    (19, 'Replacements', '2001-09-23', 'TV', 57, 'With the addition of many new men, Easy Company heads to Holland to participate in Operation Market Garden and prepare an Allied route into Germany, but they meet stiff German resistance.', 4),
    (20, 'Crossroads', '2001-09-30', 'TV', 53, 'Winters writes a report on the challenge of an unexpected resistance to a German attack, and is haunted by his conscience after shooting a teenage German SS soldier.', 4),
    (21, 'Bastogne', '2001-10-07', 'TV', 64, 'In the dead of winter, the men of Easy Company fend off frostbite and hunger - in addition to the enemy - while holding the line in a forest outside of Bastogne. Meanwhile, exhausted medic Eugene Roe finds friendship with a Belgian nurse.', 4),
    (22, 'All to Play For', '2019-03-08', 'TV', 40, 'Driver Daniel Ricciardo looks to make a statement on the track while the teams prepare for the first race of the season at the Australian Grand Prix.', 5);

INSERT INTO Roller (tittel_id, skuespiller_id, rollenavn)
VALUES
(1,2,'Cobb'),
(1,3,'Arthur'),
(1,4,'Ariadne'),
(2,2,'Teddy Daniels'),
(2,6,'Rachel 1'),
(2,7,'Chuck Aule'),
(3,11,'Bruce Wayne'),
(3,12,'Joker'),
(3,13,'Harvey Dent'),
(4,17,'Vincent Vega'),
(4,18,'Mia Wallace'),
(4,19,'Jules Winnfield'),
(5,22,'Ed Tom Bell'),
(5,23,'Anton Chigurh'),
(5,24,'24Llewelyn Moss')
;

INSERT INTO Komponister (komponist_id, tittel_id)
VALUES
(5,1),
(5,3),
(14,3),
(25,5)
;

INSERT INTO Regissorer (regissor_id, tittel_id)
VALUES
(1,1),
(8,2),
(1,3),
(15,4),
(20,5),
(21,5)
;

INSERT INTO Manusforfattere (forfatter_id, tittel_id)
VALUES
(1,1),
(9,2),
(1,3),
(10,3),
(15,4),
(16,4),
(20,5),
(21,5)
;

INSERT INTO Tittel_i_kategori (tittel_id, kategori_id)
VALUES
(1,1),
(1,2),
(1,3),
(2,4),
(2,5),
(3,1),
(3,6),
(3,7),
(4,6),
(4,7),
(5,6),
(5,7),
(5,4)
;

INSERT INTO Serier
    (id, tittel)
VALUES
    (1, 'Game of Thrones'),
    (2, 'Band of Brothers'),
    (3, 'Formula 1: Drive to Survive');

INSERT INTO Episoder
    (serie_id, episode_id, sesong, episodenummer)
VALUES
    (1, 6, 1, 1),
    (1, 7, 1, 2),
    (1, 8, 1, 3),
    (1, 9, 1, 4),
    (1, 10, 1, 5),
    (1, 11, 1, 6),
    (1, 12, 1, 7),
    (1, 13, 1, 8),
    (1, 14, 1, 9),
    (1, 15, 1, 10),
    (2, 16, 1, 1),
    (2, 17, 1, 2),
    (2, 18, 1, 3),
    (2, 19, 1, 4),
    (2, 20, 1, 5),
    (2, 21, 1, 6),
    (3, 22, 1, 1);
