package Hotel1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean executando = true;

        while (executando) {
        	System.out.println("-----------------------------------------------");
        	System.out.println("\nOlá, seja Bem Vindo(a) ao sistema de gerenciamento do nosso Hotel\n");
        	System.out.println("Segue as nossas opções:\n");
            System.out.println("1 = Cadastrar Quarto");
            System.out.println("2 = Cadastrar Hóspede");
            System.out.println("3 = Realizar Check-in");
            System.out.println("4 = Realizar Check-out");
            System.out.println("5 = Listar Quartos Disponíveis");
//            System.out.println("6 = Listar Quartos Ocupados");
//            System.out.println("7 = Listar Hóspedes Cadastrados");
//            System.out.println("8 = Cadastrar Funcionários");
//            System.out.println("9 = Editar informações dos hóspedes");
//            System.out.println("10 = Editar Informações dos Funcionários");
//            System.out.println("11 = Visualizar Histórico de estadias");
//            System.out.println("12 = Calcular Salário dos Funcionários");
            System.out.println("6 = Criar Reserva");
            System.out.println("7 = Cancelar Reserva");
            System.out.println("8 = Sair\n");
            System.out.print("\nDigite dentre as nossas opções, a sua escolha: \n ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            try {
                switch (opcao) {
                    case 1: // Cadastrar Quarto
                        System.out.print("\nDigite o número do quarto: ");
                        String inputNumero = scanner.nextLine();
                        if (inputNumero.isEmpty()) {
                            System.out.println("\nCadastro de quarto cancelado! Número do quarto não informado.");
                            break;
                        }
                        int numero = Integer.parseInt(inputNumero);

                        System.out.print("\nDigite o tipo de quarto (Solteiro/ Casal / Suíte): ");
                        String tipo = scanner.nextLine().toLowerCase();
                        if (!(tipo.equals("solteiro") || tipo.equals("casal") || tipo.equals("grande") || tipo.equals("suíte") || tipo.equals("suite") || tipo.equals(""))) {
                        	System.out.println("\nImpossível cadastrar! Tipo do quarto não informado ou não coincide com o Tipo de quarto que trabalhamos (Solteiro, Casal ou Suíte).");
                        	break;	
                        	}	

                        System.out.print("\nDigite a capacidade do quarto ( 1, 2, 3, 4 ): ");
                        String inputCapacidade = scanner.nextLine();
                        if (!(inputCapacidade.equals("1") || inputCapacidade.equals("2") || inputCapacidade.equals("3") || inputCapacidade.equals("4") || tipo.equals(""))) {
                        	System.out.println("\nImpossível cadastrar! Capacidade do quarto não informada ou não corresponde ao limite de capacidade que nossos quartos possuem ( 1, 2 , 3, 4 )");
                        	break;	
                        	}	
                        
                        int capacidade = Integer.parseInt(inputCapacidade);

                        System.out.print("\nDigite o preço da diária (Em R$ ): ");
                        double preco = scanner.nextDouble();
                        
                        
                        Quarto quarto = new Quarto(numero, tipo, capacidade, preco);
                        hotel.cadastrarQuarto(quarto);
                        break;

                    case 2: // Cadastrar Hóspede
                        System.out.print("\nDigite o nome do hóspede: ");
                        String nomeHospede = scanner.nextLine();
                        if (nomeHospede.equals("")) {
                			System.out.println("\nImpossível cadastrar! Nome do Hóspede não informado!");
                			break;
                        }

                        System.out.print("\nDigite o CPF do hóspede ( 11 dígitos ): ");
                        String cpfHospede = scanner.nextLine();
                        if (cpfHospede.equals("")) {
                        	System.out.println("\nImpossível cadastrar! CPF do Hóspede não informado!");
                        	break;
                        }

                        System.out.print("\nDigite a data de nascimento do hóspede (dd/mm/aaaa): ");
                        String dataNascimento = scanner.nextLine();
                        if (dataNascimento.equals("")) {
                        	System.out.println("\nImpossível cadastrar! Data de Nascimento do Hóspede não informada!");
                        	break;
                        }

                        System.out.print("\nDigite o endereço do hóspede: ");
                        String endereco = scanner.nextLine();
                        if (endereco.equals("")) {
                        	System.out.println("\nImpossível cadastrar! Endereço do Hóspede não informado!");
                        	break;
                        }

                        System.out.print("\nDigite o número de contato do hóspede: ");
                        String numeroContato = scanner.nextLine();
                        if (numeroContato.equals("")) {
                        	System.out.println("\nImpossível cadastrar! Contato do Hóspede não informado.");
                        	break;
                        }

                        Hospede hospede = new Hospede(nomeHospede, cpfHospede, dataNascimento, endereco, numeroContato);
                        hotel.cadastrarHospede(hospede);
                        break;

                    case 3: // Realizar Check-in
                        System.out.print("\nDigite o número do quarto para check-in: ");
                        String InputnumeroQuartoCheckIn = scanner.nextLine();
                        if (InputnumeroQuartoCheckIn.equals("")) {
                        	System.out.println("\nImpossível realizar Check-in! Número do quarto não informado.");
                        	break;
                        }
                        
                        int numeroQuartoCheckIn = Integer.parseInt(InputnumeroQuartoCheckIn);

                        System.out.print("\nDigite o CPF do hóspede: ");
                        String cpfHospedeCheckIn = scanner.nextLine();
                        if (cpfHospedeCheckIn.equals("")) {
                        	System.out.println("\\nImpossível realizar Check-in! CPF do Hóspede não informado.");
                        	break;
                        }

                        hotel.realizarCheckIn(numeroQuartoCheckIn, cpfHospedeCheckIn);
                        break;

                    case 4: // Realizar Check-out
                        System.out.print("\nDigite o número do quarto para check-out: ");
                        String InputnumeroQuartoCheckOut = scanner.nextLine();
                        if (InputnumeroQuartoCheckOut.equals("")) {
                        	System.out.println("\nImpossível realizar Check-out! Número do quarto não informado.");
                        	break;
                        }
                        
                        int numeroQuartoCheckOut = Integer.parseInt(InputnumeroQuartoCheckOut);

                        hotel.realizarCheckOut(numeroQuartoCheckOut);
                        break;

                    case 5: // Listar Quartos Disponíveis
                        System.out.println("\nListando quartos disponíveis:");
                        hotel.listarQuartosDisponiveis();
                        break;

                    case 6: // Criar Reserva
                        System.out.print("\nDigite o CPF do hóspede para a reserva: ");
                        String cpfHospedeReserva = scanner.nextLine();

                        System.out.print("\nDigite o número do quarto para a reserva: ");
                        int numeroQuartoReserva = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha

                        System.out.print("\nDigite a data de entrada (dd/mm/yyyy): ");
                        String dataEntrada = scanner.nextLine();

                        System.out.print("\nDigite a data de saída (dd/mm/yyyy): ");
                        String dataSaida = scanner.nextLine();

                        Hospede hospedeReserva = hotel.buscarHospedePorCpf(cpfHospedeReserva);
                        Quarto quartoReserva = hotel.buscarQuartoPorNumero(numeroQuartoReserva);

                        if (hospedeReserva != null && quartoReserva != null) {
                            hotel.criarReserva(hospedeReserva, quartoReserva, dataEntrada, dataSaida);
                        } else {
                            System.out.println("\nHóspede ou quarto não encontrado.");
                        }
                        break;

                    case 7: // Cancelar Reserva
                        System.out.print("\nDigite o número do quarto para cancelar a reserva: ");
                        int numeroQuartoCancelar = scanner.nextInt();

                        hotel.cancelarReserva(numeroQuartoCancelar);
                        break;

                    case 8: // Sair
                        executando = false;
                        System.out.println("\nSaindo do sistema...");
                        break;

                    default:
                        System.out.println("\nOpção inválida! Tente novamente.");
                        break;
                }
            } catch (DadosInvalidosException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
