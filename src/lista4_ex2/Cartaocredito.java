package lista4.ex2;

public class CartaoCredito {

    private static final double LIMITE_PADRAO = 200.00;
    private static final double TARIFA_COMPRA = 1.50;

    private final int numeroCartao;    // não muda após a emissão
    private String titular;
    private double limite;
    private double saldoFatura;        // sem setter

    public CartaoCredito(int numeroCartao, String titular) {
        this(numeroCartao, titular, LIMITE_PADRAO);
    }

    public CartaoCredito(int numeroCartao, String titular, double limiteInicial) {
        if (limiteInicial < 0) {
            throw new IllegalArgumentException("Limite não pode ser negativo");
        }
        this.numeroCartao = numeroCartao;
        setTitular(titular);
        this.limite = limiteInicial;
        this.saldoFatura = 0.0;
    }

    public int getNumeroCartao() { return numeroCartao; }

    public String getTitular() { return titular; }

    public void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular não pode ser vazio");
        }
        this.titular = titular;
    }

    public double getLimite() { return limite; }

    public double getSaldoFatura() { return saldoFatura; }

    public void realizarCompra(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da compra deve ser positivo");
        }
        double custoTotal = valor + TARIFA_COMPRA;
        if (saldoFatura + custoTotal > limite) {
            throw new IllegalArgumentException("Compra excede o limite do cartão");
        }
        saldoFatura += custoTotal;
    }

    public void pagarFatura(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo");
        }
        if (valor > saldoFatura) {
            throw new IllegalArgumentException("Pagamento maior que a fatura atual");
        }
        saldoFatura -= valor;
    }

    @Override
    public String toString() {
        return String.format("Cartão %d, Titular: %s, Limite: R$ %.2f, Fatura Atual: R$ %.2f",
                numeroCartao, titular, limite, saldoFatura);
    }
}
