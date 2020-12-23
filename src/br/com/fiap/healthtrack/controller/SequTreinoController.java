package br.com.fiap.healthtrack.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.dao.SequAtividadeDAO;
import br.com.fiap.healthtrack.dao.SequenciaTreinoDAO;
import br.com.fiap.healthtrack.dao.SequenciaTreinoDAOImpl;
import br.com.fiap.healthtrack.dao.TreinoClienteDAO;
import br.com.fiap.healthtrack.entities.SequAtividade;
import br.com.fiap.healthtrack.entities.SequenciaTreino;
import br.com.fiap.healthtrack.entities.TreinoCliente;
import br.com.fiap.healthtrack.exception.DBException;
/**
 * Servlet implementation class TreinoController
 */
@WebServlet("/sequ-treino")
public class SequTreinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TreinoClienteDAO dao;
	private SequenciaTreinoDAO sequTreinoDao;
	private SequAtividadeDAO sequAtividadeDao;
	private TreinoController treinoController;

	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getTreinoClienteDAO();
		sequTreinoDao = DAOFactory.getSequenciaTreinoDAO();
		sequAtividadeDao = DAOFactory.getSequAtividadeDAO();
		treinoController = new TreinoController();
	}
	/**  =============    doGet    ===================
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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

		Long idTreino = Long.parseLong(request.getParameter("id_treino_2"));
		TreinoCliente treino = dao.buscarPorId(idTreino);
		request.setAttribute("rqIdTreino", treino);

		carregarListas(request);
		request.getRequestDispatcher("ht_sequ_treino_crud_create.jsp").forward(request, response);
		
	}
	private void carregarListas(HttpServletRequest request) {

		treinoController.verificarClienteSession(request);
		
		List<SequAtividade> listaSequAtiv = sequAtividadeDao.getAll(); 
		request.setAttribute("rqSequAtividades", listaSequAtiv);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			treinoController.verificarClienteSession(request);
	
			Long idTreino = Long.parseLong(request.getParameter("id_treino_edit"));
			
			TreinoCliente treino = dao.buscarPorId(idTreino);
			request.setAttribute("rqIdTreino", treino);
			
			List<SequAtividade> listaSequAtiv = sequAtividadeDao.getAll();
			request.setAttribute("rqSequAtividades", listaSequAtiv);
			
			Long idSequTreino = Long.parseLong(request.getParameter("id_sequ_treino"));
			
			System.out.println("sequ treino tela list= " + idSequTreino);
			SequenciaTreino sequenciaTreino = sequTreinoDao.buscarPorId(idSequTreino);
			request.setAttribute("rqSequTreino", sequenciaTreino);
			System.out.println(sequenciaTreino);
		
		}catch(DBException db) {
			System.out.println( "SequTreinoController.abrirFormEdicao Erro ao chamar método: buscarPorId" +
			db.getMessage());
			db.printStackTrace();
			request.setAttribute("erro", "Erro ler Tabela Sequencia Treino");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("ht_sequ_treino_crud_edit.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{	
			Long idTreino = Long.parseLong(request.getParameter("id_treino_2"));
			TreinoCliente treino = dao.buscarPorId(idTreino);
			request.setAttribute("rqIdTreino", treino);
			
			treinoController.verificarClienteSession(request);
			List<SequenciaTreino> listaSequenciaTreino = sequTreinoDao.getAll(idTreino);
			
			request.setAttribute("rqListaSequTreino", listaSequenciaTreino);
			
		}catch(DBException db) {
			System.out.println( "SequTreinoController.listar Erro ao chamar método: getAll" +
									db.getMessage());
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao ler dados na Tabela Sequencia Treino");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("ht_sequ_treino_crud_list.jsp").forward(request, response);
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
			Long idTreino = (Long.parseLong(request.getParameter("id_treino")));
			TreinoCliente treinoCliente = dao.buscarPorId(idTreino);
			
			Long idSequAtiv = (Long.parseLong(request.getParameter("sequ_atividade")));
			SequAtividade sequAtividade = sequAtividadeDao.buscarPorId(idSequAtiv);
			
			Integer qtSeries = (Integer.parseInt(request.getParameter("qt_series")));
			Integer qtRepeticoes = (Integer.parseInt(request.getParameter("qt_repet")));
			Double  pesoCarga = (Double.parseDouble(request.getParameter("qt_carga")));
			String  metodo = (request.getParameter("desc_metodo"));
			String  descAtiv = (request.getParameter("desc_ativ"));
			Double  intervalo = (Double.parseDouble(request.getParameter("qt_intervalo")));
			Double  velocidade = (Double.parseDouble(request.getParameter("qt_veloc")));
			String  frequCardio = (request.getParameter("frequ_cardio"));
			Double  intensidade = (Double.parseDouble(request.getParameter("qt_intensidade")));
			Double  duracao = (Double.parseDouble(request.getParameter("qt_duracao")));
			Double  tempoMedio = (Double.parseDouble(request.getParameter("qt_tempo_medio")));
			
			
			SequenciaTreino sequenciaTreino = new SequenciaTreino(0l, descAtiv,
					qtSeries,qtRepeticoes,pesoCarga,frequCardio,tempoMedio,velocidade,intensidade,
					duracao,intervalo, metodo);
			
			sequenciaTreino.setTreinoCliente(treinoCliente);
			sequenciaTreino.setSequAtiv(sequAtividade);
			
			sequTreinoDao.incluir(sequenciaTreino);
			
			/*		Reenviar tela 
			 * 		==============
			 */
			request.setAttribute("msg", "Treino incluido!");
			request.setAttribute("rqIdTreino", treinoCliente);
			carregarListas(request);
			
		}catch(DBException db) {
			System.out.println( "SequTreinoController.Incluir Erro ao chamar método: incluir" +
									db.getMessage());
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao incluir dados na Tabela Sequencia Treino");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("ht_sequ_treino_crud_create.jsp").forward(request, response);
	}
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idTreino = (Long.parseLong(request.getParameter("id_treino")));
			TreinoCliente treinoCliente = dao.buscarPorId(idTreino);
			
			Long idSequAtiv = (Long.parseLong(request.getParameter("sequ_atividade")));
			SequAtividade sequAtividade = sequAtividadeDao.buscarPorId(idSequAtiv);
			
			Long    idSequTreino = (Long.parseLong(request.getParameter("sequ_Treino")));
			String  descAtiv = (request.getParameter("desc_atividade"));
			Integer qtSeries = (Integer.parseInt(request.getParameter("qt_series")));
			Integer qtRepeticoes = (Integer.parseInt(request.getParameter("qt_repet")));
			Double  pesoCarga = (Double.parseDouble(request.getParameter("qt_carga")));
			String  metodo = (request.getParameter("desc_metodo"));
			Double  intervalo = (Double.parseDouble(request.getParameter("qt_intervalo")));
			Double  velocidade = (Double.parseDouble(request.getParameter("qt_veloc")));
			String  frequCardio = (request.getParameter("frequ_cardio"));
			Double  intensidade = (Double.parseDouble(request.getParameter("qt_intensidade")));
			Double  duracao = (Double.parseDouble(request.getParameter("qt_duracao")));
			Double  tempoMedio = (Double.parseDouble(request.getParameter("qt_tempo_medio")));
			
			
			SequenciaTreino sequenciaTreino = new SequenciaTreino(idSequTreino, descAtiv,
					qtSeries,qtRepeticoes,pesoCarga,frequCardio,tempoMedio,velocidade,intensidade,
					duracao,intervalo, metodo);
			
			sequenciaTreino.setTreinoCliente(treinoCliente);
			sequenciaTreino.setSequAtiv(sequAtividade);

			sequTreinoDao.alterar(sequenciaTreino);
			/*		Reenviar tela 
			 * 		==============
			 */
			request.setAttribute("msg", "Sequência de Treino editada!");
			request.setAttribute("rqIdTreino", treinoCliente);
			request.setAttribute("rqSequTreino", sequenciaTreino);
			carregarListas(request);
			
			request.getRequestDispatcher("ht_sequ_treino_crud_edit.jsp").forward(request, response);

		}catch(DBException db) {
			System.out.println( "SequTreinoController.editar Erro ao chamar metodo: alterar " +
									db.getMessage());
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao alterar dados na Tabela Sequencia Treino");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		Long idTreino = Long.parseLong(request.getParameter("id_treino"));
		
		dao.excluir(idTreino);
		request.setAttribute("msg", "Treino removido!");
		listar(request,response);
	}		
}	