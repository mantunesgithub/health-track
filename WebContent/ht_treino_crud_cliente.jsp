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
   	<form action="treino" method="post">	
		<div class="row">
               <div class="col-7 container d-flex justify-content-center">
                   <div><h4>Clientes do VP Saúde </h4></div>   
               </div>
	      </div>
		 <hr>
		   <input type="hidden" value="menu" name="acao">
           <table class="table table-striped table-sm border border-dark">
                <thead class="table-dark">
                    <tr>
                       <th>Nome Cliente</th>
                       <th>CPF</th> 
                       <th>E-mail</th>
                       <th>DDD</th>
                       <th>Telefone</th> 
                       <th>Status</th> 
                       <th>Data Nasc.</th> 
                       <th></th> 
                    </tr>
                </thead>
                <c:forEach items="${rqClientes}" var="c">
                    <tr>
						<td>${c.nome}</td>
						<td>${c.cdCPFCliente}</td>
						<td>${c.email}</td>
                        <td>${c.dddCelular}</td>
						<td>${c.numeroCelular}</td>
						<td>${c.statusCliente}</td>
						<td>
							<fmt:formatDate value="${c.dataNascimento.time }" pattern="dd/MM/yyyy"/>
						</td>
						<td>
							<c:url value="treino" var="link">
								<c:param name="acao" value="menu"/>
								<c:param name="cpf_cliente" value="${c.cdCPFCliente}"/>
							</c:url>
							<a href="${link}" class="btn btn-success active btn-sm">
									Selecionar</a>
						</td>
                    </tr>
                </c:forEach>
            </table>
  </main>  	
		<%@ include file="ht_crud_footer_1.jsp"%>
    </body>
</html>
