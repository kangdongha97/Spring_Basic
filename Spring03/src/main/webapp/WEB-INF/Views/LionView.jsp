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
	<h1>����</h1>
	<!-- �信�� �ڹ� �ڵ� x -->
	<!-- ����� ����ؾ��Ѵٸ� jstl �� ��� -->
	<%-- <h1>����</h1>
	<h1>${name}</h1>
	<h1>${age}</h1>
	 --%>
	 
	<%-- ��ü�� �޾������� ��ü.�Լ� <h1>${ppp.getName()}</h1> --%>
	<h1>${mmm.get(0)}</h1>
	<h1>${mmm.get(1)}</h1>
	<h1>${mmm.get(2)}</h1>
	 
	 
<%
	//getAttribute �� ���� Ÿ���� object Ÿ���̶� String ���� ĳ���� �ؾ���
	//String name = (String)request.getAttribute("name");
	//String age = (String)request.getAttribute("age");
	
	// ��ü�� �޾������� ��ü�� ĳ����
	//Person person = (Person)request.getAttribute("ppp");
	//person.getName();
	
%>

<% //person.getName() %>
<% //person.getAge() %> 






</body>
</html>