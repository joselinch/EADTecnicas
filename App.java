package trabalhoestrutura;

import java.util.Scanner;

public class App {
    	static Lista listaCadastro = new Lista();
	static Lista listaPacientesProntos = new Lista();
	static Fila atend = new Fila();
	static Fila fila1 = new Fila();
	static Fila fila2 = new Fila();
	static Fila fila3 = new Fila();
	static Fila fila4 = new Fila();
	static Fila fila5 = new Fila();
	
public static void main(String[] args) {
		int numero = -1;
		Scanner teclado = new Scanner(System.in);
		try{ while (numero<1 || numero>8) {
                    //deixa o código rodando enquanto números entre 1 e 8 forem digitados
                    //quando o número 8 é inserido, o código para, conforme disponibilizado ao usuário
                while (numero != 8 ){
                    System.out.println("\t ---Informe qual função deseja acessar---"
				+ "\n1 - Cadastrar um novo paciente"
				+ "\n2 - Pesquisar um paciente"
				+ "\n3 - Iniciar atendimento de um paciente"
				+ "\n4 - Chamar o paciente para o processo de triagem"
				+ "\n5 - Chamar o paciente para consulta"
				+ "\n6 - Realizar a liberação do paciente"
				+ "\n7 - Relatórios Administrativos" +
                                  "\n8 - Encerrar o programa");
		
		numero = teclado.nextInt();
		switch (numero) {
		case 1: 
			Paciente dado = cadastraPaciente();
			listaCadastro.addEnd(dado);
			//faz o cadastro do paciente e insere no final da listaCadastro
			break;
		case 2:
			consultaCadastroPaciente();
			break;
                        //faz a busca pelo paciente através do cpf e informa através de toString os dados do mesmo
		case 3:
			chamaAtendimento();
			//insere o paciente na lista de atendimento
			break;
		case 4:
			chamaTriagem(atend.dequeue().info);
			//chama o paciente para a triagem, para que sejam coletadas as informações vitais sobre o mesmo e ele seja inserido em
                        //alguma fila de prioridade
			break;
		case 5:
			Atendimento a = chamaConsulta();
			if (a != null) {
				listaPacientesProntos.addEnd(a);
				realizaConsulta(a);
			}
			
			break;
		case 6:
			altaPaciente();
			
			break;
		case 7:
			menuRelatorios();
			break;
                case 8:
                    System.out.println("Programa encerrado.");
		}
                }
                }
                }catch(Exception e){
                   numero = -1;
		   teclado = new Scanner(System.in);
                    System.out.println("Número inserido inválido, digite novamente.");
                    while (numero != 8 ){
                    System.out.println("\t ---Informe qual função deseja acessar---"
				+ "\n1 - Cadastrar um novo paciente"
				+ "\n2 - Pesquisar um paciente"
				+ "\n3 - Iniciar atendimento de um paciente"
				+ "\n4 - Chamar o paciente para o processo de triagem"
				+ "\n5 - Chamar o paciente para consulta"
				+ "\n6 - Realizar a liberação do paciente"
				+ "\n7 - Relatórios Administrativos" +
                                  "\n8 - Encerrar o programa");
		
		numero = teclado.nextInt();
		switch (numero) {
		case 1: 
			Paciente dado = cadastraPaciente();
			listaCadastro.addEnd(dado);
			//faz o cadastro do paciente e insere no final da listaCadastro
			break;
		case 2:
			consultaCadastroPaciente();
			break;
                        //faz a busca pelo paciente através do cpf e informa através de toString os dados do mesmo
		case 3:
			chamaAtendimento();
			//insere o paciente na lista de atendimento
			break;
		case 4:
			chamaTriagem(atend.dequeue().info);
			//chama o paciente para a triagem, para que sejam coletadas as informações vitais sobre o mesmo e ele seja inserido em
                        //alguma fila de prioridade
			break;
		case 5:
			Atendimento a = chamaConsulta();
			if (a != null) {
				listaPacientesProntos.addEnd(a);
				realizaConsulta(a);
			}
			
			break;
		case 6:
			altaPaciente();
			
			break;
		case 7:
			menuRelatorios();
			break;
                case 8:
                    System.out.println("Programa encerrado.");
                }
                }
	}
	}
	
public static void menuRelatorios() {
			int numero = 0;
			Scanner teclado = new Scanner(System.in);
			while (numero<1 || numero>3) {
			System.out.println("Digite o número correspondente a opção desejada"
					+ "\n1 - Tempo médio de espera para atendimento"
					+ "\n2 - Tempo médio de atendimento"
					+ "\n3 - Tempo médio de permanecimento");
			
			numero = teclado.nextInt(); //tratar excecao
			}
			
			//teclado.close();
			switch (numero) {
			case 1: 
				//Tempo médio de espera para atendimento
				relatorioEsperaAtendimento();
				break;
			case 2:
				//Tempo médio de atendimento
				relatorioAtendimento();
				break;
			case 3:
				relatorioAtendimentoFilas();
				//Tempo médio de permanecimento
				break;
			}
	}
	
public static Paciente cadastraPaciente() {
		System.out.println("-- CADASTRO DE PACIENTE -- ");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o nome");
		String nome = teclado.nextLine();
		System.out.println("Digite o CPF");
		String cpf = teclado.nextLine();
		System.out.println("Digite o ano de nascimento");
		int ano = teclado.nextInt();
		Paciente p1 = new Paciente(nome, cpf, ano);
		return p1;
		//faz o cadastro do paciente, coletando nome, cpf e data de nascimento e incluindo na fila de pacientes
	}
	
public static Paciente consultaCadastroPaciente() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o CPF que deve ser buscado");
		String cpf = teclado.nextLine();
		Paciente cadastrado = listaCadastro.searchByID(cpf);
		if (cadastrado != null) {
			System.out.println("O paciente está na lista. Seus dados: ");
                        cadastrado.toString();
			return cadastrado;
		} else {
			System.out.println("Paciente não cadastrado.");
			return null;
			
		}
		//faz a busca do paciente através da informação do seu CPF. Se o paciente for encontrado, é feito a impressão dos seus dados através de
                // do* cadastro.toString(), que imprime seu nome, cpf e data de nascimento
                // Caso o paciente não seja encontrado pelo cpf, retorna que o paciente não está cadastrado
		
	}	
