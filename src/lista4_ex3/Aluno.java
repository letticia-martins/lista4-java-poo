package lista4.ex3;

public class Aluno {

    private final int matricula;       // gerada uma vez, nunca muda
    private String nome;
    private double descontoPercentual;
    private double saldoDevedor;       // sem setter

    public Aluno(int matricula, String nome) {
        this(matricula, nome, 0.0);
    }

    public Aluno(int matricula, String nome, double desconto) {
        if (desconto < 0 || desconto > 100) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 100");
        }
        this.matricula = matricula;
        setNome(nome);
        this.descontoPercentual = desconto;
        this.saldoDevedor = 0.0;
    }

    public int getMatricula() { return matricula; }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public double getDescontoPercentual() { return descontoPercentual; }

    public double getSaldoDevedor() { return saldoDevedor; }

    public void gerarMensalidade(double valorBase) {
        if (valorBase <= 0) {
            throw new IllegalArgumentException("Valor base deve ser positivo");
        }
        saldoDevedor += valorBase * (1 - descontoPercentual / 100.0);
    }

    public void efetuarPagamento(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo");
        }
        if (valor > saldoDevedor) {
            throw new IllegalArgumentException("Pagamento maior que o saldo devedor");
        }
        saldoDevedor -= valor;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %d, Aluno: %s, Desconto: %.1f%%, Saldo Devedor: R$ %.2f",
                matricula, nome, descontoPercentual, saldoDevedor);
    }
}
