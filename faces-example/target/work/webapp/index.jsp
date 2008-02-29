<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CPF</title>
</head>
<body>
<f:view>
	<h:form id="formulario">
		<h:outputLabel value="cpf:" />
		<h:inputText >
			<f:validator validatorId="cpfValidator" />
		</h:inputText>
		<h:commandButton value="Enviar" />
		<h:messages />
	</h:form>
</f:view>
</body>
</html>