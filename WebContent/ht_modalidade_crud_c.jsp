<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
    	
            <form action="modalidade" method="post">
            	<input type="hidden" value="incluir" name="acao">
                <div class="row">
                    <div class="col-7 container d-flex justify-content-center">
                        <h4>Inclus�o de Modalidades</h4>   
                    </div>
                    <div class="col-5 container d-flex justify-content-start">
                        
                      	<div class="col">
                        	<a href="./ht_menu01.jsp" class="btn btn-primary  btn-sm">menu</a>
	                        <a href="modalidade?acao=listar" class="btn btn-primary btn-sm">listar</a>
                    	</div>
                    </div>	
                </div>    
                <hr>
                <div class="form-group">
                   <label for="id_cd_modalidade">C�digo da Modalidade :</label>
                   <input type="text" name="cd_modalidade" id="id_cd_modalidade" class="form-control">
               	</div>
                <div class="form-group">
                   <label for="id_ds_modalidade">Descri��o da Modalidade : </label>
                   <input type="text" name="ds_modalidade" id="id_ds_modalidade" class="form-control">
               	</div>
               	<input type="submit" value="Salvar" class="btn btn-success active btn-sm">
            </form>
        </main>
       	<%@ include file="ht_crud_footer_1.jsp" %> 
    </body>
</html>