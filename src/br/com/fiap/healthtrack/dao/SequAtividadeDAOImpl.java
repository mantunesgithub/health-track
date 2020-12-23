package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.SequAtividade ;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;


public class SequAtividadeDAOImpl implements SequAtividadeDAO {
	private Connection conexao;
	/**
	 *	Cria uma lista de  SequAtividade   
	 */
	public List<SequAtividade> getAll() {
		
		List<SequAtividade> lista = new ArrayList<SequAtividade>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			stmt = conexao.prepareStatement
					("SELECT * FROM T_SQ_ATIV"
					+" INNER JOIN T_MOD" 
					+" ON T_SQ_ATIV.T_MOD_CD_MOD = T_MOD.CD_MOD"
					+" ORDER BY T_SQ_ATIV.T_MOD_CD_MOD, DS_SEQ_ATIV ") ;

			rs = stmt.executeQuery();
			//* Percorre todos os registros encontrados
			while (rs.next()) {
				//* Cria um objeto SequAtividade com as informações encontradas
				// Passa no Construtor direto da tabela
				SequAtividade sequAtiv = new  SequAtividade
				(rs.getLong("id_seq_ativ"), rs.getString("ds_seq_ativ"),
				 rs.getString("ds_objetivo_seq"));

				//* Cria um objeto Modalidade da associação Sequencia Atividade x Modalidade
				int cdModalidade = rs.getInt("cd_mod");
				String dsModalidade = rs.getString("ds_modal");
				Modalidade modalidade = new Modalidade(cdModalidade, dsModalidade);
				sequAtiv.setModalidade(modalidade);
				//* Adiciona o medida na lista
				lista.add(sequAtiv);
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
	 * Inclusao de SequAtividade
	 */
	public void incluir(SequAtividade sequAtiv) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			conexao.setAutoCommit(false);
			
			String sql = "INSERT INTO T_SQ_ATIV "
			+ "(id_seq_ativ,ds_seq_ativ,ds_objetivo_seq,t_mod_cd_mod)"
			+ " VALUES (T_SQ_ATIV_SQID.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, sequAtiv.getDescSequAtiv());
			stmt.setString(2, sequAtiv.getDescObjetivoAtiv());
			stmt.setInt(3, sequAtiv.getModalidade().getCodigoModalidade());
			
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
	 * Alteração de SequAtividade
	 */
	public void alterar(SequAtividade sequAtiv) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "UPDATE T_SQ_ATIV SET "
			+ "ds_seq_ativ = ?,ds_objetivo_seq = ?,t_mod_cd_mod = ?"
			+ "WHERE id_seq_ativ = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, sequAtiv.getDescSequAtiv());
			stmt.setString(2, sequAtiv.getDescObjetivoAtiv());
			stmt.setInt(3, sequAtiv.getModalidade().getCodigoModalidade());
			stmt.setLong(4, sequAtiv.getIdSequAtiv());
					
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
	 * Exclusão de SequAtividade
	 */
	public void excluir(Long IdSequAtiv) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "DELETE FROM T_SQ_ATIV "
					+	 "WHERE id_seq_ativ = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, IdSequAtiv);
			
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
	 * Busca por Id sequencia Atividade
	 */
	public SequAtividade buscarPorId(Long idSequAtiv) {
		SequAtividade  sequAtiv = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM T_SQ_ATIV"
					+ " INNER JOIN T_MOD" 
					+ " ON T_SQ_ATIV.T_MOD_CD_MOD = T_MOD.CD_MOD" 
					+ " WHERE ID_SEQ_ATIV = ?" );
			stmt.setLong(1, idSequAtiv );
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				//* Cria um objeto SequAtividade com as informações encontradas
					sequAtiv = new  SequAtividade
					(rs.getLong("id_seq_ativ"), rs.getString("ds_seq_ativ"),
					 rs.getString("ds_objetivo_seq"));

					//* Cria um objeto Modalidade da associação Sequencia Atividade x Modalidade
					int cdModalidade = rs.getInt("cd_mod");
					String dsModalidade = rs.getString("ds_modal");
					Modalidade modalidade = new Modalidade(cdModalidade, dsModalidade);
					sequAtiv.setModalidade(modalidade);
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
	    return (sequAtiv);
   }

}
