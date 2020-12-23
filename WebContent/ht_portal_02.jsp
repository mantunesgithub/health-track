<!DOCTYPE html>
<html lang="pt_BR">
    <head>
        <title>Health-track - Portal</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="resources/ht_assets/css/bootstrap.min.css">
         <link rel="stylesheet" href="resources/ht_assets/css/ht_style.css"> 
    </head>
    <body> 
        <header class="text-white d-flex">
            <div class="container d-flex justify-content-between align-items-center">
                <img src="resources/ht_assets/css/ht_imagens/ht_vp_saude_icon01.png" alt="VP SaÃºde">
                <nav>
                    <ul class="list-inline">
                        <li class="list-inline-item">Home</li>
                        <li class="list-inline-item">Contato</li>
                        <a class="list-inline-item" class="btn" href="./ht_portal_02.jsp">Login</a>
                    </ul>
                </nav>
            </div>
            
        </header>
 
            
            <div class="row">
                <nav class="col-md-6">
                    <div class="container-fluid">  
                        <form class="form-horizontal" action="login" method="post">
                        	<input type="hidden" value="login" name="acao">   
                            <div class="col-sm-offset-2 col-sm-11">      
                                <h5>Efetue seu Login no VP Saúde!</h5>  
                            </div>   
                           <div class="form-group">    
                              <label class="control-label col-sm-2 " for="id_email">Email:</label>   
                              <div class="col-md-12">     
                                   <input type="email" name="email" class="form-control form-control-sm" id="id_email" placeholder="Digite o email">   
                               </div> 
                           </div>   
                           <div class="form-group">  
                               <label class="control-label col-sm-9" for="id_senha">Senha:</label>  
                              <div class="col-md-9">       
                                   <input type="password" name="senha" class="form-control form-control-sm" id="id_senha" placeholder="Digite a senha">     
                              </div>   
                           </div> 
                         
                       	   <input type="submit" value="Entrar" class="btn btn-success active btn-sm">
               		
                        </form> 
                        <div class="col-sm-offset-2 col-sm-10">
                        	 <br><br>
                            <h6>Ainda não é Cliente?</h6>      
                            <ul type=circle class="list-inline-item">
                                <li>Entre com seu e-mail</li>
                                <li>Digite a senha e Cadastrar</li>
                                <h6> </h6> 
                                <a href="./ht_cliente_crud_c.jsp"    
                                    class="btn btn-primary btn-sm">Cadastrar Usuário</a>
                            </ul>
                            
                       </div>       
                   </div> 
                </nav>
                <main class="col-md-6">
                    <div class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="slide w-100 slide-1">
                                    <p>
                                        Valorize seu treino,<br>
                                        cuide de sua Saúde,<br>
                                        ela merece sua atenção!<br>
                                    </p>  
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="slide w-100 slide-2">
                                    <p>
                                        Treine com um <br>
                                        especialista,<br>
                                        solicite um treino<br>
                                        experimental<br>
                                        sem nenhum custo.<br>
                                       </p>    
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="slide w-100 slide-3">
                                    <p>
                                        Inscreva-se, é rápido, <br>
                                        e simples, experimente<br>
                                        e comprove<br>
                                       </p>     
                                </div>    
                            </div>
                            <div class="carousel-item">
                                <div class="slide w-100  slide-4">
                                    Um Personal Trainer<br>
                                    faz toda a diferença...<br>
                                </div>
                            </div> 
                            <div class="carousel-item">
                                <div class="slide w-100  slide-5">
                                    Não garantimos o resultado !!!<br>
                                    solicite seu<br>
                                    Treino Experimental.<br>
                                </div>
                            </div> 
                        </div>
                    </div>
                </main>
            </div>
        </section>
    <footer class="container-fluid">
        <div class="text-white">
            <div class="row">
                <ul class="col-sm-4 list-unstyled">
                    <li><h6>Siga-nos</h6></li>
                    <li>Facebook</li>
                    <li>Instagram</li>
                </ul>
                <ul class="col-sm-4 list-unstyled">
                    <li><h6>Sobre VP Saúde</h6></li>
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
    <script src="resources/ht_assets/js/bootstrap.min.js"></script>
    </body>
</html>