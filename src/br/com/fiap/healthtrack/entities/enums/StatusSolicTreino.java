package br.com.fiap.healthtrack.entities.enums;

public enum StatusSolicTreino {
		PENDENTE(1),
		PROCESSANDO(2),
		FINALIZADA(3);
		
		private	int	code;

		private StatusSolicTreino(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		public	static	StatusSolicTreino valueOf (int code) {
			for (StatusSolicTreino   value : StatusSolicTreino .values()) {
				if (value.getCode() == code) {
					return value;
				}
			}
			throw	new IllegalArgumentException ("Invalido Status Solicitação Treino ");
		}
}

