package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.MedidaCliente;
import br.com.fiap.healthtrack.jdbc.ConnectionManager;

public class MedidaClienteDAOImpl implements MedidaClienteDAO {
	
	private Connection conexao;
	/**
	 *	Cria uma lista de Medidas de Clientes stmt.set 
	 */
	public List<MedidaCliente> getAll(Long cpfCliente) {
		
		List<MedidaCliente> lista = new ArrayList<MedidaCliente>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_MED_CLI " +
						"WHERE T_CLIE_CD_CPF_CLI = ? " +
						"ORDER BY DT_MEDICAO_CLIE");
			
			stmt.setLong(1, cpfCliente);
			rs = stmt.executeQuery();
	 //* Percorre todos os registros encontrados
			while (rs.next()) {
				Integer idMedidaCliente = rs.getInt("ID_MED_CLI");
				
				java.sql.Date data = rs.getDate("DT_MEDICAO_CLIE");
				Calendar dataMedida = Calendar.getInstance();
				dataMedida.setTimeInMillis(data.getTime());
				
				Double vlPeso = rs.getDouble("VL_PESO");
				Double vlAltura = rs.getDouble("VL_ALTURA");
				String vlPressao = rs.getString("DS_VALOR_PRESSAO");
				Double qtCalConsDia = rs.getDouble("QT_CAL_CONS_DIA");
				Double vlCoefCalculo = rs.getDouble("VL_COEFIC_CALC");
				Double vlfreqCardiaca = rs.getDouble("VL_FREQ_CARDIACA");
				Double vlMedidaPescoco = rs.getDouble("VL_MED_PESCOCO");
				Double vlMedidaAnteBraco = rs.getDouble("VL_MED_ANTEBRACO");
				Double vlMedidaPeito = rs.getDouble("VL_MED_PEITO");
				Double vlMedidaCintura = rs.getDouble("VL_MED_CINTURA");
				Double vlMedidaQuadris = rs.getDouble("VL_MED_QUADRIS");
				Double vlMedidaCoxas = rs.getDouble("VL_MED_COXAS");
				Double vlMedidaPanturrilha = rs.getDouble("VL_MED_PANTURR");
				Double idFatorAtividade = rs.getDouble("ID_FATOR_ATIVIDADE");
				Double vlGastoEnergReal = rs.getDouble("VL_GASTO_ENERG_REAL");
				Double vlIMCCalculado = rs.getDouble("VL_IMC_CALC");
				Double vlTMBCalculado = rs.getDouble("VL_TMB_CALC");
				String dsObservacao = rs.getString("DS_OBSERV");
				Long cdCPFCliente = rs.getLong("T_CLIE_CD_CPF_CLI");
	 //* Cria um objeto MedidaCliente com as informações encontradas
				MedidaCliente mc = new MedidaCliente();
				mc.setIdMedidaCliente(idMedidaCliente);
				mc.setDtMedicao(dataMedida);
				mc.setVlPeso(vlPeso);
				mc.setVlAltura(vlAltura);
				mc.setVlPressao(vlPressao);
				mc.setQtCalConsDia(qtCalConsDia);
				mc.setVlCoefCalculo(vlCoefCalculo);
				mc.setVlfreqCardiaca(vlfreqCardiaca);
				mc.setVlMedidaPescoco(vlMedidaPescoco);
				mc.setVlMedidaAnteBraco(vlMedidaAnteBraco);
				mc.setVlMedidaPeito(vlMedidaPeito);
				mc.setVlMedidaCintura(vlMedidaCintura);
				mc.setVlMedidaQuadris(vlMedidaQuadris);
				mc.setVlMedidaCoxas(vlMedidaCoxas);
				mc.setVlMedidaPanturrilha(vlMedidaPanturrilha);
				mc.setIdFatorAtividade(idFatorAtividade);
				mc.setVlGastoEnergReal(vlGastoEnergReal);
				mc.setVlIMCCalculado(vlIMCCalculado);
				mc.setVlTMBCalculado(vlTMBCalculado);
				mc.setDsObservacao(dsObservacao);
				mc.setCdCPFcliente(cdCPFCliente);
				mc.setMsgIMCCalculado(mc.getMsgIMCCalculado());
	 //* Adiciona o medida na lista
				lista.add(mc);
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
	 * Inclusao de Medida de Cliente
	 */
	public void incluir(MedidaCliente medida) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "INSERT INTO T_MED_CLI"
					+ "(id_med_cli,dt_medicao_clie,vl_peso,vl_altura,ds_valor_pressao,qt_cal_cons_dia,vl_coefic_calc,vl_freq_cardiaca"
					+ ",vl_med_pescoco,vl_med_antebraco,vl_med_peito,vl_med_cintura,vl_med_quadris,vl_med_coxas,vl_med_panturr,id_fator_atividade"
					+ ",vl_gasto_energ_real,vl_imc_calc,vl_tmb_calc,ds_observ,t_clie_cd_cpf_cli)"
					+ " VALUES (T_MED_CLI_SQID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date dataMedicao = new java.sql.Date((medida.getDtMedicao().getTimeInMillis()));
			stmt.setDate(1, dataMedicao);
			stmt.setDouble(2, medida.getVlPeso());
			stmt.setDouble(3, medida.getVlAltura());
			stmt.setString(4, medida.getVlPressao());
			stmt.setDouble(5, medida.getQtCalConsDia());
			stmt.setDouble(6, medida.getVlCoefCalculo());
			stmt.setDouble(7, medida.getVlfreqCardiaca());
			stmt.setDouble(8, medida.getVlMedidaPescoco());
			stmt.setDouble(9, medida.getVlMedidaAnteBraco());
			stmt.setDouble(10, medida.getVlMedidaPeito());
			stmt.setDouble(11, medida.getVlMedidaCintura());
			stmt.setDouble(12, medida.getVlMedidaQuadris());
			stmt.setDouble(13, medida.getVlMedidaCoxas());
			stmt.setDouble(14, medida.getVlMedidaPanturrilha());
			stmt.setDouble(15, medida.getIdFatorAtividade());
			stmt.setDouble(16, medida.getVlGastoEnergReal());
			stmt.setDouble(17, medida.getVlIMCCalculado());
			stmt.setDouble(18, medida.getVlTMBCalculado());
			stmt.setString(19, medida.getDsObservacao());
			stmt.setLong(20, medida.getCdCPFcliente());

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
	 * Alteração de Medida de Cliente
	 */
	public void alterar(MedidaCliente medida) {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "UPDATE T_MED_CLI SET "
					+ "dt_medicao_clie = ?, vl_peso = ?, vl_altura = ?, ds_valor_pressao = ?, qt_cal_cons_dia = ?, vl_coefic_calc = ?, vl_freq_cardiaca = ?,"
					+ "vl_med_pescoco = ?, vl_med_antebraco = ?, vl_med_peito = ?, vl_med_cintura = ?, vl_med_quadris = ?, vl_med_coxas = ?, vl_med_panturr = ?, id_fator_atividade = ?,"
					+ "vl_gasto_energ_real = ?, vl_imc_calc = ?, vl_tmb_calc = ?, ds_observ = ?, t_clie_cd_cpf_cli = ?"
					+ "WHERE id_med_cli = ?";
			stmt = conexao.prepareStatement(sql);
			stmt = conexao.prepareStatement(sql);
			java.sql.Date dataMedicao = new java.sql.Date((medida.getDtMedicao().getTimeInMillis()));
			stmt.setDate(1, dataMedicao);
			stmt.setDouble(2, medida.getVlPeso());
			stmt.setDouble(3, medida.getVlAltura());
			stmt.setString(4, medida.getVlPressao());
			stmt.setDouble(5, medida.getQtCalConsDia());
			stmt.setDouble(6, medida.getVlCoefCalculo());
			stmt.setDouble(7, medida.getVlfreqCardiaca());
			stmt.setDouble(8, medida.getVlMedidaPescoco());
			stmt.setDouble(9, medida.getVlMedidaAnteBraco());
			stmt.setDouble(10, medida.getVlMedidaPeito());
			stmt.setDouble(11, medida.getVlMedidaCintura());
			stmt.setDouble(12, medida.getVlMedidaQuadris());
			stmt.setDouble(13, medida.getVlMedidaCoxas());
			stmt.setDouble(14, medida.getVlMedidaPanturrilha());
			stmt.setDouble(15, medida.getIdFatorAtividade());
			stmt.setDouble(16, medida.getVlGastoEnergReal());
			stmt.setDouble(17, medida.getVlIMCCalculado());
			stmt.setDouble(18, medida.getVlTMBCalculado());
			stmt.setString(19, medida.getDsObservacao());
			stmt.setLong(20, medida.getCdCPFcliente());
			stmt.setInt   (21, medida.getIdMedidaCliente());
			
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
	 * Exclusão de Medida de Cliente
	 */
	public void excluir(Integer idMedidaCliente) {

		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.obterConexao();
			
			String sql = "DELETE FROM T_MED_CLI "
					+	 "WHERE id_med_cli = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idMedidaCliente);
			
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
	 * Busca por Id de Medida de Cliente
	 */
	public MedidaCliente buscarPorId(Integer idMedidaCliente) {
		MedidaCliente mc = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.obterConexao();
			stmt = conexao.prepareStatement
					("SELECT * FROM T_MED_CLI WHERE id_med_cli = ?");
			stmt.setInt(1, idMedidaCliente);
			rs = stmt.executeQuery();
			
	// Percorre todos os registros encontrados
			if (rs.next()) {
				Integer id = rs.getInt("ID_MED_CLI");
				java.sql.Date data = rs.getDate("DT_MEDICAO_CLIE");
				Calendar dataMedida = Calendar.getInstance();
				dataMedida.setTimeInMillis(data.getTime());
				Double vlPeso = rs.getDouble("VL_PESO");
				Double vlAltura = rs.getDouble("VL_ALTURA");
				String vlPressao = rs.getString("DS_VALOR_PRESSAO");
				Double qtCalConsDia = rs.getDouble("QT_CAL_CONS_DIA");
				Double vlCoefCalculo = rs.getDouble("VL_COEFIC_CALC");
				Double vlfreqCardiaca = rs.getDouble("VL_FREQ_CARDIACA");
				Double vlMedidaPescoco = rs.getDouble("VL_MED_PESCOCO");
				Double vlMedidaAnteBraco = rs.getDouble("VL_MED_ANTEBRACO");
				Double vlMedidaPeito = rs.getDouble("VL_MED_PEITO");
				Double vlMedidaCintura = rs.getDouble("VL_MED_CINTURA");
				Double vlMedidaQuadris = rs.getDouble("VL_MED_QUADRIS");
				Double vlMedidaCoxas = rs.getDouble("VL_MED_COXAS");
				Double vlMedidaPanturrilha = rs.getDouble("VL_MED_PANTURR");
				Double idFatorAtividade = rs.getDouble("ID_FATOR_ATIVIDADE");
				Double vlGastoEnergReal = rs.getDouble("VL_GASTO_ENERG_REAL");
				Double vlIMCCalculado = rs.getDouble("VL_IMC_CALC");
				Double vlTMBCalculado = rs.getDouble("VL_TMB_CALC");
				String dsObservacao = rs.getString("DS_OBSERV");
				Long   cdCPFCliente = rs.getLong("T_CLIE_CD_CPF_CLI");

	// Cria um objeto MedidaCliente com as informações encontradas
				mc = new MedidaCliente();
				mc.setIdMedidaCliente(id);
				mc.setDtMedicao(dataMedida);
				mc.setVlPeso(vlPeso);
				mc.setVlAltura(vlAltura);
				mc.setVlPressao(vlPressao);
				mc.setQtCalConsDia(qtCalConsDia);
				mc.setVlCoefCalculo(vlCoefCalculo);
				mc.setVlfreqCardiaca(vlfreqCardiaca);
				mc.setVlMedidaPescoco(vlMedidaPescoco);
				mc.setVlMedidaAnteBraco(vlMedidaAnteBraco);
				mc.setVlMedidaPeito(vlMedidaPeito);
				mc.setVlMedidaCintura(vlMedidaCintura);
				mc.setVlMedidaQuadris(vlMedidaQuadris);
				mc.setVlMedidaCoxas(vlMedidaCoxas);
				mc.setVlMedidaPanturrilha(vlMedidaPanturrilha);
				mc.setIdFatorAtividade(idFatorAtividade);
				mc.setVlGastoEnergReal(vlGastoEnergReal);
				mc.setVlIMCCalculado(vlIMCCalculado);
				mc.setVlTMBCalculado(vlTMBCalculado);
				mc.setDsObservacao(dsObservacao);
				mc.setCdCPFcliente(cdCPFCliente);
				mc.setMsgIMCCalculado(mc.getMsgIMCCalculado());
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
	    return mc;
   }
}
