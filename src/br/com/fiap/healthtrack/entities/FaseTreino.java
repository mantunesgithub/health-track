package br.com.fiap.healthtrack.entities;

public class FaseTreino {
	/**
	 * O objetivo desta classe é cadastrar as fase de treino do Treino 
	 * saude do cliente
	 * @author antun
	 * @version 1.0
	 */
		private Long    idFaseTreino;
		private Integer cdFaseTreino;	
		private Integer tpFaseTreino;
		private String  dsTipoTreino;
		private String  dsObjetivoTreino;
		private Modalidade modalidade;
		
		

		public FaseTreino(Long idFaseTreino, Integer cdFaseTreino, Integer tpFaseTreino, String dsTipoTreino,
				String dsObjetivoTreino) {
			super();
			this.idFaseTreino = idFaseTreino;
			this.cdFaseTreino = cdFaseTreino;
			this.tpFaseTreino = tpFaseTreino;
			this.dsTipoTreino = dsTipoTreino;
			this.dsObjetivoTreino = dsObjetivoTreino;
			
		}

		public FaseTreino() {
		}

		public Long getIdFaseTreino() {
			return idFaseTreino;
		}

		public void setIdFaseTreino(Long idFaseTreino) {
			this.idFaseTreino = idFaseTreino;
		}

		public Integer getCdFaseTreino() {
			return cdFaseTreino;
		}

		public void setCdFaseTreino(Integer cdFaseTreino) {
			this.cdFaseTreino = cdFaseTreino;
		}

		public Integer getTpFaseTreino() {
			return tpFaseTreino;
		}

		public void setTpFaseTreino(Integer tpFaseTreino) {
			this.tpFaseTreino = tpFaseTreino;
		}

		public String getDsTipoTreino() {
			return dsTipoTreino;
		}

		public void setDsTipoTreino(String dsTipoTreino) {
			this.dsTipoTreino = dsTipoTreino;
		}

		public String getDsObjetivoTreino() {
			return dsObjetivoTreino;
		}

		public void setDsObjetivoTreino(String dsObjetivoTreino) {
			this.dsObjetivoTreino = dsObjetivoTreino;
		}


		public Modalidade getModalidade() {
			return modalidade;
		}

		public void setModalidade(Modalidade modalidade) {
			this.modalidade = modalidade;
		}
		@Override
		public String toString() {
			return "FaseTreino [idFaseTreino=" + idFaseTreino + ", cdFaseTreino=" + cdFaseTreino + ", tpFaseTreino="
					+ tpFaseTreino + ", dsTipoTreino=" + dsTipoTreino + ", dsObjetivoTreino=" + dsObjetivoTreino + "]";
		}
}
