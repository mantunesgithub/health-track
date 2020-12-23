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
		 * Obtem a Lista de Treino de Cliente antes da atualização
		 */			
		List <TreinoCliente> treinoCliente = dao.getAll(100L, "cpf");
		System.out.println("Lista de Treino de Cliente antes da atualização");
		
		for (TreinoCliente tc : treinoCliente) {
			System.out.println(tc);
		}
	
		// Instancia Treino Cliente de um cliente
		Calendar dataAlteracao = Calendar.getInstance();
		Calendar dataInclusao = Calendar.getInstance();
		TreinoCliente tc = new TreinoCliente();
		tc.setDataInicioTreino(dataAlteracao);
		tc.setDataFinalTreino(dataInclusao);
		tc.setDiasDaSemana("Segunda-feira e Terça-feira");
		tc.setQtdeVolumeSemana(2.0);
		tc.setQtdeVolumeSessao(1.0);
		tc.setDescObjetivoTreino("Desenvolvimento de Peitoral");
		tc.setDescLocalTreino("Academia");
		tc.setDescTrajeTreino("Calça e Bermuda");
		tc.setDescAssesTreino("Toalha");
		tc.setIdMediaTreino(1l);
		tc.setStatusTreino(StatusTreinoCliente.ATIVO);
		tc.setDescObservacoes("");
		tc.setDataAlteracao(dataAlteracao);
		tc.setDataInclusao(dataInclusao);



		dao.incluir(tc);
		/**
		 * Busca Id Treino de Cliente antes da atualização 
		 */
		TreinoCliente tc1 = dao.buscarPorId(21l);
		if  (tc1 == null) {
			System.out.println("Não trouxe o Id = " + tc1);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + tc1);
		}		

		/**
		 * Alteração de Treino de Cliente
		 */
		TreinoCliente tc2 = new TreinoCliente();
		tc2.setDataInicioTreino(dataAlteracao);
		tc2.setDataFinalTreino(dataAlteracao);
		tc2.setDiasDaSemana("todo dia xxxxxxxxxxxxx");
		tc2.setQtdeVolumeSemana(2.0);
		tc2.setQtdeVolumeSessao(1.0);
		tc2.setDescObjetivoTreino("Desenvolvimento de Peitoral");
		tc2.setDescLocalTreino("Academia");
		tc2.setDescTrajeTreino("Calça e Bermuda");
		tc2.setDescAssesTreino("Toalha");
		tc2.setIdMediaTreino(1l);
		tc2.setStatusTreino(StatusTreinoCliente.ATIVO);
		tc2.setDescObservacoes("Xtestes");
		tc2.setDataAlteracao(dataAlteracao);
		tc2.setIdTreino(21l);
		
		dao.alterar(tc2);
		System.out.println("Alterou o Id = " + tc2.getIdTreino());
		/**
		 * Lista de Treino de Cliente após inclusão e atualização
		 */
		List <TreinoCliente> treinoClientes = dao.getAll(12703046820l, "cpf");
		
		System.out.println("Lista de Treino de Cliente após Inclusão/alteração");
		for (TreinoCliente tc3 : treinoClientes) {
			System.out.println(tc3);
		}
		/**
		 * Exclui Id de Treino de Cliente 
		 */	
		dao.excluir(21l);
		System.out.println("Excluiu Id  ======");
		/**
		 *  Busca Id Treino de Cliente após atualização
		 */
		TreinoCliente tc4 = dao.buscarPorId(21l);
		if  (tc4 == null) {
			System.out.println("Ok, Não trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro, Nao excluiu ");
		}		
	}	
}	
