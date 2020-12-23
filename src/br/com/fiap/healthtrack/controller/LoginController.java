package br.com.fiap.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.bo.EmailBO;
import br.com.fiap.healthtrack.dao.ClienteDAO;
import br.com.fiap.healthtrack.dao.DAOFactory;
import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.enums.StatusCliente;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.exception.EmailException;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO dao;
	private EmailBO bo;
  
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getClienteDAO();
		bo = new EmailBO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "login":
			login(request, response);
			break;
		case "incluir":
			cadastroNovo(request,response);
			break;
		}
	}	
	private void cadastroNovo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Cliente cliente = new Cliente();
			cliente.setCdCPFCliente(Long.parseLong(request.getParameter("cpf_cliente")));
			cliente.setNome(request.getParameter("nome_cliente"));
			cliente.setEmail(request.getParameter("email_cliente"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataNasc = Calendar.getInstance();
			dataNasc.setTime(sdf.parse(request.getParameter("data_nasc")));
			cliente.setDataNascimento(dataNasc);
			cliente.setDdiCelular(55);
			cliente.setDddCelular(Integer.parseInt(request.getParameter("ddd_cliente")));
			cliente.setNumeroCelular(Integer.parseInt(request.getParameter("celular_cliente")));
			cliente.setSenhaAtual(request.getParameter("senha"));
			cliente.setStatusCliente(StatusCliente.ATIVO);
			cliente.setRg(13402621);
			cliente.setEndereco("teste");
			cliente.setNumero(1);
			cliente.setComplemento("teste");
			cliente.setBairro("teste");
			cliente.setCidade("teste");
			cliente.setUf("te");
			cliente.setPais("teste");
			cliente.setCepPrefixo(1);
			cliente.setCepSufixo(1);
			cliente.setProfissao("teste");
			cliente.setSenhaAnterior(request.getParameter("senha_ant"));
			cliente.setTentativasErro(1);
			cliente.setDataAlteracao(Calendar.getInstance());
			cliente.setDataInclusao(Calendar.getInstance());
			
			String senhaAtual = request.getParameter("senha");
			String senhaAnt = request.getParameter("senha_ant");
			if  (senhaAtual.equals(senhaAnt)) {
				dao.incluir(cliente);
				request.setAttribute("msg", "Cadastrado efetuado!");
			}else {
				request.setAttribute("erro", "Erro, Senhas diferentes!");
			}
		}catch(DBException db) {
			System.out.println( "cadastroNovo. Erro ao chamar método: incluir" +
			db.getMessage());
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao incluir Tabela Cliente");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("ht_cliente_crud_c.jsp").forward(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Cliente clienteSenha = new Cliente(email, senha);
	    Cliente clienteLogin = dao.validarCliente(clienteSenha);
		if (clienteLogin != null)  {
				HttpSession session = request.getSession();
				session.setAttribute("user", email);
				session.setAttribute("clienteok", clienteLogin);
				String mensagem = "Um login foi realizado";
				try {
					bo.enviarEmail(email, "Login Realizado", mensagem);
				} catch (EmailException e) {
				e.printStackTrace();
				}
		}else {
			request.setAttribute("erro", "Cliente e/ou senha inválidos+");
			request.getRequestDispatcher("./ht_portal.jsp").forward(request, response);
		}
		request.getRequestDispatcher("./ht_menu.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
//		request.getRequestDispatcher("home.jsp").forward(request, response);
		request.getRequestDispatcher("./ht_portal.jsp").forward(request, response);
	}
}



