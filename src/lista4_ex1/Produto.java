package lista4.ex1;

public class Produto {

    private static final double TAXA_MANUSEIO = 2.00;

    private final int codigo;          // final: não pode mudar depois do cadastro
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;   // sem setter: só muda por métodos de negócio

    // Cadastro sem estoque inicial
    public Produto(int codigo, String nome, double preco) {
        this(codigo, nome, preco, 0);
    }

    // Cadastro com estoque inicial
    public Produto(int codigo, String nome, double preco, int quantidadeInicial) {
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("Quantidade inicial não pode ser negativa");
        }
        this.codigo = codigo;
        setNome(nome);
        setPreco(preco);
        this.quantidadeEmEstoque = quantidadeInicial;
    }

    public int getCodigo() { return codigo; }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public double getPreco() { return preco; }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() { return quantidadeEmEstoque; }

    // Entrada / reposição de estoque
    public void adicionarProdutos(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        quantidadeEmEstoque += quantidade;
    }

    // Venda: dá baixa no estoque e aplica a taxa fixa de manuseio
    public void removerProdutos(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        if (quantidade > quantidadeEmEstoque) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }
        quantidadeEmEstoque -= quantidade;
        double totalVenda = quantidade * preco + TAXA_MANUSEIO;
        System.out.printf("Total da venda (com taxa de manuseio de R$ %.2f): R$ %.2f%n",
                TAXA_MANUSEIO, totalVenda);
    }

    public double valorTotalEmEstoque() {
        return preco * quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return String.format("Código: %d, Nome: %s, Preço: R$ %.2f, Estoque: %d unidades",
                codigo, nome, preco, quantidadeEmEstoque);
    }
}
