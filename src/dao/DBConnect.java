package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    public static Connection getConnection() throws SQLException{
        try {
            Connection cons = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cons = DriverManager.getConnection("jdbc:sqlserver://CAOTHAO\\SQLEXPRESS:1433;databaseName=Shop;user=sa;password=123456;encrypt=true;trustServerCertificate=true;sslProtocol=TLS");
            return cons;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) throws SQLException{
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    } 
}

//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class DBConnect {
//    public static Connection getConnection() throws SQLException {
//        Properties props = new Properties();
//        props.setProperty("user", "sa");
//        props.setProperty("password", "123");
//        props.setProperty("encrypt", "true");
//        props.setProperty("trustServerCertificate", "false");
//        props.setProperty("hostNameInCertificate", "*.database.windows.net");
//
//        String url = "jdbc:sqlserver://yourserver.database.windows.net:1433;database=Shop;";
//        Connection conn = DriverManager.getConnection(url, props);
//        return conn;
//    }
//
//    public static void main(String[] args) throws SQLException {
//        Connection c = getConnection();
//        System.out.println(c.toString());
//        c.close();
//    }
//}