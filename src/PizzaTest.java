/*
 * Class used to test database connection.
 * @author Magne Halvorsen
*/
import java.sql.*;
import java.util.*;

public class PizzaTest extends DBConn{

public void getPizza(){
    try{
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM pizzatyper");
        while(rs.next()){
            System.out.println(
                    rs.getString("pid")+" "+
                    rs.getString("navn")+" "+
                    rs.getString("pris")
                    );
        }
    }catch(SQLException e){
        throw new RuntimeException("SQLError: ", e);
    }
}
}

