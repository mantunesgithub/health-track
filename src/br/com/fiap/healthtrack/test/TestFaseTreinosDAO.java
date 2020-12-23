package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.List;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.FaseTreinoDAO;
import br.com.fiap.healthtrack.entities.FaseTreino;
import br.com.fiap.healthtrack.entities.Modalidade;

public class TestFaseTreinosDAO {
	public static void main(String[] args) throws ParseException {
			
		FaseTreinoDAO dao = DAOFactory.getFaseTreinoDAO();
		/**
		 * Obtem a Lista de FaseTreino
		 */			
		
		List <FaseTreino> faseTreino20 = dao.getAll();
		System.out.println("Lista de FaseTreino antes da atualização");
		
		for (FaseTreino faseTreino21 : faseTreino20) {
			System.out.println(faseTreino21);
		}
		/**
		/**
		 * Inclusão de FaseTreino
		 */			
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigoModalidade(90);
		modalidade.setDescricaoModalidade("Teste Modal");

		FaseTreino faseTreino201 = new FaseTreino();
		faseTreino201.setIdFaseTreino(701L);
		faseTreino201.setCdFaseTreino(3);
		faseTreino201.setTpFaseTreino(4);
		faseTreino201.setDsTipoTreino("Treinamento A");
		faseTreino201.setDsObjetivoTreino("Desenvolvimento peitoral+braço triceps e pernas");
		faseTreino201.setModalidade(modalidade);
		dao.incluir(faseTreino201); 
//		 * Busca Id FaseTreino antes da atualização 
//		 */
		FaseTreino faseTreino2 = dao.buscarPorId(701l);
		if  (faseTreino2 == null) {
			System.out.println("Não trouxe o Id = " + faseTreino2);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + faseTreino2);
		}		
		/**
		 * Alteração de FaseTreino
		 */
		FaseTreino faseTreino21 = new FaseTreino();
		faseTreino21.setIdFaseTreino(701L);
		faseTreino21.setCdFaseTreino(3);
		faseTreino21.setTpFaseTreino(4);
		faseTreino21.setDsTipoTreino("Treinamento A");
		faseTreino21.setDsObjetivoTreino("Desenvolvimento peitoral+braço triceps e pernas");
		faseTreino21.setModalidade(modalidade);
		
		dao.alterar(faseTreino21);
		/**
		 * Lista de FaseTreino após inclusão e atualização
		 */
		List <FaseTreino> faseTreino  = dao.getAll();
		
		System.out.println("Lista de FaseTreino");
		for (FaseTreino pq : faseTreino) {
			System.out.println(pq);
		}
		/**
		 * Exclui de FaseTreino 
		 */	
		dao.excluir(701l);
		System.out.println("Excluiu cd faseTreino20 ======");
		/**
		 *  Busca id faseTreino20 após atualização
		 */
		FaseTreino faseTreino3 = dao.buscarPorId(701l);
		if  ( faseTreino3 == null) {
			System.out.println("ok, Não trouxe Id, foi excluido" );
		} else {
			System.out.println("Erro , Nao excluiu ??");
		}		
	
	}	
}	