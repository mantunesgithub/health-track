package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.PersonalTrainerDAO;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.enums.StatusPersonal;
public class TestPersonalTrainerDAO {
	public static void main(String[] args) throws ParseException {
			
		PersonalTrainerDAO dao = DAOFactory.getPersonalTrainerDAO();
		/**
		 * Obtem a Lista de PersonalTrainer antes da atualização
		 */			
		List <PersonalTrainer> personalTrainer = dao.getAll();
		System.out.println("Lista de PersonalTrainer antes da atualização");
		
		for (PersonalTrainer pt : personalTrainer) {
			System.out.println(pt);
		}
		// Instancia PersonalTrainer
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		PersonalTrainer pt = new PersonalTrainer(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		pt.setCpfPersonal(22233344455l);
		pt.setNome("Professor João Paulo");
		pt.setCref("cref 12345");
		pt.setRg(11222333l);
		pt.setEndereco("Rua Yolanda");
		pt.setNumero(11);
		pt.setComplemento("x");
		pt.setBairro("Vila Yolanda");
		pt.setCidade("Osasco");
		pt.setUf("SP");
		pt.setPais("BR");
		pt.setEmail("mantunes001@gmail.com");
		pt.setCepPrefixo(6000);
		pt.setCepSufixo(112);
		pt.setStatusPersonalTrainer(StatusPersonal.ATIVO);
		pt.setDdiCelular(55);
		pt.setDddCelular(11);
		pt.setNumeroCelular(988887777);
		pt.setDataInclusao(sdf.parse("20/01/2021 10:30:12"));

		dao.incluir(pt);
		/**
		 * Busca Id PersonalTrainer antes da atualização 
		 */
		PersonalTrainer pt1 = dao.buscarPorId(22233344455l);
		if  (pt1 == null) {
			System.out.println("Não trouxe o Id = " + pt1);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + pt1);
		}		

		/**
		 * Alteração de PersonalTrainer
		 */
		PersonalTrainer pt2 = new PersonalTrainer(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		pt2.setCpfPersonal(22233344455l);
		pt2.setNome("Professor João Paulo");
		pt2.setCref("cref 12345");
		pt2.setRg(1122233344l);
		pt2.setEndereco("Rua Yolanda");
		pt2.setNumero(11);
		pt2.setComplemento("");
		pt2.setBairro("Vila Yolanda");
		pt2.setCidade("Osasco");
		pt2.setUf("SP");
		pt2.setPais("BR");
		pt2.setEmail("mantunes001@gmail.com");
		pt2.setCepPrefixo(06000);
		pt2.setCepSufixo(112);
		pt2.setStatusPersonalTrainer(StatusPersonal.ATIVO);
		pt2.setDdiCelular(55);
		pt2.setDddCelular(11);
		pt2.setNumeroCelular(988887777);
		pt2.setDataInclusao(sdf.parse("20/01/2021 10:30:12"));
		
		dao.alterar(pt2);
		
		/**
		 * Lista de PersonalTrainer após inclusão e atualização
		 */
		List <PersonalTrainer> personalTrainer1 = dao.getAll();
		
		System.out.println("Lista de PersonalTrainer após Inclusão/alteração");
		for (PersonalTrainer pt4 : personalTrainer1) {
			System.out.println(pt4);
		}
		/**
		 * Exclui Id de PersonalTrainer 
		 */	
		dao.excluir(22233344455l);
		System.out.println("Excluiu Id  ======");
		/**
		 *  Busca Id PersonalTrainer após atualização
		 */
		PersonalTrainer medCli1 = dao.buscarPorId(22233344455l);
		if  (medCli1 == null) {
			System.out.println("Ok, Não trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro, Nao excluiu ");
		}		

	
	}	
}	
/**
 * Inclusao de PersonalTrainer
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
