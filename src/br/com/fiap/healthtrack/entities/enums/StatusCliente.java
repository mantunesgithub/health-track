package br.com.fiap.healthtrack.entities.enums;
/**
 * O objetivo desta classe é devolver string correspondente ao status da matricula  
 * @author antun
 * @version 1.0 */
public enum StatusCliente {
	ATIVO(1),
	INATIVO(2),
	VISITANTE(3);
	
	private	Integer	code;

	private StatusCliente(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	public	static	StatusCliente valueOf (Integer code) {
		for (StatusCliente  value : StatusCliente.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw	new IllegalArgumentException ("Invalido Status da Matricula ");
	}
}
