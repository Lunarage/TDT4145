/*
 * Class used to test database connection.
 * @author Magne Halvorsen
*/
import java.util.Scanner;
//Scanner for input from user
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
        System.out.println("hentRoller");
        System.out.println("hentTitler");
        System.out.println("exit");
        System.out.print("Valg: ");
        String command = sc.nextLine();
        switch(command){
            case "hentRoller":
                ListEntities idForRoller = new ListEntities("Skuespillere");
                idForRoller.connect(type, host, port, database ,p);
                int rolleChoice = idForRoller.findId();

                HentData hentRoller = new HentData();
                hentRoller.connect(type, host, port, database ,p);
                List<List<String>> roller = hentRoller.hentRoller(rolleChoice);

                TabellGenerator rolleTabell = new TabellGenerator(roller);
                rolleTabell.printTabell();
                sc.nextLine();
            break;
            case "hentTitler":
                ListEntities idForTitler = new ListEntities("Skuespillere");
                idForTitler.connect(type, host, port, database ,p);
                int tittelChoice = idForTitler.findId();

                HentData hentTitler = new HentData();
                hentTitler.connect(type, host, port, database ,p);
                List<List<String>> titler = hentTitler.hentFilmer(tittelChoice);

                TabellGenerator tittelTabell = new TabellGenerator(titler);
                tittelTabell.printTabell();
                sc.nextLine();
            break;
            case "exit":
                return;
            default:
        }
    }
}

}

