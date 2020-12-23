package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.FaseTreinoDAO;
import br.com.fiap.healthtrack.dao.ModalidadeDAO;
import br.com.fiap.healthtrack.entities.FaseTreino;
import br.com.fiap.healthtrack.entities.Modalidade;

/**
 * Servlet implementation class FaseTreinoController
 */
@WebServlet("/fase-treino")
public class FaseTreinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FaseTreinoDAO dao;
	private ModalidadeDAO modalidadeDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getFaseTreinoDAO();
		modalidadeDao = DAOFactory.getModalidadeDAO();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		case "abrir-form-inclusao":	
			abrirFormInclusao(request, response);
		break;
		}	
	}

	private void abrirFormInclusao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		carregarOpcoesModalidade(request);
		request.getRequestDispatcher("ht_fase_treino_crud_create.jsp").forward(request, response);
		
	}

	private void carregarOpcoesModalidade(HttpServletRequest request) {
		List<Modalidade> lista = modalidadeDao.getAll(); 
		request.setAttribute("rqModalidades", lista);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idFaseTreino = Long.parseLong(request.getParameter("id_fase_treino"));
		FaseTreino faseTreino = dao.buscarPorId(idFaseTreino);
		request.setAttribute("rqIdFaseTreino", faseTreino);

		carregarOpcoesModalidade(request);
		request.getRequestDispatcher("ht_fase_treino_crud_edit.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<FaseTreino> lista = dao.getAll();
		request.setAttribute("rqListaFaseTreino", lista);
		request.getRequestDispatcher("ht_fase_treino_crud_list.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "incluir":
			incluir(request, response);
			break;
		case "editar":
			editar(request,response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}
	
	private void incluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		
			Integer cdFaseTreino = (Integer.parseInt(request.getParameter("cod_fase_treino"))); 
			Integer tpFaseTreino = (Integer.parseInt(request.getParameter("tp_treino"))); 
			String dsTipoTreino = (request.getParameter("descr_tp_treino"));
			String  dsObjetivoTreino = (request.getParameter("descr_objetivo"));
			Integer codigoModalidade = (Integer.parseInt(request.getParameter("modalidade"))); 
			
			Modalidade modalidade = new Modalidade();
			modalidade.setCodigoModalidade(codigoModalidade);
			
			FaseTreino faseTreino = new FaseTreino(0l,cdFaseTreino,tpFaseTreino,dsTipoTreino,dsObjetivoTreino);
			faseTreino.setModalidade(modalidade); 
			dao.incluir(faseTreino);
			request.setAttribute("msg", "Fase de Treino incluida!");
		
//		}catch(DBException db) {
//			db.printStackTrace();
//			request.setAttribute("erro", "Erro ao incluir");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		abrirFormInclusao(request, response);
	}
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idFaseTreino = (Long.parseLong(request.getParameter("id_fase_treino"))); 
			Integer cdFaseTreino = (Integer.parseInt(request.getParameter("cod_fase_treino"))); 
			Integer tpFaseTreino = (Integer.parseInt(request.getParameter("tp_treino"))); 
			String dsTipoTreino = (request.getParameter("descr_tp_treino"));
			String  dsObjetivoTreino = (request.getParameter("descr_objetivo"));
			Integer codigoModalidade = (Integer.parseInt(request.getParameter("modalidade"))); 
			
			
			Modalidade modalidade = new Modalidade();
			modalidade.setCodigoModalidade(codigoModalidade);
			
			FaseTreino faseTreino = new FaseTreino(idFaseTreino,cdFaseTreino,tpFaseTreino,dsTipoTreino,dsObjetivoTreino);
			faseTreino.setModalidade(modalidade); 

			dao.alterar(faseTreino);
			request.setAttribute("msg", "Fase de Treino atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
		}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		Long idFaseTreino = Long.parseLong(request.getParameter("id_fase_treino"));
		
		dao.excluir(idFaseTreino);
		request.setAttribute("msg", "Fase de Treino removida!");
		listar(request,response);
	}		
}	