package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.FaseTreino;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.SolicitacaoTreino;
import br.com.fiap.healthtrack.entities.enums.StatusSolicTreino;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class SolicitacaoTreinoDAOImpl implements SolicitacaoTreinoDAO {

	private Connection conexao;
	/**
	 * Cria uma lista de Squencia de Treino de Clientes stmt.set
	 */
	public List<SolicitacaoTreino> getAll(Long cpfClienteSession) {

		List<SolicitacaoTreino> lista = new ArrayList<SolicitacaoTreino>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();

			stmt = conexao.prepareStatement("SELECT * FROM T_SOL_TREINO");
			rs = stmt.executeQuery();
			// * Percorre todos os registros encontrados
			while (rs.next()) {
				Long idSolicitacaoTreino = rs.getLong("nr_sol");
				java.sql.Date dataSol = rs.getDate("dt_solicitacao");
				Calendar dataSolicitacao = Calendar.getInstance();
				dataSolicitacao.setTimeInMillis(dataSol.getTime());
				
				String descObjetivoTreino = rs.getString("ds_objetivo_treino");
				
				java.sql.Date dataGer = rs.getDate("dt_pers_gerou_treino");
				Calendar dataGerTreino = Calendar.getInstance();
				dataGerTreino.setTimeInMillis(dataGer.getTime());
				
				int statusSolicTreino = rs.getInt("st_solicitacao");
				StatusSolicTreino stSolicTreino = null;
				if 	(statusSolicTreino == 1) {
					stSolicTreino = StatusSolicTreino.PENDENTE;
				}
				if 	(statusSolicTreino == 2) {
					stSolicTreino = StatusSolicTreino.PROCESSANDO;
				}
				if 	(statusSolicTreino == 3) {
					stSolicTreino = StatusSolicTreino.FINALIZADA;
				}
				java.sql.Date dataIncl = rs.getDate("dt_inclusao");
				Calendar dataInclTreino = Calendar.getInstance();
				dataInclTreino.setTimeInMillis(dataIncl.getTime());
				
				Long cpfCliente = rs.getLong("t_clie_cd_cpf_cli");
				ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
				Cliente cliente = clienteDAOImpl.buscarPorId(cpfCliente);
				
				Integer codigoModalidade = rs.getInt("t_mod_cd_mod");
				ModalidadeDAOImpl modalidadeDAOImpl = new ModalidadeDAOImpl() ;
				Modalidade modalidade = modalidadeDAOImpl.buscarPorId(codigoModalidade);
				
				Long cpfPersonal = rs.getLong("t_personal_nr_cpf_pers");
				PersonalTrainerDAOImpl personalTrainerDAOImpl = new PersonalTrainerDAOImpl();
				PersonalTrainer personalTrainer = 
								personalTrainerDAOImpl.buscarPorId(cpfPersonal);
				

				// * Cria um objeto SolicitacaoTreino com as informações encontradas
				SolicitacaoTreino st = new SolicitacaoTreino(idSolicitacaoTreino,dataSolicitacao,
						descObjetivoTreino,dataGerTreino,stSolicTreino,dataInclTreino,cliente,
						personalTrainer,modalidade);

				// * Adiciona o solicitacao solicitacao na lista
				lista.add(st);
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
	 * Inclusao de Solicitacao Treino de Cliente
	 */
	public void incluir(SolicitacaoTreino solicitacao) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "INSERT INTO T_SOL_TREINO" +
					"(nr_sol,dt_solicitacao,ds_objetivo_treino,dt_pers_gerou_treino," + 
					"st_solicitacao,dt_inclusao,t_clie_cd_cpf_cli,t_personal_nr_cpf_pers," + 
					"t_mod_cd_mod)"+		
					"VALUES (T_SOL_TREINO_SQID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			java.sql.Date 	dataSolic = new java.sql.Date(solicitacao.getDataSolicitacao().getTimeInMillis());
			stmt.setDate	(1, dataSolic);			
			stmt.setString 	(2, solicitacao.getDescObjetivoTreino());
			java.sql.Date 	dataGerTreino = new java.sql.Date(solicitacao.getDataGeracaoTreino().getTimeInMillis());
			stmt.setDate	(3, dataGerTreino);
			stmt.setInt		(4, solicitacao.getStatusSolicTreinoInt());
			java.sql.Date 	dataIncl = new java.sql.Date(solicitacao.getDataInclusao().getTimeInMillis());
			stmt.setDate	(5, dataIncl);			
			stmt.setLong	(6, solicitacao.getCliente().getCdCPFCliente());
			stmt.setLong	(7, solicitacao.getPersonalTrainer().getCpfPersonal());
			stmt.setInt		(8, solicitacao.getModalidade().getCodigoModalidade());
			
			stmt.executeUpdate();
			System.out.println("ok => Incluiu SolicitacaoTreino");
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
	 * Alteração de Solicitacao Treino de Cliente
	 */
	public void alterar(SolicitacaoTreino solicitacao) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "UPDATE T_SOL_TREINO SET " +
			"dt_solicitacao = ?,ds_objetivo_treino = ?,dt_pers_gerou_treino = ?," + 
			"st_solicitacao = ?,dt_inclusao = ?,t_clie_cd_cpf_cli = ?,t_personal_nr_cpf_pers = ?," + 
			"t_mod_cd_mod = ? " +
			"WHERE nr_sol = ?";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date dataSolic = new java.sql.Date(solicitacao.getDataSolicitacao().getTimeInMillis());
			stmt.setDate	(1, dataSolic);			
			stmt.setString 	(2, solicitacao.getDescObjetivoTreino());
			java.sql.Date dataGerTreino = new java.sql.Date(solicitacao.getDataGeracaoTreino().getTimeInMillis());
			stmt.setDate	(3, dataGerTreino);
			stmt.setInt		(4, solicitacao.getStatusSolicTreinoInt());
			java.sql.Date dataIncl = new java.sql.Date(solicitacao.getDataInclusao().getTimeInMillis());
			stmt.setDate	(5, dataIncl);			
			stmt.setLong	(6, solicitacao.getCliente().getCdCPFCliente());
			stmt.setLong	(7, solicitacao.getPersonalTrainer().getCpfPersonal());
			stmt.setInt		(8, solicitacao.getModalidade().getCodigoModalidade());
			stmt.setLong	(9, solicitacao.getIdSolicitacaoTreino());
			
			stmt.executeUpdate();
			System.out.println("ok => Efetuou a alteração SolicitacaoTreino no Id = "
			+ solicitacao.getIdSolicitacaoTreino());
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
	 * Exclusão de Squencia de Treino de Cliente
	 */
	public void excluir(Long idSolicitacaoTreino) {

		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();

			String sql = "DELETE FROM T_SOL_TREINO " + "WHERE nr_sol = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idSolicitacaoTreino);

			stmt.executeUpdate();
			System.out.println("ok => Excluiu SolicitacaoTreino Id = " +
					idSolicitacaoTreino);
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
	 * Busca por Id de Squencia de Treino de Cliente
	 */
	public SolicitacaoTreino buscarPorId(Long idSolicitacaoTreino) {
		SolicitacaoTreino st = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_SOL_TREINO WHERE nr_sol = ?");
			stmt.setLong(1, idSolicitacaoTreino);
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			if (rs.next()) {
				Long idSolicitacaoTreino1 = rs.getLong("nr_sol");
				java.sql.Date dataSol = rs.getDate("dt_solicitacao");
				Calendar dataSolicitacao = Calendar.getInstance();
				dataSolicitacao.setTimeInMillis(dataSol.getTime());
				String descObjetivoTreino = rs.getString("ds_objetivo_treino");
				java.sql.Date dataGer = rs.getDate("dt_pers_gerou_treino");
				Calendar dataGerTreino = Calendar.getInstance();
				dataGerTreino.setTimeInMillis(dataGer.getTime());
				int statusSolicTreino = rs.getInt("st_solicitacao");
				StatusSolicTreino stSolicTreino = null;
				if 	(statusSolicTreino == 1) {
					stSolicTreino = StatusSolicTreino.PENDENTE;
				}
				if 	(statusSolicTreino == 2) {
					stSolicTreino = StatusSolicTreino.PROCESSANDO;
				}
				if 	(statusSolicTreino == 3) {
					stSolicTreino = StatusSolicTreino.FINALIZADA;
				}
				
				java.sql.Date dataIncl = rs.getDate("dt_inclusao");
				Calendar dataInclTreino = Calendar.getInstance();
				dataInclTreino.setTimeInMillis(dataIncl.getTime());
				Long cpfCliente = rs.getLong("t_clie_cd_cpf_cli");
				ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
				Cliente cliente = clienteDAOImpl.buscarPorId(cpfCliente);
				
				Integer codigoModalidade = rs.getInt("t_mod_cd_mod");
				ModalidadeDAOImpl modalidadeDAOImpl = new ModalidadeDAOImpl() ;
				Modalidade modalidade = modalidadeDAOImpl.buscarPorId(codigoModalidade);
				
				Long cpfPersonal = rs.getLong("t_personal_nr_cpf_pers");
				PersonalTrainerDAOImpl personalTrainerDAOImpl = new PersonalTrainerDAOImpl();
				PersonalTrainer personalTrainer = 
								personalTrainerDAOImpl.buscarPorId(cpfPersonal);
				

				// * Cria um objeto SolicitacaoTreino com as informações encontradas
				st = new SolicitacaoTreino(idSolicitacaoTreino,dataSolicitacao,
						descObjetivoTreino,dataGerTreino,stSolicTreino,dataInclTreino,cliente,
						personalTrainer,modalidade);

				System.out.println("ok => Trouxe SolicitacaoTreino busca por Id = "
						  + idSolicitacaoTreino1);
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
		return st;
	}

}
