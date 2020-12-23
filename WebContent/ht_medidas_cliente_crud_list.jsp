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
 		<form action="medidas-cliente" method="post">
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
                        <div><h4>Cadastrar Minhas Medidas</h4></div>   
                    </div>
                    <div class="col-2 ">
                          <input type="submit" value="Salvar" class="btn btn-success active btn-sm ">
                    </div>
                </div>
                <hr>
                <div><h4>Medidas Básicas</h4></div>   
	            <div class="form-row"> 
	                <div class="col-sm-2 form-grupo">
	                    <label for="id_data_medida">Data Medida</label>
	                    <input type="text" name="data_medida" class="form-control" id="id_data_medida"
	                    placeholder="dd/mm/aaaa">
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_peso">Peso</label>
	                    <input type="number" name="peso" class="form-control" id="id_peso"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_altura">Altura</label>
	                    <input type="number" name="altura" class="form-control" id="id_altura"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_calorias">Calorias/dia</label>
	                    <input type="number" name="calorias" class="form-control" id="id_calorias"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_freqCardiaca">Frequ.Cardíaca</label>
	                    <input type="number" name="freqCardiaca" class="form-control" id="id_freqCardiaca"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_pressao">Pressão</label>
	                    <input type="text" name="pressao" class="form-control" id="id_pressao">
	                </div>
	            </div>
	            </div>
                <div><h4>Outras Medidas</h4></div>   
	            <div class="form-row"> 
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_pescoco">Pescoço</label>
	                    <input type="number" name="pescoco" class="form-control" id="id_pescoco"
	                    value=0.00>
	                </div>
                	<div class="col-sm-1 form-grupo">
	                    <label for="id_ante_braco">Ante-Braço</label>
	                    <input type="number" name="ante_braco" class="form-control" id="id_ante_braco"
	                    value=0.00>
                	</div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_peito">Peito</label>
	                    <input type="number" name="peito" class="form-control" id="id_peito"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_cintura">Cintura</label>
	                    <input type="number" name="cintura" class="form-control" id="id_cintura"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_quadris">Quadris</label>
	                    <input type="number" name="quadris" class="form-control" id="id_quadris"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_coxa">Coxa</label>
	                    <input type="number" name="coxa" class="form-control" id="id_coxa"
	                    value=0.00>
	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_paturrilha">Panturrilha</label>
	                    <input type="number" name="paturrilha" class="form-control" id="id_paturrilha"
	                    value=0.00>
	                </div>
	            </div>
	            <div class="form-row">   
                	<div class="col-sm-12 form-grupo">
                    <label for="id_observacoes">Observações</label>
	                    <textarea name="observacoes" class="form-control" id="id_observacoes"
 	                   cols="100" rows="1" ></textarea>
	                </div>
	             </div>
		</form>  
		<hr> 
        <table class="table table-striped table-sm border border-dark ">
        		
                <thead class="table-dark">
                	<tr> <h4>Últimas Medidas </h4> </tr>
                    <tr>
                       <th>Id.</th> 
                       <th>Data Medida</th>
                       <th>Peso</th>
                       <th>Pressão</th>
                       <th>Calorias/dia</th>
                       <th>IMC</th>
                       <th></th><th></th>
                    </tr>
                </thead>
                <c:forEach items="${rqLmedidaCliente}" var="p">
                    <tr>
						<td>${p.idMedidaCliente}</td>
						<td>			
							<fmt:formatDate value="${p.dtMedicao.time }" pattern="dd/MM/yyyy"/>
						</td>
						<td>${p.vlPeso}</td>
						<td>${p.vlPressao}</td>
						<td>${p.qtCalConsDia}</td>
						<td>${p.vlIMCCalculado}</td>
						<td>
							<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" 
								data-target="#excluirModal" onclick="codigoExcluir.value = ${p.idMedidaCliente}">
	  							Excluir
							</button>

							<c:url value="medidas-cliente" var="link">
								<c:param name="acao" value="abrir-form-detalhe"/>
								<c:param name="id_medida_cliente_dt" value="${p.idMedidaCliente}"/>
							</c:url>
							<a href="${link}" class="btn btn-success active btn-sm">Detalhes</a>
						
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
		        		Deseja realmente excluir estas Medidas ?
		      </div>
		      <div class="modal-footer">
		      	<form action="medidas-cliente" method="post">
		      		<input type="hidden" name="acao" value="excluir">
		      		<input type="hidden" name="id_medida_cliente_ex" id="codigoExcluir">
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