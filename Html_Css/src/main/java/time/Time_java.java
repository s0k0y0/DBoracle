package time;

import java.util.Calendar;
//순수한 자바는 서버에서 실행한다
public class Time_java {
	public static void main(String[] args) {
		
		Calendar c=Calendar.getInstance();//싱글톤으로 하나의 객체생성을 통해 모든 메소드를 쑬 수 있다
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		System.out.println(hour+":"+minute+":"+second);//서버의 시간을 의미한다
		

	}
}
