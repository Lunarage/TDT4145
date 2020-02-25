/*
 * Class used to test database connection.
 * @author Magne Halvorsen
*/
import java.sql.*;
import java.util.*;

public class Main {
    //TODO: Input for å velge databaseparametere
    //type (default mysql), host (default localhost), port (default 3306), database, user, password
    public static void main(String[] args){
        Properties p = new Properties();
        p.put("user", "pizza");
        p.put("password", "pizza");

        PizzaTest test = new PizzaTest();
        test.connect("mariadb","localhost","3306","pizzaDB",p);

        test.getPizza();
    }
}

