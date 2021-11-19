package p00.mvc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class droduct {

	private int num;
	private String name;
	private int price;

	public droduct(int num, String name, int price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		String result = "num: " + num + "name: " + name + "price: " + price;
		return result;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

interface DAO {

	void insertd(droduct p);

	droduct select(int num);

	Vector<droduct> selectAll();

	void delete(int num);

	void update(int num, droduct p);

}

class orable implements DAO {

	DBconnectonp00 dd = new DBconnectonp00();
	Statement st = null;
	droduct pp;

	@Override
	public void insertd(droduct p) {

		dd.connect();
		try {
			st = dd.c.createStatement();
			String q = "insert into product values( 'reno.nextval','" + p.getName() + "' ,' " + p.getPrice() + "')";
			int re = st.executeUpdate(q);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public droduct select(int num) {

		dd.connect();

		try {
			st = dd.c.createStatement();
			String q = "SELECT * FROM product WHERE num = '" + num + "';";
			ResultSet re = st.executeQuery(q);
			num = re.getInt(1);
			String name = re.getString(2);
			int price = re.getInt(3);
			pp = new droduct(num, name, price);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pp;
	}

	@Override
	public Vector<droduct> selectAll() {
		dd.connect();

		try {

			st = dd.c.createStatement();
			String q = "select*from product;";
			ResultSet re = st.executeQuery(q);

			while (re.next()) {
				int num = re.getInt(1);
				String name = re.getString(2);
				int price = re.getInt(3);
				pp = new droduct(num, name, price);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pp;
	}

	@Override
	public void delete(int num) {
		dd.connect();
		try {
			st = dd.c.createStatement();
			String q = "delete from product WHERE num = '" + num + "';";
			int re = st.executeUpdate(q);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(int num, droduct p) {
		dd.connect();
		
		try {
			st = dd.c.createStatement();
			String q = "update product set name='"+p.getName()+"' and price='"+p.getPrice()+"' where num='"+num+"';";
			int re = st.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

class DBconnectonp00 {

	Connection c = null;

	public void connect() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			c = DriverManager.getConnection(url, "javalink", "javalink");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	};

}


