-- INSERT INTO Personer(navn, bursdag, land)
-- VALUES
-- ('Christopher Nolan', '1970-07-30', 'England'),
-- ('Leonardo DiCaprio','1974-11-11','USA'),
-- ('Joseph Gordon-Levitt','1981-02-17','USA'),
-- ('Ellen Page','1987-02-21','Canada'),
-- ('Hans Zimmer','1957-09-12','Tyskland');

-- INSERT INTO Kategorier (navn, beskrivelse)
-- VALUES
-- ('Action','Yes'),
-- ('Adventure','Yes'),
-- ('Sci-Fi','Yes'),
-- ('Thriller','Yes');

-- INSERT INTO Selskaper (navn, adresse, land, nettside)
-- VALUES
-- ('Warner Bros.','3400 Warner Blvd, Burbank, CA 91505','USA','https://www.warnerbros.com/');


INSERT INTO Titler (tittel, lanseringsdato, laget_for, lengde, beskrivelse, utgiver_id)
VALUES
('Inception','2010-07-13','Kino',148,
    'Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb''s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.',
    1);
