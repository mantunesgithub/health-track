package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.SequenciaTreino;
import br.com.fiap.healthtrack.exception.DBException;

public	interface SequenciaTreinoDAO {
	public	void incluir (SequenciaTreino sequTreino) throws DBException;
	public	void excluir (Long idSequTreino) throws DBException;
	public	void alterar (SequenciaTreino sequTreino) throws DBException;					
	public	List <SequenciaTreino> getAll(Long IdTreino) throws DBException;
	public	SequenciaTreino buscarPorId(Long idSequTreino) throws DBException;;
}
