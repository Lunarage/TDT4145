# Internet Movie DatDatBase
Dette er et prosjekt i faget TDT4145 - Datamodellering og Databasesystemer
ved NTNU.
Formålet med dette prosjektet er å implementere en database og et tilhørende
program.
Databasen inneholder informasjon om filmer og serier à la IMDb og programmet
leser og skriver til denne databasen.

# Dokumentasjon Database
Databasen er implementert med MySQL.

## Konseptuell Modell
Databasen er basert på følgende ER-diagram:
![ER-diagram](https://github.com/jakobsen/internet-movie-datdatbase/img/Filmdatabase_ER.png)

# Dokumentasjon Program
Programmet er skrevet i java og skal bruke JDBC for å snakke med databaser.

## Konseptuell Modell
Programmet er basert på følgende klassediagram:
Insert image of UML-diagram here.

## Klasser

### Main
Kontroller for programmet.
Henter input fra bruker og kaller på andre klasser for å utføre oppgaver.

#### Properties

#### Methods

### DBConn
Abstrakt klasse som kan lage en tilkobling til en database.

#### Properties

```java
protected Connection conn
protected String url
protected Properties p
```

#### Methods

##### public void connect(String type, String host, String port, String database, Properties p)
Tar inn parametere og lager en tilkobling til en database.

Arguments:
* type: hvilken type database {mysql, mariadb}
* host: ip-adresse/url til der databasen hostes
* port: hvilken port databasen kjører på
* database: navnet på databasen
* p: brukernavn og passord

### SjangerFilmselskap
Implementerer DBConn.

#### Properties

#### Methods

### SkuespillerFilmer
Implementerer DBConn.

#### Properties

#### Methods

##### public List<List<String>> hentFilmer(String skuespiller)
Henter alle filmer en skuespiller har spilt i.

Arguments:
* skuespiller: Hvilken skuespiller.

Returns:
  2-dimensjonal liste med data.

### SkuespillerRoller
Implementerer DBConn.

#### Properties

#### Methods

### NyFilm
Implementerer DBConn.

#### Properties

#### Methods

### NyAnmeldelse
Implementerer DBConn.

#### Properties

#### Methods

### TabellGenerator

#### Properties

```java
private List<List<String>> list
private List<Integer> widthList
//Inneholder lengden på den lengste strenger per kolonne
private Integer columns
//Antall kolonner
private Integer rows
//Antall rader
```

#### Methods

##### public TabellGenerator(List<List<String>> inputList)
Constructor. Finner ut hvor stor listen er og hvor bred kolonnene skal være.

Arguments:
* inputList: Listen som skal bli tabell. Må være en MxN matrise.

##### public void printTabell()
Skriver ut tabellen til STDOUT.