public static void chamaAtendimento() {
		Paciente dado = consultaCadastroPaciente();
		System.out.println("Digite o horário de atendimento do paciente " + dado.getNome());
		int hora = registraHora();
		int minuto = registraMinuto();
		Atendimento a1 = new Atendimento(dado, hora, minuto);
		atend.enqueue(a1);
		System.out.println("Paciente " + dado.getNome() + " aguardando triagem");
	}
public static void chamaTriagem(Atendimento a) {
		System.out.println("-- TRIAGEM PACIENTE -- ");
		String nome = a.getPessoa().getNome();
		System.out.println("Será feita a triagem do paciente " + nome);
		Scanner leitura = new Scanner(System.in);
		System.out.println("Está entubado, apnéico, sem pulso ou sem reação?");
		if(soun()) {
			a.setPrioridade(1);
			fila1.enqueue(a);
		} else {
			System.out.println("Está em situação de alto risco? Confuso/letárgico/desorientado? Tem Dor ou sofrimento agudo?");
			if(soun()) {
				a.setPrioridade(2);
				fila2.enqueue(a);
			 } else {
				 System.out.println("Quantos procedimentos diferentes são necessárias(Raio X/testes/laboratoriais/injeções/procedimentos/consulta)?");
				 int numero = -1;
				 numero = leitura.nextInt();
                                 switch (numero) {
				 case 0:
					 a.setPrioridade(5);
					 fila5.enqueue(a);
					 break;
				 case 1:
					 a.setPrioridade(4);
					 fila4.enqueue(a);
					 break;
				 default:
					 System.out.println("Frequência Respiratória maior que 90 ou Frequência Cardiaca maior que 20 ou OP<90% ou IFPT<200?");
					 if(soun()) {
						 a.setPrioridade(2);
						 fila2.enqueue(a);
					 } else if(verificaTemperatura(a)<36 || verificaTemperatura(a)>38) {
						 a.setPrioridade(2);
						 fila2.enqueue(a);
					 } else {
						 a.setPrioridade(3);
						 fila3.enqueue(a);
					 }
                                 return;
                                 }
				 switch (numero) {
				 case 0:
					 a.setPrioridade(5);
					 fila5.enqueue(a);
					 break;
				 case 1:
					 a.setPrioridade(4);
					 fila4.enqueue(a);
					 break;
				 default:
					 System.out.println("Frequência Respiratória maior que 90 ou Frequência Cardiaca maior que 20 ou OP<90% ou IFPT<200?");
					 if(soun()) {
						 a.setPrioridade(2);
						 fila2.enqueue(a);
					 } else if(verificaTemperatura(a)<36 || verificaTemperatura(a)>38) {
						 a.setPrioridade(2);
						 fila2.enqueue(a);
					 } else {
						 a.setPrioridade(3);
						 fila3.enqueue(a);
					 }
				 }
				 
			 }
			}
		System.out.println("A triagem detectou que o paciente possui prioridade: " + a.getPrioridade());
	}//aqui ocorre a detecção do grua de prioridade do paciente, ocorrendo a coleta dos dados do mesmo, observando o risco e inserindo o mesmo na sua devida fila
	
	
