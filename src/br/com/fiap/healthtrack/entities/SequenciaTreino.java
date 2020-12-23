package br.com.fiap.healthtrack.entities;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe de Sequencia do Treino ou exercicios programados pelo Personal
 * Trainer.  
 *  * @author antun
 * @version 1.0
 */
public class SequenciaTreino {
	private Long idSequTreino;
	private String descAtividade;
	private Integer qtdeSeries;
	private Integer qtdeRepeticoes;
	private Double pesoDaCarga;
	private String qtdeFreqCardiaca;
	private Double qtdeTempoMedio;
	private Double qtdeVelocidade;
	private Double qtdeIntesidade;
	private Double qtdeTempoDuracao;
	private Double qtdeTempoDescanso;
	private String descMetodo;
	
	private TreinoCliente treinoCliente;
	private SequAtividade sequAtiv;
	/**
	 *    Contrutores
	 */
	public SequenciaTreino(Long idSequTreino, String descAtividade, Integer qtdeSeries, Integer qtdeRepeticoes,
			Double pesoDaCarga, String qtdeFreqCardiaca, Double qtdeTempoMedio, Double qtdeVelocidade,
			Double qtdeIntesidade, Double qtdeTempoDuracao, Double qtdeTempoDescanso, String descMetodo) {
	
		this.idSequTreino = idSequTreino;
		this.descAtividade = descAtividade;
		this.qtdeSeries = qtdeSeries;
		this.qtdeRepeticoes = qtdeRepeticoes;
		this.pesoDaCarga = pesoDaCarga;
		this.qtdeFreqCardiaca = qtdeFreqCardiaca;
		this.qtdeTempoMedio = qtdeTempoMedio;
		this.qtdeVelocidade = qtdeVelocidade;
		this.qtdeIntesidade = qtdeIntesidade;
		this.qtdeTempoDuracao = qtdeTempoDuracao;
		this.qtdeTempoDescanso = qtdeTempoDescanso;
		this.descMetodo = descMetodo;
	}
	public SequenciaTreino() {
	
	}
	/**
	 * Metodos Getters e Seters
	 * 
	 */

	public Long getIdSequTreino() {
		return idSequTreino;
	}

	public void setIdSequTreino(Long idSequTreino) {
		this.idSequTreino = idSequTreino;
	}

	public String getDescAtividade() {
		return descAtividade;
	}

	public void setDescAtividade(String descAtividade) {
		this.descAtividade = descAtividade;
	}

	public Integer getQtdeSeries() {
		return qtdeSeries;
	}

	public void setQtdeSeries(Integer qtdeSeries) {
		this.qtdeSeries = qtdeSeries;
	}

	public Integer getQtdeRepeticoes() {
		return qtdeRepeticoes;
	}

	public void setQtdeRepeticoes(Integer qtdeRepeticoes) {
		this.qtdeRepeticoes = qtdeRepeticoes;
	}

	public Double getPesoDaCarga() {
		return pesoDaCarga;
	}

	public void setPesoDaCarga(Double pesoDaCarga) {
		this.pesoDaCarga = pesoDaCarga;
	}

	public String getQtdeFreqCardiaca() {
		return qtdeFreqCardiaca;
	}

	public void setQtdeFreqCardiaca(String qtdeFreqCardiaca) {
		this.qtdeFreqCardiaca = qtdeFreqCardiaca;
	}

	public Double getQtdeTempoMedio() {
		return qtdeTempoMedio;
	}

	public void setQtdeTempoMedio(Double qtdeTempoMedio) {
		this.qtdeTempoMedio = qtdeTempoMedio;
	}

	public Double getQtdeVelocidade() {
		return qtdeVelocidade;
	}

	public void setQtdeVelocidade(Double qtdeVelocidade) {
		this.qtdeVelocidade = qtdeVelocidade;
	}

	public Double getQtdeIntesidade() {
		return qtdeIntesidade;
	}

	public void setQtdeIntesidade(Double qtdeIntesidade) {
		this.qtdeIntesidade = qtdeIntesidade;
	}

	public Double getQtdeTempoDuracao() {
		return qtdeTempoDuracao;
	}

	public void setQtdeTempoDuracao(Double qtdeTempoDuracao) {
		this.qtdeTempoDuracao = qtdeTempoDuracao;
	}

	public Double getQtdeTempoDescanso() {
		return qtdeTempoDescanso;
	}

	public void setQtdeTempoDescanso(Double qtdeTempoDescanso) {
		this.qtdeTempoDescanso = qtdeTempoDescanso;
	}

	public String getDescMetodo() {
		return descMetodo;
	}

	public void setDescMetodo(String descMetodo) {
		this.descMetodo = descMetodo;
	}


	public TreinoCliente getTreinoCliente() {
		return treinoCliente;
	}

	public void setTreinoCliente(TreinoCliente treinoCliente) {
		this.treinoCliente = treinoCliente;
	}


	public SequAtividade getSequAtiv() {
		return sequAtiv;
	}
	public void setSequAtiv(SequAtividade sequAtiv) {
		this.sequAtiv = sequAtiv;
	}


	/**
	 * Associacão Treino Cliente x Sequencia de Treino
	 */
	private List<SequenciaTreino> tm = new ArrayList<SequenciaTreino>();
	
	public  void adicionarTreino(SequenciaTreino treino) {
		tm.add(treino);
	}	
	
	public List<SequenciaTreino> getMusculacao() {
		return tm;
	}
//	public void imprimirSequenciaTreino() {
//		for (SequenciaTreino x : tm) {
//			System.out.println("Sequencia           = " + x.getSequenciaExercicio());
//			System.out.println("Descricao Exercicio = " + x.getDescricaoExecicio());
//		}
	@Override
	public String toString() {
		return "SequenciaTreino [idSequTreino=" + idSequTreino + ", descAtividade=" + descAtividade + ", qtdeSeries="
				+ qtdeSeries + ", qtdeRepeticoes=" + qtdeRepeticoes + ", pesoDaCarga=" + pesoDaCarga
				+ ", qtdeFreqCardiaca=" + qtdeFreqCardiaca + ", qtdeTempoMedio=" + qtdeTempoMedio + ", qtdeVelocidade="
				+ qtdeVelocidade + ", qtdeIntesidade=" + qtdeIntesidade + ", qtdeTempoDuracao=" + qtdeTempoDuracao
				+ ", qtdeTempoDescanso=" + qtdeTempoDescanso + ", descMetodo=" + descMetodo + ", treinoCliente="
				+ treinoCliente + ", sequAtiv=" + sequAtiv + "]";
	}
}
