package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.TreinoClienteDAO;
import br.com.fiap.healthtrack.entities.TreinoCliente;
import br.com.fiap.healthtrack.entities.enums.StatusTreinoCliente;
public class TestTreinoClienteDAO {
	public static void main(String[] args) throws ParseException {
			
		TreinoClienteDAO dao = DAOFactory.getTreinoClienteDAO();
		/**
		 * Obtem a Lista de Treino de Cliente antes da atualiza��o
		 */			
		List <TreinoCliente> treinoCliente = dao.getAll(100L, "cpf");
		System.out.println("Lista de Treino de Cliente antes da atualiza��o");
		
		for (TreinoCliente tc : treinoCliente) {
			System.out.println(tc);
		}
	
		// Instancia Treino Cliente de um cliente
		Calendar dataAlteracao = Calendar.getInstance();
		Calendar dataInclusao = Calendar.getInstance();
		TreinoCliente tc = new TreinoCliente();
		tc.setDataInicioTreino(dataAlteracao);
		tc.setDataFinalTreino(dataInclusao);
		tc.setDiasDaSemana("Segunda-feira e Ter�a-feira");
		tc.setQtdeVolumeSemana(2.0);
		tc.setQtdeVolumeSessao(1.0);
		tc.setDescObjetivoTreino("Desenvolvimento de Peitoral");
		tc.setDescLocalTreino("Academia");
		tc.setDescTrajeTreino("Cal�a e Bermuda");
		tc.setDescAssesTreino("Toalha");
		tc.setIdMediaTreino(1l);
		tc.setStatusTreino(StatusTreinoCliente.ATIVO);
		tc.setDescObservacoes("");
		tc.setDataAlteracao(dataAlteracao);
		tc.setDataInclusao(dataInclusao);



		dao.incluir(tc);
		/**
		 * Busca Id Treino de Cliente antes da atualiza��o 
		 */
		TreinoCliente tc1 = dao.buscarPorId(21l);
		if  (tc1 == null) {
			System.out.println("N�o trouxe o Id = " + tc1);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + tc1);
		}		

		/**
		 * Altera��o de Treino de Cliente
		 */
		TreinoCliente tc2 = new TreinoCliente();
		tc2.setDataInicioTreino(dataAlteracao);
		tc2.setDataFinalTreino(dataAlteracao);
		tc2.setDiasDaSemana("todo dia xxxxxxxxxxxxx");
		tc2.setQtdeVolumeSemana(2.0);
		tc2.setQtdeVolumeSessao(1.0);
		tc2.setDescObjetivoTreino("Desenvolvimento de Peitoral");
		tc2.setDescLocalTreino("Academia");
		tc2.setDescTrajeTreino("Cal�a e Bermuda");
		tc2.setDescAssesTreino("Toalha");
		tc2.setIdMediaTreino(1l);
		tc2.setStatusTreino(StatusTreinoCliente.ATIVO);
		tc2.setDescObservacoes("Xtestes");
		tc2.setDataAlteracao(dataAlteracao);
		tc2.setIdTreino(21l);
		
		dao.alterar(tc2);
		System.out.println("Alterou o Id = " + tc2.getIdTreino());
		/**
		 * Lista de Treino de Cliente ap�s inclus�o e atualiza��o
		 */
		List <TreinoCliente> treinoClientes = dao.getAll(12703046820l, "cpf");
		
		System.out.println("Lista de Treino de Cliente ap�s Inclus�o/altera��o");
		for (TreinoCliente tc3 : treinoClientes) {
			System.out.println(tc3);
		}
		/**
		 * Exclui Id de Treino de Cliente 
		 */	
		dao.excluir(21l);
		System.out.println("Excluiu Id  ======");
		/**
		 *  Busca Id Treino de Cliente ap�s atualiza��o
		 */
		TreinoCliente tc4 = dao.buscarPorId(21l);
		if  (tc4 == null) {
			System.out.println("Ok, N�o trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro, Nao excluiu ");
		}		
	}	
}	
