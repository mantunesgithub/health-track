package br.com.fiap.healthtrack.entities;

import java.util.Date;

/**
 * Esta Classe devolve para o Cliente a mensagem de que a solicitacao de Treino
 * ja foi atendida
 * 
 * @author antun
 * @version 1.0
 */

public class DevolucaoTreinoDoCliente {
	private Long id;
	private Integer statusDevolucaoTreino;
	private Date dataConclusaoDoPersonal;
	private Date dataEnvioTreino;
	private Cliente cliente;
	private TreinoCliente treinoCliente;
	private PersonalTrainer personalTrainer;
/**
 * 	Metodo para sinalizar que o treino ja foi concluido e que esta pronto para
 *  enviar para o Cliente 
 */
	public void enviarTreinoCliente() {

	}

	/**
	 * Metodos Getters e Seters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataConclusaoDoPersonal() {
		return dataConclusaoDoPersonal;
	}

	public void setDataConclusaoDoPersonal(Date dataConclusaoDoPersonal) {
		this.dataConclusaoDoPersonal = dataConclusaoDoPersonal;
	}

	public Date getDataEnvioTreino() {
		return dataEnvioTreino;
	}

	public void setDataEnvioTreino(Date dataEnvioTreino) {
		this.dataEnvioTreino = dataEnvioTreino;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TreinoCliente getTreinoCliente() {
		return treinoCliente;
	}

	public void setTreinoCliente(TreinoCliente treinoCliente) {
		this.treinoCliente = treinoCliente;
	}

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}

	public void setPersonalTrainer(PersonalTrainer personalTrainer) {
		this.personalTrainer = personalTrainer;
	}

	public Integer getStatusDevolucaoTreino() {
		return statusDevolucaoTreino;
	}

	public void setStatusDevolucaoTreino(Integer statusDevolucaoTreino) {
		this.statusDevolucaoTreino = statusDevolucaoTreino;
	}
}
