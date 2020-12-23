package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.healthtrack.entities. Questionario ;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class QuestionarioDAOImpl implements QuestionarioDAO {
	private Connection conexao;
	/**
	 *	Cria uma lista de  Questionario  stmt.set 
	 */
	public List<Questionario> getAll() {
		
		List<Questionario> lista = new ArrayList<Questionario>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			stmt = conexao.prepareStatement("SELECT * FROM T_QUEST ");
			rs = stmt.executeQuery();
			//* Percorre todos os registros encontrados
			while (rs.next()) {
				
				//* Cria um objeto Questionario com as informações encontradas
				Questionario  quest = new  Questionario (rs.getInt("CD_QUEST"),
													     rs.getString("DS_QUEST"));

				//* Adiciona o medida na lista
				lista.add(quest);
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
	 * Inclusao de Questionario
	 */
	public void incluir(Questionario questionario) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "INSERT INTO T_QUEST"
					+    "(CD_QUEST, DS_QUEST)"
					+    " VALUES (?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, questionario.getCdQuestionario());
			stmt.setString(2, questionario.getDsQuestionario());
			
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
	 * Alteração de Questionario
	 */
	public void alterar(Questionario questionario) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "UPDATE T_QUEST SET DS_QUEST = ?"
			           + "WHERE CD_QUEST = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, questionario.getDsQuestionario());
			stmt.setInt   (2, questionario.getCdQuestionario());
			
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
	 * Exclusão de Questionario
	 */
	public void excluir(Integer cdQuestionario) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "DELETE FROM T_QUEST "
					+	 "WHERE CD_QUEST = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdQuestionario);
			
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
	 * Busca por codigo questionario
	 */
	public Questionario buscarPorId(Integer cdQuestionario) {
		Questionario  quest = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement
					("SELECT * FROM T_QUEST WHERE CD_QUEST = ?");
			stmt.setInt(1, cdQuestionario );
			rs = stmt.executeQuery();
			

			if (rs.next()) {
				//* Cria um objeto Questionario com as informações encontradas
				quest = new  Questionario (rs.getInt("CD_QUEST"),
										 rs.getString("DS_QUEST"));
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
	    return quest;
   }
}
