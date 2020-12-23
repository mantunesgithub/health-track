package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.Questionario;

public interface QuestionarioDAO {
	
	public	void incluir (Questionario questionario);
	public	void excluir (Integer cdQuestionario);
	public	void alterar (Questionario questionario);					
	public	List <Questionario> getAll();
	public	Questionario buscarPorId(Integer cdQuestionario);
}
