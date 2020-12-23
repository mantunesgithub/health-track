package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.PersonalTrainer;

public interface PersonalTrainerDAO {
	public	void incluir (PersonalTrainer personalTrainer);
	public	void excluir (Long cpfPersonal);
	public	void alterar (PersonalTrainer personalTrainer);					
	public	List <PersonalTrainer> getAll();
	public	PersonalTrainer buscarPorId(Long cpfPersonal);

}
