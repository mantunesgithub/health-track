package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.exception.DBException;

public interface ClienteDAO {
	public	void incluir (Cliente cliente) throws DBException;
	public	void excluir (Long cpfCliente) throws DBException;
	public	void alterar (Cliente cliente) throws DBException;					
	public	List <Cliente> getAll() ;
	public	Cliente buscarPorId(Long cpfCliente) ;
	public	Cliente	validarCliente(Cliente cliente) ;

}
