<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<body>
<f:view>
	<h:form id="formulario">
		<h:outputLabel value="cpf:"/>
		<h:inputText>
			<f:validator validatorId="cpfValidator"/>
			</h:inputText> 
		<h:commandButton value="enviar" action="#{}"/>
		<h:messages/>
		
	</h:form>
</f:view>
</body>
</html>
