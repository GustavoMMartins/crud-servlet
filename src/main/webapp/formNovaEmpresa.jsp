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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body class="container">

<h1 class="mt-5 mb-5 text-center">Formulário de cadastro de empresa</h1>



<form class="col-6 mx-auto" action="${novaEmpresaServlet}" method="post">		
	
	<div class="mb-3">
	  <label for="nome" class="form-label">Empresa</label>
	  <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome da Empresa" required="required">
	</div>
	<div class="mb-5">
	  <label for="dataFundacao" class="form-label">Data</label>
	  <input type="date" class="form-control" name="dataFundacao" id="dataFundacao" placeholder="Data de fundação da empresa">
	</div>
	<div class="col-12">
		<input class="col-12 btn btn-outline-primary" type="submit" value="Cadastrar">	
	</div>
</form>

</body>
</html>