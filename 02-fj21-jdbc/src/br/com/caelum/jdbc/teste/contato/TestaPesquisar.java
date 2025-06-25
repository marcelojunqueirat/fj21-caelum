package br.com.caelum.jdbc.teste.contato;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.utils.Utils;

public class TestaPesquisar {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisar(4);
		
		if (contato != null) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + Utils.converterParaData(contato.getDataNascimento().getTime()) + "\n");	
		} else {
			System.out.println("Contato não encontrado.");
		}
	}

}
