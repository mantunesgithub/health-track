<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt_BR">
<%@ include file="ht_crud_head_1.jsp" %>
     <body> 
    <header>
        <nav class="navbar narvbar-light  navbar-expand-lg">
            <img src="resources/ht_assets/css/ht_imagens/ht_vp_saude_icon01.png" alt="VP Saúde">
            
            <button type="button" class="navbar-toggler" data-toggle="collapse"
                        data-target="#navbar">
                <span class="navbar-toggler-icon"></span>
            </button>
    	</nav>
    <header>
     
  <main class="container-fluid ">
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	
    <form action="login" method="post">
     	<input type="hidden" value="incluir" name="acao">
         <div class="row">
             <div class="col-7 container d-flex justify-content-center">
                 <h4>Cadastro Simples para Login no sistema </h4>   
             </div>
             <div class="col-5 container d-flex justify-content-start">
                 
               	<div class="col">
                 	<a href="./ht_portal_02.jsp" class="btn btn-primary
                 	  btn-sm">Login</a>
             	</div>
             </div>	
         </div>    
         <hr>
         
       <div class="form-row"> 	
          <div class="col-sm-4 form-group">    
	            <label for="id_senha">Senha</label>
	            <input type="password" name="senha" id="id_senha"
	             		placeholder="Cadastre uma Senha" class="form-control">
       	  </div>
          <div class="col-sm-4 form-group">    
	            <label for="id_senha_ant">Senha</label>
	            <input type="password" name="senha_ant" id="id_senha_ant"
	             		placeholder="Repetir a Senha" class="form-control">
       	 </div>
      </div>
      <div class="form-row"> 	
          <div class="col-sm-2 form-group">    
               <label for="id_cpf_cliente">CPF</label>
               <input type="number" name="cpf_cliente" id="id_cpf_cliente" class="form-control">
          </div>
          <div class="col-sm-3 form-group">    
               <label for="id_nome_cliente">Nome</label>
               <input type="text" name="nome_cliente" id="id_nome_cliente" class="form-control">
          </div>
          <div class="col-sm-3 form-group">    
               <label for="id_email_cliente">Email</label>
               <input type="email" name="email_cliente" id="id_email_cliente" class="form-control">
          </div>
      </div>
      <div class="form-row"> 	
          <div class="col-sm-2 form-group">    
				<label for="id_dt_nasc">Data Nascimento</label>
				<input type="text" name="data_nasc" id="id_dt_nasc" class="form-control">
		  </div> 
          <div class="col-sm-3 form-group">    
               <label for="id_ddd_cliente">(DDD)</label>
               <input type="number" name="ddd_cliente" id="id_ddd_cliente" class="form-control">
    	  </div>
          <div class="col-sm-3 form-group">    
               <label for="id_celular_cliente">Celular</label>
               <input type="number" name="celular_cliente" id="id_celular_cliente" class="form-control">
          </div>
       </div>
	 <div class="form-row"> 	
          <div class="col-sm-8 form-group">  	
           	<input type="submit" value="Cadastrar" class="btn btn-success active btn-sm btn-block">
	      </div>
     </div>
    </form>
    </main>
       	<%@ include file="ht_crud_footer_1.jsp" %> 
    </body>
</html>
