package p00.JDBC_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDtest {

	Connection c=null;
	Statement st=null;

	static {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void connect() {
		
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			c = DriverManager.getConnection(url, "javalink", "javalink");
			st= c.createStatement();//데이터 수정이나 출력을 서로 주고 받기 위한 개체를 생성하도록 한다?
			
			//데이터를 주고 받기 위한 사전 연결을 위해선 반드시 위의 4가지 문장이 들어가야 한다
			//1.oracle driver 찾기 2.데이터 테이블 utl, 접속 아이디, 링크 설정 3.주고 받기도록 하기 위한 개체 생성
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void insert() {
		
		try {
			
			String q="insert into member1 values('aaa','1111','홍길동','22','서울시','a@a.com')";
			int result=st.executeUpdate(q);
			
			if(result>0) {
				System.out.println("insert success");
			} else {
				System.out.println("insert not success");
			}
			
			
		} catch (SQLException e) {
			
		}
	}

	public void select() {
		
		try {
			
			
			String q="select*from member1";
			ResultSet result= st.executeQuery(q);
			
			while(result.next()) {
				String id=result.getString(1);
				String password=result.getString(2);
				String name=result.getString(3);
				int age=result.getInt(4);
				String addr=result.getString(5);
				String email=result.getString(6);
				
				System.out.println(id+":"+password+":"+name+":"+age+":"+addr+":"+email);
				
				
			}
		} catch (SQLException e) {
			
		}
		
	}

	public void update() {
		//id=aaa 를 찾아서 addr=부산시
		try {
			
			String q="update member1 set addr='busan' where id='aaa'";
			int count = st.executeUpdate(q);
			
			if(count>0) {
				System.out.println("update success");
			} else {
				System.out.println("update not success");
			}
			
			
		} catch (SQLException e) {
			
		}
		
		
		
		
	}

	public void delete() {
		//id=aaa 삭제
		
		try {
			String q="delete member1 where id='aaa'";
			int count= st.executeUpdate(q);
			
			if(count>0) {
				System.out.println("delete success");
			} else {
				System.out.println("delete not success");
			}
		} catch (SQLException e) {
			
		}
		
		
	}

	public static void main(String[] args) {
		
		CRUDtest st=new CRUDtest();
		
		System.out.println("insert 수행 후");
		
		st.connect();
		
		//배열 출력
		st.select();
		
		//배열 데이터 삽입
		st.insert();
		
		//배열 데이터 수정: addr_busan. 적상 작동
		st.update();
		
		//배열 데이터 삭제: aaa행 삭제. 적상 작동
		st.delete();
		
		

	}

}
