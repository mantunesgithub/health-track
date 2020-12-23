package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.MedidaClienteDAO;
import br.com.fiap.healthtrack.entities.MedidaCliente;
import br.com.fiap.healthtrack.exception.DBException;
public class TestMedidaClienteDAO {
	public static void main(String[] args) throws ParseException {
			
		MedidaClienteDAO dao = DAOFactory.getMedidaClienteDAO();
		/**
		 * Obtem a Lista de Medida de Cliente antes da atualização
		 */			
		List<MedidaCliente> medidaCliente = null;
		try {
			medidaCliente = dao.getAll(11l);
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Lista de Medida de Cliente antes da atualização");
		
		for (MedidaCliente medida : medidaCliente) {
			System.out.println(medida);
		}
		// Instancia Medida Cliente de um cliente
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		MedidaCliente mc = new MedidaCliente();
		Calendar dataMedicao = Calendar.getInstance();
		mc.setDtMedicao(dataMedicao);
		mc.setVlPeso(86.5);
		mc.setVlAltura(1.90);
		mc.setVlPressao("pressao 13/9 ");
		mc.setQtCalConsDia(2100.5);
		mc.setVlCoefCalculo(0.0);
		mc.setVlfreqCardiaca(60.0);
		mc.setVlMedidaPescoco(0.30);
		mc.setVlMedidaAnteBraco(0.60);
		mc.setVlMedidaPeito(0.90);
		mc.setVlMedidaCintura(0.90);
		mc.setVlMedidaQuadris(0.70);
		mc.setVlMedidaCoxas(0.40);
		mc.setVlMedidaPanturrilha(0.20);
		mc.setIdFatorAtividade(0.0);
		mc.setVlGastoEnergReal(0.0);
		mc.setVlIMCCalculado(0.0);
		mc.setVlTMBCalculado(0.0);
		mc.setDsObservacao("Teste Inclusao");
		mc.setCdCPFcliente(12703046820l);

		try {
			dao.incluir(mc);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * Busca Id Medida de Cliente antes da atualização 
		 */
		MedidaCliente medCli = null;
		try {
			medCli = dao.buscarPorId(315);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if  (medCli == null) {
			System.out.println("Não trouxe o Id = " + medCli);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + medCli);
		}		

		/**
		 * Alteração de Medida de Cliente
		 */
		MedidaCliente mc1 = new MedidaCliente();
		mc1.setIdMedidaCliente(315);
		Calendar dataMedicao1 = Calendar.getInstance();
		mc.setDtMedicao(dataMedicao1);
		mc1.setVlPeso(95.5);
		mc1.setVlAltura(1.89);
		mc1.setVlPressao("pressao 12/8 ");
		mc1.setQtCalConsDia(1900.0);
		mc1.setVlCoefCalculo(0.0);
		mc1.setVlfreqCardiaca(70.0);
		mc1.setVlMedidaPescoco(0.30);
		mc1.setVlMedidaAnteBraco(0.60);
		mc1.setVlMedidaPeito(1.00);
		mc1.setVlMedidaCintura(1.10);
		mc1.setVlMedidaQuadris(0.70);
		mc1.setVlMedidaCoxas(0.40);
		mc1.setVlMedidaPanturrilha(0.20);
		mc1.setIdFatorAtividade(0.0);
		mc1.setVlGastoEnergReal(0.0);
		mc1.setVlIMCCalculado(0.0);
		mc1.setVlTMBCalculado(0.0);
		mc1.setDsObservacao("Teste Alteração Id 315");
		mc1.setCdCPFcliente(12703046820l);
		
		try {
			dao.alterar(mc1);
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/**
		 * Lista de Medida de Cliente após inclusão e atualização
		 */
		List<MedidaCliente> medidaClientes = null;
		try {
			medidaClientes = dao.getAll(10l);
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Lista de Medida de Cliente após Inclusão/alteração");
		for (MedidaCliente medida : medidaClientes) {
			System.out.println(medida);
		}
		/**
		 * Exclui Id de Medida de Cliente 
		 */	
		try {
			dao.excluir(315);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Excluiu Id 315 ======");
		/**
		 *  Busca Id Medida de Cliente após atualização
		 */
		MedidaCliente medCli1 = null;
		try {
			medCli1 = dao.buscarPorId(315);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if  (medCli1 == null) {
			System.out.println("Ok, Não trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro, Nao excluiu ");
		}		

	
	}	
}	
/**
 * Inclusao de Medida de Cliente
 */
/* Instancia um cliente 
		Cliente c1 = new Cliente();
		c1.setCdCPFCliente(12703046820l);
		c1.setNome("Marcio Antunes");
		c1.setRg("13402631");
		c1.setDataNascimento(sdf.parse("14/09/2010 10:30:12"));
		c1.setEndereco("Rua Braga");
		c1.setNumero(999);
		c1.setComplemento("Condominio A, T1");
		c1.setBairro("Jardim Luzitania");
		c1.setCidade("SBC");
		c1.setUf("SP");
		c1.setPais("Br");
		c1.setCepPrefixo(97111);
		c1.setCepSufixo(121);
		c1.setStatusCliente(StatusCliente.ATIVO);
		c1.setEmail("mantunes001@gmail.com");
		c1.setProfissao("Vendedor");
		c1.setSenhaAnterior("123456");
		c1.setSenhaAnterior("999999");
		c1.setTentativasErro(0);
		c1.setDddCelular(11);
		c1.setDdiCelular(55);
		c1.setNumeroCelular(988776655);
		c1.setDataInclusao(sdf.parse("11/09/2020 12:30:12"));
		c1.setDataAlteracao(sdf.parse("11/01/2020 10:30:12"));
		System.out.println(c1);
		System.out.println(" ");
 */
