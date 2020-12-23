package br.com.fiap.healthtrack.dao;

  
  public abstract class DAOFactory {
  
    public static ClienteDAO getClienteDAO(){
      return new ClienteDAOImpl();
    }
    public static MedidaClienteDAO getMedidaClienteDAO(){
    	return new MedidaClienteDAOImpl();
    }
    public static ModalidadeDAO getModalidadeDAO(){
      return new ModalidadeDAOImpl();
    }
    public static QuestionarioDAO getQuestionarioDAO(){
    	return new QuestionarioDAOImpl();
    }
    public static PerguntaQuestDAO getPerguntaQuestDAO(){
    	return new PerguntaQuestDAOImpl();
    }
    public static FaseTreinoDAO getFaseTreinoDAO(){
    	return new FaseTreinoDAOImpl();
    }
    public static SequAtividadeDAO getSequAtividadeDAO(){
    	return new SequAtividadeDAOImpl();
    }
    public static PersonalTrainerDAO getPersonalTrainerDAO(){
    	return new PersonalTrainerDAOImpl();
    }
    public static TreinoClienteDAO getTreinoClienteDAO(){
    	return new TreinoClienteDAOImpl();
    }
    public static SequenciaTreinoDAO getSequenciaTreinoDAO(){
    	return new SequenciaTreinoDAOImpl();
    }
    public static SolicitacaoTreinoDAO getSolicitacaoTreinoDAO(){
    	return new SolicitacaoTreinoDAOImpl();
    }
    public static TreinoClienteDAO getTreinoDAO(){
    	return new TreinoClienteDAOImpl();
    }
}
