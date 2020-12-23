package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.List;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.SequAtividadeDAO;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.SequAtividade;

public class TestSequAtividadeDAO {
	public static void main(String[] args) throws ParseException {
			
		SequAtividadeDAO dao = DAOFactory.getSequAtividadeDAO();
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigoModalidade(90);
		modalidade.setDescricaoModalidade("Teste Modal");
		/**
		 * Obtem a Lista de SequAtividade
		 */			
		List<SequAtividade> sequAtiv1 = dao.getAll();
		System.out.println("Lista de SequAtividade antes da atualiza��o");
		
		for (SequAtividade sq : sequAtiv1) {
			System.out.println(sq);
		}
		/**
		 * Inclus�o de SequAtividade
		 */			
		
		dao.incluir(new SequAtividade
				(0l,"SUPINO RETO","DESENVOLVIMENTO PEITO",modalidade));
		dao.incluir(new SequAtividade
				(0l,"SUPINO INCLINADO","DESENVOLVIMENTO PEITO",modalidade));

		/**
		 * Busca Id SequAtividade antes da atualiza��o 
		 */
		SequAtividade sequAtiv2 = dao.buscarPorId(7l);
		if  (sequAtiv1 == null) {
			System.out.println("N�o trouxe o Id = " + sequAtiv2);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + sequAtiv2);
		}		
		/**
		 * Altera��o de SequAtividade
		 */
		SequAtividade sequAtiv3 = new SequAtividade();
		sequAtiv3.setIdSequAtiv(7l);
		sequAtiv3.setDescSequAtiv("Rosca Alternada");
		sequAtiv3.setDescObjetivoAtiv("Desenvolvimento bra�o ");
		sequAtiv3.setModalidade(modalidade);
		
		dao.alterar(sequAtiv3);
		/**
		 * Lista de SequAtividade ap�s inclus�o e atualiza��o
		 */
		List <SequAtividade> sequAtiv  = dao.getAll();
		
		System.out.println("Lista de SequAtividade");
		for (SequAtividade seq : sequAtiv) {
			System.out.println(seq);
		}
		/**
		 * Exclui de SequAtividade 
		 */	
		dao.excluir(7l);
		System.out.println("Excluiu cd sequAtiv1 ======");
		/**
		 *  Busca id sequAtiv1 ap�s atualiza��o
		 */
		SequAtividade sequAtiv4 = dao.buscarPorId(7l);
		if  ( sequAtiv4 == null) {
			System.out.println("ok, N�o trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro , Nao excluiu ??");
		}		
	}	
}