package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.FaseTreino;

public	interface FaseTreinoDAO {
	public	void incluir (FaseTreino faseTreino);
	public	void excluir (Long idFaseTreino);
	public	void alterar (FaseTreino faseTreino);					
	public	List <FaseTreino> getAll();
	public	FaseTreino buscarPorId(Long idFaseTreino);
	
}
