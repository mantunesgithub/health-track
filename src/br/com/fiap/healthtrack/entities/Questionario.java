package br.com.fiap.healthtrack.entities;

/**
 * O objetivo desta classe é gerar questionario para obter informações sobre a
 * saude do cliente
 * 
 * @author antun
 * @version 1.0
 */
public class Questionario {
	private Integer cdQuestionario;
	private String dsQuestionario;

	public Questionario(Integer cdQuestionario, String dsQuestionario) {
		super();
		this.cdQuestionario = cdQuestionario;
		this.dsQuestionario = dsQuestionario;
	}

	/**
	 * Associacões entre entidades
	 */

	public Questionario() {
	}

	/**
	 * Metodos Getters e Seters
	 * 
	 */

	public Integer getCdQuestionario() {
		return cdQuestionario;
	}

	public void setCdQuestionario(Integer cdQuestionario) {
		this.cdQuestionario = cdQuestionario;
	}

	public String getDsQuestionario() {
		return dsQuestionario;
	}

	public void setDsQuestionario(String dsQuestionario) {
		this.dsQuestionario = dsQuestionario;
	}

	@Override
	public String toString() {
		return "Questionario [cdQuestionario=" + cdQuestionario + ", dsQuestionario=" + dsQuestionario + "]";
	}


}
