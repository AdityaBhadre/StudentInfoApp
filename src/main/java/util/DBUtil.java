package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static String url = "jdbc:mysql://localhost:3306/studentinfoapp?useSSL=false&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "";
	
	 public static Connection getConnection() {
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	 }
}
