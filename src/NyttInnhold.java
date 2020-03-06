/*
 * Class Description
 * @author Magne Halvorsen
*/

import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

public class NyttInnhold extends DBConn{

private String query;

public void settInn(String tabell, List<String> verdier) throws SQLException{
    switch(tabell){
        case "Selskap":
            query = "INSERT INTO Selskaper "
                  + "(navn, adresse, land, nettside) "
                  + "VALUES (?, ?, ?, ?)";
        break;
        case "Person":
            query = "INSERT INTO Personer "
                  + "(navn, bursdag, land) "
                  + "VALUES (?, ?, ?)";
        break;
        case "Rolle":
            query = "INSERT INTO Roller "
                  + "(tittel_id, skuespiller_id, rollenavn) "
                  + "VALUES (?, ?, ?)";
        break;
        case "Serie":
            query = "INSERT INTO Serier "
                  + "(tittel) "
                  + "VALUES (?)";
        break;
        case "Kategori":
            query = "INSERT INTO Kategorier "
                  + "(navn, beskrivelse) "
                  + "VALUES (?, ?)";
        break;
        case "Regissor":
            query = "INSERT INTO Regissorer "
                  + "(regissor_id, tittel_id) "
                  + "VALUES (?, ?)";
        break;
        case "Forfatter":
            query = "INSERT INTO Manusforfattere "
                  + "(forfatter_id, tittel_id) "
                  + "VALUES (?, ?)";
        break;
        case "Musiker":
            query = "INSERT INTO Musikere "
                  + "(musiker_id, tittel_id) "
                  + "VALUES (?, ?)";
        break;
        case "Komponist":
            query = "INSERT INTO Komponister "
                  + "(komponist_id, tittel_id) "
                  + "VALUES (?, ?)";
        break;
        case "Tittel":
            query = "INSERT INTO Titler "
                  + "(tittel, lanseringsdato, laget_for,"
                  + " lengde, beskrivelse, utgiver_id) "
                  + "VALUES (?, ?, ?, ?, ?, ?)";
        break;
        default:
            query = "";
    }
    if(!query.isEmpty()){
        PreparedStatement statement = conn.prepareStatement(query);
        ParameterMetaData meta = statement.getParameterMetaData();
        if(meta.getParameterCount() == verdier.size()){
            for(Integer i = 0; i < verdier.size(); i++){
                statement.setString(i+1, verdier.get(i));
            }
            statement.executeUpdate();
        }else{
            System.out.println("Mismatch antall parametere");
        }
        statement.close();
    }else{
        System.out.println("Ugyldig tabell.");
    }
}

}
