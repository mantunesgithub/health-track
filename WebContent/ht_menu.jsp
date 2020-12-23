<!DOCTYPE html>
<html lang="pt_BR">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Health-track-Menu</title>
        <link rel="stylesheet" type="text/css" href="resources/ht_assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/node_modules/@fortawesome/fontawesome-free/css/all.css ">
   		<link rel="stylesheet" href="resources/ht_assets/css/ht_style_menu.css"> 	
    </head>
    <body>
    <header>
        <nav class="navbar narvbar-light  navbar-expand-lg">
            <img src="resources/ht_assets/css/ht_imagens/ht_vp_saude_icon01.png" alt="VP Saúde" class="rounded-circle">
            
            <button type="button" class="navbar-toggler" data-toggle="collapse"
                        data-target="#navbar">
                <span class="navbar-toggler-icon"></span>
            </button>
           
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="navbar-nav mr-auto">
                    
                     <li class="nav-item dropdown">
                        <a href="" class="nav-link dropdown-toggle"
                            data-toggle="dropdown">Personal Trainer</a>
                        <div class="dropdown-menu">
                        	<a href="treino?acao=abrir-form-cliente" class="dropdown-item">Selecionar Cliente</a>
                            <%-- <a href="#" class="dropdown-item disabled">Visualizar Solicitações</a> --%>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="" class="nav-link dropdown-toggle"
                            data-toggle="dropdown">Administrador</a>
                        <div class="dropdown-menu">
                            <a href="modalidade?acao=listar" class="dropdown-item">Atualizar Modalidades</a>
                            <a href="./ht_modalidade_crud_c.jsp" class="dropdown-item">Cadastrar Modalidades</a>
                            <a href="personal?acao=listar" class="dropdown-item">Atualizar Personal Trainer</a>
                            <a href="./ht_personal_trainer_crud_c.jsp" class="dropdown-item">Cadastrar Personal Trainer</a>
                                          </div>
                    </li>
                    <li class="nav-item"> <a href="./ht_portal.jsp" class="nav-link">Home</a></li>
                </ul>
                <form action="" class="form-inline my-2 my-lg-o">
                    <input type="search" class="form-control mr-sm-2"
                            placeholder="Pesquisar ...">    
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                            Pesquisar</button>
                    </button>    
                </form>   
            </div>    
        </nav> 
    </header> 
   <section class="container-fluid">
  	<div style='text-align:left'>
  	
         <p style=color:dark class="h5"><u>${clienteok.nome}</u> , <small>Seja Bem Vindo ao VP Saúde!</small></p>    		
     </div>
     <div>    
		 <br>
		 <h5 style=color:rgb(22,90,218)>Solicite seu Treino</h5>
		 <ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link active btn-sm" href="solicitar-treino?acao=abrir-form-inclusao">Solicitar Treino</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link " href="treino?acao=listar-todos-treinos">Visualisar Treino</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="medidas-cliente?acao=abrir-form-inclusao">Atualizar Medidas</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link " href="#">Atualizar Cadastro</a>
			  </li>
		</ul>    		
       	<br><br>
		<h5 style=color:rgb(22,90,218)>Conheça as Modalidades e Personal Trainner</h5>
		 <br>
	     <a href="ht_modalidades.jsp" class="btn btn-primary btn-sm ">Modalidades</a>      
	     <a href="./ht_personal.jsp" class="btn btn-primary btn-sm ">Personal Trainer</a>     

	</div>
	</section>
		<footer> 
            <div class="text-white">
                <div class="row">
                    <ul class="col-sm-4 list-unstyled">
                        <li><h6>Siga-nos</h6></li>
                        <li>Facebook</li>
                        <li>Instagram</li>
                    </ul>
                    <ul class="col-sm-4 list-unstyled">
                        <li><h6>Sobre VP Saúdede</h6></li>
                        <li>Nossa História</li>
                        <li>Contato</li>
                    </ul>
                    <ul class="col-sm-4 list-unstyled">
                        <li><h6>Legal </h6></li>
                        <li>Termos e Condições</li>
                        <li>Politica de Privacidade</li>
                    </ul>
                </div>
            </div>
    	</footer> 
        <script src="resources/ht_assets/js/jquery-3.5.1.min.js"></script>
        <script src="resources/ht_assets/js/bootstrap.bundle.min.js"></script>
		<script src="resources/ht_assets/js/popper.min.js"></script>
    </body>
</html>