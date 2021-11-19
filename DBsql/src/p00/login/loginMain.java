package p00.login;

import java.util.Scanner;

public class loginMain {

	public static void main(String[] args) {
		
		boolean isStop=false;
		Scanner s=new Scanner(System.in);
		
		loginSVC l=new loginSVC();
		
		
		do {
			
			System.out.println("로그인 화면입니다.");
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.print("아이디 : ");
			String id=s.next();
			System.out.println("비밀번호 : ");
			String passwd=s.next();
			
			user u=l.login(id, passwd);//메소드의 리턴타입인 user타입으로 변수값을 입력시키겠다
			
			if(u==null) {
				System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
				
			} else {
				
				System.out.println("로그인한 사용자 정보");
				System.out.println(u);
				isStop=true;
				
			}
	
		} while(!(isStop=true));
		
		s.close();

	}

}
