package plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallInoutProc extends Object  {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		Connection conn=DriverManager.getConnection(url, "javalink", "javalink");
		
		
		//변수선언
		String p1in=new String("a");
		String p2inout=new String("b");
		String p3out;
		
		CallableStatement cs=conn.prepareCall("{call javatest(?,?,?) }");
		cs.setString(1, p1in);//값을 물음표(프로시저의 변수자리에) 넣어준다
		cs.setString(2, p2inout);
		
		cs.registerOutParameter(2, Types.VARCHAR);//넣어준 값을 begin을 실행한 후 저장한다
		cs.registerOutParameter(3, Types.VARCHAR);
		
		cs.execute();
		
		p2inout=cs.getString(2);//저장된 값을 출력한다
		p3out=cs.getString(3);
		
		System.out.println("p2: "+p2inout);
		System.out.println("p3: "+p3out);
		
		

	}

}
