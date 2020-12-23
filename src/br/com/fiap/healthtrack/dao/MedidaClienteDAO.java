package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.MedidaCliente;
import br.com.fiap.healthtrack.exception.DBException;

public interface MedidaClienteDAO {
	
	public	void incluir (MedidaCliente medida) throws DBException;
	public	void excluir (Integer idMedidaCliente) throws DBException;
	public	void alterar (MedidaCliente medida) throws DBException;					
	public	List <MedidaCliente> getAll(Long cpfCliente) throws DBException;
	public	MedidaCliente buscarPorId(Integer idMedidaCliente) throws DBException;
}
