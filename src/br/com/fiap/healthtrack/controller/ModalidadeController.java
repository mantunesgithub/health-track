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
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.exception.DBException;


/**
 * Servlet implementation class ModalidadeController
 */
@WebServlet("/modalidade")
public class ModalidadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModalidadeDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getModalidadeDAO();
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
		}	
	}
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("cd_modalidade"));
		Modalidade modalidade = dao.buscarPorId(id);
		request.setAttribute("modalidade", modalidade);
		request.getRequestDispatcher("ht_modalidade_crud_edit.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Modalidade> lista = dao.getAll();
		request.setAttribute("modalidades", lista);
		request.getRequestDispatcher("ht_modalidade_crud_l.jsp").forward(request, response);
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
			String dsModalidade = request.getParameter("ds_modalidade");
			int    cdModalidade = Integer.parseInt(request.getParameter("cd_modalidade"));
			
			Modalidade modalidade = new Modalidade(cdModalidade, dsModalidade); 
			dao.incluir(modalidade);
			
			request.setAttribute("msg", "Modalidade incluida!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao incluir");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("ht_modalidade_crud_c.jsp").forward(request, response);
	}
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String dsModalidade = request.getParameter("ds_modalidade");
			int    cdModalidade = Integer.parseInt(request.getParameter("cd_modalidade"));
			Modalidade modalidade = new Modalidade(cdModalidade, dsModalidade); 
			dao.alterar(modalidade);

			request.setAttribute("msg", "Modalidade atualizada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
		}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cd_modalidade"));
		
		try {
			dao.excluir(id);
			request.setAttribute("msg", "Modalidade removida!");
		} catch (DBException e) {
				e.printStackTrace();
				request.setAttribute("erro", "Erro ao excluir");
		}
		listar(request,response);
	}		
}	