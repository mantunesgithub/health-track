package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.SolicitacaoTreino;
import br.com.fiap.healthtrack.exception.DBException;

public	interface SolicitacaoTreinoDAO {
	public	void incluir (SolicitacaoTreino solicTreino) throws DBException;
	public	void excluir (Long idSolicTreino);
	public	void alterar (SolicitacaoTreino solicTreino);					
	public	List <SolicitacaoTreino> getAll(Long cpfClienteSession);
	public	SolicitacaoTreino buscarPorId(Long idSolicTreino);
}
