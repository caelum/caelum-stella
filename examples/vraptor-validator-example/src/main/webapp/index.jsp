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

<form action="usuario.cadastra.logic"><label for="cpf">CPF:</label>
<input id="cpf" type="text" name="usuario.cpf" /> <input type="submit"
	value="Cadastrar" /></form>

<form action="usuario.cadastra.logic"><label for="CNPJ">CNPJ:</label>
<input id="CNPJ" type="text" name="usuario.cnpj" /> <input type="submit"
	value="Cadastrar" /></form>

<form action="usuario.cadastra.logic"><label for="NIT">NIT:</label>
<input id="NIT" type="text" name="usuario.nit" /> <input type="submit"
	value="Cadastrar" /></form>


</body>
</html>
