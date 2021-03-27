<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<c:url value="/cadastraEmpresa" var="novaEmpresaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Nova Empresa</title>
</head>
<body>

<h2>Formulário de cadastro de uma nova Empresa</h2>

<form action="${novaEmpresaServlet}" method="post">		
	
	<label for="nome">
		Nome:<br><input type="text" name="nome" id="nome" required="required"/>
	</label>	
	<br><br>
	<label for="dataFundacao">
		Data de fundação:<br><input type="date" name="dataFundacao" id="dataFundacao">
	</label>	
	<br><br>
	
	<input type="submit" value="Cadastrar">	
	
</form>

</body>
</html>