package p00.mvc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	private static DBconnect db=new DBconnect();
	private Connection conn=null;

	String driver="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	private DBconnect() {//기본 생성자:객체생성시 초기값 저장
		
		try {
			
			Class.forName(driver);
			conn=DriverManager.getConnection(url, "javalink", "javalink");
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//singleton:메소드를 통한 객체생성을 한번만, 현재 클래스에서 생성
	public static DBconnect getInstance() {//DBconnect클래스를 싱글톤으로 사용하겠다. 1.싱글톤 생성방법
		return db;//db의 변수로 객체를 생성할 시 DBconnect의 생성자 내용이 실행됨
	}

	public Connection getConnection() {//연결 상태을 쓰겠다??
		return conn;
	}


}
