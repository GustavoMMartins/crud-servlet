<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="formNovaEmpresa.jsp" var="formularNovaEmpresa"/>
<c:url value="/editaEmpresa" var="edita"/>
<c:url value="/removeEmpresa" var="remove"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<h3>Lista Empresas</h3>

	<a href="${formularNovaEmpresa}">Adicionar Empresa</a>

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<fmt:formatDate value="${empresa.dataFundacao}" pattern="dd/MM/yyyy" var="dataFormatada"/>
			<li>${empresa.nome}, ${dataFormatada} <a href="${edita}?id=${empresa.id}">Editar</a> - <a href="${remove}?id=${empresa.id}">Remover</a></li>
		</c:forEach>
	</ul>

</body>
</html>