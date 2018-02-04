package model.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by yashjain on 1/11/18.
 */
public class ConnectionConfig {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","yash");
        }catch (Exception e){
                e.printStackTrace();

        }
        return conn;
    }

}
