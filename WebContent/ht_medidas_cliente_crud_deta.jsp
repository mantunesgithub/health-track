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
                       <div><h4>Detalhes das Minhas Medidas</h4></div>   
                   </div>
                   <div class="col-2 ">
                          <a href="medidas-cliente?acao=abrir-form-inclusao" class="btn btn-primary btn-sm">Voltar</a>
                   </div>
            </div>
               <hr>
            <div class="form-row"> 
                <div class="col-sm-6 form-grupo">
              		<h5>Cálculo IMC - Índice de Massa Corporal</h5>
            	</div>
                <div class="col-sm-6 form-grupo">
              		<h5>Cálculo do TMB - Taxa Metabólica Basal</h5>
            	</div>
            </div>
            <div class="form-row"> 
                <div class="col-sm-2 form-grupo">
                    <label for="id_imc">IMC Calculado</label>
                    <input type="text" name="imc" class="form-control" id="id_imc"
                     readonly="readonly" value="${rqIdMedidaCliente.vlIMCCalculado}">
                </div>
                <div class="col-sm-4 form-grupo">
                    <label for="id_imc_res">Seu IMC esta na faixa:</label>
                    <input type="text" name="imc_res" class="form-control" id="id_imc_res"
                     readonly="readonly" value="${rqIdMedidaCliente.msgIMCCalculado}">
                </div>
                <div class="col-sm-2 form-grupo">
                    <label for="id_tbm">TMB Calculado</label>
                    <input type="text" name="tmb" class="form-control" id="id_tmb"
                    readonly="readonly" value="${rqIdMedidaCliente.vlTMBCalculado}">
                </div>
                <div class="col-sm-4 form-grupo">
                    <label for="id_tbm_res">O seu índice esta?</label>
                    <input type="text" name="tbm_res" class="form-control" id="id_tbm_res"
                    readonly="readonly" value="${rqIdMedidaCliente.msgTMBCalculado}">
                </div>
            </div>
			<hr>	
            <div><h5>Medidas Básicas</h5></div>      
            <div class="form-row"> 
                <div class="col-sm-1 form-grupo">
                    <label for="id_idmedida_cliente">Id.</label>
                    <input type="text" name="idmedida_cliente" class="form-control" id="id_idmedida_cliente"
                    readonly="readonly" value="${rqIdMedidaCliente.idMedidaCliente}">
                </div>
             
                <div class="col-sm-1 form-grupo">
                	
                    <label for="id_data_medida">Data Medida</label>
                    <input type="text" name="data_medida" class="form-control" id="id_data_medida"
                    readonly="readonly" value="<fmt:formatDate value="${rqIdMedidaCliente.dtMedicao.time }" pattern="dd/MM/yyyy"/>">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_peso">Peso</label>
                    <input type="number" name="peso" class="form-control" id="id_peso"
                    readonly="readonly" value="${rqIdMedidaCliente.vlPeso}">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_altura">Altura</label>
                    <input type="number" name="altura" class="form-control" id="id_altura"
                    readonly="readonly" value="${rqIdMedidaCliente.vlAltura}">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_calorias">Calorias/dia</label>
                    <input type="number" name="calorias" class="form-control" id="id_calorias"
                    readonly="readonly" value="${rqIdMedidaCliente.qtCalConsDia}">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_freqCardiaca">Frequ.Cardíaca</label>
                    <input type="number" name="freqCardiaca" class="form-control" id="id_freqCardiaca"
                    readonly="readonly" value="${rqIdMedidaCliente.vlPressao}">
                </div>
            </div>
            <hr>
            <div><h5>Medidas Corporais</h5></div>   
            <div class="form-row"> 
                <div class="col-sm-1 form-grupo">
                    <label for="id_pescoco">Pescoço</label>
                    <input type="number" name="pescoco" class="form-control" id="id_pescoco"
                    readonly="readonly" value="${rqIdMedidaCliente.vlMedidaPescoco}">
                </div>
               	<div class="col-sm-1 form-grupo">
                    <label for="id_ante_braco">Ante-Braço</label>
                    <input type="number" name="ante_braco" class="form-control" id="id_ante_braco"
                    readonly="readonly" value="${rqIdMedidaCliente.vlMedidaAnteBraco}">
               	</div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_peito">Peito</label>
                    <input type="number" name="peito" class="form-control" id="id_peito"
                    readonly="readonly" value="${rqIdMedidaCliente.vlMedidaPeito}">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_cintura">Cintura</label>
                    <input type="number" name="cintura" class="form-control" id="id_cintura"
                    readonly="readonly" value="${rqIdMedidaCliente.vlMedidaCintura}">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_quadris">Quadris</label>
                    <input type="number" name="quadris" class="form-control" id="id_quadris"
                    readonly="readonly" value="${rqIdMedidaCliente.vlMedidaQuadris}">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_coxa">Coxa</label>
                    <input type="number" name="coxa" class="form-control" id="id_coxa"
                    readonly="readonly" value="${rqIdMedidaCliente.vlMedidaCoxas}">
                </div>
                <div class="col-sm-1 form-grupo">
                    <label for="id_paturrilha">Panturrilha</label>
                    <input type="number" name="paturrilha" class="form-control" id="id_paturrilha"
                    readonly="readonly" value="${rqIdMedidaCliente.vlMedidaPanturrilha}">
                </div>
            </div>
            <div class="form-row">   
               	<div class="col-sm-12 form-grupo">
                   <label for="id_observacoes">Observações</label>
                    <textarea name="observacoes" class="form-control" id="id_observacoes"
	                   cols="50" rows="2" readonly="readonly" value="${rqIdMedidaCliente.dsObservacao}"
	                   ></textarea>
                </div>
             </div>
       </main>
 		<%@ include file="ht_crud_footer_1.jsp" %>
    </body>
</html>