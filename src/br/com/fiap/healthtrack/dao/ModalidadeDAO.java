package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.exception.DBException;

public interface ModalidadeDAO {
	
	public	void incluir (Modalidade modalidade) throws DBException; ;
	public	void excluir (Integer cdModalidade) throws DBException;;
	public	void alterar (Modalidade modalidade) throws DBException;;					
	public	List <Modalidade> getAll();
	public	Modalidade buscarPorId(Integer cdModalidade);
	
}
