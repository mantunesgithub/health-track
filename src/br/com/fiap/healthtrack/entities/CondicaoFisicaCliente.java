package br.com.fiap.healthtrack.entities;

import java.util.List;

/**
 * O objetivo desta classe é exibie as condicoes físicas, medidas, dados gerais
 * do Cliente
 * 
 * @author antun
 * @version 1.0
 */
public class CondicaoFisicaCliente {
	private Long id;
	private Cliente cliente;
	private List<MedidaCliente> medidaCliente;
	private List<Questionario> questionarios;

	/**
	 * Metodo para receber codigoCliente e retornar um Cliente
	 * @param codigoCliente	codigo Cliente
	 * @return	Cliente		Cliente	
	 */
	public Cliente obterDadosCliente(Integer codigoCliente) {
		return cliente;
	}
	/**
	 * Metodo para receber codigoCliente e retornar uma lista das medidadas do cliente
	 * @param codigoCliente Codigo Cliente
	 * @return	lista das medidadas do cliente
	 */
	public List<MedidaCliente> obterMedidasCliente(Integer codigoCliente) {
		return medidaCliente;
	}
	/**
	 * Metodo para receber codigoCliente e retornar uma lista questionario do cliente
	 * @param codigoCliente	Codigo Cliente
	 * @return	lista questionario do cliente
	 */
	public List<Questionario> obterQuestionario(Integer codigoCliente) {
		return questionarios;
	}
	/**
	 * Metodo para exibir informacoes gerais e da saude do cliente
	 * @return	informacoes gerais e da saude do cliente
	 */
	public CondicaoFisicaCliente exibirCondicaoFisicaCliente() {
		return null;
	}

	/**
	 * Metodos Getters e Seters
	 * 
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<MedidaCliente> getMedidaCliente() {
		return medidaCliente;
	}

	public void setMedidaCliente(List<MedidaCliente> medidaCliente) {
		this.medidaCliente = medidaCliente;
	}

	public List<Questionario> getQuestionario() {
		return questionarios;
	}

	public void setQuestionario(List<Questionario> questionario) {
		this.questionarios = questionario;
	}

}
