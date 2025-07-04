<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,
			br.com.caelum.dao.*,
			br.com.caelum.modelo.*,
			java.text.SimpleDateFormat
			"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de contatos via scriptlet</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
		<%
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		for (Contato contato : contatos) {
		%>
			<tr>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getEmail()%></td>
				<td><%=contato.getEndereco()%></td>
				<td><%=formatoData.format(contato.getDataNascimento().getTime())%></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>