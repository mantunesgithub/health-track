package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.List;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.ModalidadeDAO;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.exception.DBException;

public class TestModalidadeDAO {
	public static void main(String[] args) throws ParseException {
			
		ModalidadeDAO dao = DAOFactory.getModalidadeDAO();
		/**
		 * Obtem a Lista de Modalidade
		 */			
		List <Modalidade> modalidade = dao.getAll();
		System.out.println("Lista de Modalidade antes da atualização");
		
		for (Modalidade modal : modalidade) {
			System.out.println(modal);
		}
		/**
		 * Inclusão de Modalidade
		 */			
		Modalidade modal = new Modalidade(95, "TENIS");
		try {
			dao.incluir(modal);
			
		} catch (DBException e) {
			e.printStackTrace();
		}
		

		Modalidade modalId = dao.buscarPorId(95);
		if  (modalId == null) {
			System.out.println("Não trouxe o Id = " + modalId);
		} else {
			System.out.println("Trouxe o Id pesquisado = " + modalId);
		}		
		/**
		 * Alteração de Modalidade
		 */
		Modalidade modalAlt = new Modalidade();
		modalAlt.setDescricaoModalidade("Tenis de Mesa");
		modalAlt.setCodigoModalidade(95);
		try {
			dao.alterar(modalAlt);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		/**
		 * Lista de Modalidade após inclusão e atualização
		 */
		List <Modalidade> Modalidades = dao.getAll();
		
		System.out.println("Lista de Modalidade");
		for (Modalidade moda : Modalidades) {
			System.out.println(moda);
		}
		/**
		 * Exclui Id de Medida de Cliente 
		 */	
		try {
			dao.excluir(95);
		} catch (DBException e) {
			e.printStackTrace();
		}
		System.out.println("Excluiu Id ======");
		/**
		 *  Busca Id Medida de Cliente após atualização
		 */
		Modalidade modfim = dao.buscarPorId(95);
		if  (modfim == null) {
			System.out.println("Não trouxe Id, foi excluido" );
		} else {
			System.out.println("Nao excluiu ??");
		}		

	
	}	
}	