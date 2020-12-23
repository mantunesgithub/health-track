package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class ClienteDAOImpl implements ClienteDAO {
	private Connection conexao;

	/**
	 * Validar Cliente e senha
	 */
@Override
		public Cliente validarCliente(Cliente cliente) {
			Cliente clienteLogin = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conexao = ConnectionManager.obterConexao();
				stmt = conexao.prepareStatement
						("SELECT * FROM T_CLIE WHERE DS_EMAIL = ? AND CD_SENHA_ATUAL = ?");
				stmt.setString(1, cliente.getEmail());
				stmt.setString(2, cliente.getSenhaAtual());
				rs = stmt.executeQuery();

				if (rs.next()){
					Long cdCPFCliente = rs.getLong("cd_cpf_cli");
					String nome = rs.getString("nm_cliente");
					String email = rs.getString("ds_email");
					java.sql.Date dtNasc = rs.getDate("dt_nascimentto");
					Calendar dataNasc = Calendar.getInstance();
					dataNasc.setTimeInMillis(dtNasc.getTime());
					Integer dddCelular = rs.getInt("nr_ddd_fone_cel");
					Integer numeroCelular = rs.getInt("nr_cel_clie");
					Integer stCliente = rs.getInt("st_cliente");
					// * Cria um objeto Cliente com as informações encontradas
					clienteLogin = new Cliente(cdCPFCliente, nome, email, dataNasc,
							dddCelular, numeroCelular, stCliente);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					rs.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return clienteLogin;
		}

/**
 * Criar uma lista de Cliente
 */
public List<Cliente> getAll() {

	List<Cliente> lista = new ArrayList<Cliente>();

	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		conexao = ConnectionManager.obterConexao();

		stmt = conexao.prepareStatement("SELECT * FROM T_CLIE "
										+ "ORDER BY nm_cliente");
		rs = stmt.executeQuery();
		// * Percorre todos os registros encontrados
		while (rs.next()) {
			Long cdCPFCliente = rs.getLong("cd_cpf_cli");
			String nome = rs.getString("nm_cliente");
			String email = rs.getString("ds_email");
			java.sql.Date dtNasc = rs.getDate("dt_nascimentto");
			Calendar dataNasc = Calendar.getInstance();
			dataNasc.setTimeInMillis(dtNasc.getTime());
			Integer dddCelular = rs.getInt("nr_ddd_fone_cel");
			Integer numeroCelular = rs.getInt("nr_cel_clie");
			Integer stCliente = rs.getInt("st_cliente");
			// * Cria um objeto Cliente com as informações encontradas
			Cliente cliente = new Cliente(cdCPFCliente, nome, email, dataNasc,
					dddCelular, numeroCelular, stCliente);
					
//			 * Adiciona o medida na lista
			lista.add(cliente);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return lista;
}

/**
 * Inclusao de Cliente
 */
public void incluir(Cliente cliente) {
	PreparedStatement stmt = null;
	try {
		conexao = ConnectionManager.obterConexao();
		conexao.setAutoCommit(false);

		String sql = "INSERT INTO T_CLIE"
				+ "(cd_cpf_cli,nm_cliente,nr_rg,dt_nascimentto,ds_endereco,nr_endereco,"
				+ "ds_complemento,ds_bairro,ds_cidade,ds_uf,ds_pais,cd_cep_prefixo,cd_cep_sufixo,"
				+ "st_cliente,ds_email,ds_profissao,cd_senha_atual,cd_senha_anterior,qt_tentativas," 
				+ "nr_ddi_fone_cel,nr_ddd_fone_cel,nr_cel_clie,dt_alteracao_clie,dt_inclusao_clie)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
		stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, cliente.getCdCPFCliente());
		stmt.setString(2, cliente.getNome());
		stmt.setInt(3, cliente.getRg());
		java.sql.Date dataNasc = new java.sql.Date(cliente.getDataNascimento().getTimeInMillis());
		stmt.setDate(4, dataNasc);
		stmt.setString(5, cliente.getEndereco());
		stmt.setInt(6, cliente.getNumero());
		stmt.setString(7, cliente.getComplemento());
		stmt.setString(8, cliente.getBairro());
		stmt.setString(9, cliente.getCidade());
		stmt.setString(10, cliente.getUf());
		stmt.setString(11, cliente.getPais());
		stmt.setInt(12, cliente.getCepPrefixo());
		stmt.setInt(13, cliente.getCepSufixo());
		stmt.setInt(14, cliente.getStatusCliente());
		stmt.setString(15, cliente.getEmail());
		stmt.setString(16, cliente.getProfissao());
		stmt.setString(17, cliente.getSenhaAtual());
		stmt.setString(18, cliente.getSenhaAnterior());
		stmt.setInt(19, cliente.getTentativasErro());
		stmt.setInt(20, cliente.getDdiCelular());
		stmt.setInt(21, cliente.getDddCelular());
		stmt.setInt(22, cliente.getNumeroCelular());
		java.sql.Date dataAlte = new java.sql.Date(cliente.getDataAlteracao().getTimeInMillis());
		stmt.setDate(23, dataAlte);
		java.sql.Date dataIncl = new java.sql.Date(cliente.getDataInclusao().getTimeInMillis());
		stmt.setDate(24, dataIncl);

		stmt.executeUpdate();

		conexao.commit();
	} catch (SQLException e) {
		e.printStackTrace();
		try {
			conexao.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} finally {
		try {
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Alteração de Cliente
 */
public void alterar(Cliente cliente) {
	PreparedStatement stmt = null;
	try {
		conexao = ConnectionManager.obterConexao();
		String sql = "UPDATE T_CLIE SET "
				+ "nm_cliente = ?,nr_rg = ?,dt_nascimentto = ?,ds_endereco = ?,nr_endereco = ?,"
				+ "ds_complemento = ?,ds_bairro = ?,ds_cidade = ?,ds_uf = ?,ds_pais = ?,cd_cep_prefixo = ?,cd_cep_sufixo = ?,"
				+ "st_cliente = ?,ds_email = ?,ds_profissao = ?,cd_senha_atual = ?,cd_senha_anterior = ?,qt_tentativas = ?," 
				+ "nr_ddi_fone_cel = ?,nr_ddd_fone_cel = ?,nr_cel_clie = ?,dt_alteracao_clie = ?,dt_inclusao_clie = ?"
				+ "WHERE cd_cpf_cli = ?";
				
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setInt(2, cliente.getRg());
		java.sql.Date dataNasc = new java.sql.Date(cliente.getDataNascimento().getTimeInMillis());
		stmt.setDate(3, dataNasc);
		stmt.setString(4, cliente.getEndereco());
		stmt.setInt(5, cliente.getNumero());
		stmt.setString(6, cliente.getComplemento());
		stmt.setString(7, cliente.getBairro());
		stmt.setString(8, cliente.getCidade());
		stmt.setString(9, cliente.getUf());
		stmt.setString(10, cliente.getPais());
		stmt.setInt(11, cliente.getCepPrefixo());
		stmt.setInt(12, cliente.getCepSufixo());
		stmt.setInt(13, cliente.getStatusCliente());
		stmt.setString(14, cliente.getEmail());
		stmt.setString(15, cliente.getProfissao());
		stmt.setString(16, cliente.getSenhaAtual());
		stmt.setString(17, cliente.getSenhaAnterior());
		stmt.setInt(18, cliente.getTentativasErro());
		stmt.setInt(19, cliente.getDdiCelular());
		stmt.setInt(20, cliente.getDddCelular());
		stmt.setInt(21, cliente.getNumeroCelular());
		java.sql.Date dataAlte = new java.sql.Date(cliente.getDataAlteracao().getTimeInMillis());
		stmt.setDate(22, dataAlte);
		java.sql.Date dataIncl = new java.sql.Date(cliente.getDataInclusao().getTimeInMillis());
		stmt.setDate(23, dataIncl);
		stmt.setLong(24, cliente.getCdCPFCliente());



		stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Exclusão de Cliente
 */
public void excluir(Long cdCPFCliente) {
	PreparedStatement stmt = null;
	try {
		conexao = ConnectionManager.obterConexao();

		String sql = "DELETE FROM T_CLIE " + "WHERE cd_cpf_cli = ?";
		stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, cdCPFCliente);

		stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Busca por codigo cliente
 */
public Cliente buscarPorId(Long cdCPFCliente) {
	Cliente cliente = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		conexao = ConnectionManager.obterConexao();
		stmt = conexao.prepareStatement("SELECT * FROM T_CLIE WHERE cd_cpf_cli = ?");
		stmt.setLong(1, cdCPFCliente);
		rs = stmt.executeQuery();

		if (rs.next()) {						
			// * Cria um objeto Cliente com as informações encontradas
			Long cdCPFCliente1 = rs.getLong("cd_cpf_cli");
			String nome = rs.getString("nm_cliente");
			String email = rs.getString("ds_email");
			java.sql.Date dtNasc = rs.getDate("dt_nascimentto");
			Calendar dataNasc = Calendar.getInstance();
			dataNasc.setTimeInMillis(dtNasc.getTime());
			Integer ddiCelular = rs.getInt("nr_ddi_fone_cel");
			Integer dddCelular = rs.getInt("nr_ddd_fone_cel");
			Integer numeroCelular = rs.getInt("nr_cel_clie");
			String senhaAtual = rs.getString("cd_senha_atual");
			Integer stCliente = rs.getInt("st_cliente");
			Integer rg = rs.getInt("nr_rg");
			String endereco = rs.getString("ds_endereco");
			Integer numero = rs.getInt("nr_endereco");
			String complemento = rs.getString("ds_complemento");
			String bairro = rs.getString("ds_bairro");
			String cidade = rs.getString("ds_cidade");
			String uf = rs.getString("ds_uf");
			String pais = rs.getString("ds_pais");
			Integer cepPrefixo = rs.getInt("cd_cep_prefixo");
			Integer cepSufixo = rs.getInt("cd_cep_sufixo");
			String profissao = rs.getString("ds_profissao");
			String senhaAnterior = rs.getString("cd_senha_anterior");
			Integer tentativasErro = rs.getInt("qt_tentativas");
			java.sql.Date dataalt = rs.getDate("dt_alteracao_clie");
			Calendar dataAlteracao = Calendar.getInstance();
			dataAlteracao.setTimeInMillis(dataalt.getTime());
			java.sql.Date data = rs.getDate("dt_inclusao_clie");
			Calendar dataInclusao = Calendar.getInstance();
			dataInclusao.setTimeInMillis(data.getTime());

			// * Cria um objeto Cliente com as informações encontradas
			cliente = new Cliente(cdCPFCliente1, nome, email, dataNasc,
					ddiCelular, dddCelular,numeroCelular,senhaAtual,stCliente,rg,endereco,
					numero, complemento, bairro,cidade, uf, pais,cepPrefixo,
					cepSufixo,profissao,senhaAnterior,tentativasErro,dataAlteracao,dataInclusao);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return (cliente);
}
}
