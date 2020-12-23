<!DOCTYPE html>
<html lang="pt_BR">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Health-track-Menu</title>
        <link rel="stylesheet" type="text/css" href="resources/ht_assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/node_modules/@fortawesome/fontawesome-free/css/all.css ">
        <link rel="stylesheet" href="resources/ht_assets/css/ht_style_menu01.css"> 
    </head>
    <body>
    <header>
        <nav class="navbar narvbar-light  navbar-expand-lg">
            <img src="resources/ht_assets/css/ht_imagens/ht_vp_saude_icon01.png" alt="VP Saúde">
            
            <button type="button" class="navbar-toggler" data-toggle="collapse"
                        data-target="#navbar">
                <span class="navbar-toggler-icon"></span>
            </button>
           
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="navbar-nav mr-auto">
                    
                    <li class="nav-item dropdown">
                        <a href="" class="nav-link dropdown-toggle"
                            data-toggle="dropdown">Cliente</a>
                        <div class="dropdown-menu">
                        	<a href="./ht_solic_treino_crud_c.jsp" class="dropdown-item">Solicitar Treino - Incluir</a>
                            <a href="./ht_modalidades.html" class="dropdown-item">Conhecer modalidades</a>
                            <a href="./ht_personal.html" class="dropdown-item">Conhecer Personal Trainer</a>
                            <a href="./ht_modalidades_treino.html" class="dropdown-item">Solicitar Treino</a>
                            <a href="./ht_treinos_montado_escolhido.html" class="dropdown-item">Treino solicitado</a>
                            <a href="" class="dropdown-item">Efetuar pagamento</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="" class="nav-link dropdown-toggle"
                            data-toggle="dropdown">Personal</a>
                        <div class="dropdown-menu">
                        	<a href="treino?acao=abrir-form-cliente" class="dropdown-item">Escolher Cliente</a>
                            <a href="sequ-atividade?acao=abrir-form-inclusao" class="dropdown-item">Sequência Atividade Cadastrar</a>
                            <a href="sequ-atividade?acao=listar" class="dropdown-item">Sequência Atividade - Manutenção</a>
                            <a href="fase-treino?acao=abrir-form-inclusao" class="dropdown-item">Fases de Treino - Cadastrar</a>
                            <a href="fase-treino?acao=listar" class="dropdown-item">Fases de Treino - Manutenção</a>
                        	<a href="treino?acao=abrir-form-menu" class="dropdown-item">Treino Cliente - Cadastrar</a>
                            <a href="./ht_sequ_treino_crud_l.jsp" class="dropdown-item">Sequencia de Treino Cliente - Manutenção</a>
                            <a href="./ht_sequ_treino_crud_c.jsp" class="dropdown-item">Sequencia de Treino Cliente - Cadastrar</a>                            
                            <a href="" class="dropdown-item">Analisar solicitação treino</a>
                            <a href="" class="dropdown-item">Analisar perfil</a>
                            <a href="" class="dropdown-item">Elaborar Treino Experimental</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="" class="nav-link dropdown-toggle"
                            data-toggle="dropdown">Gestor</a>
                        <div class="dropdown-menu">
                            <a href="modalidade?acao=listar" class="dropdown-item">Modalidades - Manutenção</a>
                            <a href="./ht_modalidade_crud_c.jsp" class="dropdown-item">Modalidades - Cadastrar</a>
                            <a href="personal?acao=listar" class="dropdown-item">Personal Trainer - Listar</a>
                            <a href="./ht_personal_trainer_crud_c.jsp" class="dropdown-item">Personal Trainer - Manutenção</a>
                                          </div>
                    </li>
                    <li class="nav-item"> <a href="#" class="nav-link">Contato</a></li>
                    
                    <li class="nav-item"> <a href="./ht_portal.jsp" class="nav-link">Login</a></li>
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
    
        <ul class="nav flex-column ">
            <label for="primeiro" class="col-form-label" style="color: blue; margin:1vh">
                <h5>Solicite seu Treino Experimental:</h5>
            </label> 

            <li class="nav-item"><a href="ht_modalidades.html" class="nav-link btn btn-primary btn-sm" style="margin:1vh"
                    >Modalidades</a> </li> 
              
            <li class="nav-item"><a href="./ht_personal.html" class="nav-link btn btn-primary btn-sm" style="margin:1vh"
                    >Personal Trainer</a></li>  
            <li class="nav-item"><a href="./ht_modalidades_treino.html" class="nav-link btn btn-primary btn-sm" style="margin:1vh"
                    >Solicitar treino</a></li>   
            <li class="nav-item"><a href="resources./ht_treinos_montado_escolhido.html" class="nav-link btn btn-primary btn-sm" style="margin:1vh"
                    >Treino solicitado <span class="badge badge-light">1</span></a></li> 
       </ul>
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