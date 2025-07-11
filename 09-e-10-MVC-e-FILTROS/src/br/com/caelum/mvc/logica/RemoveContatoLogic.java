package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogic implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long id = Long.parseLong(request.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		// busca a conexão pendurada na requisição via FiltroConexao
		Connection connection = (Connection) request.getAttribute("conexao");

		ContatoDao dao = new ContatoDao(connection);
		dao.remove(contato);

		System.out.println("Excluindo contato...");
		return "mvc?logica=ListaContatosLogic";
	}

}
