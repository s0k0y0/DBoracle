package p00.mvc2;

import java.util.Scanner;
import java.util.Vector;

public class ProductMain {/// 프레젠테이션 제출

	public static void main(String[] args) {

		Service ser = new ServiceImpl();
		
		ser.addProduct();
		ser.getProduct();
		Vector<Product> v = ser.getProducts();//메소드의 리턴타입으로 메소드를 변수에 넣어줌
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		ser.editProduct();
		ser.delProduct();
		
		
		
		
		
		
		
		
		
//		Scanner c = new Scanner(System.in);
//
//		boolean stop = true;
//		int keyboard = 0;
//
//		while (stop) {
//
//			System.out.println("1.제품등록  2.제품검색  3.전체검색  4.수정  5.삭제  6.종료");
//			keyboard = c.nextInt();
//
//			if (keyboard == 1) {
//
//				
//			}
//
//			if (keyboard == 2) {
//
//				
//			}
//
//			if (keyboard == 3) {
//
//				
//			}
//
//			if (keyboard == 4) {
//
//				
//			}
//
//			if (keyboard == 5) {
//
//				
//			}
//
//			if (keyboard == 6) {
//				stop = false;
//				c.close();
//			}
//
//		}
	}
}
