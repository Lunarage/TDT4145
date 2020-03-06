/*
 * Class used to connect to a database.
 * @author Magne Halvorsen
*/

import java.util.Properties;
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

public abstract class DBConn{

protected Connection conn;
protected String url;
protected Properties p;
protected PreparedStatement statement;

public DBConn(){
}

public void connect(String type, String host, String port, String database, Properties p){
    //type: {mariadb, mysql} should default to mysql
    //host: should default to localhost
    //port: should default to 3306
    //database: name of database on host
    //p: username and password as Properties
    url = "jdbc:"+type+"://"+host+":"+port+"/"+database+"?autoReconnect=true&useSSL=false";
    try{
        conn = DriverManager.getConnection(url,p);
    }catch(SQLException e){
        throw new RuntimeException("Unable to connect: ", e);
    }
}

}
