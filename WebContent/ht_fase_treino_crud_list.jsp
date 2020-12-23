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
                    <div class><h4>Atualizar Fase de Treino</h4></div>   
                </div>
                <div class="col-4 container d-flex justify-content-start">
                    <class="col">
                    <a href="./ht_menu01.jsp" class="btn btn-primary active btn-sm">Menu</a>
               		<a href="fase-treino?acao=abrir-form-inclusao" class="btn btn-primary active btn-sm">Cadastrar</a>
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
            	<label for="id_modal" class="col-sm-0 col-form-label" >Id.</label> 
                <div class="col-sm-3"> <input type="text" name="modal" id="id_modal"  
                     class="form-control form-control-sm"> 
                </div>
            </div>
 					
            <table class="table table-striped table-sm ">
                <thead class="table-dark">
                    <tr>
                       <th>Id</th> 
                       <th>Cod Fase Treino</th>
                       <th>Tipo Treino</th>
                       <th>Descrição Tipo Treino</th>
                       <th>Descrição Objetivos</th>
                       <th>Modalidade</th> 
                       <th></th> 
                    </tr>
                </thead>
                <c:forEach items="${rqListaFaseTreino}" var="p">
                    <tr>
                        <td>${p.idFaseTreino}</td>
                        <td>${p.cdFaseTreino}</td>
						<td>${p.tpFaseTreino}</td>
						<td>${p.dsTipoTreino}</td>
						<td>${p.dsObjetivoTreino}</td>
						<td>${p.modalidade.descricaoModalidade}</td>
						<td>
							<c:url value="fase-treino" var="link">
								<c:param name="acao" value="abrir-form-edicao"/>
								<c:param name="id_fase_treino" value="${p.idFaseTreino}"/>
							</c:url>
							<a href="${link}" class="btn btn-primary btn-sm">Editar</a>
							<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" 
								data-target="#excluirModal" onclick="codigoExcluir.value = ${p.idFaseTreino}">
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
		        		Deseja realmente excluir Fase de Treino?
		      </div>
		      <div class="modal-footer">
		      	<form action="fase-treino" method="post">
		      		<input type="hidden" name="acao" value="excluir">
		      		<input type="hidden" name="id_fase_treino" id="codigoExcluir">
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