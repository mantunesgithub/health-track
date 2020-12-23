package br.com.fiap.healthtrack.controller;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.bo.EmailBO;
import br.com.fiap.healthtrack.dao.ClienteDAOImpl;
import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.MedidaClienteDAO;
import br.com.fiap.healthtrack.dao.ModalidadeDAO;
import br.com.fiap.healthtrack.dao.ModalidadeDAOImpl;
import br.com.fiap.healthtrack.dao.PersonalTrainerDAO;
import br.com.fiap.healthtrack.dao.PersonalTrainerDAOImpl;
import br.com.fiap.healthtrack.dao.SolicitacaoTreinoDAO;
import br.com.fiap.healthtrack.dao.TreinoClienteDAO;
import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.MedidaCliente;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.SolicitacaoTreino;
import br.com.fiap.healthtrack.entities.TreinoCliente;
import br.com.fiap.healthtrack.entities.enums.StatusSolicTreino;
import br.com.fiap.healthtrack.exception.DBException;
/**
 * Servlet implementation class TreinoController
 */
import br.com.fiap.healthtrack.exception.EmailException;
@WebServlet("/solicitar-treino")
public class SolicitacaoTreinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SolicitacaoTreinoDAO dao;
	private TreinoClienteDAO daoTreino;
	private ModalidadeDAO modalidadeDao;
	private PersonalTrainerDAO personalTrainerDAO;
	private MedidaClienteDAO medidaClienteDAO;
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getSolicitacaoTreinoDAO();
		daoTreino = DAOFactory.getTreinoClienteDAO();
		DAOFactory.getClienteDAO();
		personalTrainerDAO = DAOFactory.getPersonalTrainerDAO();
		modalidadeDao = DAOFactory.getModalidadeDAO();
		medidaClienteDAO = DAOFactory.getMedidaClienteDAO();
	}

	/**  =============    doGet    ===================
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		System.out.println("acao doget= " + acao);
		switch (acao) {
		case "abrir-form-inclusao":	
			abrirFormInclusao(request, response);
		break;
		case "abrir-form-analise-perfil":	
			abrirFormAnalisePerfil(request, response);
			break;
		case "atzar-solicitacao":
			atzarSolicitacao(request, response);
			abrirFormAnalisePerfil(request, response);
			break;

		}	
	}
	protected void verificarClienteSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sscliente") != null) {
			request.setAttribute("rqClienteSS", session.getAttribute("sscliente"));
		}
	}

	private void abrirFormInclusao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		carregarListas(request);
		request.getRequestDispatcher("ht_solic_treino_crud_list.jsp").forward(request, response);
		
	}
	private void abrirFormAnalisePerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("sscliente") != null) {
			request.setAttribute("rqClienteSS", session.getAttribute("sscliente"));
		}
		Cliente cliente = (Cliente) request.getAttribute("rqClienteSS");
		Long cpfClienteSession = cliente.getCdCPFCliente();

		
		List<SolicitacaoTreino> listaSolicitacaoTreino = dao.getAll(cpfClienteSession); 
		request.setAttribute("rqLsolicTreino", listaSolicitacaoTreino);

		List<MedidaCliente> listaMedidaCliente;
		try {
			listaMedidaCliente = medidaClienteDAO.getAll(cpfClienteSession);
			request.setAttribute("rqLmedidaCliente", listaMedidaCliente);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		List<TreinoCliente> listaTodosTreinos = daoTreino.getAll(cpfClienteSession, "join");
		request.setAttribute("rqLtodosTreinos", listaTodosTreinos);
		
		request.getRequestDispatcher("ht_analise_perfil.jsp").forward(request, response);
	}
	private void carregarListas(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cliente clienteLogin = (Cliente) session.getAttribute("clienteok");
		Long cpfClienteLogin = clienteLogin.getCdCPFCliente();
		List<SolicitacaoTreino> listaSolicitacaoTreino = dao.getAll(cpfClienteLogin); 

		List<Modalidade> listaModalidade = modalidadeDao.getAll(); 
		List<PersonalTrainer> listaPersonal = personalTrainerDAO.getAll(); 
		
		request.setAttribute("rqModalidades", listaModalidade);
		request.setAttribute("rqLsolicTreino", listaSolicitacaoTreino);
		request.setAttribute("rqPersonal", listaPersonal);
	}
	/**  =============    doPost    ===================
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		System.out.println("acao dopost= " + acao);
		switch (acao) {
		
		case "incluir":
			incluir(request, response);
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
			String objetivos = (request.getParameter("objetivos"));
			Calendar dataSolicitacao = Calendar.getInstance();
			
			Calendar dataInclusao = Calendar.getInstance();
			Calendar dataGeracaoTreino = Calendar.getInstance();

			ModalidadeDAOImpl modalidadeDAOImpl = new ModalidadeDAOImpl() ;
			Modalidade modalidade = modalidadeDAOImpl.buscarPorId(codigoModalidade);
			
			PersonalTrainerDAOImpl personalTrainerDAOImpl = new PersonalTrainerDAOImpl();
			PersonalTrainer personalTrainer = 
							personalTrainerDAOImpl.buscarPorId(cpfPersonal);

			ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
			Cliente cliente = clienteDAOImpl.buscarPorId(cpfCliente);
	
			SolicitacaoTreino solicitacaoTreino = new SolicitacaoTreino(0l,dataSolicitacao,objetivos,
					dataGeracaoTreino,StatusSolicTreino.PENDENTE,dataInclusao,cliente,personalTrainer,modalidade);

			dao.incluir(solicitacaoTreino);
			request.setAttribute("msg", "Solicitação de Treino incluido! Personal Trainer - "
						+ personalTrainer.getNome() + " foi avisado da sua solicitação!");
			
			EmailBO bo = new EmailBO();
			
			String mensagemPersonal = "Olá Professor " + personalTrainer.getNome() + " o cliente, " + cliente.getNome() +
										" cpf: " + cliente.getCdCPFCliente() + " solicitou um Treino";
			
			try {
				bo.enviarEmail(personalTrainer.getEmail(), "Solicitação de Treino", mensagemPersonal);
			} catch (EmailException e) {
			e.printStackTrace();
			}
			
		}catch(DBException db) {
			System.out.println( "SolicitacaoTreinoController.incluir Erro ao chamar método: dao.incluir" +
			db.getMessage());
			db.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		
		abrirFormInclusao(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		Long idSolicitacaoTreino = Long.parseLong(request.getParameter("id_Solicitacao_Treino"));
		
		dao.excluir(idSolicitacaoTreino);
		request.setAttribute("msg", "Solicitação de Treino Excluida!");
		abrirFormInclusao(request, response);
	}		
	private void atzarSolicitacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idSolicitacaoTreino = Long.parseLong(request.getParameter("id_Solicitacao_Treino"));
		System.out.println("id solic = " + idSolicitacaoTreino);
		
		SolicitacaoTreino solicitacaoTreino = dao.buscarPorId(idSolicitacaoTreino);
		
		if (solicitacaoTreino.getStatusSolicTreino() == StatusSolicTreino.PENDENTE) {
			
				solicitacaoTreino.setStatusSolicTreino(StatusSolicTreino.PROCESSANDO);
		}else{
		if (solicitacaoTreino.getStatusSolicTreino() == StatusSolicTreino.PROCESSANDO)
			
				solicitacaoTreino.setStatusSolicTreino(StatusSolicTreino.FINALIZADA);
				EmailBO bo = new EmailBO();
				
				String mensagemCliente = "Olá " + solicitacaoTreino.getCliente().getNome() +
							" , sua solicitação de treino já foi atendida, acesso seu treino no VP Saúde!";
				
				try {
					bo.enviarEmail(solicitacaoTreino.getCliente().getEmail(),
							"Solicitação de Treino Atendida", mensagemCliente);
				} catch (EmailException e) {
				e.printStackTrace();
				}
		}
		
		dao.alterar(solicitacaoTreino);
		request.setAttribute("msg", "Status da Solicitação de Treino Alterado!");
	}
}