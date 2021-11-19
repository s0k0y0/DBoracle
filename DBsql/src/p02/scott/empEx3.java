package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.ldap.PagedResultsControl;

//preparedstatement 사용하기

public class empEx3 {

	public static void main(String[] args) {

		Connection c = null;
		PreparedStatement st = null;

		Scanner s = new Scanner(System.in);
		System.out.print("EMPNO: ");
		int id = s.nextInt();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			c = DriverManager.getConnection(url, "scott", "scott");
			String q = "select*from emp02 where empno=?";
			st =  c.prepareStatement(q);
			st.setInt(1, id);//찾을 컬럼의 인덱스,찾은 내용

			ResultSet re = st.executeQuery();

				if(re.next()) {
					int a1 = re.getInt(1);
					String a2 = re.getString(2);
					String a3 = re.getString(3);
					int a4 = re.getInt(4);
					Date a5 = re.getDate(5);
					int a6 = re.getInt(6);
					int a7 = re.getInt(7);
					int a8 = re.getInt(8);

					System.out.println("EMPNO: " + a1 + "\tENAME: " + a2 + "\tJOB: " + a3 + "\tMGR: " + a4
							+ "\tHIREDATE: " + a5 + "\tSAL: " + a6 + "\tCOMM: " + a7 + "\tDEPTNO: " + a8);
					
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
