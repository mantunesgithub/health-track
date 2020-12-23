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
		System.out.println("Lista de PerguntaQuest antes da atualização");
		
		for (PerguntaQuest pergQuest : perguntaQuest) {
			System.out.println(pergQuest);
		}
		/**
		 * Inclusão de PerguntaQuest
		 */			
		dao.incluir(new PerguntaQuest
			("Costuma ficar muito tempo sentada?","Sim ou Não",null,1));
		dao.incluir(new PerguntaQuest
			("Você tem antecedentes cirúrgicos?","Sim ou Não","Quais?",1));
		dao.incluir(new PerguntaQuest
			("Funcionamento Intestinal regular ?","Sim ou Não","Alguma observação?",1));
		dao.incluir(new PerguntaQuest
			("Pratica atividade física?","Sim ou Não","Quais?",1));
		dao.incluir(new PerguntaQuest
			("É fumante?","Sim ou Não","Quanto tempo?",1));
		dao.incluir(new PerguntaQuest
			("É gestante?","Possui filhos","Quantos?",1));
		dao.incluir(new PerguntaQuest
			("Já fez algum tratamento ortomolecular?","Sim ou Não","Quais?",1));
		/**
		 * Busca Id perguntaQuest antes da atualização 
		 */
		PerguntaQuest pergQuestId = dao.buscarPorId(91);
		if  (pergQuestId == null) {
			System.out.println("Não trouxe o Id = " + pergQuestId);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + pergQuestId);
		}		
		/**
		 * Alteração de PerguntaQuest
		 */
		PerguntaQuest pergQuestAlt = new PerguntaQuest();
		pergQuestAlt.setDsPergunta1("E tratamento ortomolecular?");
		pergQuestAlt.setDsPergunta2("Sim ou Não");
		pergQuestAlt.setDsPergunta3("Quanto tempo");
		pergQuestAlt.setIdPergunta(91);
		pergQuestAlt.setCdQuestionario(1);
		dao.alterar(pergQuestAlt);
		
		/**
		 * Lista de PerguntaQuest após inclusão e atualização
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
		 *  Busca id perguntaQuest após atualização
		 */
		PerguntaQuest pergQuestfim = dao.buscarPorId(91);
		if  ( pergQuestfim == null) {
			System.out.println("ok, Não trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro , Nao excluiu ??");
		}		

	
	}	
}	