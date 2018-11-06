package Testes;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class MovimentaçãoBancária {
	public static void main(String[] args) throws Exception{
		Scanner entrada = new Scanner(System.in);
		Scanner entrada2 = new Scanner(System.in);                //  senha gerente  ( 1010 )
		Scanner entrada3 = new Scanner(System.in);               
		Scanner ler = new Scanner(System.in);
		int v = 10;
		String[] Nome = new String[v];
		int[] senha = new int[v];
		String[] Endereco = new String[v];
		String[] Telefone = new String[v];
		String[] cpf = new String[v];
		String[] cc = new String[v];
		String[] NumeroAgencia = new String[v];
		String[] NomeGerente = new String[v];
		double[] SaldoAtual = new double[v];
		String operador;
		int operacao;
		int contador = 0;
		int retornar = 1;
		int senhaUsuario = 0;
		int senhaGerente = 0;
		do {
			System.out.printf("%n%n");
			System.out.printf("|************************************************|");
			System.out.printf("%n|             *** Banco 24 Horas ***             |");  // 50 linhas
			System.out.printf("%n|         OPERADOR - GERENTE ou USUÀRIO ?        |");
			System.out.printf("%n|       IDENTIFIQUE-SE:            ( ");
			operador = entrada.next();
		if(operador.equals("usuario") | operador.equals("gerente")) {
			if(operador.equals("gerente")) {
				FileWriter arqGerente = new FileWriter("D:\\Eclipse\\ExtratoGerente.txt",true);
				PrintWriter salvarGerente = new PrintWriter(arqGerente);
				System.out.printf("|       DIGITE SUA SENHA:          ( ");
				senhaGerente = ler.nextInt();
				System.out.printf("|------------------------------------------------|");
				int i = 1;
				while(senhaGerente != 1010) {
					System.out.printf("%n|          ****** SENHA INVÁLIDA *****           |");
					System.out.printf("%n|          *** DIGITE NOVAMENTE    ( ");
					senhaGerente = ler.nextInt();
					System.out.printf("|------------------------------------------------|");
					i ++;
					if(i == 3) {
						System.out.printf("|------------------------------------------------|");
						System.out.printf("%n| *****  -----  *****  -----  *****  -----  *****|");
						System.out.printf("%n|       ******   SENHA NÃO CONFERE   ******      |");
						System.out.printf("%n|    ********   CONTATE SUA AGÉNCIA   ********   |");
						System.out.printf("%n| *****  -----  *****  -----  *****  -----  *****|");
						System.out.printf("%n|------------------------------------------------|");
						senhaGerente = 1010;
						i ++;
						operacao = 5;
					}
				}
				int retornarGerente;
				do {
					if(i == 1 | i <= 3) {
					System.out.printf("%n|                 *** OPERAÇÃO ***               |");
					System.out.printf("%n|------------------------------------------------|");
					System.out.printf("%n|       ( 1 ) CADASTRO de CLIENTE                |");
					System.out.printf("%n|       ( 2 ) VISUALIZAR CADASTRO                |");
					System.out.printf("%n|       ( 3 ) MOVIMENTAÇÃO                       |");
					System.out.printf("%n|       ( 4 ) SALVAR e SAIR        (  ");
					operacao = ler.nextInt();
					System.out.printf("|------------------------------------------------|");
					while(operacao == 0 | operacao > 4) {
						System.out.printf("%n|    ********** OPERAÇÃO INVÁLIDA **********     |");
						System.out.printf("%n|------------------------------------------------|");
						System.out.printf("%n|       DIGITE NOVAMENTE:          (  ");
						operacao = ler.nextInt();
						System.out.printf("|------------------------------------------------|");
					}
					while(operacao != 1 & contador == 0) {
						System.out.printf("%n|    /// AINDA NÃO TEM CLIENTE CADASTRADO ///    |");
						System.out.printf("%n|      -----     -----     -----     -----       |");
						System.out.printf("%n|       ( 1 ) PARA CADASTRAR       (  ");
						operacao = ler.nextInt();
						System.out.printf("|------------------------------------------------|");
					}
					}else {
						operacao = 5;
					}
					switch(operacao) {
					case 1:
						System.out.printf("%n|     ***** INSIRA OS DADOS DO CLIENTE *****     |");
						System.out.printf("%n|------------------------------------------------|");
						int sairCadastro = 1;
						while(sairCadastro == 1){
							System.out.printf("%n|       NOME:           ( ");
							Nome[contador] = entrada.next();
							System.out.printf("|       SENHA:          ( ");
							senha[contador] = ler.nextInt();
							System.out.printf("|       ENDEREÇO:       ( ");
							Endereco[contador] = entrada.next();
							System.out.printf("|       TELEFONE:       ( ");
							Telefone[contador] = entrada2.next();
							System.out.printf("|       CPF             ( ");
							cpf[contador] = entrada.next();
							System.out.printf("|       CONTA CORRENTE: ( ");
							cc[contador] = entrada2.next();
							System.out.printf("|       AGÊNCIA:        ( ");
							NumeroAgencia[contador] = entrada3.next();
							System.out.printf("|       GERENTE:        ( ");
							NomeGerente[contador] = entrada3.next();
							System.out.printf("|       SALDO ATUAL:    ( ");
							SaldoAtual[contador] = ler.nextDouble();
							System.out.printf("|------------------------------------------------|");
							System.out.printf("%n|       ( 1 ) NOVO CADASTRO                      |");
							System.out.printf("%n|       ( 0 ) SAIR                 ( ");
							contador ++;
							sairCadastro = ler.nextInt();
							System.out.printf("|------------------------------------------------|");
							while(sairCadastro != 0 & sairCadastro != 1) {
								System.out.printf("%n|          ???   ERRO DE DIGITAÇÃO   ???         |");
								System.out.printf("%n|       ( 1 ) NOVO CADASTRO                      |");
								System.out.printf("%n|       ( 0 ) SAIR                 ( ");
								sairCadastro = ler.nextInt();
								System.out.printf("|________________________________________________|");
							}
						}
						break;
					case 2:
						for(int a = 0; a < contador; a ++) {
							System.out.printf("%n|  **  **  **  **  CLIENTE ( %2d ) **  **  **  ** |", a + 1);
							System.out.printf("%n|       NOME: %33s  |",Nome[a]);
							System.out.printf("%n|       SENHA: %32s  |",senha[a]);
							System.out.printf("%n|       ENDEREÇO: %29s  |",Endereco[a]);
							System.out.printf("%n|       TELEFONE: %29s  |",Telefone[a]);
							System.out.printf("%n|       CPF: %34s  |",cpf[a]);
							System.out.printf("%n|       CONTA CORRENTE: %23s  |",cc[a]);
							System.out.printf("%n|       NUMERO DA AGÊNCIA: %20s  |",NumeroAgencia[a]);
							System.out.printf("%n|       NOME DO GERENTE: %22s  |",NomeGerente[a]);
							System.out.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[a]);
							System.out.printf("%n|________________________________________________|");
						}
						break;
					case 3:
						System.out.printf("%n|       ***       EM CONSTRUÇÃO       ***        |");
						System.out.printf("%n|________________________________________________|");
						break;
					case 4:
						System.out.printf("%n|     **  **  SALVAR E GERAR EXTRATO  **  **     |");
						for(int a = 0; a < contador; a++) {
							System.out.printf("%n|       CONTA: ( %2d ) %26s |",a + 1, Nome[a]);
						}
						System.out.printf("%n|------------------------------------------------|");
						System.out.printf("%n| INSIRA O NUMERO DA CONTA PARA IMPRESSÃO (  ");
						int cliente = ler.nextInt();
						while(cliente == 0 & cliente > contador) {
							System.out.printf("|------------------------------------------------|");
							System.out.printf("%n|       DIGITAÇÃO ERRADA - TENTE NOVAMENTE  (  ");
							cliente = ler.nextInt();
						}
						salvarGerente.printf("%n|________________________________________________|");
						salvarGerente.printf("%n|  **  **  **  CADASTRO CLIENTE ( %2d ) **  ** ** |", cliente);
						salvarGerente.printf("%n|       NOME: %33s  |",Nome[cliente]);
						salvarGerente.printf("%n|       SENHA: %32s  |",senha[cliente]);
						salvarGerente.printf("%n|       ENDEREÇO: %29s  |",Endereco[cliente]);
						salvarGerente.printf("%n|       TELEFONE: %29s  |",Telefone[cliente]);
						salvarGerente.printf("%n|       CPF: %34s  |",cpf[cliente]);
						salvarGerente.printf("%n|       CONTA CORRENTE: %23s  |",cc[cliente]);
						salvarGerente.printf("%n|       NUMERO DA AGÊNCIA: %20s  |",NumeroAgencia[cliente]);
						salvarGerente.printf("%n|       NOME DO GERENTE: %22s  |",NomeGerente[cliente]);
						salvarGerente.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[cliente]);
						salvarGerente.printf("%n|________________________________________________|");
						System.out.printf("|       *** OPERAÇÃO SALVA COM SUCESSO ***       |");
						System.out.printf("%n|  -----  -----  -----  -----  -----  -----  ----|");
						System.out.printf("%n|           *** OPERAÇÃO FINALIZADA ***          |");
						System.out.printf("%n|________________________________________________|");
						arqGerente.close();
						break;
						default:
							System.out.printf("%n|           *** OPERAÇÃO FINALIZADA ***          |");
							System.out.printf("%n|________________________________________________|");
					}
					retornarGerente = operacao;
				}while(retornarGerente >= 1 & retornarGerente <= 3 );
				}else {
					if(operador.equals("usuario")) {
						FileWriter arqUsuario = new FileWriter("D:\\Eclipse\\ExtratoUsuario.txt",true);
						PrintWriter salvarUsuario = new PrintWriter(arqUsuario);
						salvarUsuario.printf("|************************************************|");
						salvarUsuario.printf("%n|             *** Banco 24 Horas ***             |");
						int retornarUsuario;
						int primeiroAcesso = 0;
						System.out.printf("|       DIGITE SEU NOME:           ( ");
						String nomeConferencia = entrada.next();
						do {
							if(contador == 0) {
								System.out.printf("|------------------------------------------------|");								
								System.out.printf("%n|        *** NENHUMA CONTA CADASTRADA ***        |");
								System.out.printf("%n|    *** ENTRE EM CONTATO COM SEU GERENTE ***    |");
								System.out.printf("%n|------------------------------------------------|");
								System.out.printf("%n|           *** OPERAÇÃO FINALIZADA ***          |");
								System.out.printf("%n|________________________________________________|");
								operacao = 7;
							}else {
								int indice = 0;
								for(int j = 0; j < contador; j ++) {
									if(Nome[j].equals(nomeConferencia)) {
										indice = j;
									}
								}
								if(Nome[indice].equals(nomeConferencia)) {
									int i = 1;
									if(primeiroAcesso == 0) {
										primeiroAcesso ++;
										System.out.printf("|       DIGITE SUA SENHA:          ( ");
										senhaUsuario = ler.nextInt();
										while(senhaUsuario != senha[indice]) {
											System.out.printf("|  -----  -----  -----  -----  -----  -----  ----|");
											System.out.printf("%n|           ***** SENHA INVÁLIDA *****           |");
											System.out.printf("%n|       DIGITE NOVAMENTE           ( ");
											senhaUsuario = ler.nextInt();
											i ++;
											if(i == 3 & senhaUsuario != senha[indice]) {
												System.out.printf("|------------------------------------------------|");
												System.out.printf("%n| *****  -----  *****  -----  *****  -----  *****|");
												System.out.printf("%n|      SUA     SENHA     FOI     CANCELADA       |");
												System.out.printf("%n|           PROCURE    SEU    GERENTE            |");
												System.out.printf("%n| -----  *****  -----  *****  -----  *****  -----|");
												senhaUsuario = senha[indice];
												i ++;
											}
										}
									}
									if(i <= 3) {
										System.out.printf("%n|------------------------------------------------|");
										System.out.printf("%n|                 *** OPERAÇÃO ***               |");
										System.out.printf("%n|------------------------------------------------|");
										System.out.printf("%n|       ( 1 ) DEPOSITO                           |");
										System.out.printf("%n|       ( 2 ) SIMULAR RECEBIMENTO                |");
										System.out.printf("%n|       ( 3 ) PAGAMENTO de BOLETO                |");
										System.out.printf("%n|       ( 4 ) CONSULTA de SALDO                  |");
										System.out.printf("%n|       ( 5 ) TRANSFERÊNCIA                      |");
										System.out.printf("%n|       ( 6 ) FINALIZAR E IMRIMIR EXTRATO        |");
										System.out.printf("%n|       ( 7 ) FINALIZAR OPERAÇÃO   (  ");
										operacao = ler.nextInt();
										System.out.printf("|------------------------------------------------|");
										while(operacao == 0 | operacao > 7) {
											System.out.printf("|------------------------------------------------|");
											System.out.printf("%n|    ********** OPERAÇÃO INVÁLIDA **********     |");
											System.out.printf("%n|------------------------------------------------|");
											System.out.printf("%n|       DIGITE NOVAMENTE:          (  ");
											operacao = ler.nextInt();
										}
									}else {
										operacao = 7;
									}
								}else {
									System.out.printf("  |      ****   NÃO EXISTE ESTE USUÁRIO   ****     |");
									operacao = 7;
								}
							switch(operacao) {
							case 1:
								int e;
								System.out.printf("%n|                *** DEPOSITO ***                |");
								System.out.printf("%n|    **  **  **  **  CLIENTES  **  **  **  **    |");
								for(int a = 0; a < contador; a++) {
									System.out.printf("%n|       ( %2d ) CORRENTISTA:%20s  |",a + 1, Nome[a]);
									System.out.printf("%n|       CONTA CORRENTE: %23s  |",cc[a]);
								}
								System.out.printf("%n|------------------------------------------------|");
								System.out.printf("%n|       VALOR PARA DEPOSITO:       (  ");
								Double deposito = ler.nextDouble();
								System.out.printf("|       CONTA DO FAVORECIDO:       (  ");
								int H = ler.nextInt();
								System.out.printf("|------------------------------------------------|");
								System.out.printf("%n|  ** **  **  **  ** FAVORECIDO **  **  **  **   |");
								System.out.printf("%n|       NOME: %33s  |",Nome[H - 1]);
								System.out.printf("%n|       CPF: %34s  |",cpf[H - 1]);
								System.out.printf("%n|       CONTA CORRENTE: %23s  |",cc[H - 1]);
								System.out.printf("%n|       AGÊNCIA DE DESTINO: %19s  |",NumeroAgencia[H - 1]);
								System.out.printf("%n|       VALOR DEPOSITADO: %21.2f  |",deposito);
								System.out.printf("%n|------------------------------------------------|");
								System.out.printf("%n|       ( 1 ) SIM - CONFIRMA TRANSAÇÃO           |");
								System.out.printf("%n|       ( 2 ) NÃO                  (  ");
								e = ler.nextInt();
								while(e != 1 & e != 2) {
									System.out.printf("|------------------------------------------------|");
									System.out.printf("%n|            ***  ERRO DE DIGITÇÃO ***           |");
									System.out.printf("%n|       ( 1 ) SIM ( 2 ) NÃO        (  ");
									e = ler.nextInt();
								}
								if(e == 1) {
									salvarUsuario.printf("%n|************************************************|");
									salvarUsuario.printf("%n|            *** EXTRATO DE DEPOSITO ***         |");
									salvarUsuario.printf("%n|  ** **  **  **  ** FAVORECIDO **  **  **  **   |");
									salvarUsuario.printf("%n|       NOME: %33s  |",Nome[H - 1]);
									salvarUsuario.printf("%n|       CPF: %34s  |",cpf[H - 1]);
									salvarUsuario.printf("%n|       CONTA CORRENTE: %23s  |",cc[H - 1]);
									salvarUsuario.printf("%n|       AGÊNCIA DE DESTINO: %19s  |",NumeroAgencia[H - 1]);
									salvarUsuario.printf("%n|       VALOR DEPOSITADO: %21.2f  |",deposito);
									salvarUsuario.printf("%n|************************************************|");
									SaldoAtual[H - 1] = SaldoAtual[H - 1] + deposito;
								}
								break;
							case 2:
								System.out.printf("%n|               *** RECEBIMENTO ***              |");
								double receber = 250.00;
								System.out.printf("%n|------------------------------------------------|");
								System.out.printf("%n|  ** **  **  **  ** FAVORECIDO **  **  **  **   |");
								System.out.printf("%n|       NOME: %33s  |",Nome[indice]);
								System.out.printf("%n|       CPF: %34s  |",cpf[indice]);
								System.out.printf("%n|       CONTA CORRENTE: %23s  |",cc[indice]);
								System.out.printf("%n|       AGÊNCIA DE DESTINO: %19s  |",NumeroAgencia[indice]);
								System.out.printf("%n|       SALDO ANTERIOR: %23.2f  |",SaldoAtual[indice]);
								System.out.printf("%n|       VALOR RECEBIDO: %23.2f  |",receber);
								System.out.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[indice] + receber);
								salvarUsuario.printf("%n|************************************************|");
								salvarUsuario.printf("%n|               *** EXTRATO ***               |");
								salvarUsuario.printf("%n|  ** **  **  **  ** FAVORECIDO **  **  **  **   |");
								salvarUsuario.printf("%n|       NOME: %33s  |",Nome[indice]);
								salvarUsuario.printf("%n|       CPF: %34s  |",cpf[indice]);
								salvarUsuario.printf("%n|       CONTA CORRENTE: %23s  |",cc[indice]);
								salvarUsuario.printf("%n|       AGÊNCIA DE DESTINO: %19s  |",NumeroAgencia[indice]);
								salvarUsuario.printf("%n|       SALDO ANTERIOR: %23.2f  |",SaldoAtual[indice]);
								salvarUsuario.printf("%n|       VALOR RECEBIDO: %19.2f  |",receber);
								salvarUsuario.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[indice] + receber);
								salvarUsuario.printf("%n|************************************************|");
								SaldoAtual[indice] = SaldoAtual[indice] + receber;
								break;
							case 3:
								System.out.printf("%n|                *** PAGAMENTO ***               |");
								double pagamentoBoleto;
								e = 1;
								while(e == 1) {
									System.out.printf("%n|------------------------------------------------|");
									System.out.printf("%n|       VALOR DO BOLETO:           (  ");
									pagamentoBoleto = ler.nextDouble();
									System.out.printf("|------------------------------------------------|");
									System.out.printf("%n|       CORRENTISTA:       ( %2d ) %13s  |",indice + 1, Nome[indice]);
									System.out.printf("%n|       VALOR DO BOLETO:     %18.2f  |",pagamentoBoleto);
									System.out.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[indice]);
									System.out.printf("%n|------------------------------------------------|");
									System.out.printf("%n|       ( 1 ) SIM - CONFIRMA TRANSAÇÃO           |");
									System.out.printf("%n|       ( 2 ) NÃO                  (  ");
									e = ler.nextInt();
									while(e != 1 & e != 2) {
										System.out.printf("|------------------------------------------------|");
										System.out.printf("%n|            ***  ERRO DE DIGITÇÃO ***           |");
										System.out.printf("%n|       ( 1 ) SIM ( 2 ) NÃO        (  ");
										e = ler.nextInt();
									}
									if(SaldoAtual[indice] < pagamentoBoleto) {
										System.out.printf("|       $$$ SALDO EM CONTA INSUFICIÊNTE $$$      |");
									}
									if(SaldoAtual[indice] >= pagamentoBoleto) {
										System.out.printf("|------------------------------------------------|");
									    System.out.printf("%n|  ** **  **  **   DADOS DA CONTA   **  **  **   |");
									    System.out.printf("%n|       NOME: %33s  |",Nome[indice]);
								    	System.out.printf("%n|       CPF: %34s  |",cpf[indice]);
									    System.out.printf("%n|       CONTA CORRENTE: %23s  |",cc[indice]);
								    	System.out.printf("%n|       NUMERO DA AGÊNCIA: %20s  |",NumeroAgencia[indice]);
								    	System.out.printf("%n|       SALDO ANTERIOR: %23.2f  |",SaldoAtual[indice]);
								    	System.out.printf("%n|       VALOR DO BOLETO:     %18.2f  |",pagamentoBoleto);
								    	System.out.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[indice] - pagamentoBoleto);
								    	salvarUsuario.printf("%n|************************************************|");
								    	salvarUsuario.printf("%n|                 *** EXTRATO ***                |");
								    	salvarUsuario.printf("%n|           *** PAGAMENTO ON LINE ***            |");
								    	salvarUsuario.printf("%n|   ** **  **  DADOS DA CONTA CORRENTE  **  **   |");
								    	salvarUsuario.printf("%n|       NOME: %33s  |",Nome[indice]);
								    	salvarUsuario.printf("%n|       CPF: %34s  |",cpf[indice]);
								    	salvarUsuario.printf("%n|       CONTA CORRENTE: %23s  |",cc[indice]);
								    	salvarUsuario.printf("%n|       SALDO ANTERIOR: %23.2f  |",SaldoAtual[indice]);
								    	salvarUsuario.printf("%n|       VALOR DO BOLETO    : %18.2f  |",pagamentoBoleto);
								    	salvarUsuario.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[indice] - pagamentoBoleto);
								    	salvarUsuario.printf("%n|************************************************|");
								    	SaldoAtual[indice] = SaldoAtual[indice] -  pagamentoBoleto;
									}
									System.out.printf("%n|------------------------------------------------|");
									System.out.printf("%n|       ( 1 ) REPETIR TRANSAÇÃO                  |");
									System.out.printf("%n|       ( 2 ) SAIR                 (  ");
									e = ler.nextInt();
									while(e != 1 & e != 2) {
										System.out.printf("|------------------------------------------------|");
										System.out.printf("%n|            ***  ERRO DE DIGITÇÃO ***           |");
										System.out.printf("%n|       ( 1 ) REPETIR ( 2 ) SAIR   (  ");
										e = ler.nextInt();
									}
								}
								break;
							case 4:
								System.out.printf("%n|            *** CONSULTA DE SALDO ***           |");
								System.out.printf("%n|       NOME: %33s  |",Nome[indice]);
								System.out.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[indice]);
								salvarUsuario.printf("%n|************************************************|");
								salvarUsuario.printf("%n|                 *** EXTRATO ***                |");
								salvarUsuario.printf("%n|            *** CONSULTA DE SALDO ***           |");
								salvarUsuario.printf("%n|  ** **  **  **  CONTA CORRENTE  **  **  **  ** |");
								salvarUsuario.printf("%n|       NOME: %33s  |",Nome[indice]);
								salvarUsuario.printf("%n|       SALDO ATUAL: %26.2f  |",SaldoAtual[indice]);
								salvarUsuario.printf("%n|************************************************|");
								break;
							case 5:
								double transferencia = 0;
								System.out.printf("%n|   ** **  **  **  TRANSFERÊNCIA  **  **   **    |");
								e = 1 ;
								while(e == 1) {
									System.out.printf("%n|   **  **  **  **   CLIENTES   **  **  **  **   |");
									for(int a = 0; a < contador; a++) {
										if(a == indice) {
											System.out.printf("");
										}
										System.out.printf("%n|       ( %2d ) CORRENTISTA:%20s  |",a + 1, Nome[a]);
									}
									System.out.printf("%n|------------------------------------------------|");
									System.out.printf("%n|       VALOR PARA TRANSFERÊNCIA:  (  ");
									transferencia = ler.nextDouble();
									System.out.printf("|       CONTA DE DESTINO:          (  ");
									int D = ler.nextInt();
									System.out.printf("|------------------------------------------------|");
									System.out.printf("%n|       CONTA DESTINO: ( %2d ) %17s  |",D, Nome[D - 1]);
									System.out.printf("%n|       VALOR TRANSFERÊNCIA: %18.2f  |",transferencia);
									System.out.printf("%n|------------------------------------------------|");
									System.out.printf("%n|          **** CONFIRMAR TRANSAÇÃO ****         |");
									System.out.printf("%n|       ( 1 ) SIM                                |");
									System.out.printf("%n|       ( 2 ) NÃO                 (  ");
									e = ler.nextInt();
									while(e != 1 & e != 2) {
										System.out.printf("|------------------------------------------------|");
										System.out.printf("%n|            ***  ERRO DE DIGITÇÃO ***           |");
										System.out.printf("%n|       ( 1 ) SIM ( 2 ) NÃO        (  ");
										e = ler.nextInt();
										System.out.printf("|------------------------------------------------|");
									}
									if(e == 1){
										if(transferencia <= SaldoAtual[indice]) {
											salvarUsuario.printf("%n|************************************************|");
											salvarUsuario.printf("%n|                *** EXTRATO ***                 |");
											salvarUsuario.printf("%n|  * **  **  **  ** FAVORECIDO **  **  **  **  * |");
											salvarUsuario.printf("%n|       NOME: %33s  |",Nome[D - 1]);
											salvarUsuario.printf("%n|       CONTA CORRENTE: %23s  |",cc[D - 1]);
											salvarUsuario.printf("%n|       SALDO ANTERIOR: %23f  |",SaldoAtual[D - 1]);
											salvarUsuario.printf("%n|       VALOR TRANSFERÊNCIA: %18s  |",transferencia);
											salvarUsuario.printf("%n|       SALDO ATUAL: %26f  |",SaldoAtual[D - 1] + transferencia);
											salvarUsuario.printf("%n|************************************************|");
											SaldoAtual[D - 1] = SaldoAtual[D - 1] +  transferencia;
											SaldoAtual[indice] = SaldoAtual[indice] -  transferencia;
											}
										else{
												System.out.printf("|------------------------------------------------|");
												System.out.printf("%n|          ***   TRANSAÇÃO CANCELADA ***         |");
												System.out.printf("%n|       $$$ SALDO EM CONTA INSUFICIÊNTE $$$      |%n");
											}
										}
									System.out.printf("|------------------------------------------------|");
									System.out.printf("%n|       ( 1 ) REPETIR TRANSAÇÃO                  |");
									System.out.printf("%n|       ( 2 ) SAIR                 (  ");
									e = ler.nextInt();
									while(e != 1 & e != 2) {
										System.out.printf("|------------------------------------------------|");
										System.out.printf("%n|            ***  ERRO DE DIGITÇÃO ***           |");
										System.out.printf("%n|       ( 1 ) REPETIR ( 2 ) SAIR   (  ");
										e = ler.nextInt();
									}
								}
								break;
							case 6:
								System.out.printf("|            *** RETIRE SEU EXTRATO ***          |");
								System.out.printf("%n|               *** VOLTE SEMPRE ***             |%n");
								arqUsuario.close();
								break;
								default:
									System.out.printf("%n|------------------------------------------------|");
									System.out.printf("%n|           *** OPERAÇÃO FINALIZADA ***          |");
									System.out.printf("%n|________________________________________________|");
							}
							}
							retornarUsuario = operacao;
							}while(retornarUsuario >= 1 & retornarUsuario <= 5);
						}
					}
			}else {
				System.out.printf("|------------------------------------------------|");
		        System.out.printf("%n|           *** OPERAÇÃO FINALIZADA ***          |");
	        	System.out.printf("%n|________________________________________________|");
	        	}
		}while(retornar == 1 );
		}
	}
