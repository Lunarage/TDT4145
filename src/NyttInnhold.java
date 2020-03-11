import java.util.List;
//More on lists:
//https://www.javatpoint.com/java-arraylist
import java.util.Properties;
import java.sql.*;
//More on JDBC
//https://www.javatpoint.com/java-jdbc

/**
 * Contains a method to send INSERT queries to the database.
 * {@inheritDoc}
*/
public class NyttInnhold extends DBConn{

/**
 * {@inheritDoc}
 */
public NyttInnhold(String type, String host, String port,
        String database, Properties p){
    super(type,host,port,database,p);
}

/**
 * Sends INSERT queries to the database.
 *
 * @param   tabell    What case to use.
 * @param   verdier   Values to put in the query.
 * @throws  SQLException On SQL error.
 */
public void settInn(String tabell, List<String> verdier)
        throws SQLException{
    String query = "";
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
        case "Rolle":
            query = "INSERT INTO Roller "
                  + "(tittel_id, skuespiller_id, rollenavn) "
                  + "VALUES (?, ?, ?)";
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
        case "Anmeldelse":
            query = "INSERT INTO Anmeldelser "
                  + "(bruker_id, tittel_id, rating, tekst) "
                  + "VALUES (?, ?, ?, ?)";
        break;
        case "Episoder":
            query = "INSERT INTO Episoder "
                  + "(serie_id, episode_id, sesong, episodenummer) "
                  + "VALUES (?, ?, ?, ?)";
        break;
        case "TittelIKategori":
            query = "INSERT INTO Tittel_i_kategori "
                  + "(tittel_id, kategori_id) "
                  + "VALUES (?, ?)";
        break;
        default:
    }

    //Har vi en spørring?
    if(!query.isEmpty()){
        PreparedStatement statement = conn.prepareStatement(query);
        ParameterMetaData meta = statement.getParameterMetaData();
        //Er antall parametere til spørringen likt antall parametere gitt?
        //aka antall '?' lik lengen på listen 'verdier'
        if(meta.getParameterCount() == verdier.size()){
            //Sett parameterne til spørringen fra verdiene gitt.
            for(Integer i = 0; i < verdier.size(); i++){
                statement.setString(i+1, verdier.get(i));
            }
            //Kjør spørringen
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
