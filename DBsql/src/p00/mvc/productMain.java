package p00.mvc;

import java.util.Scanner;

public class productMain {

	public static void main(String[] args) {

		boolean stop = true;
		int keyboard;
		droduct ddd;

		Scanner c = new Scanner(System.in);
		orable oo = new orable();
		

		while (stop) {
			
			System.out.println("1.제품등록  2.제품검색  3.전체검색  4.수정  5.삭제  6.종료");
			keyboard = c.nextInt();
			
			if (keyboard == 1) {
				
				System.out.print("제품이름: ");
				String name=c.next();
				System.out.print("제품가격: ");
				int price=c.nextInt();
				
				ddd=new droduct(0,name, price);
				oo.insertd(ddd);
				
			}

			if (keyboard == 2) {

			}

			if (keyboard == 3) {

			}
			
			if (keyboard == 4) {

			}
			
			if (keyboard == 5) {

			}
			
			if (keyboard == 6) {
				stop=false;
			}

		}

	}

}
