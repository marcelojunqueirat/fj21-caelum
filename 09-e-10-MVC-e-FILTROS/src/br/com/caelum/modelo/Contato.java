package br.com.caelum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Contato {
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

	public Contato() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novo) {
		this.nome = novo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String novo) {
		this.email = novo;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String novo) {
		this.endereco = novo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long novo) {
		this.id = novo;
	}

	public Calendar getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataNascimentoFormatada() {
		if (dataNascimento == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dataNascimento.getTime());
	}
}
