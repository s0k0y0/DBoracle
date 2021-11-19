package p00.JDBC_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionTest {// DBconnection 내용

	Connection c = null;
	Statement st=null;

	static {// static 초기화 블럭: 실행시 가장 먼저 최초 한번만 무조건 실행된다

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("success");
			
		} catch (ClassNotFoundException e) {
			System.out.println("fail");
		}

	}

	public void connect() {

		try {

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			c = DriverManager.getConnection(url, "javalink", "javalink");
			st = c.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		connectionTest c=new connectionTest();
		c.connect();
		
		
		
		
		

	}

}
