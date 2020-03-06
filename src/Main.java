/*
 * Class used to test database connection.
 * @author Magne Halvorsen
*/
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

public class Main {

public static String type;
public static String host;
public static String port;
public static String database;
public static String user;
public static String password;
public static Properties p = new Properties();

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

public static void main(String[] args){
    setupDatabaseParameters();

    Scanner sc = new Scanner(System.in); //System.in is standard input stream
    while(true){
        clearScreen();
        System.out.println("0 Avslutt");
        System.out.println("1 Hent Roller");
        System.out.println("2 Sett inn nytt innhold");
        System.out.print("Valg: ");
        String command = sc.nextLine();
        switch(command){
            case "1":
                ArrayList<String> henteVerdier = new ArrayList<String>();
                ListEntities idForRoller = new ListEntities("Skuespillere");
                idForRoller.connect(type, host, port, database ,p);
                henteVerdier.add(idForRoller.findId());

                HentData hentRoller = new HentData();
                hentRoller.connect(type, host, port, database ,p);
                try{
                List<List<String>> roller =
                    hentRoller.hentData("SkuespillerRoller",henteVerdier);
                    TabellGenerator rolleTabell = new TabellGenerator(roller);
                    rolleTabell.printTabell();
                }catch(SQLException e){
                    throw new RuntimeException("SQLError: ", e);
                }
            break;
            case "2":
                NyttInnhold nytt = new NyttInnhold();
                nytt.connect(type, host, port, database ,p);

                ArrayList<String> verdier = new ArrayList<String>(2);
                verdier.add("Test");
                verdier.add("Beskrivelse");
                try{
                    nytt.settInn("Kategori", verdier);
                }catch(SQLException e){
                    throw new RuntimeException("SQLError: ", e);
                }
            break;
            case "0":
                return;
            default:
                System.out.println("Ugyldig valg");
        }
        sc.nextLine(); //Venter med å gå til start
    }
}

}

