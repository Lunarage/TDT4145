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

public class SkuespillerFilmer extends DBConn{

public List<List<String>> hentFilmer(String skuespiller){

    List<List<String>> filmer = new ArrayList<List<String>>();

    try{
        //Java does not support raw strings aka one string over multiple lines.
        //The solution for long strings is to concatenate strings.
        String query = "SELECT DISTINCT(tittel) "
            + "FROM Roller as r "
            + "JOIN Personer as p ON r.skuespiller_id = p.id "
            + "JOIN Titler as t ON r.tittel_id = t.id "
            + "WHERE r.skuespiller_id = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, skuespiller);
        ResultSet rs = statement.executeQuery();
        List<String> row = new ArrayList<String>(1);
        row.add("Titler");
        filmer.add(row);
        while(rs.next()){
            List<String> newRow = new ArrayList<String>(1);
            newRow.add(rs.getString("tittel"));
            filmer.add(newRow);
        }
        statement.close();
        return filmer;
    }catch(SQLException e){
        throw new RuntimeException("SQLError: ", e);
    }
}
}
