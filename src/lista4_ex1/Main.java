package lista4.ex1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
       
    	Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // consome o ENTER que sobrou
        System.out.print("Insira o nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Insira o preço unitário: ");
        double preco = sc.nextDouble();

        System.out.print("Deseja cadastrar estoque inicial (s/n)? ");
        char resp = sc.next().charAt(0);

        Produto produto;
        if (resp == 's' || resp == 'S') {
            System.out.print("Insira a quantidade inicial: ");
            int qtdInicial = sc.nextInt();
            produto = new Produto(codigo, nome, preco, qtdInicial);
        } else {
            produto = new Produto(codigo, nome, preco);
        }
        System.out.println("Dados do produto: " + produto);

        System.out.print("Insira a quantidade para dar entrada no estoque: ");
        produto.adicionarProdutos(sc.nextInt());
        System.out.println("Dados atualizados: " + produto);

        System.out.print("Insira a quantidade vendida: ");
        produto.removerProdutos(sc.nextInt());
        System.out.println("Dados atualizados: " + produto);

        sc.close();
    }
}
