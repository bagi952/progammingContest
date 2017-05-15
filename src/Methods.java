
import DB.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by cane on 5/15/17.
 */
public  class Methods {
    public static Database db = null;
    public static Connection con = null;
    public static Statement stmt = null;
    public static boolean isConnected=false;

    public static boolean logInTakmicar(String ime, String pass){

        try
        {
            db = Database.getInstance();
            con = (Connection) db.getConnection();
            stmt = (Statement) con.createStatement();
            String upit = "SElECT * FROM takmicar where ime='"+ime+"' AND pass='"+pass+"';";
            ResultSet rs = stmt.executeQuery(upit);
            if(rs.next())
                isConnected=true;
            System.out.println("True in takmicar");
        }catch(Exception e)
        {
            System.out.println("Error while trying to connect to TAKMICAR " + e.getMessage());
            isConnected = false;
        }
        finally {
            db.putConnection(con);
        }
        return isConnected;
    }
    public static boolean logInKomisija(String ime, String pass){

        try
        {
            db = Database.getInstance();
            con = (Connection) db.getConnection();
            stmt = (Statement) con.createStatement();
            String upit = "SElECT * FROM komisija where ime='"+ime+"' AND pass='"+pass+"';";
            ResultSet rs = stmt.executeQuery(upit);
            if(rs.next())
                isConnected=true;
            System.out.println("True in komisija");
        }catch(Exception e)
        {
            System.out.println("Error while trying to connect to TAKMICAR " + e.getMessage());
            isConnected = false;
        }
        finally {
            db.putConnection(con);
        }
        return isConnected;
    }
    public static boolean logInAdmin(String ime, String pass){
        try
        {
            db = Database.getInstance();
            con = (Connection) db.getConnection();
            stmt = (Statement) con.createStatement();
            String upit = "SElECT * FROM administrator where ime='"+ime+"' AND pass='"+pass+"';";
            ResultSet rs = stmt.executeQuery(upit);
            if(rs.next())
                isConnected=true;
            System.out.println("True in admin");
        }catch(Exception e)
        {
            System.out.println("Error while trying to connect to TAKMICAR " + e.getMessage());
            isConnected = false;
        }
        finally {
            db.putConnection(con);
        }
        return isConnected;
    }

    public static boolean checkWhoIs(String ime, String pass) {

        if(ime.split("")[0].equals("t") && Methods.logInTakmicar(ime,pass))
                return true;


        else if(ime.split("")[0].equals("k") && Methods.logInKomisija(ime,pass))
                return true;

       else if(ime.split("")[0].equals("a") && Methods.logInAdmin(ime,pass))
                return true;
       else
           return false;

    }

    public static void RankList(TextArea txtArea) {
    txtArea.clear();
        try
        {
            db = Database.getInstance();
            con = (Connection) db.getConnection();
            stmt = (Statement) con.createStatement();
            String upit = "SElECT * FROM takmicar";
            ResultSet rs = stmt.executeQuery(upit);
            while(rs.next())
            {

                txtArea.appendText("Ime: "+rs.getString("ime") + "\nZbir: " +
                        (rs.getInt("kvalitetkoda")+
                                rs.getInt("tacnost")+rs.getInt("opstiUtisak"))  +
                        "\nOcena: " +rs.getInt("ocena")+"\n---------------------------------\n");
            }
        }catch(Exception e)
        {
            System.out.println("Error...@" + e.getMessage());

        }
        finally {
            db.putConnection(con);
        }
    }

    public static void listAllExams(TextArea txtArea) {
        
    }
}
