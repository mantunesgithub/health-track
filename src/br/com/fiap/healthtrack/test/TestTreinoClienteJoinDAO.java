package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.util.List;

import com.sun.glass.ui.Size;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.SequenciaTreinoDAO;
import br.com.fiap.healthtrack.dao.TreinoClienteDAO;
import br.com.fiap.healthtrack.entities.SequenciaTreino;
import br.com.fiap.healthtrack.entities.TreinoCliente;

public class TestTreinoClienteJoinDAO {
	public static void main(String[] args) throws ParseException {
		
		TreinoClienteDAO dao = DAOFactory.getTreinoClienteDAO();
		/**
		 * Obtem a Lista de Treino de Cliente antes da atualização
		 */			
		
		for (TreinoCliente tc : dao.getAll(100L, "join")) {
			System.out.println("Treino do Cliente");
			System.out.println("id.treino: " + tc.getIdTreino() +" Objetivo : " + tc.getDescObjetivoTreino() +
							" Fase treino: " + tc.getFaseTreino().getCdFaseTreino() + " Tp Treino: " + tc.getFaseTreino().getTpFaseTreino() +
							" Dia Semana: " + tc.getDiasDaSemana());
				for  (SequenciaTreino sq : tc.getSequenciaTreinos()) {
					System.out.println("Sequencia de Treino size: " + tc.getSequenciaTreinos().size());
						System.out.println("    " + " Id.Sq = " + sq.getIdSequTreino() +
								" sequ atividade: " + sq.getSequAtiv().getDescObjetivoAtiv() +
								" qt serie: " + sq.getQtdeSeries() + " qt repetições: " + sq.getQtdeRepeticoes() +
								" qt carga: " + sq.getPesoDaCarga());
				}
		}
	}
}
