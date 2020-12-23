package br.com.fiap.healthtrack.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta é uma Classe Pagamento que possui os seguintes objetivos principais: -
 * Gerar o treino do Cliente por um Personal Trainer para cada modalidade da
 * solicitacao de treino do cliente
 * 
 * @author antun
 * @version 1.0
 */

public class PlanoPagamentoCliente {
	private Long id;
	private Modalidade codigoModalidade;
	private String tipoDePlano;
	private Date dataInicioPlano;
	private Date dataFinalPlano;
	private String formaPagamento;
	private Double valorAVista;
	private Integer quantidadeParcelas;
	private Double valorDaParcela;
	private Date dataInclusao;
	private Integer statusDoPlano;
	/**
	 * Associacoes
	 */
	private Cliente cliente;

	private List<ParcelasDoPlanoPagamento> parcelas = new ArrayList<ParcelasDoPlanoPagamento>();

	public List<ParcelasDoPlanoPagamento> getParcelas() {
		return parcelas;
	}
	/**
	 * Lsta de retorno
	 */
	private List<PlanoPagamentoCliente> pagamentoClientes = new ArrayList<PlanoPagamentoCliente>();

	/**
	 * Construtor Padrao
	 */
	public PlanoPagamentoCliente() {

	}

	/**
	 * Metodo para gerar parcellas do Plano de pagamento do cliente
	 */
	public void gerarParcelaPlanoPagamentoCliente() {

	}

	/**
	 * Metodo para atualizar Plano de pagamento do cliente
	 */
	public void atualizarPlanoPagamento() {

	}
	/**
	 * Metodo para incluir Plano de pagamento do cliente
	 */
	public void incluirPlanoPagamento() {

	}

	/**
	 * Metodo para devolver lista de Plano de pagamento do cliente a partir do
	 * codigo Cliente
	 */
	public List<PlanoPagamentoCliente> consultarPlanoPagamentoCliente(Cliente cliente) {
		return pagamentoClientes;
	}

	/**
	 * Metodos Getters e Seters
	 * 
	 */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Modalidade getCodigoModalidade() {
		return codigoModalidade;
	}

	public void setCodigoModalidade(Modalidade codigoModalidade) {
		this.codigoModalidade = codigoModalidade;
	}

	public String getTipoDePlano() {
		return tipoDePlano;
	}

	public void setTipoDePlano(String tipoDePlano) {
		this.tipoDePlano = tipoDePlano;
	}

	public Date getDataInicioPlano() {
		return dataInicioPlano;
	}

	public void setDataInicioPlano(Date dataInicioPlano) {
		this.dataInicioPlano = dataInicioPlano;
	}

	public Date getDataFinalPlano() {
		return dataFinalPlano;
	}

	public void setDataFinalPlano(Date dataFinalPlano) {
		this.dataFinalPlano = dataFinalPlano;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValorAVista() {
		return valorAVista;
	}

	public void setValorAVista(Double valorAVista) {
		this.valorAVista = valorAVista;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public Double getValorDaParcela() {
		return valorDaParcela;
	}

	public void setValorDaParcela(Double valorDaParcela) {
		this.valorDaParcela = valorDaParcela;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Integer getStatusDoPlano() {
		return statusDoPlano;
	}

	public void setStatusDoPlano(Integer statusDoPlano) {
		this.statusDoPlano = statusDoPlano;
	}

	public List<PlanoPagamentoCliente> getPagamentoClientes() {
		return pagamentoClientes;
	}

	public void setPagamentoClientes(List<PlanoPagamentoCliente> pagamentoClientes) {
		this.pagamentoClientes = pagamentoClientes;
	}
}