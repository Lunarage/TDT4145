/*
 * Class Description
 * @author Magne Halvorsen
*/
import java.util.ArrayList;
import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

public class SjangerFilmselskap extends DBConn{

public List<List<String>> hentSelskaper(){

    List<List<String>> selskaper = new ArrayList<List<String>>();

    try{
        String query = "";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
        /* Put results in List here */
        }
    }catch(SQLException e){
        throw new RuntimeException("SQLError: ", e);
    }
    return selskaper;
}

}
