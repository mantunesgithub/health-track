package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class PersonalTrainerDAOImpl implements PersonalTrainerDAO {
	private Connection conexao;

	/**
	 * Cria uma lista de PersonalTrainer
	 */
	public List<PersonalTrainer> getAll() {

		List<PersonalTrainer> lista = new ArrayList<PersonalTrainer>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();

			stmt = conexao.prepareStatement("SELECT * FROM T_PERSONAL ORDER BY nm_personal");
			rs = stmt.executeQuery();
			// * Percorre todos os registros encontrados
			while (rs.next()) {
				Long cpfPersonal = rs.getLong("nr_cpf_pers");
				String nome = rs.getString("nm_personal");
				String cref = rs.getString("nr_cref");
				Long rg = rs.getLong("nr_rg");
				String endereco = rs.getString("ds_endereco");
				Integer numero = rs.getInt("nr_endereco");
				String complemento = rs.getString("ds_complemento");
				String bairro = rs.getString("ds_bairro");
				String cidade = rs.getString("ds_cidade");
				String uf = rs.getString("ds_uf");
				String pais = rs.getString("ds_pais");
				String email = rs.getString("ds_email");
				Integer cepPrefixo = rs.getInt("cd_cep_prefixo");
				Integer cepSufixo = rs.getInt("cd_cep_sufixo");
				Integer statusPersonal = rs.getInt("st_personal");
				Integer ddiCelular = rs.getInt("nr_ddi_fone_cel");
				Integer dddCelular = rs.getInt("nr_ddd_fone_cel");
				Integer numeroCelular = rs.getInt("nr_celular");
				java.sql.Date data = rs.getDate("dt_inclusao");
				Calendar dataInclusao = Calendar.getInstance();
				dataInclusao.setTimeInMillis(data.getTime());
				// * Cria um objeto PersonalTrainer com as informações encontradas
				PersonalTrainer personal = new PersonalTrainer(cpfPersonal, nome, cref, rg, endereco, numero,
						complemento, bairro, cidade, uf, pais, email, cepPrefixo, cepSufixo, statusPersonal, ddiCelular,
						dddCelular, numeroCelular, data);
						
				// * Adiciona o medida na lista
				lista.add(personal);
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
	 * Inclusao de PersonalTrainer
	 */
	public void incluir(PersonalTrainer personal) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			conexao.setAutoCommit(false);

			String sql = "INSERT INTO T_PERSONAL"
					+ "(nr_cpf_pers,nm_personal,nr_cref,nr_rg,ds_endereco,nr_endereco,ds_complemento,ds_bairro,"
					+ "ds_cidade,ds_uf,ds_pais,cd_cep_prefixo,cd_cep_sufixo,st_personal,nr_ddi_fone_cel,"
					+ "nr_ddd_fone_cel,nr_celular,ds_email,dt_inclusao)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, personal.getCpfPersonal());
			stmt.setString(2, personal.getNome());
			stmt.setString(3, personal.getCref());
			stmt.setLong(4, personal.getRg());
			stmt.setString(5, personal.getEndereco());
			stmt.setInt(6, personal.getNumero());
			stmt.setString(7, personal.getComplemento());
			stmt.setString(8, personal.getBairro());
			stmt.setString(9, personal.getCidade());
			stmt.setString(10, personal.getUf());
			stmt.setString(11, personal.getPais());
			stmt.setInt(12, personal.getCepPrefixo());
			stmt.setInt(13, personal.getCepSufixo());
			stmt.setInt(14, personal.getStatusPersonal());
			stmt.setInt(15, personal.getDdiCelular());
			stmt.setInt(16, personal.getDddCelular());
			stmt.setInt(17, personal.getNumeroCelular());
			stmt.setString(18, personal.getEmail());
			java.sql.Date data = new java.sql.Date(personal.getDataInclusao().getTime());
			stmt.setDate(19, data);

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
	 * Alteração de PersonalTrainer
	 */
	public void alterar(PersonalTrainer personal) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "UPDATE T_PERSONAL SET "
					+ "nm_personal = ?,nr_cref = ?,nr_rg = ?,ds_endereco = ?,nr_endereco = ?,ds_complemento = ?,ds_bairro = ?,"
					+ "ds_cidade = ?,ds_uf = ?,ds_pais = ?,cd_cep_prefixo = ?,cd_cep_sufixo = ?,st_personal = ?,nr_ddi_fone_cel = ?,"
					+ "nr_ddd_fone_cel = ?,nr_celular = ?,ds_email = ?,dt_inclusao = ?"
					+ "WHERE nr_cpf_pers = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, personal.getNome());
			stmt.setString(2, personal.getCref());
			stmt.setLong(3, personal.getRg());
			stmt.setString(4, personal.getEndereco());
			stmt.setInt(5, personal.getNumero());
			stmt.setString(6, personal.getComplemento());
			stmt.setString(7, personal.getBairro());
			stmt.setString(8, personal.getCidade());
			stmt.setString(9, personal.getUf());
			stmt.setString(10, personal.getPais());
			stmt.setInt(11, personal.getCepPrefixo());
			stmt.setInt(12, personal.getCepSufixo());
			stmt.setInt(13, personal.getStatusPersonal());
			stmt.setInt(14, personal.getDdiCelular());
			stmt.setInt(15, personal.getDddCelular());
			stmt.setInt(16, personal.getNumeroCelular());
			stmt.setString(17, personal.getEmail());
			java.sql.Date data = new java.sql.Date(personal.getDataInclusao().getTime());
			stmt.setDate(18, data);
			stmt.setLong(19, personal.getCpfPersonal());

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
	 * Exclusão de PersonalTrainer
	 */
	public void excluir(Long cpfPersonal) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();

			String sql = "DELETE FROM T_PERSONAL " + "WHERE nr_cpf_pers = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, cpfPersonal);

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
	 * Busca por codigo personal
	 */
	public PersonalTrainer buscarPorId(Long cpfPersonal) {
		PersonalTrainer personal = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_PERSONAL WHERE nr_cpf_pers = ?");
			stmt.setLong(1, cpfPersonal);
			rs = stmt.executeQuery();

			if (rs.next()) {
				// * Cria um objeto PersonalTrainer com as informações encontradas
				Long cpfPersonal1 = rs.getLong("nr_cpf_pers");
				String nome = rs.getString("nm_personal");
				String cref = rs.getString("nr_cref");
				Long rg = rs.getLong("nr_rg");
				String endereco = rs.getString("ds_endereco");
				Integer numero = rs.getInt("nr_endereco");
				String complemento = rs.getString("ds_complemento");
				String bairro = rs.getString("ds_bairro");
				String cidade = rs.getString("ds_cidade");
				String uf = rs.getString("ds_uf");
				String pais = rs.getString("ds_pais");
				String email = rs.getString("ds_email");
				Integer cepPrefixo = rs.getInt("cd_cep_prefixo");
				Integer cepSufixo = rs.getInt("cd_cep_sufixo");
				Integer statusPersonal = rs.getInt("st_personal");
				Integer ddiCelular = rs.getInt("nr_ddi_fone_cel");
				Integer dddCelular = rs.getInt("nr_ddd_fone_cel");
				Integer numeroCelular = rs.getInt("nr_celular");
				java.sql.Date data = rs.getDate("dt_inclusao");
				Calendar dataInclusao = Calendar.getInstance();
				dataInclusao.setTimeInMillis(data.getTime());
				// * Cria um objeto PersonalTrainer com as informações encontradas
				personal = new PersonalTrainer(cpfPersonal1, nome, cref, rg, endereco, numero, complemento, bairro,
						cidade, uf, pais, email, cepPrefixo, cepSufixo, statusPersonal, ddiCelular, dddCelular,
						numeroCelular, data);

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
		return (personal);
	}
}
