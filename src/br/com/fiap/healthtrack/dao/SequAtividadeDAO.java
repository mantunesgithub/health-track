package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.SequAtividade;

public	interface SequAtividadeDAO {
	public	void incluir (SequAtividade sequAtividade);
	public	void excluir (Long idSequAtiv);
	public	void alterar (SequAtividade sequAtividade);					
	public	List <SequAtividade> getAll();
	public	SequAtividade buscarPorId(Long idSequAtiv);
}
