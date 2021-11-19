package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDconnection_indexprint {
//CRUD: Create Read Update Delete

	public static void main(String[] args) {

		Connection c = null;// 로컬변수 초기화
		Statement st=null;
		
		
		try {
			// Class.forName("java.lang.String");클래스 이름 찾기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			c = DriverManager.getConnection(url, "javalink", "javalink");//데이터 베이스있는 서버와 연결하기 
			st= c.createStatement();
			String q="select*from goodsinfo";
			ResultSet re=st.executeQuery(q);//오라클 명령어가 담긴 q를 실행쿼리에 놓고 resultset 결과저장을 한다.값을 가져와서 출력하기
			while(re.next()) {
				String code=re.getString(1);//오라클과 이클립스 사이의 데이터 주고 받는 형태.
				String name=re.getString(2);//table data값 가져오는 방법
				String price=re.getString("price");
				String maker=re.getString("maker");
				System.out.println(code+":"+name+":"+price+":"+maker);
			
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
