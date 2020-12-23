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
		<form action="sequ-treino" method="post">
            <input type="hidden" value="editar" name="acao">
            <input type="hidden" value="${rqIdTreino.idTreino}" name="id_treino">
          	<div class="row">
				<div class="col-sm-5">
					<label for="id_cliente">Cliente</label>
				    <input type="text" name="cliente"  id="id_cliente" size="22" readonly="readonly"
		                 value="${rqClienteSS.nome}" readonly="readonly">
					<label for="id_cpf_cliente">CPF </label>
					<input type="text" name="cpf-cliente"  id="id_cpf_cliente" size="15" readonly="readonly"
		                  value="${rqClienteSS.cdCPFCliente}" readonly="readonly">
				</div>
				<div class="col-4">
             	      <div><h4>Editar Sequência de Treino</h4></div>   
			    </div>
                <div class="col-3">
            		<c:url value="sequ-treino" var="link">
						<c:param name="acao" value="listar"/>
						<c:param name="id_treino_2" value="${rqIdTreino.idTreino}"/>
					</c:url>
					<a href="${link}" class="btn btn-primary active btn-sm">Listar</a>
                		
			        <a href="treino?acao=listar" class="btn btn-primary active btn-sm">Treino</a>
                </div>
            </div>
                		<hr>		
			<div class="form-row">
                   	<div><h5>Tipo de Treino</h5></div>  
 			</div>
            <div class="form-row">
				<div class="col-sm-2 form-grupo">
					<label for="id_modalidade">Modalidade</label>
					<input type="text" name="modalidade" class="form-control" id="id_modalidade"
					value="${rqIdTreino.modalidade.descricaoModalidade}" readonly="readonly">	
	            </div>
				<div class="col-sm-1 form-grupo">
					<label for="id_treino">Id.</label>
					<input type="number" name="id_treino" class="form-control" id="id_treino"
					value="${rqIdTreino.idTreino}" readonly="readonly">	
	            </div>
	            <div class="col-sm-3 form-grupo">
	                <label for="id_objetivo_treino">Objetivo</label>
	                <input type="text" name="objetivo_treino" class="form-control" id="id_objetivo_treino"
                     value="${rqIdTreino.descObjetivoTreino}" readonly="readonly">	
	            </div>
	            <div class="col-sm-1 form-grupo">
	                <label for="id_cdFase_treino">Fase</label>
	                <input type="number" name="cdFase_treino" class="form-control" id="id_cdFase_treino"
	                value="${rqIdTreino.faseTreino.cdFaseTreino}" readonly="readonly">	
	            </div>
	            <div class="col-sm-3 form-grupo">
				    <label for="id_dstipo_Treino">Descrição</label>
					<input type="text" name="dstipo_treino" class="form-control" id="id_dstipo_Treino"
	                 value="${rqIdTreino.faseTreino.dsTipoTreino}" readonly="readonly">	
	            </div>
	            <div class="col-sm-2 form-grupo">
				    <label for="id_dia_semana">Dia da Semana</label>
					<input type="text" name="dia_semana" class="form-control" id="id_dia_semana"
	                 value="${rqIdTreino.diasDaSemana}" readonly="readonly">	
	            </div>
	        </div>
	            <hr>
                <div class="form-row">
                   	<div><h5>Editar Sequência Treino</h5></div>  
   				</div>
  		        <div class="form-row">
               	   <div class="col-sm-1 form-grupo">
	                	   <label for="id_sequTreino">Id.</label>
   	               			<input type="number" name="sequ_Treino" class="form-control" id="id_sequTreino"
   	               			value="${rqSequTreino.idSequTreino}" readonly="readonly">
	               </div>
                   <div class="col-sm-3 form-group">    
	                    <label for="id_seq_atividade">Descrição da Atividade</label>
	                    <select name="sequ_atividade" id="id_sequ_atividade" class="form-control">
	                        <option value="0">Selecione</option>
	                        <c:forEach items="${rqSequAtividades}" var="s">
	                        
	                            <c:if test="${s.idSequAtiv == rqSequTreino.sequAtiv.idSequAtiv}">
									<option value="${s.idSequAtiv}" selected>${s.descSequAtiv}</option>
								</c:if>
								<c:if test="${s.idSequAtiv != rqSequTreino.sequAtiv.idSequAtiv}">
									<option value="${s.idSequAtiv}">${s.descSequAtiv}</option>
								</c:if>
	                        </c:forEach>
	                    </select>
	                </div>
	                <div class="col-sm-1 form-grupo">
 	                   <label for="id_qt_series">Séries</label>
    	               <input type="number" name="qt_series" class="form-control" id="id_qt_series"
    	               value="${rqSequTreino.qtdeSeries}">
 	                </div>
	                <div class="col-sm-1 form-grupo">
		                <label for="id_qt_repet">Repetições</label>
	                    <input type="number" name="qt_repet" class="form-control" id="id_qt_repet"
	                    value="${rqSequTreino.qtdeRepeticoes}">
 	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_qt_carga">Carga </label>
	                    <input type="number" name="qt_carga" class="form-control" id="id_qt_carga"
	                    value="${rqSequTreino.pesoDaCarga}">
 	                </div>
	                <div class="col-sm-3 form-grupo">
	                    <label for="id_desc_metodo">Método </label>
	                    <input type="text" name="desc_metodo" class="form-control" id="id_desc_metodo"
	                    value="${rqSequTreino.descMetodo}">
 	                </div>
 	            </div>
 	            <div class="form-row">   	                
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_qt_veloc">Velocidade</label>
	                    <input type="number" name="qt_veloc" class="form-control" id="id_qt_veloc"
	                    value="${rqSequTreino.qtdeVelocidade}">
 	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_qt_intensidade">Intensidade </label>
	                    <input type="number" name="qt_intensidade" class="form-control" id="id_qt_intensidade"
	                    value="${rqSequTreino.qtdeIntesidade}">
 	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_qt_duracao">Duração </label>
	                    <input type="number" name="qt_duracao" class="form-control" id="id_qt_duracao"
	                    value="${rqSequTreino.qtdeTempoDuracao}">
 	                </div>
	                <div class="col-sm-1 form-grupo">
	                    <label for="id_qt_intervalo">Intervalo</label>
	                    <input type="number" name="qt_intervalo" class="form-control" id="id_qt_intervalo"
	                    value="${rqSequTreino.qtdeTempoDescanso}"> 	               
 	                </div>
	                <div class="col-sm-2 form-grupo">
	                    <label for="id_frequ_cardio">Frequência Cardíaca</label>
	                    <input type="text" name="frequ_cardio" class="form-control" id="id_frequ_cardio"
	                    value="${rqSequTreino.qtdeFreqCardiaca}">
 	                </div>
	                <div class="col-sm-2 form-grupo">
	                    <label for="id_qt_tempo_medio">Tempo Médio </label>
	                    <input type="number" name="qt_tempo_medio" class="form-control" id="id_qt_tempo_medio"
	                    value="${rqSequTreino.qtdeTempoMedio}">
 	                </div>
 	                <br>
 	            </div>
 	            <div class="form-row">   
	                <div class="col-sm-12 form-grupo">
	                    <label for="id_desc_ativ">Objetivo da Atividade </label>
	                    <input type="text" name="desc_atividade" class="form-control" id="id_desc_ativ"
	                    value="${rqSequTreino.descAtividade}">
 	                </div>
				</div>
				<br>
				<input type="submit" value="Salvar" class="btn btn-success btn-block active btn-sm">
          </form>
        </main>					
       	<%@ include file="ht_crud_footer_1.jsp" %>         
    </body>
</html>