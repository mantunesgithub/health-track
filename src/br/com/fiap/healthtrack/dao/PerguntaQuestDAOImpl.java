package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.healthtrack.entities. PerguntaQuest ;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class PerguntaQuestDAOImpl implements PerguntaQuestDAO {
	private Connection conexao;
	/**
	 *	Cria uma lista de  PerguntaQuest   
	 */
	public List<PerguntaQuest> getAll() {
		
		List<PerguntaQuest> lista = new ArrayList<PerguntaQuest>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			stmt = conexao.prepareStatement("SELECT * FROM T_PERG_QUEST ");
			rs = stmt.executeQuery();
			//* Percorre todos os registros encontrados
			while (rs.next()) {
				
				//* Cria um objeto PerguntaQuest com as informações encontradas
				PerguntaQuest  pergunta = new  PerguntaQuest
						(rs.getInt("id_perg"), rs.getString("ds_perg_1"),
						rs.getString("ds_perg_2"), rs.getString("ds_perg_3"),
						rs.getInt("t_quest_cd_quest"));

				//* Adiciona o medida na lista
				lista.add((pergunta));
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
	 * Inclusao de PerguntaQuest
	 */
	public void incluir(PerguntaQuest perguntaQuest) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			conexao.setAutoCommit(false);
			
			String sql = "INSERT INTO T_PERG_QUEST"
					+    "(id_perg, ds_perg_1,ds_perg_2,ds_perg_3,t_quest_cd_quest)"
					+    " VALUES (T_PERG_QUEST_SQID.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, perguntaQuest.getDsPergunta1());
			stmt.setString(2, perguntaQuest.getDsPergunta2());
			stmt.setString(3, perguntaQuest.getDsPergunta3());
			stmt.setInt(4, perguntaQuest.getCdQuestionario());
			
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
				stmt.close(); conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Alteração de PerguntaQuest
	 */
	public void alterar(PerguntaQuest perguntaQuest) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "UPDATE T_PERG_QUEST SET "
					+ " ds_perg_1 = ?, ds_perg_2 = ?, ds_perg_3 = ?,t_quest_cd_quest = ? " 
			        + "WHERE id_perg = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, perguntaQuest.getDsPergunta1());
			stmt.setString(2, perguntaQuest.getDsPergunta2());
			stmt.setString(3, perguntaQuest.getDsPergunta3());
			stmt.setInt(4, perguntaQuest.getCdQuestionario());
			stmt.setInt(5, perguntaQuest.getIdPergunta());
					
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
	 * Exclusão de PerguntaQuest
	 */
	public void excluir(Integer IdPergunta ) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "DELETE FROM T_PERG_QUEST "
					+	 "WHERE id_perg = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, IdPergunta);
			
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
	 * Busca por codigo perguntaQuest
	 */
	public PerguntaQuest buscarPorId(Integer idPerguntaQuest) {
		PerguntaQuest  pergunta1 = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement
					("SELECT * FROM T_PERG_QUEST WHERE id_perg = ?" );
			stmt.setInt(1, idPerguntaQuest );
			rs = stmt.executeQuery();
			

			if (rs.next()) {
				//* Cria um objeto PerguntaQuest com as informações encontradas
					    pergunta1 = new  PerguntaQuest
						(rs.getInt("id_perg"), rs.getString("ds_perg_1"),
						rs.getString("ds_perg_2"), rs.getString("ds_perg_3"),
						rs.getInt("t_quest_cd_quest"));


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
	    return (pergunta1);
   }
}
