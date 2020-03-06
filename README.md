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

![ER-diagram av databasen](img/Filmdatabase_ER.png)

# Dokumentasjon Program
Programmet er skrevet i java og bruker JDBC for å snakke med databaser.

Use cases som løses av programmet:
1. Finne navnet på alle rollene en gitt skuespiller har.
2. Finne hvilke filmer som en gitt skuespiller opptrer i.
3. Finne hvilke filmselskap som lager flest filmer inne hver sjanger (grøssere, familie, o.l.).
4. Sette inn en ny film med regissør, manusforfattere, skuespillere og det som hører med.
5. Sette inn ny anmeldelse av en episode av en serie.

## Konseptuell Modell
Klassen Main er kontrolleren for programmet.

Programmet er basert på følgende klassediagram:

![Insert UML-diagram here]()

## Klasser

### Main
Kontroller for programmet.
Henter input fra bruker og kaller på andre klasser for å utføre oppgaver.

#### Properties

```java
public static String type
public static String host
public static String port
public static String database
public static String user
public static String password
public static Properties p
```

#### Methods

##### public static void setupDatabaseParameters()
Henter inn info om databasen man vil bruke fra brukeren.

##### public static void clearScreen()
Tømmer konsollet for tekst.

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

### HentData
Implementerer DBConn. Løser use case 1, 2 og 3.

#### Properties

#### Methods

##### public List<List<String>> hentRoller(String skuespiller)
Henter alle roller en skuespiller har spilt. Løser use case 1.

Arguments:
* skuespiller: Hvilken skuespiller.

Returns:
  2-dimensjonal liste med data.

##### public List<List<String>> hentFilmer(String skuespiller)
Henter alle filmer en skuespiller har spilt i. Løser use case 2.

Arguments:
* skuespiller: Hvilken skuespiller.

Returns:
  2-dimensjonal liste med data.

##### public List<List<String>> hentSelskaper()
Løser use case 3.

Returns:
  2-dimensjonal liste med data.

### NyttInnhold
Implementerer DBConn. Løser use case 4.

#### Properties

#### Methods

### NyAnmeldelse
Implementerer DBConn. Løser use case 5.

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

### ListEntities
Implementerer DBConn.

#### Properties

#### Methods

##### public ListEntities(String table)
Constructor.

Arguments:
* table: Hvilken tabell i databasen man vil se på. {Personer, Skuespillere, Titler}

##### public int findId()
Lister opp innhold i en tabell og lar deg velge en id

Returns:
  id til raden man vil ha
