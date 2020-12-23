package br.com.fiap.healthtrack.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * O objetivo desta classe cadastrar as modalidades de treino
 * 
 * @author antun
 * @version 1.0
 */

public class Modalidade {
	
	private Integer codigoModalidade;
	private String descricaoModalidade;
	

	public Modalidade() {
	}
	
	public Modalidade(Integer codigoModalidade, String descricaoModalidade) {
		this.codigoModalidade = codigoModalidade;
		this.descricaoModalidade = descricaoModalidade;
	}

	/**
	 * Associacões
	 */
	private List<SolicitacaoTreino> solicitacaoTreinos = new ArrayList<SolicitacaoTreino>();

	public List<SolicitacaoTreino> getSolicitacaoTreinos() {
		return solicitacaoTreinos;
	}

	private List<TreinoCliente> treinoClientes = new ArrayList<TreinoCliente>();

	public List<TreinoCliente> getTreinoClientes() {
		return treinoClientes;
	}

	/**
	 * Metodo para retorna uma modalidade
	 * 
	 * @param codigo O codigo da modalidade
	 * @return descricao da Modalidade
	 */
	public String consultarModalidade(Integer codigo) {
		return descricaoModalidade;

	}

	/**
	 * Metodos Getters e Seters
	 * 
	 */
	public Integer getCodigoModalidade() {
		return codigoModalidade;
	}

	public void setCodigoModalidade(Integer codigoModalidade) {
		this.codigoModalidade = codigoModalidade;
	}

	public String getDescricaoModalidade() {
		return descricaoModalidade;
	}

	public void setDescricaoModalidade(String descricaoModalidade) {
		this.descricaoModalidade = descricaoModalidade;
	}

	@Override
	public String toString() {
		return "Modalidade [codigoModalidade=" + codigoModalidade + ", descricaoModalidade=" + descricaoModalidade
				+ "]";
	}
	
}
