package br.com.fiap.healthtrack.entities.enums;
/**
 * O objetivo desta classe é devolver string correspondente ao status do treino cliente  
 * @author antun
 * @version 1.0 */
public enum StatusTreinoCliente {
		ATIVO(1),
		INATIVO(2),
		VISITANTE(3);
		
		private	int	code;

		private StatusTreinoCliente(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		public	static	StatusTreinoCliente valueOf (int code) {
			for (StatusTreinoCliente   value : StatusTreinoCliente .values()) {
				if (value.getCode() == code) {
					return value;
				}
			}
			throw	new IllegalArgumentException ("Invalido Status do treino cliente ");
		}
}
