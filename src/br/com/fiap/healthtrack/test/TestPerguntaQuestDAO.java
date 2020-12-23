package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.List;
import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.PerguntaQuestDAO;
import br.com.fiap.healthtrack.entities.PerguntaQuest;

public class TestPerguntaQuestDAO {
	public static void main(String[] args) throws ParseException {
			
		PerguntaQuestDAO dao = DAOFactory.getPerguntaQuestDAO();
		/**
		 * Obtem a Lista de PerguntaQuest
		 */			
		List <PerguntaQuest> perguntaQuest = dao.getAll();
		System.out.println("Lista de PerguntaQuest antes da atualiza��o");
		
		for (PerguntaQuest pergQuest : perguntaQuest) {
			System.out.println(pergQuest);
		}
		/**
		 * Inclus�o de PerguntaQuest
		 */			
		dao.incluir(new PerguntaQuest
			("Costuma ficar muito tempo sentada?","Sim ou N�o",null,1));
		dao.incluir(new PerguntaQuest
			("Voc� tem antecedentes cir�rgicos?","Sim ou N�o","Quais?",1));
		dao.incluir(new PerguntaQuest
			("Funcionamento Intestinal regular ?","Sim ou N�o","Alguma observa��o?",1));
		dao.incluir(new PerguntaQuest
			("Pratica atividade f�sica?","Sim ou N�o","Quais?",1));
		dao.incluir(new PerguntaQuest
			("� fumante?","Sim ou N�o","Quanto tempo?",1));
		dao.incluir(new PerguntaQuest
			("� gestante?","Possui filhos","Quantos?",1));
		dao.incluir(new PerguntaQuest
			("J� fez algum tratamento ortomolecular?","Sim ou N�o","Quais?",1));
		/**
		 * Busca Id perguntaQuest antes da atualiza��o 
		 */
		PerguntaQuest pergQuestId = dao.buscarPorId(91);
		if  (pergQuestId == null) {
			System.out.println("N�o trouxe o Id = " + pergQuestId);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + pergQuestId);
		}		
		/**
		 * Altera��o de PerguntaQuest
		 */
		PerguntaQuest pergQuestAlt = new PerguntaQuest();
		pergQuestAlt.setDsPergunta1("E tratamento ortomolecular?");
		pergQuestAlt.setDsPergunta2("Sim ou N�o");
		pergQuestAlt.setDsPergunta3("Quanto tempo");
		pergQuestAlt.setIdPergunta(91);
		pergQuestAlt.setCdQuestionario(1);
		dao.alterar(pergQuestAlt);
		
		/**
		 * Lista de PerguntaQuest ap�s inclus�o e atualiza��o
		 */
		List <PerguntaQuest> pergQuest  = dao.getAll();
		
		System.out.println("Lista de PerguntaQuest");
		for (PerguntaQuest pq : pergQuest) {
			System.out.println(pq);
		}
		/**
		 * Exclui de PerguntaQuest 
		 */	
		dao.excluir(91);
		System.out.println("Excluiu cd perguntaQuest ======");
		/**
		 *  Busca id perguntaQuest ap�s atualiza��o
		 */
		PerguntaQuest pergQuestfim = dao.buscarPorId(91);
		if  ( pergQuestfim == null) {
			System.out.println("ok, N�o trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro , Nao excluiu ??");
		}		

	
	}	
}	