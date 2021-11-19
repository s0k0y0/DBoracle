package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection_insert {

	public static void main(String[] args) {
		
		Connection c = null;
		Statement st=null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			
			c = DriverManager.getConnection(url, "javalink", "javalink"); 
			st= c.createStatement();
			
			//무결성 제약조건: 완전히 같은 테이블 값은 중복 기입할 수 없다
			String q="insert into goodsinfo values('33','OLED TV',435000,'LG')";//실행할 오라클 명령 기입
			int count=st.executeUpdate(q);//데이블의 데이터 내용을 수정하는 메소드
			
			if(count>0) {
				System.out.println("data save");
			} else {
				System.out.println("data not save");
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
