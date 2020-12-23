package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.PersonalTrainerDAO;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.enums.StatusPersonal;

/**
 * Servlet implementation class PersonalTrainerController
 */
@WebServlet("/personal")
public class PersonalTrainerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonalTrainerDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPersonalTrainerDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		Long cpfPersonal = Long.parseLong(request.getParameter("cpf_personal"));
		PersonalTrainer personal = dao.buscarPorId(cpfPersonal);
		request.setAttribute("personal", personal);
		request.getRequestDispatcher("ht_personal_trainer_crud_edit.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<PersonalTrainer> lista = dao.getAll();
		request.setAttribute("personal", lista);
		request.getRequestDispatcher("ht_personal_trainer_crud_l.jsp").forward(request, response);
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
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			PersonalTrainer personal = new PersonalTrainer
					(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null); 
			personal.setCpfPersonal(Long.parseLong(request.getParameter("cpf_personal")));
			personal.setNome(request.getParameter("nome_personal"));
			personal.setCref(request.getParameter("cref_personal"));
			personal.setRg(0);
			personal.setEndereco("teste");
			personal.setNumero(0);
			personal.setComplemento("teste");
			personal.setBairro("teste");
			personal.setCidade("teste");
			personal.setUf("te");
			personal.setPais("teste");
			personal.setEmail(request.getParameter("email_personal"));
			personal.setCepPrefixo(0);
			personal.setCepSufixo(0);
			personal.setStatusPersonalTrainer(StatusPersonal.ATIVO);
			personal.setDdiCelular(55);
			personal.setDddCelular(Integer.parseInt(request.getParameter("ddd_personal")));
			personal.setNumeroCelular(Integer.parseInt(request.getParameter("celular_personal")));
			personal.setDataInclusao(sdf.parse("11/11/2020 10:30:12"));
			
			dao.incluir(personal);
			request.setAttribute("msg", "PersonalTrainer incluido!");
//		}catch(DBException db) {
//			db.printStackTrace();
//			request.setAttribute("erro", "Erro ao incluir");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("ht_personal_trainer_crud_c.jsp").forward(request, response);
	}
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			PersonalTrainer personal = new PersonalTrainer
					(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null); 
		
			personal.setCpfPersonal(Long.parseLong(request.getParameter("cpf_personal")));
			personal.setNome(request.getParameter("nome_personal"));
			personal.setCref(request.getParameter("cref_personal"));
			personal.setRg(0);
			personal.setEndereco("teste");
			personal.setNumero(0);
			personal.setComplemento("teste");
			personal.setBairro("teste");
			personal.setCidade("teste");
			personal.setUf("tt");
			personal.setPais("teste");
			personal.setEmail(request.getParameter("email_personal"));
			personal.setCepPrefixo(0);
			personal.setCepSufixo(0);
			personal.setStatusPersonalTrainer(StatusPersonal.ATIVO);
			personal.setDdiCelular(55);
			personal.setDddCelular(Integer.parseInt(request.getParameter("ddd_personal")));
			personal.setNumeroCelular(Integer.parseInt(request.getParameter("celular_personal")));
			personal.setDataInclusao(sdf.parse("11/11/2020 10:30:12"));

			dao.alterar(personal);
			request.setAttribute("msg", "PersonalTrainer atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
		}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		Long cpfPersonal = Long.parseLong(request.getParameter("cpf_personal"));
		
		dao.excluir(cpfPersonal);
		request.setAttribute("msg", "PersonalTrainer removido!");
		listar(request,response);
	}		
}	