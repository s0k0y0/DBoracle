package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//java 에서 oracle DB연결 유무 확인 방법
public class DBconnection {

	public static void main(String[] args) {
		
		Connection c=null;//로컬변수 초기화
		
		try {
			//Class.forName("java.lang.String");클래스 이름 찾기
			Class.forName("oracle.jdbc.driver.OracleDriver");//앞에 세개 driver까지 패키지, oracleDriver은 클래스
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			
				c=DriverManager.getConnection(url, "javalink", "javalink");
				c.close();
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver Not Found_"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL error"+e.getMessage());
		}
		
		System.out.println("program close");
		
		
		
		
		
		
		
		
		
		

	}

}
