package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.entities. FaseTreino ;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class FaseTreinoDAOImpl implements FaseTreinoDAO {
	private Connection conexao;
	/**
	 *	Cria uma lista de  FaseTreino   
	 */
	public List<FaseTreino> getAll() {
		
		List<FaseTreino> lista = new ArrayList<FaseTreino>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			stmt = conexao.prepareStatement
					("SELECT * FROM T_FASE_TR"
					+" INNER JOIN T_MOD" 
					+" ON T_FASE_TR.T_MOD_CD_MOD = T_MOD.CD_MOD"
					+" ORDER BY T_MOD_CD_MOD, CD_FASE, TP_TREINO") ;

			rs = stmt.executeQuery();
			//* Percorre todos os registros encontrados
			while (rs.next()) {
				//* Cria um objeto FaseTreino com as informações encontradas
				FaseTreino faseTreino = new  FaseTreino
				(rs.getLong("id_fase_tr"), rs.getInt("cd_fase"), rs.getInt("tp_treino") ,
				 rs.getString("ds_tipo_treino"), rs.getString("ds_objetivo") );

				//* Cria um objeto Modalidade da associação Sequencia Atividade x Modalidade
				int cdModalidade = rs.getInt("cd_mod");
				String dsModalidade = rs.getString("ds_modal");
				Modalidade modalidade = new Modalidade(cdModalidade, dsModalidade);
				faseTreino.setModalidade(modalidade);
				//* Adiciona o medida na lista
				lista.add(faseTreino);
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
	}/**
	 * Inclusao de FaseTreino
	 */
	public void incluir(FaseTreino faseTreino) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			conexao.setAutoCommit(false);
			
			String sql = "INSERT INTO T_FASE_TR"
			+ "(id_fase_tr,cd_fase,tp_treino,ds_tipo_treino,ds_objetivo,t_mod_cd_mod)"
			+ " VALUES (T_FASE_TR_SQID.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, faseTreino.getCdFaseTreino());
			stmt.setInt(2, faseTreino.getTpFaseTreino());
			stmt.setString(3, faseTreino.getDsTipoTreino());
			stmt.setString(4, faseTreino.getDsObjetivoTreino());
			stmt.setInt(5, faseTreino.getModalidade().getCodigoModalidade());
			
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
	 * Alteração de FaseTreino
	 */
	public void alterar(FaseTreino faseTreino) {
		PreparedStatement stmt = null;
		try {
			System.out.println("Chegou alterar ");
			conexao = ConnectionManager.obterConexao();
			String sql = "UPDATE T_FASE_TR SET "
			+ "cd_fase = ?, tp_treino = ?, ds_tipo_treino = ?, "
			+ "ds_objetivo = ?, t_mod_cd_mod = ? "
			+ "WHERE id_fase_tr = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, faseTreino.getCdFaseTreino());
			stmt.setInt(2, faseTreino.getTpFaseTreino());
			stmt.setString(3, faseTreino.getDsTipoTreino());
			stmt.setString(4, faseTreino.getDsObjetivoTreino());
			stmt.setInt(5, faseTreino.getModalidade().getCodigoModalidade());
			stmt.setLong(6, faseTreino.getIdFaseTreino());
					
			stmt.executeUpdate();
			System.out.println("Chegou alterou ");
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
	 * Exclusão de FaseTreino
	 */
	public void excluir(Long idFaseTreino ) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "DELETE FROM T_FASE_TR "
					+	 "WHERE id_fase_tr = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idFaseTreino);
			
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
	 * Busca por codigo faseTreino
	 */
	public FaseTreino buscarPorId(Long idFaseTreino) {
		FaseTreino  faseTreino = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM T_FASE_TR"
					+ " INNER JOIN T_MOD" 
					+ " ON T_FASE_TR.T_MOD_CD_MOD = T_MOD.CD_MOD" 
					+ " WHERE ID_FASE_TR = ?" );
			stmt.setLong(1, idFaseTreino );
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				//* Cria um objeto FaseTreino com as informações encontradas
				faseTreino = new  FaseTreino
				(rs.getLong("id_fase_tr"), rs.getInt("cd_fase"), rs.getInt("tp_treino") ,
				 rs.getString("ds_tipo_treino"), rs.getString("ds_objetivo") );

				//* Cria um objeto Modalidade da associação Sequencia Atividade x Modalidade
				int cdModalidade = rs.getInt("cd_mod");
				String dsModalidade = rs.getString("ds_modal");
				Modalidade modalidade = new Modalidade(cdModalidade, dsModalidade);
				faseTreino.setModalidade(modalidade);

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
	    return (faseTreino);
   }

}
