<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/stella.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invalid CPF</title>
</head>
<h1>Invalid CPF</h1>
<body>
There were some validation problems:
<div id="errors">
<ul>
	<c:forEach var="error" items="${errors.iterator}">
		<li>${error.key}</li>
	</c:forEach>
</ul>
</div>
</body>
</html>