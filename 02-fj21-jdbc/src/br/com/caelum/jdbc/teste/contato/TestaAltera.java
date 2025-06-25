package br.com.caelum.jdbc.teste.contato;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisar(5);
		
		contato.setNome("Marcelo Teste");
		contato.setEmail("teste_marcelo@caelum.com.br");
		contato.setEndereco("R. Testes 98745 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		dao.altera(contato);
		System.out.println("Alterado!");
	}

}
