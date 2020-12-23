package br.com.fiap.healthtrack.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta é uma Classe Parcelas Do Plano Pagamento que possui os seguintes
 * objetivos principais: - Gerar as Parcelas Do Plano Pagamento do Cliente
 * conforme seu plano escolhido
 * 
 * 
 * @author antun
 * @version 1.0
 */

public class ParcelasDoPlanoPagamento {
	private Long id;
	private Date dataVencimento;
	private Double valorDaParcela;
	private Integer numeroDaParcela;
	private Integer numeroDaUltimaParcela;
	private Integer statusDaParcela;

	public ParcelasDoPlanoPagamento() {
	}

	/**
	 * Associacoes
	 */
	private PlanoPagamentoCliente planoPagamentoCliente;

	private List<PagamentoCliente> pagamentoClientes = new ArrayList<PagamentoCliente>();

	public List<PagamentoCliente> getPagamentoClientes() {
		return pagamentoClientes;
	}

	/**
	 * Lista ParcelasDoPlanoPagamento
	 */
	private List<ParcelasDoPlanoPagamento> parcelas = new ArrayList<ParcelasDoPlanoPagamento>();

	public List<ParcelasDoPlanoPagamento> getParcelas() {
		return parcelas;
	}

	/**
	 * 
	 * @param cliente	Cliente
	 * @return Retorna	Numero Da Ultima Parcela
	 */
	public int geradorDeParcelas(Cliente cliente) {
		return numeroDaUltimaParcela;

	}

	/**
	 * Metodo devolve uma lista com as Parcelas do Plano de Pagamento do Cliente
	 * 
	 * @param planoPagamento Recebe Plano Pagamento Cliente
	 * @return lista com as Parcelas do Plano de Pagamento do Cliente
	 */
	public List<ParcelasDoPlanoPagamento> consultarParcelas(PlanoPagamentoCliente planoPagamento) {
		return parcelas;

		/**
		 * Metodo para atualizar parcela paga pelo cliente
		 */
	}

	public boolean atualizarParcelas(PagamentoCliente pagamentoCliente) {
		return false;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorDaParcela() {
		return valorDaParcela;
	}

	public void setValorDaParcela(Double valorDaParcela) {
		this.valorDaParcela = valorDaParcela;
	}

	public Integer getNumeroDaParcela() {
		return numeroDaParcela;
	}

	public void setNumeroDaParcela(Integer numeroDaParcela) {
		this.numeroDaParcela = numeroDaParcela;
	}

	public Integer getNumeroDaUltimaParcela() {
		return numeroDaUltimaParcela;
	}

	public void setNumeroDaUltimaParcela(Integer numeroDaUltimaParcela) {
		this.numeroDaUltimaParcela = numeroDaUltimaParcela;
	}

	public Integer getStatusDaParcela() {
		return statusDaParcela;
	}

	public void setStatusDaParcela(Integer statusDaParcela) {
		this.statusDaParcela = statusDaParcela;
	}

	public PlanoPagamentoCliente getPlanoPagamentoCliente() {
		return planoPagamentoCliente;
	}

}