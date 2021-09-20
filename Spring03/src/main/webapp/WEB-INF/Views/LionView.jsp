<%@page import="Pack01.Person"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="Pack01.Person.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>사자</h1>
	<!-- 뷰에는 자바 코드 x -->
	<!-- 제어문을 사용해야한다면 jstl 로 사용 -->
	<%-- <h1>사자</h1>
	<h1>${name}</h1>
	<h1>${age}</h1>
	 --%>
	 
	<%-- 객체로 받았을때는 객체.함수 <h1>${ppp.getName()}</h1> --%>
	<h1>${mmm.get(0)}</h1>
	<h1>${mmm.get(1)}</h1>
	<h1>${mmm.get(2)}</h1>
	 
	 
<%
	//getAttribute 의 리턴 타입이 object 타입이라 String 으로 캐스팅 해야함
	//String name = (String)request.getAttribute("name");
	//String age = (String)request.getAttribute("age");
	
	// 객체로 받았을때는 객체로 캐스팅
	//Person person = (Person)request.getAttribute("ppp");
	//person.getName();
	
%>

<% //person.getName() %>
<% //person.getAge() %> 






</body>
</html>