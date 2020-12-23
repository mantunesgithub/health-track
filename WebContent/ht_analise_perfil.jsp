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
             	      <div><h4>Análise Solicitação Treino/Perfil</h4></div>   
			    </div>
            </div>
  
            <hr>
            <div><h4>Ultimas Solicitações de Treino </h4></div>   
        	<table class="table table-bordered table-sm table-light ">
                <thead class="table-dark">
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
							<c:url value="solicitar-treino" var="link">
								<c:param name="acao" value="atzar-solicitacao"/>
								<c:param name="id_Solicitacao_Treino" value="${p.idSolicitacaoTreino}"/>
							</c:url>
							<a href="${link}" class="btn btn-primary btn-sm">Alterar Status</a>
						
						</td>
                    </tr>			
                </c:forEach>
            </table>
	        <table class="table table-bordered table-sm table-light ">
        		
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
	                    </tr>			
                </c:forEach>
            </table>
  					
            <div><h4>Treinos cadastrados</h4></div>   
           <table class="table table-bordered table-sm table-light ">
            <c:forEach items="${rqLtodosTreinos}" var="t">
		        	<thead class="table-dark">
	                    <tr>
	                        <th>Modalidade</th> 
	                        <th>Id. Treino</th>
	                        <th>Objetivo do Treino</th>
	                        <th>Fase </th> 
	                        <th>Descrição</th>
	                        <th>Personal </th> 
	                        <th>Dia da Semana</th> 
	                
	                    </tr>
	                </thead>
	                    <tr>
							<td>${t.modalidade.descricaoModalidade}</td>
							<td>${t.idTreino}</td>
							<td>${t.descObjetivoTreino}</td>
	                        <td>${t.faseTreino.cdFaseTreino}</td>
							<td>${t.faseTreino.dsTipoTreino}</td>
							<td>${t.personalTrainer.nome}</td>
							<td>${t.diasDaSemana}</td>
							</td>
	                    </tr>			
             	    <thead class="table-secondary">
        	           <tr>
	                       <th>Id.</th> 
	                       <th>Sequência de Treino </th> 
	                       <th>Qtd Séries</th>
	                       <th>Repetições</th>
	                       <th>Qtd Carga</th>
	                       <th>Intervalo</th>
	                       <th>Método</th>
	                       <th>Objetivo desta Sequência </th> 
	               
	                    </tr>
    	            </thead>
	             <c:forEach items="${t.sequenciaTreinos}" var="s">	
                    <tr>
						<td>${s.idSequTreino}</td>
						<td>${s.sequAtiv.descSequAtiv}</td>
                        <td>${s.qtdeSeries}</td>
                        <td>${s.qtdeRepeticoes}</td>
                        <td>${s.pesoDaCarga}</td>
						<td>${s.qtdeTempoDescanso}</td>
						<td>${s.descMetodo}</td>
						<td>${s.descAtividade}</td>
                    </tr>
                 </c:forEach>
             	  
             </c:forEach>
           </table>
 		</form>
     </main>
 		<%@ include file="ht_crud_footer_1.jsp" %>
    </body>
</html>