public static Atendimento chamaConsulta() {
		if(!fila1.isEmpty()) {
			return fila1.dequeue().info;
		} else if (!fila2.isEmpty()){
			return fila2.dequeue().info;
			} else if (!fila3.isEmpty()){
			return fila3.dequeue().info;
			} else if (!fila4.isEmpty()){
				return fila2.dequeue().info;
			} else if (!fila5.isEmpty()){
				return fila2.dequeue().info;
			} else {
				System.out.println("Todas as filas estão vazias");
				return null;
			}
	}// aqui é feito o chamamento do paciente para a consulta, onde é feito de forma hierarquica, dando prioridade para a fila 1
         // depois a fila 2, depois a 3, depois a 4 e depois a 5
	
public static void realizaConsulta(Atendimento a) {
		try{System.out.println("-- CONSULTA DE PACIENTE -- ");
		System.out.println("Consulta do paciente " + a.getPessoa().getNome());
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o horário do início da consulta:");
		int hora = registraHora();
		int minuto = registraMinuto();
		a.sethAtend(hora);
		a.setmAtend(minuto);
		int tempo = (hora-a.getHoraChegada())*60 + minuto-a.getMinChegada();
		espera+=tempo;
		numAtend++;}catch (Exception e){
                    System.out.println("Entrada incorreta, por favor, insira novamente: ");
                    System.out.println("-- CONSULTA DE PACIENTE -- ");
		System.out.println("Consulta do paciente " + a.getPessoa().getNome());
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o horário do início da consulta:");
		int hora = registraHora();
		int minuto = registraMinuto();
		a.sethAtend(hora);
		a.setmAtend(minuto);
		int tempo = (hora-a.getHoraChegada())*60 + minuto-a.getMinChegada();
		espera+=tempo;
		numAtend++;
                    
                }
		
		if(a.getTemperatura()==0) {
			System.out.println("Não há registro de coleta de temperatura na triagem");
			double temperatura=verificaTemperatura(a);
			a.setTemperatura(temperatura);
		}
		
		try{
                    Scanner teclado = new Scanner(System.in);
                    System.out.println("Digite o parecer:");
		String parecer = teclado.nextLine();
		a.setParecer(parecer);
		System.out.println("Consulta encerrada");}catch(Exception e){
                    System.out.println("Entrada incorreta, digite novamente: ");
                    System.out.println("Digite o parecer:");
                 Scanner teclado = new Scanner(System.in);
		String parecer = teclado.nextLine();
		a.setParecer(parecer);
		System.out.println("Consulta encerrada");
                }
	}
	// aqui o paciente realiza a consulta e, caso na triagem não tenha sido coletada a temperatura ou outras informações, aqui é feita.
        // se pede a hora de entrada, minuto de entrada para que assim se possam fazer os relatórios
	
public static void altaPaciente() {
		System.out.println("\t LIBERAÇÃO ");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o CPF do paciente");
		String cpf1 = teclado.nextLine();
		Atendimento alta = listaPacientesProntos.searchCpf(cpf1);
		if (alta != null) {
			int hora = registraHora();
			int minuto = registraMinuto();
			alta.setHoraSaida(hora);
			alta.setMinSaida(minuto);
			
			int tempo = (hora-alta.gethAtend())*60 + minuto-alta.getmAtend();
			duracaoAtend+=tempo;
			liberados++;
			
			
		} else {
			System.out.println("Paciente não está presente na lista de atendimentos encerrados");
		}
	}
	//aqui é feita a liberação do paciente através do seu CPF. Assim, se pede o horário de liberação e se coloca o paciente na lista
        // de consultas encerradas
public static double verificaTemperatura(Atendimento a1) {
		try{Scanner teclado = new Scanner(System.in);
		System.out.println("Informe a temperatura do paciente em graus: ");
		double temperatura = teclado.nextDouble();
		a1.setTemperatura(temperatura);
		return temperatura;}catch(Exception e){
                    Scanner teclado = new Scanner(System.in);
		System.out.println("Informe a temperatura do paciente em graus: ");
		double temperatura = teclado.nextDouble();
		a1.setTemperatura(temperatura);
		return temperatura;
                }
	}
	// metodo para a coleta da temperatura
