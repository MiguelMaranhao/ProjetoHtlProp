package Hotel1;

import java.util.ArrayList;
import java.util.List; 

class Hospede implements Cadastravel {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String numeroContato;
    private List<Reserva> historicoReservas;

    public Hospede(String nome, String cpf, String dataNascimento, String endereco, String numeroContato) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        this.historicoReservas = new ArrayList<>();
    }

    public String getCpf() { return cpf; }

    @Override
    public void cadastrar() {
        System.out.println("Hóspede " + nome + " cadastrado com sucesso!");
    }

    @Override
    public void listar() {
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
        for (Reserva r : historicoReservas) {
            System.out.println(r);
        }
    }

    public void adicionarReserva(Reserva reserva) {
        historicoReservas.add(reserva);
    }

    public void editarHospede(String endereco, String numeroContato) {
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        System.out.println("Dados do hóspede atualizados.");
    }
}
