package lista4.ex2;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        
    	Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o número do cartão: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Insira o nome do titular: ");
        String titular = sc.nextLine();

        System.out.print("Deseja solicitar limite de crédito inicial personalizado (s/n)? ");
        char resp = sc.next().charAt(0);

        CartaoCredito cartao;
        if (resp == 's' || resp == 'S') {
            System.out.print("Insira o limite inicial: ");
            cartao = new CartaoCredito(numero, titular, sc.nextDouble());
        } else {
            cartao = new CartaoCredito(numero, titular);
        }
        System.out.println("Dados do cartão: " + cartao);

        System.out.print("Insira o valor da compra: ");
        cartao.realizarCompra(sc.nextDouble());
        System.out.println("Dados do cartão atualizados: " + cartao);

        System.out.print("Insira o valor do pagamento da fatura: ");
        cartao.pagarFatura(sc.nextDouble());
        System.out.println("Dados do cartão atualizados: " + cartao);

        sc.close();
    }
}
