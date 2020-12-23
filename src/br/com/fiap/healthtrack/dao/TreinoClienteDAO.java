package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.TreinoCliente;

public	interface TreinoClienteDAO {
	public	void incluir (TreinoCliente treino);
	public	void excluir (Long idTreino);
	public	void alterar (TreinoCliente treino);					
	public	List <TreinoCliente> getAll(Long cpfCliente, String tipoGet);
	public	TreinoCliente buscarPorId(Long idTreino);
}
