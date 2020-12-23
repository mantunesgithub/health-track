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
				<div class="col-sm-6 ">
					<label for="id_cliente">Cliente :</label>
				    <input type="text" name="cliente"  id="id_cliente" size="30" readonly="readonly"
		                 value="${rqClienteSS.nome}">
					<label for="id_cpf_cliente">CPF </label>
					<input type="text" name="cpf-cliente"  id="id_cpf_cliente" size="15" readonly="readonly"
		                  value="${rqClienteSS.cdCPFCliente}">
				</div>
				<div class="col-3 ">
             	      <div><h4>Grupo Treino Cadastrados</h4></div>   
			    </div>
                <div class="col-3 ">
			          <a href="treino?acao=abrir-form-inclusao" class="btn btn-primary active btn-sm">Cadastrar</a>
			          <a href="treino?acao=abrir-form-cliente" class="btn btn-primary active btn-sm">Trocar Cliente</a>
                </div>
            </div>
            <hr>
            <c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
 					
            <table class="table table-striped table-sm border border-dark ">
                <thead class="table-dark">
                    <tr>
                        <th>Modalidade</th> 
                        <th>Id.</th>
                        <th>Objetivos</th>
                        <th>Fase</th> 
                        <th>Descrição Treino</th>
                        <th>Personal Trainer</th> 
                        <th>Dia Semana</th> 
                      <th></th> 
                    </tr>
                </thead>
                <c:forEach items="${rqListaTreino}" var="p">
                    <tr>
						<td>${p.modalidade.descricaoModalidade}</td>
						<td>${p.idTreino}</td>
						<td>${p.descObjetivoTreino}</td>
                        <td>${p.faseTreino.cdFaseTreino}</td>
						<td>${p.faseTreino.dsTipoTreino}</td>
						<td>${p.personalTrainer.nome}</td>
						<td>${p.diasDaSemana}</td>
						<td>
							<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" 
								data-target="#excluirModal" onclick="codigoExcluir.value = ${p.idTreino}">
	  							Excluir
							</button>
						
							<c:url value="treino" var="link">
								<c:param name="acao" value="abrir-form-edicao"/>
								<c:param name="id_treino" value="${p.idTreino}"/>
							</c:url>
							<a href="${link}" class="btn btn-primary btn-sm">Editar</a>
						
							<c:url value="sequ-treino" var="link">
								<c:param name="acao" value="listar"/>
								<c:param name="id_treino_2" value="${p.idTreino}"/>
							</c:url>
							<a href="${link}" class="btn btn-success active btn-sm">Abrir</a>
													
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
		        		Deseja realmente excluir o Treino do Cliente?
		      </div>
		      <div class="modal-footer">
		      	<form action="treino" method="post">
		      		<input type="hidden" name="acao" value="excluir">
		      		<input type="hidden" name="id_treino" id="codigoExcluir">
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