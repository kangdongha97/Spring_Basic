<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
</head>
<body>
	<%=new Date()%>
	<h2>Hello World</h2>
	<a href="t1">링크1</a><p/>
	<a href="t2">링크2</a><p/>
	<a href="t3">링크3</a><p/>
	<a href="t4?name=코끼리">링크4</a><p/>
	<a href="t5?name=코끼리&age=25">링크5</a><p/>
	<a href="t6?name=코끼리&age=25">링크6</a><p/>
	<a href="t7">링크7</a><p/>
	<a href="t8?name=소나무&age=40">링크8</a><p/>
	<a href="t9">링크9</a><p/>
	<a href="t10">링크10</a><p/>
	<a href="t11">링크11</a><p/>
	
	
	<form method="post" action="t12">
		<input type="text" name="name" VALUE="kang" /><p>
		<input type="text" name="age" VALUE="25" /><p>
		<input type="submit" value="전송"></input><p>
	</form>
	
	
	<br />
</body>