<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>IE</title>
</head>
<body>
<h1>Validando IE com o Componente do Stella Faces</h1>
<h2>Através do validator-id</h2>
<h3>Atenção: esta é a forma menos recomendada!</h3>
<f:view>
  <h:form id="formulario">
    <h:panelGrid columns="3">
      <h:outputLabel value="IE:"/>
      <h:inputText id="IE">
        <f:validator validatorId="StellaIEValidator"/>
      </h:inputText>
      <h:message for="IE"/>
    </h:panelGrid>

    <h:commandButton value="Enviar"/>
    <h:messages/>
  </h:form>
</f:view>
</body>
</html>