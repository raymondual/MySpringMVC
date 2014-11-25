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
		<c:forEach var="order" items="${orders}">
			<tr>
				<th>${order.id}</th>
				<th>${order.orderNumber}</th>
				<th>${order.customer.name}</th>
				<th>${order.customer.homeAddr.city}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>