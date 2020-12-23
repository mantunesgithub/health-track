package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.entities.FaseTreino;
import br.com.fiap.healthtrack.entities.SequAtividade;
import br.com.fiap.healthtrack.entities.SequenciaTreino;
import br.com.fiap.healthtrack.entities.TreinoCliente;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class SequenciaTreinoDAOImpl implements SequenciaTreinoDAO {

	private Connection conexao;

	/**
	 * Cria uma lista de Sequencia de Treino de Clientes stmt.set
	 */
	public List<SequenciaTreino> getAll(Long IdTreinoCliente) throws DBException {

		List<SequenciaTreino> lista = new ArrayList<SequenciaTreino>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();

			stmt = conexao.prepareStatement
					( " SELECT * FROM T_SQTREINO "
					+ " WHERE t_treino_id_treino  = ? " );
				
				stmt.setLong(1, IdTreinoCliente);
				rs = stmt.executeQuery();

			// * Percorre todos os registros encontrados
			while (rs.next()) {
				Long idSequTreino = rs.getLong("id_sqtreino");
				String descAtividade = rs.getString("ds_atividade");
				Integer qtdeSeries = rs.getInt("qt_series");
				Integer qtdeRepeticoes = rs.getInt("qt_repeticoes");
				Double pesoDaCarga = rs.getDouble("qt_carga");
				String qtdeFreqCardiaca = rs.getString("qt_freq_cardiaca");
				Double qtdeTempoMedio = rs.getDouble("qt_tempo_medio");
				Double qtdeVelocidade = rs.getDouble("qt_velocidade");
				Double qtdeIntesidade = rs.getDouble("qt_intensidade");
				Double qtdeTempoDuracao = rs.getDouble("qt_tempo_duracao");
				Double qtdeTempoDescanso = rs.getDouble("qt_intervalo_descanso");
				String descMetodo = rs.getString("ds_metodo");
				Long idTreino = rs.getLong("t_treino_id_treino");
				Long idSequAtividade = rs.getLong("t_sq_ativ_id_seq_ativ");

				
				// * Cria um objeto SequenciaTreino com as informações encontradas
				SequAtividadeDAOImpl atividadeDAOImpl = new SequAtividadeDAOImpl();
				SequAtividade sequAtividade = atividadeDAOImpl.buscarPorId(idSequAtividade);
				
				TreinoClienteDAOImpl clienteDAOImpl = new TreinoClienteDAOImpl();
				TreinoCliente treinoCliente = clienteDAOImpl.buscarPorId(idTreino);
				
				SequenciaTreino sequenciaTreino = new SequenciaTreino(idSequTreino,descAtividade,
						qtdeSeries,qtdeRepeticoes,pesoDaCarga,qtdeFreqCardiaca,qtdeTempoMedio,
						qtdeVelocidade,qtdeIntesidade,qtdeTempoDuracao,qtdeTempoDescanso,descMetodo);
				
				sequenciaTreino.setTreinoCliente(treinoCliente);
				sequenciaTreino.setSequAtiv(sequAtividade);;
				
				// * Adiciona o sequencia sequencia na lista
				
				lista.add(sequenciaTreino);
			}
			System.out.println("ok => Lista SequenciaTreino ");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(" Erro no Select Tabela T_SQTREINO");
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
	 * Inclusao de Squencia de Treino de Cliente
	 * @throws DBException 
	 */
	public void incluir(SequenciaTreino sequencia) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "INSERT INTO T_SQTREINO" +
					"(id_sqtreino,qt_series,qt_repeticoes,qt_carga,ds_metodo,ds_atividade,"+
					"qt_tempo_medio,qt_velocidade,qt_freq_cardiaca,qt_intensidade,qt_tempo_duracao,"+
					"qt_intervalo_descanso,t_treino_id_treino,t_sq_ativ_id_seq_ativ)"+		
					" VALUES (T_SQTREINO_SQID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt 	(1, sequencia.getQtdeSeries());
			stmt.setInt		(2, sequencia.getQtdeRepeticoes());
			stmt.setDouble 	(3, sequencia.getPesoDaCarga());
			stmt.setString 	(4, sequencia.getDescMetodo());
			stmt.setString 	(5, sequencia.getDescAtividade());
			stmt.setDouble 	(6, sequencia.getQtdeTempoMedio());
			stmt.setDouble 	(7, sequencia.getQtdeVelocidade());
			stmt.setString 	(8, sequencia.getQtdeFreqCardiaca());
			stmt.setDouble 	(9, sequencia.getQtdeIntesidade());
			stmt.setDouble 	(10, sequencia.getQtdeTempoDuracao());
			stmt.setDouble 	(11, sequencia.getQtdeTempoDescanso());
			stmt.setLong 	(12, sequencia.getTreinoCliente().getIdTreino());
			stmt.setLong 	(13, sequencia.getSequAtiv().getIdSequAtiv());
			
			stmt.executeUpdate();
			System.out.println("ok => Incluiu SequenciaTreino");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(" Erro no Insert Tabela T_SQTREINO");
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
	 * Alteração de Sequencia de Treino de Cliente
	 * @throws DBException 
	 */
	public void alterar(SequenciaTreino sequencia) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "UPDATE T_SQTREINO SET " +
			"qt_series = ?,qt_repeticoes = ?,qt_carga = ?,ds_metodo = ?,ds_atividade = ?,"+
			"qt_tempo_medio = ?,qt_velocidade = ?,qt_freq_cardiaca = ?,qt_intensidade = ?,qt_tempo_duracao = ?,"+
			"qt_intervalo_descanso = ?,t_treino_id_treino = ?,t_sq_ativ_id_seq_ativ = ?"+
			" WHERE id_sqtreino = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt 	(1, sequencia.getQtdeSeries());
			stmt.setInt		(2, sequencia.getQtdeRepeticoes());
			stmt.setDouble 	(3, sequencia.getPesoDaCarga());
			stmt.setString 	(4, sequencia.getDescMetodo());
			stmt.setString 	(5, sequencia.getDescAtividade());
			stmt.setDouble 	(6, sequencia.getQtdeTempoMedio());
			stmt.setDouble 	(7, sequencia.getQtdeVelocidade());
			stmt.setString 	(8, sequencia.getQtdeFreqCardiaca());
			stmt.setDouble 	(9, sequencia.getQtdeIntesidade());
			stmt.setDouble 	(10, sequencia.getQtdeTempoDuracao());
			stmt.setDouble 	(11, sequencia.getQtdeTempoDescanso());
			stmt.setLong 	(12, sequencia.getTreinoCliente().getIdTreino());
			stmt.setLong 	(13, sequencia.getSequAtiv().getIdSequAtiv());
			stmt.setLong 	(14, sequencia.getIdSequTreino());
			
			stmt.executeUpdate();
			System.out.println("Update ok getIdSequTreino= " + sequencia);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(" Erro no Update Tabela T_SQTREINO");
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
	 * Exclusão de Squencia de Treino de Cliente
	 * @throws DBException 
	 */
	public void excluir(Long idSequenciaTreino) throws DBException {

		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();

			String sql = "DELETE FROM T_SQTREINO " + "WHERE id_sqtreino = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idSequenciaTreino);

			stmt.executeUpdate();
			System.out.println("ok => Excluiu SequenciaTreino Id = " +
					idSequenciaTreino);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException(" Erro no Delete Tabela T_SQTREINO");
			}
		}
	}
	/**
	 * Busca por Id de Squencia de Treino de Cliente
	 */
	public SequenciaTreino buscarPorId(Long idSequenciaTreino) {
		SequenciaTreino sequenciaTreino = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_SQTREINO WHERE id_sqtreino = ?");
			stmt.setLong(1, idSequenciaTreino);
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			if (rs.next()) {
				Long idSequTreino = rs.getLong("id_sqtreino");
				String descAtividade = rs.getString("ds_atividade");
				Integer qtdeSeries = rs.getInt("qt_series");
				Integer qtdeRepeticoes = rs.getInt("qt_repeticoes");
				Double pesoDaCarga = rs.getDouble("qt_carga");
				String qtdeFreqCardiaca = rs.getString("qt_freq_cardiaca");
				Double qtdeTempoMedio = rs.getDouble("qt_tempo_medio");
				Double qtdeVelocidade = rs.getDouble("qt_velocidade");
				Double qtdeIntesidade = rs.getDouble("qt_intensidade");
				Double qtdeTempoDuracao = rs.getDouble("qt_tempo_duracao");
				Double qtdeTempoDescanso = rs.getDouble("qt_intervalo_descanso");
				String descMetodo = rs.getString("ds_metodo");
				Long idTreino = rs.getLong("t_treino_id_treino");
				Long idSequAtividade = rs.getLong("t_sq_ativ_id_seq_ativ");

				// * Cria um objeto SequenciaTreino com as informações encontradas
				SequAtividade sequAtividade = (new SequAtividadeDAOImpl().
											  buscarPorId(idSequAtividade));
				
				TreinoCliente treinoCliente = new TreinoCliente();
				treinoCliente.setIdTreino(idTreino);
				
				sequenciaTreino = new SequenciaTreino(idSequTreino,descAtividade,
						qtdeSeries,qtdeRepeticoes,pesoDaCarga,qtdeFreqCardiaca,qtdeTempoMedio,
						qtdeVelocidade,qtdeIntesidade,qtdeTempoDuracao,qtdeTempoDescanso,descMetodo);
				
				sequenciaTreino.setTreinoCliente(treinoCliente);
				sequenciaTreino.setSequAtiv(sequAtividade);;
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
		return sequenciaTreino;
	}
}
