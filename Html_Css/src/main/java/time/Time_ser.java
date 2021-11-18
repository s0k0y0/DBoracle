package time;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet:web에서 수행되는 또 다른 자바
//servlet(MVC Medel1):Client에 요청을 받아서(http://localhost/time)서버에서 처리한 후 클라이언트에 html문서 형식으로 Browser에 전달
//servlet(model2):client요청을 받아서 서버에서 처리한 후 결과를 jsp에 전달해서 browser에서 실행
@WebServlet("/Time")
public class Time_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		Calendar c=Calendar.getInstance();
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		System.out.println(hour+":"+minute+":"+second);

		PrintWriter pw=response.getWriter();
		pw.println("<html><body><br><br>");
		pw.println("시간 출력"+hour+"/"+minute+"/"+second+"<br>");
		pw.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
