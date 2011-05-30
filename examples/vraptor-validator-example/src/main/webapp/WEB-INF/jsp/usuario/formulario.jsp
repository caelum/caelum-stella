<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro de Usuário</title>
</head>
<body>

	<c:forEach items="${errors}" var="error">
		${error.category} - ${error.message}<br />
	</c:forEach>

	<form action="cadastra">
		<label for="cpf">CPF:</label> <input id="cpf" type="text"
			name="usuario.cpf" /> <input type="submit" value="Cadastrar" />
	</form>

	<h4>Exemplos de CPF</h4>
	<table>
		<tbody>
			<tr>
				<td><label> CPF Válido:</label></td>
				<td><label> 47393545608</label></td>

			</tr>
			<tr>
				<td><label> CPF INVALID_CHECK_DIGITS:</label></td>
				<td><label> 09907586561</label></td>
			</tr>
			<tr>
				<td><label> CPF INVALID_DIGITS:</label></td>
				<td><label> 123456789012</label></td>
			</tr>

			<tr>
				<td><label> CPF Formatado:</label></td>
				<td><label> 356.296.825-63</label></td>
			</tr>
		</tbody>
	</table>
	<br />

</body>
</html>