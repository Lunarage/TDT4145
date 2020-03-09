/*
 * Class Description
 * @author Magne Halvorsen
*/

import java.util.List;
import java.util.ArrayList;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.util.Properties;
import java.sql.SQLException;
import java.sql.ResultSet;
//More on ResultSet
//https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
import java.sql.ParameterMetaData;
//More on ParameterMetaData
//https://docs.oracle.com/javase/7/docs/api/java/sql/ParameterMetaData.html
import java.sql.ResultSetMetaData;
//More on ResultSetMetaData
//https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSetMetaData.html

public class HentData extends DBConn{

private String query;
private List<List<String>> returnList = new ArrayList<List<String>>();

public HentData(String type, String host, String port,
        String database, Properties p){
    super(type,host,port,database,p);
}

public List<List<String>> hentData(String tabell, List<String> verdier)
        throws SQLException{
        returnList.clear();
    switch(tabell){
        case "SkuespillerTitler":
            query = "SELECT DISTINCT(tittel) AS Titler "
                  + "FROM Roller as r "
                  + "JOIN Personer as p ON r.skuespiller_id = p.id "
                  + "JOIN Titler as t ON r.tittel_id = t.id "
                  + "WHERE r.skuespiller_id = ?";
        break;
        case "SkuespillerRoller":
            query = "SELECT tittel AS Tittel, rollenavn AS Rollenavn "
                  + "FROM Roller as r "
                  + "JOIN Personer as p ON r.skuespiller_id = p.id "
                  + "JOIN Titler as t ON r.tittel_id = t.id "
                  + "WHERE r.skuespiller_id = ?";
        break;
        case "SelskapSjanger":
            query = "SELECT MAX(Antall) AS Antall, Kategori, Selskap "
                  + "FROM ("
                  //Subquery
                  + "SELECT COUNT(t.tittel) AS Antall, "
                  + "k.navn AS Kategori, "
                  + "s.navn AS Selskap "
                  + "FROM Tittel_i_kategori AS tik "
                  + "JOIN Kategorier AS k ON tik.kategori_id = k.id "
                  + "JOIN Titler AS t ON tik.tittel_id = t.id "
                  + "JOIN Selskaper AS s ON t.utgiver_id = s.id "
                  + "GROUP BY Kategori, Selskap "
                  + "ORDER BY s.navn "
                  + ") AS foo "
                  // Subqueries must have an alias when used like this
                  + "GROUP BY Kategori";
        break;
        default:
            query = "";
    }

    //Har vi en spørring?
    if(!query.isEmpty()){
        statement = conn.prepareStatement(query);
        ParameterMetaData meta = statement.getParameterMetaData();

        //Er antall parametere til spørringen likt antall parametere gitt?
        //aka antall '?' lik lengen på listen 'verdier'
        if(meta.getParameterCount() == verdier.size()){
            //Sett parameterne til spørringen fra verdiene gitt.
            for(Integer i = 0; i < verdier.size(); i++){
                statement.setString(i+1, verdier.get(i));
            }

            //Kjør spørringen og putt resultatet i rs
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmeta = rs.getMetaData();
            Integer columns = rsmeta.getColumnCount();
            //Finn navnet på kolonnene og legg de i starten av returnlista
            List<String> headerRow = new ArrayList<String>(columns);
            for(Integer i = 1; i <= columns; i++){
                headerRow.add(rsmeta.getColumnLabel(i));
            }
            returnList.add(headerRow);
            //Legg radene med data i returnlista
            while(rs.next()){
                List<String> dataRow = new ArrayList<String>(columns);
                //Dette er basically en foreach-løkke
                //Python ekvivalent: for kolonnenavn in headerRow
                //javaScript: headerRow.forEach((element) => {})
                for(String kolonnenavn : headerRow){
                    dataRow.add(rs.getString(kolonnenavn));
                }
                returnList.add(dataRow);
            }
            statement.close();
        }else{
            System.out.println("Mismatch antall parametere");
        }
    }else{
        System.out.println("Ugyldig tabell.");
    }
    return returnList;
}

}
