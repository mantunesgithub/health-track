package br.com.fiap.healthtrack.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.fiap.healthtrack.entities.Cliente;
import br.com.fiap.healthtrack.entities.Modalidade;
import br.com.fiap.healthtrack.entities.PersonalTrainer;
import br.com.fiap.healthtrack.entities.enums.StatusPersonal;

public class TestModalidadeMusculacao {
	public static void main(String[] args) throws ParseException {

		/**
		 * Intancia de data atual
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//		Date dataHoraAtual = new Date();

		/**
		 * Instancia de Cliente
		 * 
		 */
		Cliente c1 = new Cliente();
		c1.setCdCPFCliente(1270304682l);
		c1.setNome("Marcio Antunes");
		c1.setRg(13402631);
		c1.setDataNascimento(Calendar.getInstance());
		c1.setEndereco("Rua Braga");
		c1.setNumero(999);
		c1.setComplemento("Condominio A, T1");
		c1.setBairro("Jardim Luzitania");
		c1.setCidade("SBC");
		c1.setUf("SP");
		c1.setPais("Br");
		c1.setCepPrefixo(97111);
		c1.setCepSufixo(121);
//		c1.setStatusCliente(StatusCliente.ATIVO);
		c1.setEmail("mantunes001@gmail.com");
		c1.setProfissao("Vendedor");
		c1.setSenhaAnterior("123456");
		c1.setSenhaAnterior("999999");
		c1.setTentativasErro(0);
		c1.setDddCelular(11);
		c1.setDdiCelular(55);
		c1.setNumeroCelular(988776655);
		c1.setDataInclusao(Calendar.getInstance());
		c1.setDataAlteracao(Calendar.getInstance());

		System.out.println("Instancia de Cliente:");
		System.out.println(c1);
		System.out.println(" ");

		/**
		 * Instancia de Personal Trainer
		 * 
		 */
		PersonalTrainer pt1 = new PersonalTrainer(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		pt1.setCpfPersonal(14703047720l);
		pt1.setNome("Joao Paulo Canarvale");
		pt1.setCref("22980");
		pt1.setRg(99902631l);
		pt1.setEndereco("Rua Jose Braga");
		pt1.setNumero(229);
		pt1.setComplemento("Condominio JP, T1");
		pt1.setBairro("Jardim Vila Yolanda");
		pt1.setCidade("Osasco");
		pt1.setUf("SP");
		pt1.setPais("Br");
		pt1.setEmail("JPCarnavalle@gmail.com");
		pt1.setCepPrefixo(06000);
		pt1.setCepSufixo(121);
		pt1.setStatusPersonalTrainer(StatusPersonal.ATIVO);
		pt1.setDdiCelular(55);
		pt1.setDddCelular(11);
		pt1.setNumeroCelular(988776655);
		pt1.setDataInclusao(sdf.parse("11/01/2020 12:30:12"));
		System.out.println("Instancia de Personal Trainer: ");
		System.out.println(pt1);
		System.out.println(" ");
		/**
		 * Instancia de Modalidades de Treino
		 * 
		 */
		Modalidade musc = new Modalidade();
		musc.setCodigoModalidade(1);
		musc.setDescricaoModalidade("Musculação");

		System.out.println("Instancia de Modalidades de Treino de Musculação");
		System.out.println(musc);

		System.out.println(" ");
		
//		
//		TreinoCliente tm = new Tre();
//	
//		tm.setId(1l);
//		tm.setCodigoCliente(c1);
//		tm.setPersonalTrainer(pt1);
//		tm.setModalidade(musc);;
//		tm.setLocalTreinamento("Academia");
//		tm.setTrajeTreino("bermuda-camiseta-tenis");
//		tm.setAssessoriosTreino("academia");
//		tm.setMediaExplicativa("não ha");
//		tm.setStatusTreino(StatusTreinoCliente.ATIVO);
//		tm.setDataInclusao(sdf.parse("11/01/2020 12:30:12"));
//		tm.setDataAlteracao(null);
//		tm.setObservacoes("Aumentar carga gradativamente");
//		tm.setTempoPrevistoTreino(1.30);
//		tm.setDataInicioTreino(sdf.parse("11/01/2020 12:30:12"));
//		tm.setDataFinalTreino(sdf.parse("11/03/2020 12:30:12"));
//		tm.setDiaDoTreino("segunda-feira e quinta-feira");
//		tm.setNomeDoTreino("Treino A");
//		tm.setIntervaloDeDescanco(0.30);
//		tm.setPercentualFrequenciaCardiaca(0.0);
////		/**
//		 * Classe Musculação 
//		 */
//		Musculacao  s1 = new Musculacao();
//		s1.setSequenciaExercicio(1);
//		s1.setDescricaoExecicio("Supino");
//		s1.setFrequenciaTreino("semanal");
//		s1.setQuantidadeSeries(3);
//		s1.setQuantidadeRepeticoes(12);
//		s1.setPesoDaCarga(30.0);
//		s1.setMetodo("normal");
//		
//		tm.adicionarTreino(s1);
//		/**
//		 * Imprimir Classe Musculação
//		 */
//		
//		Musculacao  s2 = new Musculacao();
//		s2.setSequenciaExercicio(2);
//		s2.setDescricaoExecicio("Supino Inclinado");
//		s2.setFrequenciaTreino("semanal");
//		s2.setQuantidadeSeries(3);
//		s2.setQuantidadeRepeticoes(12);
//		s2.setPesoDaCarga(25.0);
//		s2.setMetodo("normal");
//
//		tm.adicionarTreino(s2);
//
//		
//		Musculacao  s3 = new Musculacao();
//		s3.setSequenciaExercicio(3);
//		s3.setDescricaoExecicio("Crucifixo");
//		s3.setFrequenciaTreino("semanal");
//		s3.setQuantidadeSeries(3);
//		s3.setQuantidadeRepeticoes(12);
//		s3.setPesoDaCarga(25.0);
//		s3.setMetodo("normal");
//
//		tm.adicionarTreino(s3);
//		System.out.println("===== Treino de Musculação  ======");
//		System.out.println(" ");
//		System.out.println("Nome do Cliente:     " + tm.getCodigoCliente().getNome());
//		System.out.println("Nome do Personal:    " + tm.getPersonalTrainer().getNome());
//		System.out.println("Modalidade:          " + tm.getModalidade().getDescricaoModalidade());
//		System.out.println("Nome do Treino:      " + tm.getNomeDoTreino());
//		System.out.println("Data Inicio :        " + sdf.format(tm.getDataInicioTreino()));
//		
////		tm.imprimirSequenciaTreino();
	}	
}	
