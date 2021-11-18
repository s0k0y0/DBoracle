<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
jsp:web에서 실행되는 또 다른 자바
jsp(MVC Model1):Client요청(http://localhost/Time.jsp)을 서버의 jsp가 받아서 처리한 후 html문서로 browser에게 전달. 즉,모델1에선 서블릿과 jsp 둘중 하나의 문서로 처리되어 실행됨.jsp파일 형태가 드러나서 보안에 취약<br>
jsp(MVC Model2):Client의 요청을 서블릿이 받아서 처리한 후 jsp를 통해서 browser에 html문서로 전달. 모델2에선 jsp와 서블렛의 역할이 나누어져 있음<br>
클라이언트의 요청을 서블렛이 받아 데이터베이스에서 처리한후 결과값을 jsp에 실행허 클라이언트에서 실행히켜줌<br>



<%
Calendar c=Calendar.getInstance();
int hour=c.get(Calendar.HOUR_OF_DAY);
int minute=c.get(Calendar.MINUTE);
int second=c.get(Calendar.SECOND);
System.out.println(hour+":"+minute+":"+second);//콘솔에다가 출력하는 자바 문법


out.println("<br>띄어쓰기<br>");
out.println(hour+"/"+minute+"/"+second+"<br>");//웹에다가 출력하는 jsp문법

%>
현재 시간은 <%=hour %> 시 <%=minute %>분 <%=second %>초
</body>
</html>