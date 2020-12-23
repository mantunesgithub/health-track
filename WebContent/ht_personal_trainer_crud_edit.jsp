<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt_BR">
<%@ include file="ht_crud_head_1.jsp" %>
     <body> 
		<%@ include file="ht_crud_header_1.jsp" %>
        <main class="container-fluid">
      	
       		<c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
    	
            <form action="personal" method="post">
            	<input type="hidden" value="editar" name="acao">
            	<input type="hidden" value="${personal.cpfPersonal}" name="cpf_personal">
                <div class="row">
                    <div class="col-7 container d-flex justify-content-center">
                        <h4>Edição de Personal Trainer</h4>  
                    </div>
                 
                    <div class="col-5 container d-flex justify-content-start">
                        
                        <div class="col">
                        	<a href="./ht_menu01.jsp" class="btn btn-primary  btn-sm">menu</a>
                        	<a href="personal?acao=listar" class="btn btn-primary  btn-sm">listar</a>
                        </div>        
                    </div>
                </div>   
                <hr> 
               	<div class="form-group">
                   <label for="id_nome_personal">Nome</label>
                   <input type="text" name="nome_personal" id="id_nome_personal" class="form-control"
               	   value="${personal.nome}">	
               	</div>
                <div class="form-group">
                   <label for="id_email_personal">Email</label>
                   <input type="email" name="email_personal" id="id_email_personal" class="form-control"
               	   value="${personal.email}">	
               	</div>
                <div class="form-group">
                   <label for="id_ddd_personal">Celular(ddd)</label>
                   <input type="number" name="ddd_personal" id="id_ddd_personal" class="form-control"
               	   value="${personal.dddCelular}">	
               	</div>
                <div class="form-group">
                   <label for="id_celular_personal">Celular</label>
                   <input type="number" name="celular_personal" id="id_celular_personal" class="form-control"
               	   value="${personal.numeroCelular}">	
               	</div>
                <div class="form-group">
                   <label for="id_cref_personal">Cref</label>
                   <input type="text" name="cref_personal" id="id_cref_personal" class="form-control"
               	   value="${personal.cref}">	
               	</div>
               	<input type="submit" value="Salvar" class="btn btn-success active btn-sm">
               	<a href="personal?acao=listar" class="btn btn-danger btn-sm">Cancelar</a>
            </form>
        </main>
       	<%@ include file="ht_crud_footer_1.jsp" %> 
    </body>
</html>