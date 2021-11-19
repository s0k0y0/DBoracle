package p00.DB_conn;

import java.util.ArrayList;

public class sampleMain2 {

	public static void main(String[] args) {
		
	
		sampleDAO da=new sampleDAO();
		ArrayList<sampleDTO> a=da.findAll();//point5.arraylist타입으로 메소드를 불러와 저장하기
		
		for(int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
		
		
		
		
		

	}

}
