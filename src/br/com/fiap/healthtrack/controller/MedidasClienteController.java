package br.com.fiap.healthtrack.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import br.com.fiap.healthtrack.dao.ModalidadeDAOImpl;
import br.com.fiap.healthtrack.dao.PersonalTrainerDAOImpl;
import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.MedidaCliente;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.TreinoCliente;
import br.com.fiap.healthtrack.entities.enums.StatusSolicTreino;
import br.com.fiap.healthtrack.exception.DBException;
/**
 * Servlet implementation class TreinoController
 */
import br.com.fiap.healthtrack.exception.EmailException;
@WebServlet("/medidas-cliente")
public class MedidasClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MedidaClienteDAO medidaClienteDAO;
	@Override
	public void init() throws ServletException {
		super.init();
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
		case "abrir-form-detalhe":
			abrirFormDetalhe(request, response);
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
		request.getRequestDispatcher("ht_medidas_cliente_crud_list.jsp").forward(request, response);
		
	}
	private void carregarListas(HttpServletRequest request) {
	try {
		HttpSession session = request.getSession();
		Cliente clienteLogin = (Cliente) session.getAttribute("clienteok");
		Long cpfClienteLogin = clienteLogin.getCdCPFCliente();
		List<MedidaCliente> listaMedidaCliente = medidaClienteDAO.getAll(cpfClienteLogin); 
		
		request.setAttribute("rqLmedidaCliente", listaMedidaCliente);
		
	}catch(DBException db) {
		System.out.println( "MedidaClienteController.Erro ao chamar medidaClienteDAO.getAll" +
		db.getMessage());
		db.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
		request.setAttribute("erro","Por favor, valide os dados");}
	}
	
	private void abrirFormDetalhe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	try {
		
		Integer idMedidaCliente = Integer.parseInt(request.getParameter("id_medida_cliente_dt"));
		
		MedidaCliente medidaCliente =  medidaClienteDAO.buscarPorId(idMedidaCliente);
		request.setAttribute("msg", "Medidas do Cliente");
		request.setAttribute("rqIdMedidaCliente", medidaCliente);
		request.getRequestDispatcher("ht_medidas_cliente_crud_deta.jsp").forward(request, response);
		
	}catch(DBException db) {
		System.out.println( "MedidaClienteController.Erro ao chamar medidaClienteDAO.buscaId" +
		db.getMessage());
		db.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
		request.setAttribute("erro","Por favor, valide os dados");}
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

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dtMedicao = Calendar.getInstance();
			dtMedicao.setTime(format.parse(request.getParameter("data_medida")));
			Double vlPeso = (Double.parseDouble(request.getParameter("peso"))); 
			Double vlAltura = (Double.parseDouble(request.getParameter("altura"))); 
			String vlPressao = (request.getParameter("pressao"));
			Double qtCalConsDia = (Double.parseDouble(request.getParameter("calorias"))); 
			Double vlCoefCalculo = (0.0); 
			Double vlfreqCardiaca = (Double.parseDouble(request.getParameter("freqCardiaca"))); 
			Double vlMedidaPescoco = (Double.parseDouble(request.getParameter("pescoco"))); 
			Double vlMedidaAnteBraco = (Double.parseDouble(request.getParameter("ante_braco"))); 
			Double vlMedidaPeito = (Double.parseDouble(request.getParameter("peito"))); 
			Double vlMedidaCintura = (Double.parseDouble(request.getParameter("cintura"))); 
			Double vlMedidaQuadris = (Double.parseDouble(request.getParameter("quadris"))); 
			Double vlMedidaCoxas = (Double.parseDouble(request.getParameter("coxa"))); 
			Double vlMedidaPanturrilha = (Double.parseDouble(request.getParameter("paturrilha"))); 
			Double idFatorAtividade = (0.0); 
			Double vlIMCCalculado = (0.0); 
			Double vlTMBCalculado = (0.0); 
			Double vlGastoEnergReal = (0.0); 
			String dsObservacao = (request.getParameter("observacoes"));
			Long cpfCliente = (Long.parseLong(request.getParameter("cpf-cliente"))); 
	

			MedidaCliente medidaCliente = new MedidaCliente(0, dtMedicao, vlPeso, vlAltura, vlPressao,
					qtCalConsDia, vlCoefCalculo, vlfreqCardiaca, vlMedidaPescoco, vlMedidaAnteBraco,
					vlMedidaPeito, vlMedidaCintura, vlMedidaQuadris,vlMedidaCoxas, vlMedidaPanturrilha, idFatorAtividade,
					vlGastoEnergReal,vlIMCCalculado, vlTMBCalculado, dsObservacao, cpfCliente);

				
			medidaClienteDAO.incluir(medidaCliente);
			
			request.setAttribute("msg", "Medidas do Cliente incluido!");
			
		}catch(DBException db) {
			System.out.println( "MedidaClienteController.incluir Erro ao chamar método:medidaClienteDAO.incluir" +
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
	try {
		Integer idMedidaCliente = Integer.parseInt(request.getParameter("id_medida_cliente_ex"));
		
		medidaClienteDAO.excluir(idMedidaCliente);
		request.setAttribute("msg", "Medidas do Cliente Excluida!");
		abrirFormInclusao(request, response);
		
	}catch(DBException db) {
		System.out.println( "MedidaClienteController.excluir Erro ao chamar método:medidaClienteDAO.excluir" +
		db.getMessage());
		db.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
		request.setAttribute("erro","Por favor, valide os dados");}
	} 
}