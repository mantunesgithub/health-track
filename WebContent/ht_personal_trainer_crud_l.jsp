<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt_BR">
<%@ include file="ht_crud_head_1.jsp" %>
 <body> 
	<%@ include file="ht_crud_header_1.jsp" %>
        <main class="container-fluid">
            <div class="row">
                <div class="col-8 container d-flex justify-content-center">
                    <div class><h4>Manutenção de Personal Trainer </h4></div>   
                </div>
                <div class="col-4 container d-flex justify-content-start">
                    <class="col">
                    <a href="./ht_menu01.jsp" class="btn btn-primary active btn-sm">Menu</a>
               		<a href="./ht_personal_trainer_crud_c.jsp" class="btn btn-primary active btn-sm">Cadastrar</a>
                </div>
            </div>
            <hr>
            <c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
            <div class=" form-group row " > 
            	<label for="id_modal" class="col-sm-0 col-form-label" >CPF</label> 
                <div class="col-sm-3"> <input type="text" name="modal" id="id_modal"  
                     class="form-control form-control-sm"> 
                </div>
            </div>
 					
            <table class="table table-striped table-sm ">
                <thead class="table-dark">
                    <tr>
                       <th>Cpf</th> 
                       <th>Nome</th>
                       <th>Email</th>
                       <th>DDD</th>
                       <th>Celular</th>
                       <th>Cref</th>
                       <th></th> 
                    </tr>
                </thead>
                <c:forEach items="${personal}" var="p">
                    <tr>
                        <td>${p.cpfPersonal}</td>
						<td>${p.nome}</td>
						<td>${p.email}</td>
						<td>${p.dddCelular}</td>
						<td>${p.numeroCelular}</td>
						<td>${p.cref}</td>
						<td>
							<c:url value="personal" var="link">
								<c:param name="acao" value="abrir-form-edicao"/>
								<c:param name="cpf_personal" value="${p.cpfPersonal}"/>
							</c:url>
							<a href="${link}" class="btn btn-primary btn-sm">Editar</a>
							<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" 
								data-target="#excluirModal" onclick="codigoExcluir.value = ${p.cpfPersonal}">
	  							Excluir
							</button>
						
						</td>
                    </tr>
                </c:forEach>
            </table>
       </main>
		<!-- Modal -->
		<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        		Deseja realmente excluir o Personal Trainer?
		      </div>
		      <div class="modal-footer">
		      	<form action="personal" method="post">
		      		<input type="hidden" name="acao" value="excluir">
		      		<input type="hidden" name="cpf_personal" id="codigoExcluir">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			        <button type="submit" class="btn btn-danger">Excluir</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>	
 		<%@ include file="ht_crud_footer_1.jsp" %>
    </body>
</html>