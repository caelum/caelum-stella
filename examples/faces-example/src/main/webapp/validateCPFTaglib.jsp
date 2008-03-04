<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://stella.caelum.com.br/faces" prefix="stella" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Validando CPF usando o Componente do Stella Faces Diretamente</title>
</head>
<body>
<h1>Validando CPF usando o Componente do Stella Faces Diretamente</h1>
<f:view>
  <h:form id="formulario">

    <h:panelGrid columns="3">
      <h:outputLabel value="cpf:"/>
      <h:inputText id="cpf">
        <stella:validateCPF/>
      </h:inputText>
      <h:message for="cpf"/>
    </h:panelGrid>

    <h:commandButton value="Enviar"/>

    <h:messages/>
  </h:form>
</f:view>
</body>
</html>