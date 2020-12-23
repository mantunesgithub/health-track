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
				<div class="col-3">
             	      <div><h4>Atualizar Sequência Treino</h4></div>   
			    </div>
                <div class="col-3 ">
			        <a href="treino?acao=listar" class="btn btn-primary active btn-sm">Trocar Treino</a>
            	
            		<c:url value="sequ-treino" var="link">
						<c:param name="acao" value="abrir-form-inclusao"/>
						<c:param name="id_treino_2" value="${rqIdTreino.idTreino}"/>
					</c:url>
					<a href="${link}" class="btn btn-primary active btn-sm">Cadastrar</a>
                </div>
          </div>
            <c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
			
	        <div class="form-row">
                <div class="col-sm-1 form-grupo">
	                 <label for="id_tr">Id.Treino</label>
	                 <input type="text" name="id_treino" class="form-control" id="id_tr"
	                 value="${rqIdTreino.idTreino}">	
                </div>   		        
                <div class="col-sm-2 form-grupo">
                   <label for="id-modalidade">Modalidade</label>
	               <input type="text" name="modalidade" class="form-control" id="id_modalidade"
	               value="${rqIdTreino.modalidade.descricaoModalidade}">	
                </div>   		        
                <div class="col-sm-1 form-grupo">
                   <label for="id-cdFaseTreino">Fase</label>
	               <input type="text" name="cdFaseTreino" class="form-control" id="id_cdFaseTreino"
	               value="${rqIdTreino.faseTreino.cdFaseTreino}">	
                </div>   		        
                <div class="col-sm-3 form-grupo">
                   <label for="id-dsTipoTreino">Descrição Tipo Treino</label>
	               <input type="text" name="dsTipoTreino" class="form-control" id="id_dsTipoTreino"
	               value="${rqIdTreino.faseTreino.dsTipoTreino}">	
                </div>   		        
                <div class="col-sm-3 form-grupo">
                   <label for="id-diasDaSemana">Dia da Semana</label>
	               <input type="text" name="diasDaSemana" class="form-control" id="id_diasDaSemana"
	               value="${rqIdTreino.diasDaSemana}">
                </div>   		        
            </div>   		        
            <hr>
            <table class="table table-striped table-sm border border-dark ">
                <thead class="table-dark">
                    <tr>
                       <th>Id</th> 
                       <th>Atividade</th> 
                       <th>Qtd Séries</th>
                       <th>Qtd Repetições</th>
                       <th>Qtd Carga</th>
                       <th>Intervalo</th>
                       <th>Método</th>
                       <th>Objetivo </th> 
                       <th></th><th></th> 
                    </tr>
                </thead>
                <c:forEach items="${rqListaSequTreino}" var="s">
                    <tr>
						<td>${s.idSequTreino}</td>
						<td>${s.sequAtiv.descSequAtiv}</td>
                        <td>${s.qtdeSeries}</td>
                        <td>${s.qtdeRepeticoes}</td>
                        <td>${s.pesoDaCarga}</td>
						<td>${s.qtdeTempoDescanso}</td>
						<td>${s.descMetodo}</td>
						<td>${s.descAtividade}</td>
						<td>
							<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" 
								data-target="#excluirModal" onclick="codigoExcluir.value = ${s.idSequTreino}">
	  							Excluir
							</button>

							<c:url value="sequ-treino" var="link">
								<c:param name="id_sequ_treino" value="${s.idSequTreino}"/>
								<c:param name="acao" value="abrir-form-edicao"/>
							
								<c:param name="id_treino_edit" value="${rqIdTreino.idTreino}"/>
							</c:url>
							<a href="${link}" class="btn btn-primary btn-sm">Editar</a>
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
		        		Deseja realmente excluir a Sequência Atividade?
		      </div>
		      <div class="modal-footer">
		      	<form action="sequ-treino" method="post">
		      		<input type="hidden" name="acao" value="excluir">
		      		<input type="hidden" name="id_sequ_treino" id="codigoExcluir">
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