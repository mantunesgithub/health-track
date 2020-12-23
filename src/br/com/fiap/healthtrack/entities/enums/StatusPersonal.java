package br.com.fiap.healthtrack.entities.enums;
/**
 * O objetivo desta classe é devolver string correspondente ao status do Personal Trainer  
 * @author antun
 * @version 1.0 */ 
public enum StatusPersonal {
		ATIVO(1),
		INATIVO(2);
		
		private	int	code;

		private StatusPersonal(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		public	static	StatusPersonal valueOf (int code) {
			for (StatusPersonal   value : StatusPersonal .values()) {
				if (value.getCode() == code) {
					return value;
				}
			}
			throw	new IllegalArgumentException ("Invalido Status do Personal Trainer ");
		}
}
