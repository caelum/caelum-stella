<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CNPJ</title>
</head>
<body>
<h1>Validando CNPJ com o Componente do Stella Faces</h1>
<h2>Através do validator-id</h2>
<h3>Atenção: esta é a forma menos recomendada!</h3>
<f:view>
	<h:form id="formulario">
		<h:panelGrid columns="3">
			<h:outputLabel value="CNPJ:" />
			<h:inputText id="CNPJ">
				<f:validator validatorId="StellaCNPJValidator" />
			</h:inputText>
			<h:message for="CNPJ" />
		</h:panelGrid>

		<h:commandButton value="Enviar" />
		<h:messages />
	</h:form>
	<f:subview id="sample-cnpj">
		<jsp:include page="/exemplos-CNPJ.jsp"></jsp:include>
	</f:subview>
</f:view>
</body>
</html>