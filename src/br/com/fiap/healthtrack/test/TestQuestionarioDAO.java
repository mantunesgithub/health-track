package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.List;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.QuestionarioDAO;
import br.com.fiap.healthtrack.entities.Questionario;

public class TestQuestionarioDAO {
	public static void main(String[] args) throws ParseException {
			
		QuestionarioDAO dao = DAOFactory.getQuestionarioDAO();
		/**
		 * Obtem a Lista de Questionario
		 */			
		List <Questionario> questionario = dao.getAll();
		System.out.println("Lista de Questionario antes da atualiza��o");
		
		for (Questionario quest : questionario) {
			System.out.println(quest);
		}
		/**
		 * Inclus�o de Questionario
		 */			

		dao.incluir(new Questionario(50, "Avalia��o f�sica do Cliente"));
		/**
		 * Busca Cd questionario antes da atualiza��o 
		 */
		Questionario questCd = dao.buscarPorId(50);
		if  (questCd == null) {
			System.out.println("N�o trouxe o Id = " + questCd);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + questCd);
		}		
		/**
		 * Altera��o de Questionario
		 */
		Questionario questAlt = new Questionario();
		questAlt.setDsQuestionario("Avalia��o da Saude do Cliente ");
		questAlt.setCdQuestionario(50);
		dao.alterar(questAlt);
		
		/**
		 * Lista de Questionario ap�s inclus�o e atualiza��o
		 */
		List <Questionario> Questionarios = dao.getAll();
		
		System.out.println("Lista de Questionario");
		for (Questionario moda : Questionarios) {
			System.out.println(moda);
		}
		/**
		 * Exclui Id de Medida de Cliente 
		 */	
		dao.excluir(50);
		System.out.println("Excluiu cd questionario ======");
		/**
		 *  Busca cd questionario ap�s atualiza��o
		 */
		Questionario questfim = dao.buscarPorId(50);
		if  (questfim == null) {
			System.out.println("ok, N�o trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro , Nao excluiu ??");
		}		

	
	}	
}	