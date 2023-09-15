package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }

        public static Connection getConnection() throws SQLException {
        String serverName = "localhost";
            String portNumber = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@"+ serverName + ":" + portNumber + ":" + sid;
            String username = "system";
            String password = "lisao123";
            return DriverManager.getConnection(url, username, password);





        }
    }

