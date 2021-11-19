package p00.mvc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import p00.mvc.droduct;

public interface Dao {// 퍼시스턴스 제출

	void insert(Product p);

	Product select(int num);

	Vector<Product> selectAll();

	void delete(int num);

	void update(int num, Product p);
}

class OrableDao implements Dao {

	private Connection conn = null;
	private PreparedStatement pst;

	public OrableDao() {
		DBconnect db = DBconnect.getInstance();// 싱글통을 통한 객체 생성. 즉, 객체생성된 걸 그걸 찾아 호출하는 것. 2.싱글톤 호출 방법
		conn = db.getConnection();// DB연결
	}

	public Connection getConn() {
		return conn;
	}

	@Override
	public void insert(Product p) {

		try {
			
			
			//자유자재의 값을 넣고 수정하려면 statement보다 preparedstatement로 ?를 통해 값을 유용하게 변형시킬 수 있음
			String q = "insert into product values(reno.nextval,?,?)";
			pst = conn.prepareStatement(q);
			pst.setString(1, p.getName());// ?를 기준으로 인덱스 1번이 맞음
			pst.setInt(2, p.getPrice());
			int c = pst.executeUpdate();// 실행하는 코드

			
			
			
			
			if (c > 0) {// 데이터값이 아니라 실행자체를 뜻하는 것 실행이 되었으면 0보다 크고 실행이 안됬으면, 움직임이 없기에 0이라는 것
				System.out.println("데이터 저장");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Product select(int num) {

		try {

			String q = "select*from product where num=?";
			pst = conn.prepareStatement(q);
			pst.setInt(1, num);
			ResultSet re = pst.executeQuery();
			if (re.next()) {
				num = re.getInt(1);
				String name = re.getString(2);
				int price = re.getInt(3);
				System.out.println("num: " + num + "name: " + name + "price: " + price);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public Vector<Product> selectAll() {
		Vector<Product> v = new Vector<Product>();

		try {
			System.out.println("Orable selectAll");

			String q = "select * from product";
			pst = conn.prepareStatement(q);
			ResultSet re = pst.executeQuery();
			while (re.next()) {
				int num = re.getInt(1);
				String name = re.getString(2);
				int price = re.getInt(3);

				v.add(new Product(num, name, price));// 하나 출력한 행을 배열에 행을 저장하도록 한다

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return v;// 값을 출력하기 위해 반드시 값이 들어있는 배열을 리턴해줘야 함
	}

	@Override
	public void update(int num, Product p) {
		try {
			String q = "update product set name=?,price=? where num=?";
			pst = conn.prepareStatement(q);
			pst.setString(1, p.getName());
			pst.setInt(2, p.getPrice());
			pst.setInt(3, num);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int num) {

		try {

			String q = "delete from product where num=?";
			pst = conn.prepareStatement(q);
			pst.setInt(1, num);
			int c = pst.executeUpdate();
			if (c > 0) {
				System.out.println("데이터 삭제");
			} else {
				System.out.println("데이터 삭제 실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
