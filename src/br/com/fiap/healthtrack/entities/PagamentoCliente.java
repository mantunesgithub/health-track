package br.com.fiap.healthtrack.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta é uma Classe Pagamento do Cliente que possui os seguintes objetivos
 * principais: - Gerar o pagamento do Cliente da solicitacao de treino do
 * cliente
 * 
 * @author antun
 * @version 1.0
 */

public class PagamentoCliente {
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
	private Integer statusDaParcela;
	/**
	 * Associacoes
	 */
	private Cliente cliente;

	private List<ParcelasDoPlanoPagamento> parcelas = new ArrayList<ParcelasDoPlanoPagamento>();

	public List<ParcelasDoPlanoPagamento> getParcelas() {
		return parcelas;
	}


	/**
	 * Lista de retorno de pagamentos efetuados
	 */
	private List<PagamentoCliente> pagamentos = new ArrayList<PagamentoCliente>();
	
	public 	List<PagamentoCliente> getPagamentos() {
		return pagamentos;
	}
	/**
	 * Metodo para inclusao de pagamento dos Clientes
	 * 
	 * @param cliente	Cliente
	 * @return se atualizou ok ou não
	 */
	public boolean incluirPagamento(Cliente cliente) {
		return false;
	}

	/**
	 * Metodo para exclusão de pagamento dos Clientes
	 * 
	 */

	public boolean excluirPagamento(Cliente cliente) {
		return false;
	}
	/**
	 * Metodo para consultar de pagamento dos Clientes 
	 * 
	 */
	
	public List<PagamentoCliente> consultarPagamento(Cliente cliente) {
		return pagamentos;
	}

	/**
	 * Metodos Getters e Seteres
	 * 
	 */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PagamentoCliente() {

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

	public Integer getStatusDaParcela() {
		return statusDaParcela;
	}

	public void setStatusDaParcela(Integer statusDaParcela) {
		this.statusDaParcela = statusDaParcela;
	}

	public void setParcelas(List<ParcelasDoPlanoPagamento> parcelas) {
		this.parcelas = parcelas;
	}
}