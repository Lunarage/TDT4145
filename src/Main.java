import java.util.Scanner;
//Scanner for input from user
import java.util.ArrayList;
import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.util.Properties;
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

/*
 * Has only static methods and properties.
 * @author Magne Halvorsen
*/
public class Main {

public static String type;
public static String host;
public static String port;
public static String database;
public static String user;
public static String password;
public static Properties p = new Properties();
public static HentData hd;
public static NyttInnhold ni;
public static ListEntities li;
public static Scanner sc;

public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}

public static void setupDatabaseParameters(){
    Scanner sc = new Scanner(System.in); //System.in is standard input stream
    System.out.print("Type (default mysql): ");
    type = sc.nextLine();
    if(type.isEmpty()){
        type = "mysql";
    }
    System.out.print("Host (default localhost): ");
    host = sc.nextLine();
    if(host.isEmpty()){
        host = "localhost";
    }
    System.out.print("Host (default 3306): ");
    port = sc.nextLine();
    if(port.isEmpty()){
        port = "3306";
    }
    System.out.print("Database: ");
    database = sc.nextLine();
    System.out.print("User: ");
    user = sc.nextLine();
    System.out.print("Password: ");
    password = sc.nextLine();

    p.put("user", user);
    p.put("password", password);

    clearScreen();
}

public static void mainMenu(){
    while(true){
    clearScreen();
    System.out.println("0 Avslutt");
    System.out.println("1 Hent data");
    System.out.println("2 Sett inn nytt innhold");
    System.out.print("Valg: ");
    String command = sc.nextLine();
    switch(command){
        case "1":
            henteMenu();
        break;
        case "2":
            nyttMenu();
        break;
        case "0":
            return;
        default:
            System.out.println("Ugyldig valg");
            sc.nextLine(); //Venter med å gå til start
    }
    }
}

public static void henteMenu(){
    ArrayList<String> henteVerdier = new ArrayList<String>();
    TabellGenerator tg = new TabellGenerator();

    while(true){
    clearScreen();
    String tabell = "";
    henteVerdier.clear();
    System.out.println("0 Tilbake");
    System.out.println("1 Finne roller for en skuespiller");
    System.out.println("2 Finn filmer/serier en skuespiller har spilt i");
    System.out.println("3 Liste over fleste filmer/serier per selskap");
    System.out.print("Valg: ");
    String command = sc.nextLine();
    switch(command){
        case "1":
            tabell = "SkuespillerRoller";
            System.out.println("Søk etter skuespiller");
            henteVerdier.add(li.findId("Skuespillere"));
        break;
        case "2":
            tabell = "SkuespillerTitler";
            System.out.println("Søk etter skuespiller");
            henteVerdier.add(li.findId("Skuespillere"));
        break;
        case "3":
            tabell = "SelskapSjanger";
        break;
        case "0":
            return;
        default:
            System.out.println("Ugyldig valg");
    }
    if(!tabell.isEmpty()){
        try{
            tg.printTabell(hd.hentData(tabell, henteVerdier));
        }catch(SQLException e){
            throw new RuntimeException("SQLError: ", e);
        }
    }
    sc.nextLine(); //Venter med å gå til start
    }
}

public static void nyttMenu(){
    ArrayList<String> nyeVerdier = new ArrayList<String>();

    while(true){
    clearScreen();
    nyeVerdier.clear();
    String tabell = "";
    System.out.println("0 Tilbake");
    System.out.println("1 Ny person");
    System.out.println("2 Nytt selskap");
    System.out.println("3 Ny serie");
    System.out.println("4 Ny sjanger");
    System.out.println("5 Ny rolle");
    System.out.print("Valg: ");
    String command = sc.nextLine();
    switch(command){
        case "1":
            tabell = "Person";
            System.out.print("Navn: ");
            nyeVerdier.add(sc.nextLine());
            System.out.print("Bursdag (YYYY-MM-DD): ");
            nyeVerdier.add(sc.nextLine());
            System.out.print("Land: ");
            nyeVerdier.add(sc.nextLine());
        break;
        case "2":
            tabell = "Selskap";
            System.out.print("Navn: ");
            nyeVerdier.add(sc.nextLine());
            System.out.print("Adresse: ");
            nyeVerdier.add(sc.nextLine());
            System.out.print("Land: ");
            nyeVerdier.add(sc.nextLine());
            System.out.print("Nettside: ");
            nyeVerdier.add(sc.nextLine());
        break;
        case "3":
            tabell = "Serie";
            System.out.print("Tittel: ");
            nyeVerdier.add(sc.nextLine());
        break;
        case "4":
            tabell = "Kategori";
            System.out.print("Navn: ");
            nyeVerdier.add(sc.nextLine());
            System.out.print("Beskrivelse: ");
            nyeVerdier.add(sc.nextLine());
        break;
        case "5":
            tabell = "Rolle";
            System.out.println("Velg film/episode");
            nyeVerdier.add(li.findId("Titler"));
            System.out.println("Velg person");
            nyeVerdier.add(li.findId("Personer"));
            System.out.print("Rollenavn: ");
            nyeVerdier.add(sc.nextLine());
        break;
        case "0":
            return;
        default:
            System.out.println("Ugyldig valg");
    }
    if(!tabell.isEmpty()){
        try{
            ni.settInn(tabell, nyeVerdier);
            System.out.println("Success!");
        }catch(SQLException e){
            throw new RuntimeException("SQLError: ", e);
        }
    }
    sc.nextLine(); //Venter med å gå til start
    }
}

public static void main(String[] args){
    setupDatabaseParameters();

    hd = new HentData(type, host, port, database ,p);
    ni = new NyttInnhold(type, host, port, database ,p);
    li = new ListEntities(type, host, port, database ,p);
    sc = new Scanner(System.in); //System.in is standard input stream
    mainMenu();
}

}

