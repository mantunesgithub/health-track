package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.healthtrack.entities. Modalidade ;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class ModalidadeDAOImpl implements ModalidadeDAO {
	private Connection conexao;
	/**
	 *	Cria uma lista de  Modalidade  stmt.set 
	 */
	public List<Modalidade> getAll() {
		
		List<Modalidade> lista = new ArrayList<Modalidade>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			ConnectionManager.getInstance();
			conexao = ConnectionManager.obterConexao();
			
			stmt = conexao.prepareStatement("SELECT * FROM T_MOD ORDER BY DS_MODAL");
			rs = stmt.executeQuery();
			//* Percorre todos os registros encontrados
			while (rs.next()) {
				
				//* Cria um objeto Modalidade com as informações encontradas
				Modalidade  modal = new  Modalidade (rs.getInt("CD_MOD"),
													 rs.getString("DS_MODAL"));

				//* Adiciona o medida na lista
				lista.add(modal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close(); rs.close(); conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	/**
	 * Inclusao de Modalidade
	 */
	public void incluir(Modalidade modalidade) {
		PreparedStatement stmt = null;
		try {
			ConnectionManager.getInstance();
			conexao = ConnectionManager.obterConexao();
			String sql = "INSERT INTO T_MOD"
					+    "(CD_MOD,DS_MODAL)"
					+    " VALUES (?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, modalidade.getCodigoModalidade());
			stmt.setString(2, modalidade.getDescricaoModalidade());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close(); conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Alteração de Modalidade
	 */
	public void alterar(Modalidade modalidade) {
		PreparedStatement stmt = null;
		try {
			ConnectionManager.getInstance();
			conexao = ConnectionManager.obterConexao();
			String sql = "UPDATE T_MOD SET DS_MODAL = ?"
			           + "WHERE CD_MOD = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, modalidade.getDescricaoModalidade());
			stmt.setInt   (2, modalidade.getCodigoModalidade());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close(); conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Exclusão de Modalidade
	 */
	public void excluir(Integer cdModalidade) {
		PreparedStatement stmt = null;
		try {
			ConnectionManager.getInstance();
			conexao = ConnectionManager.obterConexao();
			
			String sql = "DELETE FROM T_MOD "
					+	 "WHERE CD_MOD = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdModalidade);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close(); conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Busca por Id de Modalidade
	 */
	public Modalidade buscarPorId(Integer cdModalidade) {
		Modalidade  modal = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			ConnectionManager.getInstance();
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement
					("SELECT * FROM T_MOD WHERE CD_MOD = ?");
			stmt.setInt(1, cdModalidade );
			rs = stmt.executeQuery();
			

			if (rs.next()) {
				//* Cria um objeto Modalidade com as informações encontradas
				modal = new  Modalidade (rs.getInt("CD_MOD"),
										 rs.getString("DS_MODAL"));
										 }
	    } catch (SQLException e) {
	          e.printStackTrace();
	    }finally {
	          try {
	            stmt.close(); rs.close(); conexao.close();
	          } catch (SQLException e) {
	            e.printStackTrace();
	          }
	    }
	    return modal;
   }
}
