<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de contatos</title>
</head>
<body>

	<fmt:setLocale value="pt_BR" />
	<!-- Acessivel via url do servlet /listarContato -->
	<c:import url="cabecalho.jsp" />

	<display:table name="contatos" id="contato" pagesize="5" requestURI="">
		<display:column property="id" title="ID" sortable="true" />
		<display:column property="nome" title="Nome" sortable="true" />

		<display:column title="E-mail" sortable="true">
			<c:choose>
				<c:when test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:when>
				<c:otherwise>
	                E-mail não informado
	            </c:otherwise>
			</c:choose>
		</display:column>


		<display:column property="endereco" title="Endereço" sortable="false" />

		<display:column title="Data de Nascimento" sortable="true">
			<fmt:formatDate value="${contato.dataNascimento.time}"
				pattern="dd/MM/yyyy" />
		</display:column>
		<br/>
	</display:table>

	<c:import url="rodape.jsp" />
</body>
</html>