<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt_BR">

 <body> 
	<%@ include file="ht_crud_header_1.jsp" %>
   	<main class="container-fluid">

		<div class="row " >
			<div class="col-sm-5 ">
				 
				<label for="id_cliente">Cliente :</label>
	               <input type="text" name="cliente"  id="id_cliente" size="30" readonly="readonly"
	                value="${rqClienteSS.nome}">
	
				<label for="id_cpf_cliente">CPF </label>
	               <input type="text" name="cpf-cliente"  id="id_cpf_cliente" size="15" readonly="readonly"
	                value="${rqClienteSS.cdCPFCliente}">
	                 </div>
               <div class="col-4">
                   <div><h4>Personal Trainer - Cadastrar treino cliente</h4></div>   
               </div>
               <div class="col-2">
                   <a href="treino?acao=abrir-form-cliente" 
                      class="btn btn-primary active btn-sm">Clientes</a>  
               </div>
	    </div>
		     <hr>      
			<h5>Cadastrar Treinos do Cliente</h5>
			<ul class="nav nav-tabs ">
			  <li class="nav-item">
			    <a class="nav-link active btn-sm" href="solicitar-treino?acao=abrir-form-analise-perfil">Analisar solicitação/perfil </a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link btn-sm" href="treino?acao=abrir-form-inclusao">Cadastrar Treino</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="treino?acao=listar">Atualizar Treino</a>
			  </li>
			</ul>
     		<hr>
			<h5>Cadastrar Fases e Tipos de Treino</h5>
			<ul class="nav flex-column">
			  <li class="nav-item">
			    <a class="nav-link active btn-sm" href="sequ-atividade?acao=abrir-form-inclusao">Cadastrar Sequência</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link " href="sequ-atividade?acao=listar">Atualizar Sequência</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="fase-treino?acao=abrir-form-inclusao">Cadastrar Fase Treino</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link " href="fase-treino?acao=listar">Atualizar Fase Treino</a>
			  </li>
			</ul>
			  <hr>
     		<br>
  </main>  	
		<%@ include file="ht_crud_footer_1.jsp" %>
    </body>
</html>