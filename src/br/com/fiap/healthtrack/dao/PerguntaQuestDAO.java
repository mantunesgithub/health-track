package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.PerguntaQuest;

public	interface PerguntaQuestDAO {
	public	void incluir (PerguntaQuest perguntaQuest);
	public	void excluir (Integer idPerguntaQuest);
	public	void alterar (PerguntaQuest perguntaQuest);					
	public	List <PerguntaQuest> getAll();
	public	PerguntaQuest buscarPorId(Integer idPerguntaQuest);
}
