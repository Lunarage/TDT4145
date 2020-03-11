import java.util.Properties;
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

/**
* Makes a connection to a database.
*/
public abstract class DBConn{

/** The database connection. */
protected Connection conn;

/**
 * Class constructor.
 *
 * @param type      What databasetype to connect to {mariadb, mysql, postgresql}
 * @param host      What host to connect to
 * @param port      What port to use
 * @param database  Name of database on host
 * @param p         Username and password as a Properties-object
*/
public DBConn(
        String type, String host, String port,
        String database, Properties p){
    String url = "jdbc:"+type+"://"+host+":"+port+"/"+database+"?autoReconnect=true&useSSL=false&generateSimpleParameterMetadata=true";
    try{
        conn = DriverManager.getConnection(url,p);
    }catch(SQLException e){
        throw new RuntimeException("Unable to connect: ", e);
    }
}

}
