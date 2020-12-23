<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
 		<form action="solicitar-treino" method="post">
            	<input type="hidden" value="incluir" name="acao">

                <div class="row">
					<div class="col-sm-6 ">
						<label for="id_cliente">Cliente :</label>
		                <input type="text" name="cliente"  id="id_cliente" size="30" readonly="readonly"
		                 value="${clienteok.nome}">
		
						<label for="id_cpf_cliente">CPF </label>
		                <input type="text" name="cpf-cliente"  id="id_cpf_cliente" size="15" readonly="readonly"
		                 value="${clienteok.cdCPFCliente}">
		                 
                    </div>
		                    
                    <div class="col-3 ">
                        <div><h4>Solicitar Treino  </h4></div>   
                    </div>
 					<input type="submit" value="Salvar" class="btn btn-success active btn-sm ">
                </div>
                
                <hr>
                <div class="form-row"> 	
                 	<div class="col-sm-3 form-group">    
	                    <label for="id-modalidade">Modalidade</label>
	                    <select name="modalidade" id="id-modalidade" class="form-control">
	                        <option value="0">Selecione</option>
	                        <c:forEach items="${rqModalidades}" var="c">
	                            <option value="${c.codigoModalidade}" >${c.descricaoModalidade}</option>
	                        </c:forEach>
	                    </select>
                	</div>
	                <div class="col-sm-3 form-group">
	                    <label for="id_personal">Personal Trainer</label>
	                    <select name="personal" id="id_personal" class="form-control">
	                        <option value="0">Selecione</option>
	                        <c:forEach items="${rqPersonal}" var="c">
	                            <option value="${c.cpfPersonal}" >${c.nome}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	                
        		 </div>
	            <div class="form-row">   
                	<div class="col-sm-12 form-grupo">
                    <label for="id_objetivo">Objetivos desejados</label>
	                    <textarea name="objetivos" class="form-control" id="id_objetivo"
 	                   cols="50" rows="1" ></textarea>
	                </div>
	            </div>
                  
            	
		<hr>				
        <table class="table table-striped table-sm border border-dark ">
        		
                <thead class="table-dark">
                	<tr> <h4>Ultimas Solicitações </h4> </tr>
                    <tr>
                       <th>Id.</th> 
                       <th>Modalidade</th> 
                       <th>Data Solic.</th>
                       <th>Objetivos desejados</th>
                       <th>Status solic.</th>
                       <th>Personal Trainer</th> 
                       <th></th> 
                    </tr>
                </thead>
                <c:forEach items="${rqLsolicTreino}" var="p">
                    <tr>
						<td>${p.idSolicitacaoTreino}</td>
						<td>${p.modalidade.descricaoModalidade}</td>
						<td>			
							<fmt:formatDate value="${p.dataSolicitacao.time }" pattern="dd/MM/yyyy"/>
						</td>
						<td>${p.descObjetivoTreino}</td>
						<td>${p.statusSolicTreino}</td>
						<td>${p.personalTrainer.nome}</td>
						<td>
							<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" 
								data-target="#excluirModal" onclick="codigoExcluir.value = ${p.idSolicitacaoTreino}">
	  							Excluir
							</button>
						
							<c:url value="solicitar-treino" var="link">
								<c:param name="id_Solicitacao_Treino" value="${p.idSolicitacaoTreino}"/>
							</c:url>
						</td>
                    </tr>			
                </c:forEach>
            </table>
        </form>  	  
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
		        		Deseja realmente excluir a Solicitação de Treino?
		      </div>
		      <div class="modal-footer">
		      	<form action="solicitar-treino" method="post">
		      		<input type="hidden" name="acao" value="excluir">
		      		<input type="hidden" name="id_Solicitacao_Treino" id="codigoExcluir">
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