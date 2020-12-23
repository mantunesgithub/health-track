<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            	<input type="hidden" value="editar" name="acao">
            	<input type="hidden" value="${rqIdTreino.idTreino}" name="id_treino">
 
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
                        <div><h4> Editar Treino </h4></div>   
                    </div>
                    <div class="col-2 ">
                          <a href="treino?acao=listar" class="btn btn-primary btn-sm">listar</a>
                    </div>
                </div>
                <hr>
  		        <div class="form-row">
   	                <div class="col-sm-3 form-grupo">
	                    <label for="id_tr">Id. Treino</label>
	                    <input type="text" name="id_treino" class="form-control" id="id_tr"
	                    value="${rqIdTreino.idTreino}">	
	                </div>
   		        
					<div class="col-sm-3 form-group">    
	                    <label for="id-modalidade">Modalidade</label>
	                    <select name="modalidade" id="id-modalidade" class="form-control">
	                        <option value="0">Selecione</option>
	                        <c:forEach items="${rqModalidades}" var="c">

		                        <c:if test="${c.codigoModalidade == rqIdTreino.modalidade.codigoModalidade}">
									<option value="${c.codigoModalidade}" selected>${c.descricaoModalidade}</option>
								</c:if>
								<c:if test="${c.codigoModalidade != rqIdTreino.modalidade.codigoModalidade}">
									<option value="${c.codigoModalidade}">${c.descricaoModalidade}</option>
								</c:if>
	                        </c:forEach>
	                    </select>
	                </div>
	                <div class="col-sm-4 form-group">    
	                    <label for="id_fase_treino">Fase de Treino</label>
	                    <select name="fase_treino" id="id_fase_treino" class="form-control">
	                        <option value="0">Selecione</option>
	                        <c:forEach items="${rqFaseTreinos}" var="c">
		                       
		                        <c:if test="${c.idFaseTreino == rqIdTreino.faseTreino.idFaseTreino}">
									<option value="${c.idFaseTreino}" selected>
									Fase: ${c.cdFaseTreino} / Treino: ${c.tpFaseTreino}
		                            	- ${c.dsTipoTreino} </option>
								</c:if>
								<c:if test="${c.idFaseTreino != rqIdTreino.faseTreino.idFaseTreino}">
		                            <option value="${c.idFaseTreino}" > 
		                            Fase: ${c.cdFaseTreino} / Treino: ${c.tpFaseTreino}
		                            	- ${c.dsTipoTreino} </option>
								</c:if>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="form-row">   
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_data_inicio">Data Inicio</label>
	                    <input type="text" name="data_inicio" class="form-control" id="id_data_inicio"
	                    value='<fmt:formatDate value="${rqIdTreino.dataInicioTreino.time}" pattern="dd/MM/yyyy"/>'>
	                </div>
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_data_final">Data Final</label>
	                    <input type="text" name="data_final" class="form-control" id="id_data_final"
	                    value='<fmt:formatDate value="${rqIdTreino.dataFinalTreino.time}" pattern="dd/MM/yyyy"/>'>	
	                </div>
	                <div class="col-sm-4 form-grupo">
	                    <label for="id_status">Dia da Semana</label>
	                    <select name="dia_semana" id="id_dia_semana"
	                        class="form-control">
	                            <option value="0">${rqIdTreino.diasDaSemana}</option>
	                            <option value="domingo">domingo</option> 
	                            <option value="segunda-feira">segunda-feira</option>
	                            <option value="terça-feira">terça-feira</option>
	                            <option value="quarta-feira">quarta-feira</option>
	                            <option value="quinta-feira">quinta-feira</option>
	                            <option value="sexta-feria">sexta-feria</option>
	                            <option value="sabado">sabado</option>
	                    </select>    
                	</div>
                </div>
	            <div class="form-row">   
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_qt_vol_semana">Qtd. volume semanal</label>
	                    <input type="number" name="qt_vol_semana" class="form-control" id="id_qt_vol_semana"
	                    value="${rqIdTreino.qtdeVolumeSemana}">	
	                </div>
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_qt_vol_sessao">Qtd. volume sessão</label>
	                    <input type="number" name="qt_vol_sessao" class="form-control" id="id_qt_vol_sessao"
	                    value="${rqIdTreino.qtdeVolumeSessao}">	
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
	                    <input type="text" name="local_treino" class="form-control" id="id_local_treino"
	                    value="${rqIdTreino.descLocalTreino}">	
	                </div>
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_traje_treino">Traje do treino</label>
	                    <input type="text" name="traje_treino" class="form-control" id="id_traje_treino"
	                    value="${rqIdTreino.descTrajeTreino}">	
	                </div>
	                <div class="col-sm-4 form-grupo">
	                    <label for="id_assessorio">Assessórios</label>
	                    <input type="text" name="assessorio" class="form-control" id="id_assessorio"
	                    value="${rqIdTreino.descAssesTreino}">	
	                </div>
	            </div>
	            <div class="form-row">   
	       	        <div class="col-sm-8 form-grupo">
	                    <label for="id_objetivo">Objetivo do treino</label>
	                    <input type="text" name="objetivos" class="form-control" id="id_objetivo"
	                    value="${rqIdTreino.descObjetivoTreino}">	
	                </div>

	                <div class="col-sm-2 form-group">
	                    <label for="id_personal">Personal Trainer</label>
	                    <select name="personal" id="id_cliente" class="form-control">
	                        <option value="0">Selecione</option>
	                        <c:forEach items="${rqPersonal}" var="c">

		                        <c:if test="${c.cpfPersonal == rqIdTreino.personalTrainer.cpfPersonal}">
									<option value="${c.cpfPersonal}" selected>${c.nome}</option>
								</c:if>
								<c:if test="${c.cpfPersonal != rqIdTreino.personalTrainer.cpfPersonal}">
	                            	<option value="${c.cpfPersonal}" >${c.nome}</option>
								</c:if>

	                        </c:forEach>
	                    </select>
	                </div>
                </div>
	            <div class="form-row">   
	       	        <div class="col-sm-7 form-grupo">
	                    <label for="id_observacoes">Observações</label>
	                    <input type="text" name="observacoes" class="form-control" id="id_observacoes"
	                    value="${rqIdTreino.descObservacoes}">	
	                </div>
		        		<br>
				</div>
				<input type="submit" value="Salvar" class="btn btn-success active btn-sm">
               	<a href="treino?acao=listar" class="btn btn-danger btn-sm">Cancelar</a>
          </form>
        </main>					
       	<%@ include file="ht_crud_footer_1.jsp" %>         
    </body>
</html>