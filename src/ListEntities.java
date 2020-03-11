import java.util.Scanner;
//Scanner for input from user
import java.util.Properties;
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

/**
 * Contains a method to list rows from the database and lets the user choose an id.
*/
public class ListEntities extends DBConn{

/**
 * {@inheritDoc}
 */
public ListEntities(String type, String host, String port,
        String database, Properties p){
    super(type,host,port,database,p);
}

/**
 * Lists rows from the database and lets the user choose an id.
 * @param table What query/case to use.
 * @return String with choice.
 */
public String findId(String table){
    //COLLATE utf8mb4_unicode_ci = Case insensitive search
    //Side note: PostgreSQL har operasjonen ILIKE som gjør det samme
    String query = "";
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
    case "Selskaper":
        query = "SELECT id, navn AS field "
            + "FROM Selskaper "
            + "WHERE navn LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY id";
        break;
    case "Titler":
        query = "SELECT id, tittel AS field "
            + "FROM Titler "
            + "WHERE tittel LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY id";
        break;
    case "Serier":
        query = "SELECT id, tittel AS field "
            + "FROM Serier "
            + "WHERE tittel LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY id";
            break;
    case "Kategorier":
        query = "SELECT id, navn AS field "
            + "FROM Kategorier "
            + "WHERE navn LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY id";
            break;
    case "Brukere":
        query = "SELECT id, brukernavn AS field "
            + "FROM Brukere "
            + "WHERE brukernavn LIKE ? COLLATE utf8mb4_unicode_ci "
            + "ORDER BY id";
            break;
    default:
    }
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
        System.out.println("SQLError: " + e.getMessage());
    }
    System.out.print("Velg id: ");
    return sc.nextLine();
}

}
