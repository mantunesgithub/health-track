package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.FaseTreino;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.SequAtividade;
import br.com.fiap.healthtrack.entities.SequenciaTreino;
import br.com.fiap.healthtrack.entities.TreinoCliente;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class TreinoClienteDAOImpl implements TreinoClienteDAO {

	private final String GET_TREINO_BY_CPF =
		"SELECT * FROM T_TREINO "
		+ "WHERE T_CLIE_CD_CPF_CLI  = ? "
		+ "ORDER BY T_MOD_CD_MOD";
			
	private final String GET_TREINO_SEQUTREINO_BY_JOIN =
			"SELECT t.id_treino,t.dt_inicio_treino,t.dt_final_treino,t.ds_dias_semana," +
			"t.qt_volume_semana,t.qt_volume_sessao,t.ds_objetivo_treino,t.ds_local_treino," +
			"t.ds_traje_treino,t.ds_acessorio_treino,t.id_media_treino,t.st_treino,t.ds_observacoes," +
			"t.dt_ult_alteracao,t.dt_inclusao,t.t_fase_tr_id_fase_tr,t.t_clie_cd_cpf_cli," +
			"t.t_personal_nr_cpf_pers,t.t_mod_cd_mod, "+
			
			"s.id_sqtreino,s.qt_series,s.qt_repeticoes,s.qt_carga,s.ds_metodo,s.ds_atividade,"+
			"s.qt_tempo_medio,s.qt_velocidade,s.qt_freq_cardiaca,s.qt_intensidade,s.qt_tempo_duracao," +
			"s.qt_intervalo_descanso,s.t_treino_id_treino,s.t_sq_ativ_id_seq_ativ "+
			"FROM T_TREINO t LEFT OUTER JOIN T_SQTREINO s " +
			"ON t.id_treino = s.t_treino_id_treino " +
			"WHERE t.T_CLIE_CD_CPF_CLI  = ? " + 
			"ORDER BY t.id_treino, s.id_sqtreino";  
	
	private Connection conexao;
	/**
	 * Cria uma lista de Treino de Clientes stmt.set
	 */
	public List<TreinoCliente> getAll(Long cpfCliente, String tipoGet) {

		List<TreinoCliente> listaTreino = new ArrayList<TreinoCliente>();


		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conexao = ConnectionManager.obterConexao();

			Map<Long, TreinoCliente> mapaTreinoCliente = new LinkedHashMap<Long, TreinoCliente>();
			TreinoCliente tc;
			
			
			if  (tipoGet == "cpf") { 
				stmt = conexao.prepareStatement(GET_TREINO_BY_CPF);
			} else {
				stmt = conexao.prepareStatement(GET_TREINO_SEQUTREINO_BY_JOIN);
			}	
			stmt.setLong(1, cpfCliente);
			rs = stmt.executeQuery();
			
			// * Percorre todos os registros encontrados
			while (rs.next()) {
				Long idTreinoCliente = rs.getLong("id_treino");
				java.sql.Date dataInicio = rs.getDate("dt_inicio_treino");
				Calendar dataInicioTreino = Calendar.getInstance();
				dataInicioTreino.setTimeInMillis(dataInicio.getTime());

				java.sql.Date dataFinal = rs.getDate("dt_final_treino");
				Calendar dataFinalTreino = Calendar.getInstance();
				dataFinalTreino.setTimeInMillis(dataFinal.getTime());
				
				String diasDaSemana = rs.getString("ds_dias_semana");
				Double qtdeVolumeSemana = rs.getDouble("qt_volume_semana");
				Double qtdeVolumeSessao = rs.getDouble("qt_volume_sessao");
				String descObjetivoTreino = rs.getString("ds_objetivo_treino");
				String descLocalTreino = rs.getString("ds_local_treino");
				String descTrajeTreino = rs.getString("ds_traje_treino");
				String descAssesTreino = rs.getString("ds_acessorio_treino");
				Long idMediaTreino = rs.getLong("id_media_treino");
				Integer statusTreino = rs.getInt("st_treino");
				String descObservacoes = rs.getString("ds_observacoes");

				java.sql.Date dataAlte = rs.getDate("dt_ult_alteracao");
				Calendar dataAlteTreino = Calendar.getInstance();
				dataAlteTreino.setTimeInMillis(dataAlte.getTime());

				java.sql.Date dataIncl = rs.getDate("dt_inclusao");
				Calendar dataInclTreino = Calendar.getInstance();
				dataInclTreino.setTimeInMillis(dataIncl.getTime());
			
				Long cpfClienteCli = rs.getLong("t_clie_cd_cpf_cli");
				ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
				Cliente cliente = clienteDAOImpl.buscarPorId(cpfClienteCli);
				
				Long idFaseTreino = rs.getLong("t_fase_tr_id_fase_tr");
				FaseTreinoDAOImpl faseTreinoDAOImpl = new FaseTreinoDAOImpl() ;
				FaseTreino faseTreino = faseTreinoDAOImpl.buscarPorId(idFaseTreino);	
				
				Integer codigoModalidade = rs.getInt("t_mod_cd_mod");
				ModalidadeDAOImpl modalidadeDAOImpl = new ModalidadeDAOImpl() ;
				Modalidade modalidade = modalidadeDAOImpl.buscarPorId(codigoModalidade);
				
				Long cpfPersonal = rs.getLong("t_personal_nr_cpf_pers");
				PersonalTrainerDAOImpl personalTrainerDAOImpl = new PersonalTrainerDAOImpl();
				PersonalTrainer personalTrainer = 
								personalTrainerDAOImpl.buscarPorId(cpfPersonal);
				
				if  (tipoGet == "cpf") {   
					// * Cria um objeto TreinoCliente com as informações encontradas
					tc = new TreinoCliente(
							idTreinoCliente,dataInicioTreino,dataFinalTreino,diasDaSemana,
							qtdeVolumeSemana,qtdeVolumeSessao,descObjetivoTreino,
							descLocalTreino,descTrajeTreino,descAssesTreino,idMediaTreino,
							statusTreino,  descObservacoes,dataAlteTreino,dataFinalTreino,cliente,
							faseTreino,personalTrainer,modalidade);
					// * Adiciona o treino na lista
					listaTreino.add(tc);
					
				}else {
					// * Adiciona o treino cliente no mapaTreinoCliente
					
					if( mapaTreinoCliente.containsKey(idTreinoCliente) ) {
						tc = (TreinoCliente) mapaTreinoCliente.get(idTreinoCliente);
					} else {
						tc = new TreinoCliente(
								idTreinoCliente,dataInicioTreino,dataFinalTreino,diasDaSemana,
								qtdeVolumeSemana,qtdeVolumeSessao,descObjetivoTreino,
								descLocalTreino,descTrajeTreino,descAssesTreino,idMediaTreino,
								statusTreino,  descObservacoes,dataAlteTreino,dataFinalTreino,cliente,
								faseTreino,personalTrainer,modalidade);

					}
					
					// * Cria um objeto SequenciaTreino com as informações tabela 
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

					Long idSequAtividade = rs.getLong("t_sq_ativ_id_seq_ativ");

					// * Cria um objeto SequenciaTreino com as informações encontradas
					SequAtividadeDAOImpl atividadeDAOImpl = new SequAtividadeDAOImpl();
					SequAtividade sequAtividade = atividadeDAOImpl.buscarPorId(idSequAtividade);
					
					SequenciaTreino st = new SequenciaTreino(idSequTreino,descAtividade,
							qtdeSeries,qtdeRepeticoes,pesoDaCarga,qtdeFreqCardiaca,qtdeTempoMedio,
							qtdeVelocidade,qtdeIntesidade,qtdeTempoDuracao,qtdeTempoDescanso,descMetodo);
					

					st.setSequAtiv(sequAtividade);
					
					// * Adiciona o sequencia treino no mapaTreinoCliente
					if  (idSequTreino != 0) {
						
						tc.getSequenciaTreinos().add(st);
					}
					
					mapaTreinoCliente.put(idTreinoCliente, tc);
		
				}
			}
			if  (tipoGet != "cpf") { 
				listaTreino = new ArrayList<TreinoCliente>( mapaTreinoCliente.values());
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
			return listaTreino;
	}

	/**
	 * Inclusao de Treino de Cliente
	 */
	public void incluir(TreinoCliente treino) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "INSERT INTO T_TREINO"
			+ "(id_treino,dt_inicio_treino,dt_final_treino,ds_dias_semana,qt_volume_semana,qt_volume_sessao,ds_objetivo_treino,ds_local_treino,\r\n" + 
			"ds_traje_treino,ds_acessorio_treino,id_media_treino,st_treino,ds_observacoes,dt_ult_alteracao,dt_inclusao,t_fase_tr_id_fase_tr,\r\n" + 
			"t_clie_cd_cpf_cli,t_personal_nr_cpf_pers,t_mod_cd_mod)"		
			+ " VALUES (T_TREINO_SQID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date dataInicioTr = new java.sql.Date(treino.getDataInicioTreino().getTimeInMillis());
			stmt.setDate(1, dataInicioTr);
			java.sql.Date dataFinalTr = new java.sql.Date(treino.getDataFinalTreino().getTimeInMillis());
			stmt.setDate(2, dataFinalTr);
			stmt.setString(3, treino.getDiasDaSemana());
			stmt.setDouble(4, treino.getQtdeVolumeSemana());
			stmt.setDouble(5, treino.getQtdeVolumeSessao());
			stmt.setString(6, treino.getDescObjetivoTreino());
			stmt.setString(7, treino.getDescLocalTreino());
			stmt.setString(8, treino.getDescTrajeTreino());
			stmt.setString(9, treino.getDescAssesTreino());
			stmt.setLong(10, treino.getIdmediaTreino());
			stmt.setInt(11, treino.getStatusTreino());
			stmt.setString(12, treino.getDescObservacoes());
			java.sql.Date dataAlte = new java.sql.Date(treino.getDataAlteracao().getTimeInMillis());
			stmt.setDate(13, dataAlte);
			java.sql.Date dataIncl = new java.sql.Date(treino.getDataInclusao().getTimeInMillis());
			stmt.setDate(14, dataIncl);
			stmt.setLong(15, treino.getFaseTreino().getIdFaseTreino());
			stmt.setLong(16, treino.getCliente().getCdCPFCliente());
			stmt.setLong(17, treino.getPersonalTrainer().getCpfPersonal());
			stmt.setLong(18, treino.getModalidade().getCodigoModalidade());
			
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
	 * Alteração de Treino de Cliente
	 */
	public void alterar(TreinoCliente treino) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "UPDATE T_TREINO SET "
					+ "dt_inicio_treino = ?, dt_final_treino = ?, ds_dias_semana = ?, qt_volume_semana = ?, "
					+ "qt_volume_sessao = ?, ds_objetivo_treino = ?, ds_local_treino = ?, "  
					+ "ds_traje_treino = ?, ds_acessorio_treino = ?, id_media_treino = ?, "
					+ "st_treino = ?, ds_observacoes = ?, dt_ult_alteracao = ?,dt_inclusao = ?, t_fase_tr_id_fase_tr = ?, " 
					+ "t_clie_cd_cpf_cli = ?, t_personal_nr_cpf_pers = ?, t_mod_cd_mod = ? "	
					+ "WHERE id_treino = ?";
			
			stmt = conexao.prepareStatement(sql);
			
			java.sql.Date dataInicioTr = new java.sql.Date(treino.getDataInicioTreino().getTimeInMillis());
			stmt.setDate(1, dataInicioTr);
			java.sql.Date dataFinalTr = new java.sql.Date(treino.getDataFinalTreino().getTimeInMillis());
			stmt.setDate(2, dataFinalTr);
			stmt.setString(3, treino.getDiasDaSemana());
			stmt.setDouble(4, treino.getQtdeVolumeSemana());
			stmt.setDouble(5, treino.getQtdeVolumeSessao());
			stmt.setString(6, treino.getDescObjetivoTreino());
			stmt.setString(7, treino.getDescLocalTreino());
			stmt.setString(8, treino.getDescTrajeTreino());
			stmt.setString(9, treino.getDescAssesTreino());
			stmt.setLong(10, treino.getIdmediaTreino());
			stmt.setInt(11, treino.getStatusTreino());
			stmt.setString(12, treino.getDescObservacoes());
			java.sql.Date dataAlte = new java.sql.Date(treino.getDataAlteracao().getTimeInMillis());
			stmt.setDate(13, dataAlte);
			java.sql.Date dataIncl = new java.sql.Date(treino.getDataInclusao().getTimeInMillis());
			stmt.setDate(14, dataIncl);
			stmt.setLong(15, treino.getFaseTreino().getIdFaseTreino());
			stmt.setLong(16, treino.getCliente().getCdCPFCliente());
			stmt.setLong(17, treino.getPersonalTrainer().getCpfPersonal());
			stmt.setLong(18, treino.getModalidade().getCodigoModalidade());
			
			stmt.setLong(19, treino.getIdTreino());
			
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
	 * Exclusão de Treino de Cliente
	 */
	public void excluir(Long idTreino) {

		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();

			String sql = "DELETE FROM T_TREINO " + "WHERE id_treino = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idTreino);

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
	 * Busca por Id de Treino de Cliente
	 */
	public TreinoCliente buscarPorId(Long idTreinoCliente) {
		TreinoCliente treinoCliente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_TREINO WHERE id_treino = ?");
			stmt.setLong(1, idTreinoCliente);
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			if (rs.next()) {
				Long idTreinoCliente1 = rs.getLong("id_treino");

				java.sql.Date dataInicio = rs.getDate("dt_inicio_treino");
				Calendar dataInicioTreino = Calendar.getInstance();
				dataInicioTreino.setTimeInMillis(dataInicio.getTime());

				java.sql.Date dataFinal = rs.getDate("dt_final_treino");
				Calendar dataFinalTreino = Calendar.getInstance();
				dataFinalTreino.setTimeInMillis(dataFinal.getTime());
				
				String diasDaSemana = rs.getString("ds_dias_semana");
				Double qtdeVolumeSemana = rs.getDouble("qt_volume_semana");
				Double qtdeVolumeSessao = rs.getDouble("qt_volume_sessao");
				String descObjetivoTreino = rs.getString("ds_objetivo_treino");
				String descLocalTreino = rs.getString("ds_local_treino");
				String descTrajeTreino = rs.getString("ds_traje_treino");
				String descAssesTreino = rs.getString("ds_acessorio_treino");
				Long idMediaTreino = rs.getLong("id_media_treino");
				Integer statusTreino = rs.getInt("st_treino");
				String descObservacoes = rs.getString("ds_observacoes");

				java.sql.Date dataAlte = rs.getDate("dt_ult_alteracao");
				Calendar dataAlteTreino = Calendar.getInstance();
				dataAlteTreino.setTimeInMillis(dataAlte.getTime());

				java.sql.Date dataIncl = rs.getDate("dt_inclusao");
				Calendar dataInclTreino = Calendar.getInstance();
				dataInclTreino.setTimeInMillis(dataIncl.getTime());

				Long cpfCliente = rs.getLong("t_clie_cd_cpf_cli");
				Cliente cliente = (new ClienteDAOImpl().buscarPorId(cpfCliente));
				
				Long idFaseTreino = rs.getLong("t_fase_tr_id_fase_tr");
				FaseTreino faseTreino = (new FaseTreinoDAOImpl().buscarPorId(idFaseTreino));
				
				Integer codigoModalidade = rs.getInt("t_mod_cd_mod");
				Modalidade modalidade = (new ModalidadeDAOImpl().buscarPorId(codigoModalidade));
				
				Long cpfPersonal = rs.getLong("t_personal_nr_cpf_pers");
				PersonalTrainer personalTrainer = (new PersonalTrainerDAOImpl().buscarPorId(cpfPersonal));

				// * Cria um objeto TreinoCliente com as informações encontradas
				treinoCliente = new TreinoCliente(
						idTreinoCliente1,dataInicioTreino,dataFinalTreino,diasDaSemana,
						qtdeVolumeSemana,qtdeVolumeSessao,descObjetivoTreino,
						descLocalTreino,descTrajeTreino,descAssesTreino,idMediaTreino,
						statusTreino,  descObservacoes,dataAlteTreino,dataFinalTreino,cliente,
						faseTreino,personalTrainer,modalidade);
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
		return treinoCliente;
	}
}
