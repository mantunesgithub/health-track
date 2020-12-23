package br.com.fiap.healthtrack.entities;

/**
 * O objetivo desta classe é gerar questionario para obter informações sobre a
 * saude do cliente
 * 
 * @author antun
 * @version 1.0
 */
public class PerguntaQuest {
	private Integer idPergunta;
	private String dsPergunta1;
	private String dsPergunta2;
	private String dsPergunta3;
	private Integer cdQuestionario;

	public PerguntaQuest(String dsPergunta1,
			String dsPergunta2, String dsPergunta3, Integer cdQuestionario) {
		
		this.dsPergunta1 = dsPergunta1;
		this.dsPergunta2 = dsPergunta2;
		this.dsPergunta3 = dsPergunta3;
		this.cdQuestionario = cdQuestionario;
	}

	public PerguntaQuest(Integer idPergunta, String dsPergunta1, String dsPergunta2, String dsPergunta3,
			Integer cdQuestionario) {
		this.idPergunta = idPergunta;
		this.dsPergunta1 = dsPergunta1;
		this.dsPergunta2 = dsPergunta2;
		this.dsPergunta3 = dsPergunta3;
		this.cdQuestionario = cdQuestionario;
	}

	public PerguntaQuest() {
	}

	public Integer getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(Integer idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getDsPergunta1() {
		return dsPergunta1;
	}

	public void setDsPergunta1(String dsPergunta1) {
		this.dsPergunta1 = dsPergunta1;
	}

	public String getDsPergunta2() {
		return dsPergunta2;
	}

	public void setDsPergunta2(String dsPergunta2) {
		this.dsPergunta2 = dsPergunta2;
	}


	public Integer getCdQuestionario() {
		return cdQuestionario;
	}
	
	public void setCdQuestionario(Integer cdQuestionario) {
		this.cdQuestionario = cdQuestionario;
	}
	public String getDsPergunta3() {
		return dsPergunta3;
	}

	public void setDsPergunta3(String dsPergunta3) {
		this.dsPergunta3 = dsPergunta3;
	}

	@Override
	public String toString() {
		return "PerguntaQuest [idPergunta=" + idPergunta + ", dsPergunta1=" + dsPergunta1 + ", dsPergunta2="
				+ dsPergunta2 + ", dsPergunta3=" + dsPergunta3 + "]";
	}
	
}
