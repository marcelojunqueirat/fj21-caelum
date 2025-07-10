package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// buscando os parâmetros no request
	    
		// Tratando id, para add contato não dar nullpointer
		String idParam = request.getParameter("id");
        Long id = null;
        if (idParam != null && !idParam.trim().isEmpty()) {
            try {
                id = Long.parseLong(idParam);
            } catch (NumberFormatException e) {
                throw new RuntimeException("ID inválido: " + idParam, e);
            }
        }
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			throw new RuntimeException("Data de nascimento inválida: " + dataEmTexto, e);
		}

		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato de alteração
		ContatoDao dao = new ContatoDao();
		if (id != null) {
		    contato.setId(id);
		    dao.altera(contato);
		} else {
		    dao.adiciona(contato);
		}


		System.out.println("Salvando contato ...");

		// recuperando a nova lista para a grid de contatos
		List<Contato> contatos = dao.getLista();
		request.setAttribute("contatos", contatos);
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