public static void relatorioEsperaAtendimento() {
		System.out.println("Número de atendimentos ocorridos: " + numAtend);
		System.out.println("Tempo de espera: " + espera/60);
		System.out.println("Média de tempo de espera: " + (double)espera/numAtend/60);
	}
        //metodo que faz a disponibilização dos relatórios sobre a espera de atendimento e o número de atendimentos realizados. Como hora e minuto foram coletados de maneira separada
        //é convertida a hora em minutos, feito a media e após convertido novamente para horas.
public static void relatorioAtendimento() {
		System.out.println("Número de atendimentos ocorridos com pacientes liberados: " + liberados);
		System.out.println("Tempo de atendimento " + duracaoAtend/60);
		System.out.println("Média de tempo de atendimento: " + (double)duracaoAtend/liberados/60);
		//metodo que faz a disponibilização dos relatórios sobre a demora dos atendimentos até a liberação do paciente. Como hora e minuto foram coletados de maneira separada
        //é convertida a hora em minutos, feito a media e após convertido novamente para horas.
	}
	
public static void relatorioAtendimentoFilas() {
		int [] fila = new int [6];
		int [] qtd = new int [6]; 		
		for (int i=0; i<listaPacientesProntos.retornaTamanho(); i++) {
			Nodo aux = listaPacientesProntos.retornaNodo(i);
			int prioridade = aux.getInfo().getPrioridade();
			int tempo = (aux.getInfo().getHoraSaida() - aux.getInfo().getHoraChegada())*60 + aux.getInfo().getMinSaida() - aux.getInfo().getMinChegada();
			fila[prioridade]+=tempo;
			qtd[prioridade]++;
			
		}
		for(int i=1;i<6;i++) {
			if(qtd[i]!=0) {
			System.out.println("Tempo médio de atendimento da fila " + i + " = " + fila[i]/qtd[i]);
		}
		
	}
}
            // faz o relatório baseado nas filas, seus tempos e seus tamanhos.
static int espera;
static int numAtend;
static int duracaoAtend;
static int liberados;
//variaveis que auxiliam nos relatórios
public static int registraHora() {
		try{Scanner teclado = new Scanner(System.in);
		System.out.println("Digite a hora:");
		int hora = teclado.nextInt();
		return hora;}catch(Exception e){
                    System.out.println("Entrada inválida, por favor tente novamente");
                    Scanner teclado = new Scanner(System.in);
		System.out.println("Digite a hora:");
		int hora = teclado.nextInt();
		return hora;
                }
	}
	//auxilia na coleta da hora
public static int registraMinuto() {
		try{Scanner teclado = new Scanner(System.in);
		System.out.println("Digite os minutos:");
		int minutos = teclado.nextInt();
		return minutos;}catch(Exception e){
                    System.out.println("Entrada inválida, por favor insira numeros inteiros");
                    Scanner teclado = new Scanner(System.in);
		System.out.println("Digite os minutos:");
		int minutos = teclado.nextInt();
		return minutos;
                }
	}
        //auxilia na coleta dos minutos
public static boolean soun() {
		Scanner tecladoNumero = new Scanner(System.in);
		try
                {System.out.println("Digite 1 para SIM ou 2 para NÃO");
		int numero = 0;
		numero = tecladoNumero.nextInt();
		while (numero !=1 && numero!=2) {
			System.out.println("Digite uma opção válida (1 para SIM ou 2 para NÃO)");
			numero = tecladoNumero.nextInt();
		}
		if (numero==1) {
			return true;
		} else {
			return false;
			}
                }catch (Exception e){
                    tecladoNumero = new Scanner(System.in);
                    System.out.println("Resposta inválida, digite novamente: ");
                    System.out.println("Digite 1 para SIM ou 2 para NÃO");
		int numero = 0;
		numero = tecladoNumero.nextInt();
		while (numero !=1 && numero!=2) {
			System.out.println("Digite uma opção válida (1 para SIM ou 2 para NÃO)");
			numero = tecladoNumero.nextInt();
		}
		if (numero==1) {
			return true;
		} else {
			return false;
			}
                }
        //metodo feito para auxiliar na coleta de dados do tipo booleano, no caso sim ou não, false ou true
}
}


