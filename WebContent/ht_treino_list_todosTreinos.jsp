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
		                 value="${clienteok.nome}">
					<label for="id_cpf_cliente">CPF </label>
					<input type="text" name="cpf-cliente"  id="id_cpf_cliente" size="15" readonly="readonly"
		                  value="${clienteok.cdCPFCliente}">
				</div>
				<div class="col-3 ">
             	      <div><h4>Treinos Cadastrados</h4></div>   
			    </div>
            </div>
            <hr>
            <c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
 					
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
	                        <th>Volume Sessão</th> 
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
							<td>${t.qtdeVolumeSessao}</td>
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
         			<th>
             </c:forEach>
           </table>
       </main>
 		<%@ include file="ht_crud_footer_1.jsp" %>
    </body>
</html>