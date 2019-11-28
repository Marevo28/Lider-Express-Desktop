package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnection {
    public Connection Connect () {
        String url="jdbc:mysql://81.16.28.103/u221300405_megion";
        String user="u221300405_sega";
        String password="FgbrT$d81";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,password);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE,null,ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}