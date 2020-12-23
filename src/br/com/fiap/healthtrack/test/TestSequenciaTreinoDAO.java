package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.List;
import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.SequenciaTreinoDAO;
import br.com.fiap.healthtrack.entities.SequenciaTreino;
import br.com.fiap.healthtrack.exception.DBException;

public class TestSequenciaTreinoDAO {
	public static void main(String[] args) throws ParseException, DBException {
			
		SequenciaTreinoDAO dao = DAOFactory.getSequenciaTreinoDAO();
		/**
		 * Obtem a Lista de Treino de Cliente antes da atualização
		 */			
		List <SequenciaTreino> sequTreino = dao.getAll(12703046820l);
		
		for (SequenciaTreino st : sequTreino) {
			System.out.println(st);
		}
		// Instancia Sequencia de Treino Cliente
		SequenciaTreino st1 = new SequenciaTreino();
		st1.setDescAtividade("Desenvolver parte superior do peito");
		st1.setQtdeSeries(4);
		st1.setQtdeRepeticoes(10);
		st1.setPesoDaCarga(30.0);
		st1.setQtdeFreqCardiaca("70 por minuto");
		st1.setQtdeTempoMedio(1.0);
		st1.setQtdeVelocidade(0.0);
		st1.setQtdeIntesidade(0.0);
		st1.setQtdeTempoDuracao(60.0);
		st1.setQtdeTempoDescanso(0.40);
		st1.setDescMetodo("Não especifico");


		dao.incluir(st1);
		
		/**
		 * Busca Id Treino de Cliente antes da atualização 
		 */
		SequenciaTreino tc1 = dao.buscarPorId(1l);
		if  (tc1 == null) {
			System.out.println("Não ok => Não trouxe SequenciaTreino o Id = " + tc1);
		} 
		/**
		 * Alteração de Treino de Cliente
		 */
		SequenciaTreino st2 = new SequenciaTreino();
		st2.setDescAtividade("Desenvolvimento Peitoral Superior");
		st2.setQtdeSeries(3);
		st2.setQtdeRepeticoes(15);
		st2.setPesoDaCarga(40.0);
		st2.setQtdeFreqCardiaca("70 por minuto");
		st2.setQtdeTempoMedio(1.0);
		st2.setQtdeVelocidade(0.0);
		st2.setQtdeIntesidade(0.0);
		st2.setQtdeTempoDuracao(60.0);
		st2.setQtdeTempoDescanso(0.40);
		st2.setDescMetodo("Set");
	
		st2.setIdSequTreino(1l);

		dao.alterar(st2);
		
		/**
		 * Lista de Treino de Cliente após inclusão e atualização
		 */
		List <SequenciaTreino> sequTreinos = dao.getAll(12703046820l);
		
		for (SequenciaTreino st3 : sequTreinos) {
			System.out.println(st3);
		}
		
		/**
		 * Exclui Id de Sequencia de Treino de Cliente 
		 */	
		dao.excluir(1l);
		
		/**
		 *  Busca Id Sequencia Treino após atualização
		 */
		SequenciaTreino tc4 = dao.buscarPorId(1l);
		if  (tc4 == null) {
			System.out.println("Ok => Não trouxe o Id (1l), foi excluido" );
		}	
	}	
}	
