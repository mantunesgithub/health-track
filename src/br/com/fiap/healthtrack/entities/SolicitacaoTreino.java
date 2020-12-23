package br.com.fiap.healthtrack.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fiap.healthtrack.entities.enums.StatusSolicTreino;
import br.com.fiap.healthtrack.entities.enums.StatusTreinoCliente;

/**
 * Classe para Gerar Solicitação de treino para Personal Trainer
 * 
 * @author antun
 */
public class SolicitacaoTreino {
	private Long idSolicitacaoTreino;
	private Calendar dataSolicitacao;
	private String descObjetivoTreino;
	private Calendar dataGeracaoTreino;
	private Integer statusSolicTreino;
	private	Calendar dataInclusao;	
	private Cliente cliente;
	private PersonalTrainer  personalTrainer ;
	private Modalidade  modalidade;
	public SolicitacaoTreino(Long idSolicitacaoTreino, Calendar dataSolicitacao, String descObjetivoTreino,
			Calendar dataGeracaoTreino, StatusSolicTreino statusSolicTreino, Calendar dataInclusao, Cliente cliente,
			PersonalTrainer personalTrainer, Modalidade modalidade) {
		super();
		this.idSolicitacaoTreino = idSolicitacaoTreino;
		this.dataSolicitacao = dataSolicitacao;
		this.descObjetivoTreino = descObjetivoTreino;
		this.dataGeracaoTreino = dataGeracaoTreino;
		setStatusSolicTreino(statusSolicTreino);
		this.dataInclusao = dataInclusao;
		this.cliente = cliente;
		this.personalTrainer = personalTrainer;
		this.modalidade = modalidade;
	}
	/**
	 * Contrutores
	 */
	public Long getIdSolicitacaoTreino() {
		return idSolicitacaoTreino;
	}
	public void setIdSolicitacaoTreino(Long idSolicitacaoTreino) {
		this.idSolicitacaoTreino = idSolicitacaoTreino;
	}
	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getDescObjetivoTreino() {
		return descObjetivoTreino;
	}
	public void setDescObjetivoTreino(String descObjetivoTreino) {
		this.descObjetivoTreino = descObjetivoTreino;
	}
	public Calendar getDataGeracaoTreino() {
		return dataGeracaoTreino;
	}
	public void setDataGeracaoTreino(Calendar dataGeracaoTreino) {
		this.dataGeracaoTreino = dataGeracaoTreino;
	}
	public StatusSolicTreino getStatusSolicTreino() {
		return StatusSolicTreino.valueOf(statusSolicTreino);
	}
	public void setStatusSolicTreino(StatusSolicTreino statusSolicTreino) {
		this.statusSolicTreino = statusSolicTreino.getCode();
	}
	public Calendar getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}
	public void setPersonalTrainer(PersonalTrainer personalTrainer) {
		this.personalTrainer = personalTrainer;
	}
	public Modalidade getModalidade() {
		return modalidade;
	}
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	public Integer getStatusSolicTreinoInt() {
		return statusSolicTreino;
	}	
}
