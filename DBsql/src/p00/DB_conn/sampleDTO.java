package p00.DB_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sampleDTO {

	private String id;
	private String name;
	private int price;

	public sampleDTO(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		String result="id: "+id+"\tname: "+name+"\tprice: "+price;
		return result;
	}
}





class sampleDAO {

	public ArrayList<sampleDTO> findAll(){
		
		Connection c = null;
		Statement st = null;
		
		ArrayList<sampleDTO> a = new ArrayList<>();//point1.sampleDTO타입의 arraylist생성
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			c = DriverManager.getConnection(url, "javalink", "javalink");
			
			st = c.createStatement();
			String q="select*from book";
			ResultSet re=st.executeQuery(q);
			
			while(re.next()) {
				
				
				String name=re.getString(2);//statement의 table값 가져오기
				int price=re.getInt(3);
				String id=re.getString(1);
				
				sampleDTO dd=new sampleDTO(id, name, price);//point2.table에서 가져온 값을 생성자 메소드로 sampleDTO변수들에 저장
				
				a.add(dd);//point3.값을 저장한 객체를 배열에 저장. 2와3을 반복문으로 돌려 배열에 한 행씩 저장되도록 한다
			
			}
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		return a;//point4. method return값이 arraylist이므로 arraylist 주소값을 리턴해줌
		
		
	}

}
