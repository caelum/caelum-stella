<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/stella.css" type="text/css"
	media="screen" />
<title>Cadastro de Usu&aacute;rios</title>
</head>
<body>

<h4>Exemplos de CPF</h4>
<table>
	<tbody>
		<tr>
			<td><label> CPF V&aacute;lido:</label></td>
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
<form action="usuario.cadastra.logic"><label for="cpf">CPF:</label>
<input id="cpf" type="text" name="usuario.cpf" /> <input type="submit"
	value="Cadastrar" /></form>
<h4>Exemplos de CNPJ</h4>
<table>
	<tbody>
		<tr>
			<td><label> CNPJ V&aacute;lido:</label></td>
			<td><label> 63025530002409</label></td>
		</tr>
		<tr>
			<td><label> CNPJ INVALID_CHECK_DIGITS:</label></td>
			<td><label> 74221325000160</label></td>
		</tr>
		<tr>
			<td><label> CNPJ INVALID_DIGITS:</label></td>
			<td><label> 1234567890123</label></td>
		</tr>
		<tr>
			<td><label> CNPJ Formatado:</label></td>

			<td><label> 26.637.142/0001-58</label></td>
		</tr>
	</tbody>
</table>
<br />

<form action="usuario.cadastra.logic"><label for="CNPJ">CNPJ:</label>
<input id="CNPJ" type="text" name="usuario.cnpj" /> <input
	type="submit" value="Cadastrar" /></form>

<h4>Exemplos de NIT</h4>
<table>
	<tbody>
		<tr>
			<td><label> NIT V&aacute;lido:</label></td>
			<td><label> 12345678919</label></td>
		</tr>
		<tr>

			<td><label> NIT INVALID_CHECK_DIGITS:</label></td>
			<td><label> 09907586561</label></td>
		</tr>
		<tr>
			<td><label> NIT INVALID_DIGITS:</label></td>
			<td><label> 123456789012</label></td>
		</tr>
		<tr>
			<td><label> NIT Formatado:</label></td>
			<td><label> 123.45678.91-9</label></td>
		</tr>
	</tbody>
</table>
<br />

<form action="usuario.cadastra.logic"><label for="NIT">NIT:</label>
<input id="NIT" type="text" name="usuario.nit" /> <input type="submit"
	value="Cadastrar" /></form>


</body>
</html>
