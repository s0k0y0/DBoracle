package plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class plsqlprocedure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//oracle DB 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		
		//변수선언
		int p1in=Integer.parseInt(args[0]);
		int p2inout=Integer.parseInt(args[1]);
		int p3out;
		
		
		//계정연결
		Connection conn=DriverManager.getConnection(url, "javalink", "javalink");
		CallableStatement cs=conn.prepareCall("{call compute_power(?,?,?) }");//plsql에서 preparedstatment역할의 느낌
		cs.setInt(1, p1in);
		cs.setInt(2, p2inout);//in:입력한 값이 물음표로 날라감
		
		cs.registerOutParameter(2,Types.INTEGER);//out:입력된 값을 물음표로부터 가져옴
		cs.registerOutParameter(3,Types.INTEGER);
		
		cs.execute();
		
		p2inout=cs.getInt(2);
		p3out=cs.getInt(3);
		
		System.out.println(p1in+"^"+p2inout+"="+p3out);
		
	}

}
