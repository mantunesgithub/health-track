package br.com.fiap.healthtrack.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.entities.enums.StatusTreinoCliente;

/**
 * Esta possui os seguintes objetivos principais: -
 * Gerar o treino do Cliente por um Personal Trainer para cada modalidade da
 * solicitacao de treino do cliente
 * 
 * @author antun
 * @version 1.0
 */

public class TreinoCliente {
	private Long idTreino;
	private Calendar dataInicioTreino;
	private Calendar dataFinalTreino;
	private String diasDaSemana;
	private Double qtdeVolumeSemana;
	private Double qtdeVolumeSessao;
	private String descObjetivoTreino;
	private String descLocalTreino;
	private String descTrajeTreino;
	private String descAssesTreino;
	private Long   idMediaTreino;
	private Integer statusTreino;
	private String descObservacoes;
	private Calendar dataAlteracao;
	private Calendar dataInclusao;
	private	Cliente	cliente;
	private FaseTreino faseTreino;
	private	PersonalTrainer personalTrainer;
	private Modalidade modalidade;
	
	private List<SequenciaTreino> sequenciaTreinos = new ArrayList<SequenciaTreino>();

	public TreinoCliente() {
	}
	public TreinoCliente(Long idTreino, Calendar dataInicioTreino, Calendar dataFinalTreino, String diasDaSemana,
			Double qtdeVolumeSemana, Double qtdeVolumeSessao, String descObjetivoTreino, String descLocalTreino,
			String descTrajeTreino, String descAssesTreino, Long idMediaTreino, Integer statusTreino,
			String descObservacoes, Calendar dataAlte, Calendar dataIncl, Cliente cliente, FaseTreino faseTreino,
			PersonalTrainer personalTrainer, Modalidade modalidade) {
		this.idTreino = idTreino;
		this.dataInicioTreino = dataInicioTreino;
		this.dataFinalTreino = dataFinalTreino;
		this.diasDaSemana = diasDaSemana;
		this.qtdeVolumeSemana = qtdeVolumeSemana;
		this.qtdeVolumeSessao = qtdeVolumeSessao;
		this.descObjetivoTreino = descObjetivoTreino;
		this.descLocalTreino = descLocalTreino;
		this.descTrajeTreino = descTrajeTreino;
		this.descAssesTreino = descAssesTreino;
		this.idMediaTreino = idMediaTreino;
		this.statusTreino = statusTreino;
		this.descObservacoes = descObservacoes;
		this.dataAlteracao = dataAlte;
		this.dataInclusao = dataIncl;
		this.cliente = cliente;
		this.faseTreino = faseTreino;
		this.personalTrainer = personalTrainer;
		this.modalidade = modalidade;
	}
	
	public Long getIdTreino() {
		return idTreino;
	}

	public void setIdTreino(Long idTreino) {
		this.idTreino = idTreino;
	}

	public Calendar getDataInicioTreino() {
		return dataInicioTreino;
	}

	public void setDataInicioTreino(Calendar dataInicioTreino) {
		this.dataInicioTreino = dataInicioTreino;
	}

	public Calendar getDataFinalTreino() {
		return dataFinalTreino;
	}

	public void setDataFinalTreino(Calendar dataFinalTreino) {
		this.dataFinalTreino = dataFinalTreino;
	}

	public String getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(String diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	public Double getQtdeVolumeSemana() {
		return qtdeVolumeSemana;
	}

	public void setQtdeVolumeSemana(Double qtdeVolumeSemana) {
		this.qtdeVolumeSemana = qtdeVolumeSemana;
	}

	public Double getQtdeVolumeSessao() {
		return qtdeVolumeSessao;
	}

	public void setQtdeVolumeSessao(Double qtdeVolumeSessao) {
		this.qtdeVolumeSessao = qtdeVolumeSessao;
	}

	public String getDescObjetivoTreino() {
		return descObjetivoTreino;
	}

	public void setDescObjetivoTreino(String descObjetivoTreino) {
		this.descObjetivoTreino = descObjetivoTreino;
	}

	public String getDescLocalTreino() {
		return descLocalTreino;
	}

	public void setDescLocalTreino(String descLocalTreino) {
		this.descLocalTreino = descLocalTreino;
	}

	public String getDescTrajeTreino() {
		return descTrajeTreino;
	}

	public void setDescTrajeTreino(String descTrajeTreino) {
		this.descTrajeTreino = descTrajeTreino;
	}

	public String getDescAssesTreino() {
		return descAssesTreino;
	}

	public void setDescAssesTreino(String descAssesTreino) {
		this.descAssesTreino = descAssesTreino;
	}

	public Long getIdmediaTreino() {
		return idMediaTreino;
	}

	public void setIdMediaTreino(Long idMediaTreino) {
		this.idMediaTreino = idMediaTreino;
	}

	public Integer getStatusTreino() {
		return Integer.valueOf(statusTreino);
	}

	public void setStatusTreino(StatusTreinoCliente statusTreino) {
		this.statusTreino = statusTreino.getCode();
	}
	
		
	public String getDescObservacoes() {
		return descObservacoes;
	}

	public void setDescObservacoes(String descObservacoes) {
		this.descObservacoes = descObservacoes;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar  dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
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

	public FaseTreino getFaseTreino() {
		return faseTreino;
	}

	public void setFaseTreino(FaseTreino faseTreino) {
		this.faseTreino = faseTreino;
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
	public List<SequenciaTreino> getSequenciaTreinos() {
		return sequenciaTreinos;
	}
	@Override
	public String toString() {
		return "TreinoCliente [idTreino=" + idTreino + ", dataInicioTreino=" + dataInicioTreino + ", dataFinalTreino="
				+ dataFinalTreino + ", diasDaSemana=" + diasDaSemana + ", qtdeVolumeSemana=" + qtdeVolumeSemana
				+ ", qtdeVolumeSessao=" + qtdeVolumeSessao + ", descObjetivoTreino=" + descObjetivoTreino
				+ ", descLocalTreino=" + descLocalTreino + ", descTrajeTreino=" + descTrajeTreino + ", descAssesTreino="
				+ descAssesTreino + ", idMediaTreino=" + idMediaTreino + ", statusTreino=" + statusTreino
				+ ", descObservacoes=" + descObservacoes + ", dataAlteracao=" + dataAlteracao + ", dataInclusao="
				+ dataInclusao + ", cliente=" + cliente + ", faseTreino=" + faseTreino + ", personalTrainer="
				+ personalTrainer + ", modalidade=" + modalidade + "]";
	}

	
}
