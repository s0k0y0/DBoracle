package p00.mvc2;

import java.util.Scanner;
import java.util.Vector;

public interface Service{//비지니스 제출

	void addProduct();

	void editProduct();

	void delProduct();

	Product getProduct();

	Vector<Product> getProducts();
	
}


class ServiceImpl implements Service {

	Dao da=new OrableDao();
	Scanner s=new Scanner(System.in);
	Vector<Product> vv;
	Product p;
	
	@Override
	public void addProduct() {
		System.out.print("제품이름: ");
		String name=s.next();
		System.out.print("제품가격: ");
		int price=s.nextInt();
		da.insert(new Product(0, name, price));//시퀀스에는 1부터이기 때문에 0을 넣어 값을 무마할 수 있음
		
	}

	@Override
	public Product getProduct() {
		System.out.print("제품번호: ");
		int num=s.nextInt();
		p=da.select(num);
		return p;//리턴값은 생성된 객체의 주소값
		
	}
	
	@Override
	public Vector<Product> getProducts() {
		
		
		Vector<Product> pp=da.selectAll();//main과 마찬가지로 메소드의 리턴타입을 데이터타입으로하여 데이터를 가져오는 메소드를 호출해줌
		return pp;
	}
	
	@Override
	public void editProduct() {
		System.out.print("수정할 제품번호: ");
		int num=s.nextInt();
		p=da.select(num);
		System.out.println(p);
		
		System.out.print("new제품이름: ");
		String name=s.next();
		System.out.print("new제품가격: ");
		int price=s.nextInt();
	
		da.update(num,new Product(num, name, price));
	}

	@Override
	public void delProduct() {
		System.out.print("삭제할 제품번호: ");
		int num=s.nextInt();
		da.delete(num);
		
	}

	

	

}
