package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.ModalidadeDAO;
import br.com.fiap.healthtrack.dao.SequAtividadeDAO;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.SequAtividade;

/**
 * Servlet implementation class SequAtividadeController
 */
@WebServlet("/sequ-atividade")
public class SequAtividadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SequAtividadeDAO dao;
	private ModalidadeDAO modalidadeDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getSequAtividadeDAO();
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
		request.getRequestDispatcher("ht_sequ_atividade_crud_c.jsp").forward(request, response);
		
	}

	private void carregarOpcoesModalidade(HttpServletRequest request) {
		List<Modalidade> lista = modalidadeDao.getAll(); 
		request.setAttribute("rqModalidades", lista);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idSequAtiv = Long.parseLong(request.getParameter("id_seq_ativ"));
		SequAtividade sequenciaAtividade = dao.buscarPorId(idSequAtiv);
		request.setAttribute("rqIdSequAtiv", sequenciaAtividade);
		carregarOpcoesModalidade(request);
		request.getRequestDispatcher("ht_sequ_atividade_crud_edt.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<SequAtividade> lista = dao.getAll();
		request.setAttribute("rqListSequAtiv", lista);
		request.getRequestDispatcher("ht_sequ_atividade_crud_l.jsp").forward(request, response);
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
			String descSequAtiv = (request.getParameter("ds_atividade"));
			String descObjetivoAtiv = (request.getParameter("ds_obj_atividade"));
			Integer codigoModalidade = (Integer.parseInt(request.getParameter("modalidade"))); 
			
			Modalidade modalidade = new Modalidade();
			modalidade.setCodigoModalidade(codigoModalidade);
			
			SequAtividade sequencia = new SequAtividade(0l,descSequAtiv,descObjetivoAtiv);
			sequencia.setModalidade(modalidade); 
			dao.incluir(sequencia);
			request.setAttribute("msg", "Sequência de Atividade incluida!");
		
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
			String descSequAtiv = (request.getParameter("ds_atividade"));
			String descObjetivoAtiv = (request.getParameter("ds_obj_atividade"));
			Integer codigoModalidade = (Integer.parseInt(request.getParameter("modalidade"))); 
			
			Modalidade modalidade = new Modalidade();
			modalidade.setCodigoModalidade(codigoModalidade);
			
			SequAtividade sequencia = new SequAtividade(0l,descSequAtiv,descObjetivoAtiv);
			sequencia.setModalidade(modalidade); 
			
			dao.alterar(sequencia);
			request.setAttribute("msg", "Sequência de Atividade atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
		}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		Long idSequAtiv = Long.parseLong(request.getParameter("id_seq_ativ"));
		
		dao.excluir(idSequAtiv);
		request.setAttribute("msg", "Sequencia de Atividade removida!");
		listar(request,response);
	}		
}	