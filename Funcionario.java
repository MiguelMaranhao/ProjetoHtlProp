package Hotel1;

class Funcionario implements Cadastravel {
    private String nome;
    private String cpf;
    private String cargo;
    private double salario;
    private int horasTrabalhadas;

    public Funcionario(String nome, String cpf, String cargo, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
        this.horasTrabalhadas = 0;
    }

    public void registrarHoras(int horas) {
        horasTrabalhadas += horas;
        System.out.println("\nHoras registradas: " + horas);
    }

    public double calcularSalario() {
        return horasTrabalhadas * salario;
    }

    @Override
    public void cadastrar() {
        System.out.println("\nFuncionário " + nome + " cadastrado com sucesso!");
    }

    @Override
    public void listar() {
        System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Cargo: " + cargo + ", Salário: " + salario);
    }

    public void editarFuncionario(String cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
        System.out.println("\nDados do funcionário atualizados.");
    }

	public Object getCpf() {
		
		return null;
	}
}