package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class empEx1 {

	public static void main(String[] args) {

		Connection c = null;
		Statement st=null;

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			c = DriverManager.getConnection(url, "scott", "scott");
			st=c.createStatement();
			String q="select*from emp02";
			ResultSet re= st.executeQuery(q);
			while(re.next()) {//if는 한 행만 불러올 수 있었음. 반복으로 출력하기 위해 while로 가야함
				int a1=re.getInt(1);
				String a2=re.getString(2);
				String a3=re.getString(3);
				int a4=re.getInt(4);
				Date a5=re.getDate(5);
				int a6=re.getInt(6);
				int a7=re.getInt(7);
				int a8=re.getInt(8);
				
				System.out.println("EMPNO: "+a1+"\tENAME: "+a2+"\tJOB: "+a3+"\tMGR: "+a4+"\tHIREDATE: "
				+a5+"\tSAL: "+a6+"\tCOMM: "+a7+"\tDEPTNO: "+a8);
				
			}
			

		} catch (ClassNotFoundException e) {
			System.out.println("driver Not Found_" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL error" + e.getMessage());
		} finally {
			try {
				c.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("program close");

	}
}
