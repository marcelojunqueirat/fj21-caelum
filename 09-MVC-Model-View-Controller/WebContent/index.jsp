<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda MVC</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/cabecalho.jsp" />

	<a href="mvc?logica=PrimeiraLogica">Primeira Lógica</a>
	<br />
	<a href="mvc?logica=ListaContatosLogic">Lista de Contatos</a>
	<br />

	<c:import url="/WEB-INF/jsp/rodape.jsp" />
</body>
</html>