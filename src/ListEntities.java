/*
 * Class Description
 * @author Magne Halvorsen
*/
import java.util.Scanner;
//Scanner for input from user
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

public class ListEntities extends DBConn{

private String query;

public ListEntities(String table){
    //COLLATE utf8mb4_unicode_ci = Case insensitive search
    //Side note: PostgreSQL har operasjonen ILIKE som gjør det samme
    switch(table){
    case "Personer":
        query = "SELECT id, navn AS field "
            + "FROM Personer "
            + "WHERE navn LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY id";
        break;
    case "Skuespillere":
        //Skuespillere er personer som har en rolle i en film.
        query = "SELECT DISTINCT(r.skuespiller_id) AS id, p.navn AS field "
            + "FROM Roller AS r "
            + "JOIN Personer as p ON r.skuespiller_id = p.id "
            + "WHERE p.navn LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY p.id";
        break;
    case "Titler":
        query = "SELECT id, tittel AS field "
            + "FROM Titler "
            + "WHERE tittel LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY id";
        break;
    default:
        break;
    }
}

public int findId(){
    Scanner sc = new Scanner(System.in); //System.in is standard input stream
    System.out.print("Search String: ");
    String searchString = sc.nextLine();
    try{
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, "%" + searchString + "%");//% is wildcard
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            System.out.printf("%2s ",rs.getString("id"));
            System.out.printf("%s%n",rs.getString("field"));
        }
    }catch(SQLException e){
        throw new RuntimeException("SQLError: ", e);
    }
    System.out.print("Velg id: ");
    return sc.nextInt();
}

}