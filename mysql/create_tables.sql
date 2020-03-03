DROP TABLE Tittel_i_kategori;
DROP TABLE Komponister;
DROP TABLE Musikere;
DROP TABLE Manusforfattere;
DROP TABLE Regissorer;
DROP TABLE Episoder;
DROP TABLE Anmeldelser;
DROP TABLE Roller;
DROP TABLE Kategorier;
DROP TABLE Brukere;
DROP TABLE Titler;
DROP TABLE Selskaper;
DROP TABLE Personer;
DROP TABLE Serier;


CREATE TABLE IF NOT EXISTS Serier
(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tittel VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS Personer
(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    navn VARCHAR(100),
    bursdag DATE,
    land VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Selskaper
(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    navn VARCHAR(200),
    adresse VARCHAR(200),
    land VARCHAR(100),
    nettside VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Titler
(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tittel VARCHAR(200),
    lanseringsdato DATE,
    laget_for VARCHAR(50),
    lengde INTEGER, -- minutter
    beskrivelse TEXT,
    utgiver_id INTEGER,
    CONSTRAINT titler_utgiver_fk FOREIGN KEY (utgiver_id) REFERENCES Selskaper(id) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Brukere
(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    brukernavn VARCHAR(50),
    epost VARCHAR(100),
    bursdag DATE,
    land VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Kategorier
(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    navn VARCHAR(30),
    beskrivelse TEXT
);

CREATE TABLE IF NOT EXISTS Roller
(
    tittel_id INTEGER,
    skuespiller_id INTEGER REFERENCES Personer ON UPDATE CASCADE ON DELETE CASCADE,
    rollenavn VARCHAR(40),
    CONSTRAINT roller_pk PRIMARY KEY (tittel_id, skuespiller_id, rollenavn),
    CONSTRAINT roller_tittel_fk FOREIGN KEY (tittel_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT roller_skuespiller_fk FOREIGN KEY (skuespiller_id) REFERENCES Personer(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Anmeldelser
(
    bruker_id INTEGER,
    tittel_id INTEGER,
    rating INTEGER,
    tekst VARCHAR(1000),
    CONSTRAINT anmeldelser_pk PRIMARY KEY (bruker_id, tittel_id),
    CONSTRAINT anmeldelser_bruker_fk FOREIGN KEY (bruker_id) REFERENCES Brukere(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT anmeldelser_tittel_fk FOREIGN KEY (tittel_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT rating_ok CHECK ((rating) >= 0 AND (rating) <= 10)
);

CREATE TABLE IF NOT EXISTS Episoder
(
    serie_id INTEGER,
    episode_id INTEGER,
    CONSTRAINT episoder_pk PRIMARY KEY (serie_id, episode_id),
    CONSTRAINT epsioder_serie_fk FOREIGN KEY (serie_id) REFERENCES Serier(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT episoder_episode_fk FOREIGN KEY (episode_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Regissorer
(
    regissor_id INTEGER,
    tittel_id INTEGER,
    CONSTRAINT regissorer_pk PRIMARY KEY (regissor_id, tittel_id),
    CONSTRAINT regissorer_person_fk FOREIGN KEY (regissor_id) REFERENCES Personer(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT regissorer_tittel_fk FOREIGN KEY (tittel_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Manusforfattere
(
    forfatter_id INTEGER,
    tittel_id INTEGER,
    CONSTRAINT manusforfattere_pk PRIMARY KEY (forfatter_id, tittel_id),
    CONSTRAINT manusforfattere_personer_fk FOREIGN KEY (forfatter_id) REFERENCES Personer(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT manusforfattere_tittel_fk FOREIGN KEY (tittel_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Musikere
(
    musiker_id INTEGER REFERENCES Personer,
    tittel_id INTEGER REFERENCES Titler,
    CONSTRAINT musikere_pk PRIMARY KEY (musiker_id, tittel_id),
    CONSTRAINT musikere_person_fk FOREIGN KEY (musiker_id) REFERENCES Personer(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT musikere_tittel_fk FOREIGN KEY (tittel_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Komponister
(
    komponist_id INTEGER REFERENCES Personer,
    tittel_id INTEGER REFERENCES Titler,
    CONSTRAINT komponister_pk PRIMARY KEY (komponist_id, tittel_id),
    CONSTRAINT komponister_person_fk FOREIGN KEY (komponist_id) REFERENCES Personer(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT komponister_tittel_fk FOREIGN KEY (tittel_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Tittel_i_kategori
(
    tittel_id INTEGER REFERENCES Titler,
    kategori_id INTEGER REFERENCES Kategorier,
    CONSTRAINT tittel_i_kategori_pk PRIMARY KEY (tittel_id, kategori_id),
    CONSTRAINT kategori_tittel_fk FOREIGN KEY (tittel_id) REFERENCES Titler(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT kategori_kategori_fk FOREIGN KEY (kategori_id) REFERENCES Kategorier(id) ON UPDATE CASCADE ON DELETE CASCADE
)
