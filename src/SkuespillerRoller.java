/*
 * Class Description
 * @author 
*/
import java.util.ArrayList;
import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

public class SkuespillerRoller extends DBConn{

    public List<List<String>> hentRoller(String skuespiller){

        List<List<String>> roller = new ArrayList<List<String>>();

        try{
            String query = ""; //Insert Query here
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            /* Put results in List here */
            }
        }catch(SQLException e){
            throw new RuntimeException("SQLError: ", e);
        }
        return roller;
    }
}
