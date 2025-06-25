package br.com.caelum.jdbc.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaInsere {

	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioDao();

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Marcelo Teste do Teste");
		funcionario.setUsuario("marcelo_");
		funcionario.setSenha("1234567");
		
		dao.insere(funcionario);
		System.out.println("Gravado!");

	}

}
