package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.SolicitacaoTreinoDAO;
import br.com.fiap.healthtrack.entities.SolicitacaoTreino;
import br.com.fiap.healthtrack.entities.enums.StatusSolicTreino;

public class TestSolicitacaoTreinoDAO {
	public static void main(String[] args) throws ParseException {
			
		SolicitacaoTreinoDAO dao = DAOFactory.getSolicitacaoTreinoDAO();
		/**
		 * Obtem a Lista de Treino de Cliente antes da atualização
		 */			
////		List <SolicitacaoTreino> soliTreino = dao.getAll();
//		
//		for (SolicitacaoTreino st : soliTreino) {
//			System.out.println(st);
//		}
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		// Instancia Sequencia de Treino Cliente
//		SolicitacaoTreino st1 = new SolicitacaoTreino();
//		st1.setDescObjetivoTreino("Aumento da massa muscular");
//		st1.setDataSolicitacao(sdf.parse("26/10/2021 10:30:12"));
//		st1.setDataGeracaoTreino(sdf.parse("31/10/2021 10:30:12"));
//		st1.setStatusSolicTreino(StatusSolicTreino.PENDENTE);
//		st1.setDataInclusao(sdf.parse("01/10/2021 10:30:12"));
//		st1.setCdCpfCliente(22703046820l);
//		st1.setCdCpfPesonal(12345678910l);
//		st1.setCdModalidade(10);

//		dao.incluir(st1);
		
		/**
		 * Busca Id Treino de Cliente antes da atualização 
		 */
		SolicitacaoTreino tc1 = dao.buscarPorId(10l);
		if  (tc1 == null) {
			System.out.println("Não ok => Não trouxe SolicitacaoTreino o Id = " + tc1);
		} 
		/**
		 * Alteração de Treino de Cliente
		 */
//		SolicitacaoTreino st2 = new SolicitacaoTreino();
//		st2.setDescObjetivoTreino("Aerobico 30 e Aumento da massa muscular");
//		st2.setDataSolicitacao(sdf.parse("26/10/2021 10:30:12"));
//		st2.setDataGeracaoTreino(sdf.parse("31/10/2021 10:30:12"));
//		st2.setStatusSolicTreino(StatusSolicTreino.PENDENTE);
//		st2.setDataInclusao(sdf.parse("01/10/2021 10:30:12"));
//		st2.setCdCpfCliente(22703046820l);
//		st2.setCdCpfPesonal(12345678910l);
//		st2.setCdModalidade(10);
//		st2.setIdSolicitacaoTreino(30l);
//
//		dao.alterar(st2);
		
		/**
		 * Lista de Treino de Cliente após inclusão e atualização
		 */
//		List <SolicitacaoTreino> soliTreinos = dao.getAll();
		
//		for (SolicitacaoTreino st3 : soliTreinos) {
//			System.out.println(st3);
//		}
		
		/**
		 * Exclui Id de Sequencia de Treino de Cliente 
		 */	
		dao.excluir(10l);
		
		/**
		 *  Busca Id Sequencia Treino após atualização
		 */
		SolicitacaoTreino tc4 = dao.buscarPorId(1l);
		if  (tc4 == null) {
			System.out.println("Ok => Não trouxe o Id (1l), foi excluido" );
		}	
	}	
}	
