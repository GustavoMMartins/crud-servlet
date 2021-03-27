package br.com.ctg.crudservlet.model;

import java.util.Date;

public class Empresa {

	private Long id;
	private String nome;
	private Date dataFundacao;
		
	public Empresa(String nome, Date dataFundacao) {
		this.nome = nome;
		this.dataFundacao = dataFundacao;
	}

	public Empresa(Long id, String nome, Date dataFundacao) {
		this.id = id;
		this.nome = nome;
		this.dataFundacao = dataFundacao;
	}
		
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", dataFundacao=" + dataFundacao + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
}
