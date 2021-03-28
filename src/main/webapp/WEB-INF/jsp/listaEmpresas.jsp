<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="formNovaEmpresa.jsp" var="formularNovaEmpresa"/>
<c:url value="/editaEmpresa" var="edita"/>
<c:url value="/removeEmpresa" var="remove"/>

<c:set var="contador" value="${0}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<div class="row mt-5">
	<h3 class="col-12">Empresas cadastradas:</h3>
</div>

	<div class="row col-12">
		<a class="btn btn-outline-primary mt-4" href="${formularNovaEmpresa}">Adicionar Empresa</a>
	</div>
	
	
	<div class="row mt-5">
		<div class="col-12">
			<table class="table table-bordered">
			  <thead>
			    <tr>
			      <th scope="col" class="text-center">ID</th>
			      <th scope="col" class="text-center">Nome</th>
			      <th scope="col" class="text-center">Data</th>
			      <th scope="col" class="text-center">Editar</th>
			      <th scope="col" class="text-center">Excluir</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach items="${empresas}" var="empresa">				  	
				  	<fmt:formatDate value="${empresa.dataFundacao}" pattern="dd/MM/yyyy" var="dataFormatada"/>
				    <tr>
				      <th scope="row" class="text-center pt-3">${contador+1}</th>
				      <td class="text-center pt-3">${empresa.nome}</td>
				      <td class="text-center pt-3">${dataFormatada}</td>
				      <td class="text-center"><a class="col-8 btn btn-outline-primary" href="${edita}?id=${empresa.id}"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
				      <td class="text-center"><a class="col-8 btn btn-outline-primary" href="${remove}?id=${empresa.id}"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
				    </tr>
				    <c:set var="contador" value="${contador+1}"/>
			    </c:forEach> 
			</table>
		</div>	
	</div>

</body>
</html>