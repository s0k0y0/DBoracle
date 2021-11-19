package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection_update {

	public static void main(String[] args) {
		//executeQuery(String sql):select 명령어 사용시. 테이블 데이터값 불러올때
		//executeUpdate(String sql):insert, update,delete 명령어 사용시.테이블 데이터 값 수정할떄
		
		Connection c = null;
		Statement st=null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			c = DriverManager.getConnection(url, "javalink", "javalink"); 
			st= c.createStatement();
			
			
			String q="update goodsinfo set maker='apple' where code='10002'";
			int count=st.executeUpdate(q);
			
			if(count>0) {
				System.out.println("data update");
			} else {
				System.out.println("data not update");
			}
			
			
			

		} catch (ClassNotFoundException e) {
			System.out.println("driver Not Found_" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL error" + e.getMessage());
		}

		System.out.println("program colse");
		try {
			c.close();
		} catch (SQLException e) {
		
		}
		
		
		

	}

}
