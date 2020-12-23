package br.com.fiap.healthtrack.entities;

public class SequAtividade {
	/**
	 * O objetivo desta classe é cadastrar a sequencia de atividades do treino do cliente
	 * @author antun
	 * @version 1.0
	 */
	private Long idSequAtiv;
	private String descSequAtiv;
	private String descObjetivoAtiv;
	private Modalidade modalidade;
	
	public SequAtividade(Long idSequAtiv, String descSequAtiv, String descObjetivoAtiv) {
		this.idSequAtiv = idSequAtiv;
		this.descSequAtiv = descSequAtiv;
		this.descObjetivoAtiv = descObjetivoAtiv;
	}
	
	public SequAtividade() {
	}


	public SequAtividade(Long idSequAtiv, String descSequAtiv, String descObjetivoAtiv, Modalidade modalidade) {
		super();
		this.idSequAtiv = idSequAtiv;
		this.descSequAtiv = descSequAtiv;
		this.descObjetivoAtiv = descObjetivoAtiv;
		this.modalidade = modalidade;
	}

	public Long getIdSequAtiv() {
		return idSequAtiv;
	}
	public void setIdSequAtiv(Long idSequAtiv) {
		this.idSequAtiv = idSequAtiv;
	}
	public String getDescSequAtiv() {
		return descSequAtiv;
	}
	public void setDescSequAtiv(String descSequAtiv) {
		this.descSequAtiv = descSequAtiv;
	}
	public String getDescObjetivoAtiv() {
		return descObjetivoAtiv;
	}
	public void setDescObjetivoAtiv(String descObjetivoAtiv) {
		this.descObjetivoAtiv = descObjetivoAtiv;
	}
	public Modalidade getModalidade() {
		return modalidade;
	}
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	@Override
	public String toString() {
		return "SequAtividade [idSequAtiv=" + idSequAtiv + ", descSequAtiv=" + descSequAtiv + ", descObjetivoAtiv="
				+ descObjetivoAtiv + ", modalidade=" + modalidade + "]";
	}
	
	
}
