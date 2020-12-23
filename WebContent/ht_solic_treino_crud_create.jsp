<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
    	
		<form action="treino" method="post">
            	<input type="hidden" value="incluir" name="acao">

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
                        <div><h4> Cadastrar Treino </h4></div>   
                    </div>
                    <div class="col-2 ">
                          <a href="treino?acao=listar" class="btn btn-primary btn-sm">listar</a>
                    </div>
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
	                <div class="col-sm-5 form-group">    
	                    <label for="id_fase_treino">Fase e Tipo de Treino</label>
	                    <select name="fase_treino" id="id_fase_treino" class="form-control">
	                        <option value="0">Selecione</option>
		                        <c:forEach items="${rqFaseTreinos}" var="c">
		                            <option value="${c.idFaseTreino}" >${c.modalidade.descricaoModalidade} 
		                            / Fase: ${c.cdFaseTreino}  
		                            	/ ${c.dsTipoTreino} </option>
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
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_data_inicio">Data Inicio</label>
	                    <input type="text" name="data_inicio" class="form-control" id="id_data_inicio">
	                </div>
                	<div class="col-sm-3 form-grupo">
	                    <label for="id_data_final">Data Final</label>
	                    <input type="text" name="data_final" class="form-control" id="id_data_final">
                	</div>
                	<div class="col-sm-4 form-grupo">
	                    <label for="id_status">Dia da Semana</label>
	                    <select name="dia_semana" id="id_dia_semana"
	                        class="form-control">
	                            <option value="0">Selecione</option>
	                            <option value="2">segunda-feira</option>
	                            <option value="3">terça-feira</option>
	                            <option value="4">quarta-feira</option>
	                            <option value="5">quinta-feira</option>
	                            <option value="6">sexta-feria</option>
	                            <option value="7">sabado</option>
	                            <option value="1">domingo</option> 
	                    </select>    
                	</div>
            	</div>
            	<div class="form-row">   
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_qt_vol_semana">Qtd. volume semanal</label>
	                    <input type="number" name="qt_vol_semana" class="form-control" id="id_qt_vol_semana">
	                </div>
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_qt_vol_sessao">Qtd. volume sessão</label>
	                    <input type="number" name="qt_vol_sessao" class="form-control" id="id_qt_vol_sessao">
	                </div>
	                <div class="col-sm-4 form-grupo">
	                    <label for="id_status">Status</label>
	                    <select name="status" id="id_status"
	                        class="form-control">
	                            <option value="1">Ativo</option> 
	                            <option value="2">Inativo</option>
	                    </select>    
	                </div>
            	</div>
	            <div class="form-row">   
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_local_treino">Local do treinamento</label>
	                    <input type="text" name="local_treino" class="form-control" id="id_local_treino">
	                </div>
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_traje_treino">Traje do treino</label>
	                    <input type="text" name="traje_treino" class="form-control" id="id_traje_treino">
	                </div>
	                <div class="col-sm-4 form-grupo">
	                    <label for="id_assessorio">Assessórios</label>
	                    <input type="text" name="assessorio" class="form-control" id="id_assessorio">
	                           
	                </div>
	            </div>
	            <div class="form-row">   
                	<div class="col-sm-7 form-grupo">
                    <label for="id_objetivo">Objetivo do treino</label>
	                    <textarea name="objetivos" class="form-control" id="id_objetivo"
 	                   cols="50" rows="2" ></textarea>
	                </div>

	            </div>
	            <div class="form-group">   
	                <div class="col-sm-7 form-grupo">
	                    <label for="id_observacoes">Observações</label>
	                    <textarea name="observacoes" class="form-control" id="id_observacoes"
	                    cols="50" rows="2" ></textarea>
	                </div>
	            </div>
            	<input type="submit" value="Salvar" class="btn btn-success active btn-sm btn-block">
				
			</form>   	
    </main>
      	<%@ include file="ht_crud_footer_1.jsp" %>         
   </body>
</html>