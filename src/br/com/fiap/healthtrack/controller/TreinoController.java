package br.com.fiap.healthtrack.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.dao.ClienteDAO;
import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.FaseTreinoDAO;
import br.com.fiap.healthtrack.dao.ModalidadeDAO;
import br.com.fiap.healthtrack.dao.PersonalTrainerDAO;
import br.com.fiap.healthtrack.dao.TreinoClienteDAO;
import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.FaseTreino;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.TreinoCliente;
import br.com.fiap.healthtrack.exception.DBException;
/**
 * Servlet implementation class TreinoController
 */
@WebServlet("/treino")
public class TreinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TreinoClienteDAO dao;
	private ModalidadeDAO modalidadeDao;
	private ClienteDAO clienteDao;
	private FaseTreinoDAO faseTreinoDao;
	private PersonalTrainerDAO personalTrainerDAO;
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getTreinoClienteDAO();
		clienteDao = DAOFactory.getClienteDAO();
		faseTreinoDao = DAOFactory.getFaseTreinoDAO();
		personalTrainerDAO = DAOFactory.getPersonalTrainerDAO();
		modalidadeDao = DAOFactory.getModalidadeDAO();
	}

	/**  =============    doGet    ===================
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		switch (acao) {
		case "abrir-form-cliente":
			abrirFormCliente(request, response);
			break;
		case "menu":
			exibirMenu(request, response);
			break;
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		case "abrir-form-inclusao":	
			abrirFormInclusao(request, response);
			break;
		case "listar-todos-treinos":	
			listarTodosTreinos(request, response);
			break;
		}	
	}
	protected void verificarClienteSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sscliente") != null) {
			request.setAttribute("rqClienteSS", session.getAttribute("sscliente"));
		}
	}
	private void abrirFormCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		verificarClienteSession(request);
		List<Cliente> listaCliente = clienteDao.getAll(); 
		request.setAttribute("rqClientes", listaCliente);
		request.getRequestDispatcher("ht_treino_crud_cliente.jsp").forward(request, response);
	}
	
	private void exibirMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long cpfCliente = (Long.parseLong(request.getParameter("cpf_cliente")));
		Cliente cliente = clienteDao.buscarPorId(cpfCliente);

		HttpSession session = request.getSession();
		session.setAttribute("sscliente", cliente);
		request.setAttribute("rqClienteSS",cliente);
		
		request.getRequestDispatcher("ht_treino_crud_menu.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		verificarClienteSession(request);
		
		Cliente cliente = (Cliente) request.getAttribute("rqClienteSS");
		Long cpfClienteSession = cliente.getCdCPFCliente();
		
		List<TreinoCliente> listaTreino = dao.getAll(cpfClienteSession, "cpf");
		request.setAttribute("rqListaTreino", listaTreino);
		request.getRequestDispatcher("ht_treino_crud_list.jsp").forward(request, response);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idTreino = Long.parseLong(request.getParameter("id_treino"));
		TreinoCliente treino = dao.buscarPorId(idTreino);
		request.setAttribute("rqIdTreino", treino);

		carregarListas(request);
		request.getRequestDispatcher("ht_treino_crud_edit.jsp").forward(request, response);
	}
	
	private void abrirFormInclusao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		carregarListas(request);
		request.getRequestDispatcher("ht_treino_crud_create.jsp").forward(request, response);
		
	}
	private void carregarListas(HttpServletRequest request) {
		
		verificarClienteSession(request);
		List<Modalidade> listaModalidade = modalidadeDao.getAll(); 
		List<FaseTreino> listaFaseTreino = faseTreinoDao.getAll(); 
		List<PersonalTrainer> listaPersonal = personalTrainerDAO.getAll(); 
		request.setAttribute("rqModalidades", listaModalidade);
		request.setAttribute("rqFaseTreinos", listaFaseTreino);
		request.setAttribute("rqPersonal", listaPersonal);
	}
	private void listarTodosTreinos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cliente clienteLogin = (Cliente) session.getAttribute("clienteok");
		Long cpfClienteLogin = clienteLogin.getCdCPFCliente();

		List<TreinoCliente> listaTodosTreinos = dao.getAll(cpfClienteLogin, "join");
		request.setAttribute("rqLtodosTreinos", listaTodosTreinos);
		request.getRequestDispatcher("ht_treino_list_todosTreinos.jsp").forward(request, response);
	}
	
	/**  =============    doPost    ===================
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
			Long cpfCliente = (Long.parseLong(request.getParameter("cpf-cliente"))); 
			Long cpfPersonal = (Long.parseLong(request.getParameter("personal"))); 
			Integer codigoModalidade = (Integer.parseInt(request.getParameter("modalidade"))); 
			Long idFaseTreino = (Long.parseLong(request.getParameter("fase_treino"))); 

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataInicio = Calendar.getInstance();
			dataInicio.setTime(format.parse(request.getParameter("data_inicio")));
			Calendar dataFinal = Calendar.getInstance();
			dataFinal.setTime(format.parse(request.getParameter("data_final")));
			String diaSemana = (request.getParameter("dia_semana"));
			Double qtVolSemana = (Double.parseDouble(request.getParameter("qt_vol_semana"))); 
			Double qtVolSessao = (Double.parseDouble(request.getParameter("qt_vol_sessao"))); 
			Integer statusTreino = (Integer.parseInt(request.getParameter("status")));
			String localTreino = (request.getParameter("local_treino"));
			String trajeTreino = (request.getParameter("traje_treino"));
			String assessorio = (request.getParameter("assessorio"));
			String objetivos = (request.getParameter("objetivos"));
			String observacoes = (request.getParameter("observacoes"));
			
			Cliente cliente = new Cliente();
			cliente.setCdCPFCliente(cpfCliente);
			PersonalTrainer personalTrainer = new PersonalTrainer();
			personalTrainer.setCpfPersonal(cpfPersonal);
			Modalidade modalidade = new Modalidade();
			modalidade.setCodigoModalidade(codigoModalidade);
			FaseTreino faseTreino = new FaseTreino();
			faseTreino.setIdFaseTreino(idFaseTreino);
			
			Calendar dataAlteracao = Calendar.getInstance();
			Calendar dataInclusao = Calendar.getInstance();
			
			TreinoCliente treinoCliente = new TreinoCliente(0l, dataInicio, dataFinal,
					diaSemana,qtVolSemana,qtVolSessao,objetivos,localTreino,trajeTreino,assessorio,
					0l,statusTreino, observacoes,dataAlteracao,dataInclusao,cliente,faseTreino,personalTrainer,
					modalidade);

			dao.incluir(treinoCliente);
			request.setAttribute("msg", "Treino incluido!");
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
			Long cpfCliente = (Long.parseLong(request.getParameter("cpf-cliente"))); 
			Long cpfPersonal = (Long.parseLong(request.getParameter("personal"))); 
			Integer codigoModalidade = (Integer.parseInt(request.getParameter("modalidade"))); 
			Long idFaseTreino = (Long.parseLong(request.getParameter("fase_treino"))); 

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataInicio = Calendar.getInstance();
			dataInicio.setTime(format.parse(request.getParameter("data_inicio")));
			
			Calendar dataFinal = Calendar.getInstance();
			dataFinal.setTime(format.parse(request.getParameter("data_final")));
			
			String diaSemana = (request.getParameter("dia_semana"));
			Double qtVolSemana = (Double.parseDouble(request.getParameter("qt_vol_semana"))); 
			Double qtVolSessao = (Double.parseDouble(request.getParameter("qt_vol_sessao"))); 
			Integer statusTreino = (Integer.parseInt(request.getParameter("status")));
			String localTreino = (request.getParameter("local_treino"));
			String trajeTreino = (request.getParameter("traje_treino"));
			String assessorio = (request.getParameter("assessorio"));
			String objetivos = (request.getParameter("objetivos"));
			String observacoes = (request.getParameter("observacoes"));
			
			Cliente cliente = new Cliente();
			cliente.setCdCPFCliente(cpfCliente);
			PersonalTrainer personalTrainer = new PersonalTrainer();
			personalTrainer.setCpfPersonal(cpfPersonal);
			Modalidade modalidade = new Modalidade();
			modalidade.setCodigoModalidade(codigoModalidade);
			FaseTreino faseTreino = new FaseTreino();
			faseTreino.setIdFaseTreino(idFaseTreino);
			Calendar dataAlteracao = Calendar.getInstance();
			Calendar dataInclusao = Calendar.getInstance();
			
			Long idTreino = (Long.parseLong(request.getParameter("id_treino"))); 
			TreinoCliente treinoCliente = new TreinoCliente(idTreino, dataInicio, dataFinal,
					diaSemana,qtVolSemana,qtVolSessao,objetivos,localTreino,trajeTreino,assessorio,
					0l,statusTreino, observacoes,dataAlteracao,dataInclusao,cliente,faseTreino,personalTrainer,
					modalidade);

			dao.alterar(treinoCliente);
			request.setAttribute("msg", "Treino atualizado!");
			
//		} catch (DBException db) {
//			db.printStackTrace();
//			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		Long idTreino = Long.parseLong(request.getParameter("id_treino"));
		
		dao.excluir(idTreino);
		request.setAttribute("msg", "Treino removido!");
		listar(request,response);
	}		
}	