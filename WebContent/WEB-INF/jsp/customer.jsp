<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC</title>
</head>
<body>
	<table>
		<c:forEach var="cust" items="${customers}">
			<tr>
				<th>${cust.id}</th>
				<th>${cust.name}</th>
				<th>${cust.homeAddr.province}</th>
				<th>${cust.homeAddr.city}</th>
				<th>${cust.homeAddr.street}</th>
				<th>${cust.comAddr.province}</th>
				<th>${cust.comAddr.city}</th>
				<th>${cust.comAddr.street}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>