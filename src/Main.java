/*
 * Class used to test database connection.
 * @author Magne Halvorsen
*/
import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.util.Properties;
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

public class Main {
    //TODO: Input for å velge databaseparametere
    //type (default mysql), host (default localhost), port (default 3306), database, user, password
    public static void main(String[] args){
        Properties p = new Properties();
        p.put("user", "pizza");
        p.put("password", "pizza");

        PizzaTest test = new PizzaTest();
        test.connect("mariadb","localhost","3306","pizzaDB",p);

        List<List<String>> list = test.getPizza();

        TabellGenerator tabell = new TabellGenerator(list);
        tabell.printTabell();
    }
}

