<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
    
<c:url value="/alteraEmpresa" var="alteraEmpresaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${alteraEmpresaServlet}" method="post">		
	
	<input type="hidden" name="id" value="${empresa.id}">
	
	<label for="nome">
		Nome:<br><input type="text" name="nome" id="nome" required="required" value="${empresa.nome}"/>
	</label>	
	<br><br>
	<label for="dataFundacao">
		<fmt:formatDate value="${empresa.dataFundacao}" pattern="yyyy-MM-dd" var="dataFormatado"/>
		Data de fundação:<br><input type="date" name="dataFundacao" id="dataFundacao" value="${dataFormatado}">
	</label>	
	<br><br>
	
	<input type="submit" value="Cadastrar">	
	
</form>

</body>
</html>