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

public class SkuespillerFilmer extends DBConn{

    public List<List<String>> hentFilmer(String skuespiller){

        List<List<String>> filmer = new ArrayList<List<String>>();

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
        return filmer;
    }
}
