/*
 * Class for testing the database connection.
 * @author Magne Halvorsen
*/
import java.util.ArrayList;
import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

public class PizzaTest extends DBConn{

    public List<List<String>> getPizza(){

        List<List<String>> rows = new ArrayList<List<String>>();

        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM pizzatyper");
            List<String> row = new ArrayList<String>(3);
            row.add("pid");
            row.add("navn");
            row.add("pris");
            rows.add(row);
            while(rs.next()){
                List<String> newRow = new ArrayList<String>(3);
                newRow.add(rs.getString("pid"));
                newRow.add(rs.getString("navn"));
                newRow.add(rs.getString("pris"));
                rows.add(newRow);
            }
            statement.close();
            return rows;
        }catch(SQLException e){
            throw new RuntimeException("SQLError: ", e);
        }
    }
}

