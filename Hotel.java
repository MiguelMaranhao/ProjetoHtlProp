package Hotel1;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Hospede> hospedes;
    private List<Funcionario> funcionarios;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        hospedes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    // 1. Gerenciamento de Quartos

    // Cadastrar novo quarto
    public void cadastrarQuarto(Quarto quarto) throws DadosInvalidosException {
        if (quarto == null || quarto.getNumero() <= 0) {
            throw new DadosInvalidosException("\nDados inválidos: número do quarto deve ser positivo.");
        }
        quartos.add(quarto);
        System.out.println("\nQuarto cadastrado com sucesso!");
    }

    // Listar quartos disponíveis
    public void listarQuartosDisponiveis() {
        boolean disponivel = false;
        for (Quarto quarto : quartos) {
            if (quarto.getStatus().equals("disponível")) {
                System.out.println(quarto);
                disponivel = true;
            }
        }
        if (!disponivel) {
            System.out.println("\nNenhum quarto disponível no momento.");
        }
    }

    // Atualizar status de um quarto
    public void atualizarStatusQuarto(int numero, String status) throws DadosInvalidosException {
        Quarto quarto = buscarQuartoPorNumero(numero);
        if (quarto == null) {
            throw new DadosInvalidosException("Quarto não encontrado.");
        }
        quarto.atualizarStatus(status);
        System.out.println("Status do quarto atualizado para: " + status);
    }

    Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    // 2. Gerenciamento de Hóspedes

    // Cadastrar novo hóspede
    public void cadastrarHospede(Hospede hospede) throws DadosInvalidosException {
        if (hospede == null || hospede.getCpf().length() != 11) {
            throw new DadosInvalidosException("CPF inválido. Por favor, insira um CPF válido.");
        }
        hospedes.add(hospede);
        System.out.println("Hóspede cadastrado com sucesso!");
    }

    // Listar histórico de estadias de um hóspede
    public void listarHistoricoHospede(String cpf) throws DadosInvalidosException {
        Hospede hospede = buscarHospedePorCpf(cpf);
        if (hospede == null) {
            throw new DadosInvalidosException("Hóspede não encontrado.");
        }
        hospede.listar();
    }

    // Editar informações de um hóspede
    public void editarHospede(String cpf, String novoEndereco, String novoNumeroContato) throws DadosInvalidosException {
        Hospede hospede = buscarHospedePorCpf(cpf);
        if (hospede == null) {
            throw new DadosInvalidosException("Hóspede não encontrado.");
        }
        hospede.editarHospede(novoEndereco, novoNumeroContato);
    }

    Hospede buscarHospedePorCpf(String cpf) {
        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                return hospede;
            }
        }
        return null;
    }

    // 3. Gerenciamento de Funcionários

    // Cadastrar novo funcionário
    public void cadastrarFuncionario(Funcionario funcionario) throws DadosInvalidosException {
        if (funcionario == null || ((String) funcionario.getCpf()).length() != 11) {
            throw new DadosInvalidosException("CPF inválido. Por favor, insira um CPF válido.");
        }
        funcionarios.add(funcionario);
        System.out.println("\nFuncionário cadastrado com sucesso!");
    }

    // Editar informações de um funcionário
    public void editarFuncionario(String cpf, String novoCargo, double novoSalario) throws DadosInvalidosException {
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf);
        if (funcionario == null) {
            throw new DadosInvalidosException("Funcionário não encontrado.");
        }
        funcionario.editarFuncionario(novoCargo, novoSalario);
    }

    private Funcionario buscarFuncionarioPorCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    // Registrar horas trabalhadas e calcular salário
    public void registrarHorasFuncionario(String cpf, int horas) throws DadosInvalidosException {
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf);
        if (funcionario == null) {
            throw new DadosInvalidosException("Funcionário não encontrado.");
        }
        funcionario.registrarHoras(horas);
        System.out.println("\nSalário atualizado: " + funcionario.calcularSalario());
    }

    // 4. Gerenciamento de Reservas

    // Criar reserva
    public void criarReserva(Hospede hospede, Quarto quarto, String dataEntrada, String dataSaida) throws DadosInvalidosException {
        if (quarto.getStatus().equals("ocupado")) {
            throw new DadosInvalidosException("Quarto indisponível.");
        }
        Reserva reserva = new Reserva(hospede, quarto, dataEntrada, dataSaida);
        reservas.add(reserva);
        quarto.atualizarStatus("ocupado");
        hospede.adicionarReserva(reserva);
        System.out.println("\nReserva criada com sucesso!");
    }

    // Cancelar reserva
    public void cancelarReserva(int numeroQuarto) throws DadosInvalidosException {
        Reserva reserva = buscarReservaPorNumeroQuarto(numeroQuarto);
        if (reserva == null) {
            throw new DadosInvalidosException("\nReserva não encontrada.");
        }
        reserva.cancelarReserva();
        reservas.remove(reserva);
    }

    private Reserva buscarReservaPorNumeroQuarto(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero() == numeroQuarto) {
                return reserva;
            }
        }
        return null;
    }

    // 5. Check-in e Check-out

    // Check-in
    public void realizarCheckIn(int numeroQuarto, String cpfHospede) throws DadosInvalidosException {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (quarto == null || !quarto.getStatus().equals("disponível")) {
            throw new DadosInvalidosException("\nQuarto não disponível.");
        }
        Hospede hospede = buscarHospedePorCpf(cpfHospede);
        if (hospede == null) {
            throw new DadosInvalidosException("\nHóspede não encontrado.");
        }
        // Simulação de um check-in (poderia adicionar mais lógica)
        quarto.atualizarStatus("ocupado");
        System.out.println("\nCheck-in realizado com sucesso para o hóspede: " + hospede.getCpf());
    }

    // Check-out
    public void realizarCheckOut(int numeroQuarto) throws DadosInvalidosException {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (quarto == null || !quarto.getStatus().equals("ocupado")) {
            throw new DadosInvalidosException("\nCheck-out não permitido. Quarto já está disponível.");
        }
        // Simulação de cálculo de diárias e liberação do quarto
        quarto.atualizarStatus("disponível");
        System.out.println("\nCheck-out realizado com sucesso. Quarto liberado.");
    }
}
