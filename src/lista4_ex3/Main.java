Package lista4.ex3;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        final double MENSALIDADE_BASE = 500.00;

        System.out.print("Insira o número de matrícula: ");
        int matricula = sc.nextInt();
        sc.nextLine();
        System.out.print("Insira o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print("Possui cupom de desconto inicial (s/n)? ");
        char resp = sc.next().charAt(0);

        Aluno aluno;
        if (resp == 's' || resp == 'S') {
            System.out.print("Insira o percentual de desconto (%): ");
            aluno = new Aluno(matricula, nome, sc.nextDouble());
        } else {
            aluno = new Aluno(matricula, nome);
        }
        System.out.println("Dados do aluno: " + aluno);

        System.out.printf("Gerando mensalidade base de R$ %.2f com desconto...%n", MENSALIDADE_BASE);
        aluno.gerarMensalidade(MENSALIDADE_BASE);
        System.out.printf("Dados atualizados: Matrícula: %d, Aluno: %s, Saldo Devedor: R$ %.2f%n",
                aluno.getMatricula(), aluno.getNome(), aluno.getSaldoDevedor());

        System.out.print("Insira o valor do pagamento: ");
        aluno.efetuarPagamento(sc.nextDouble());
        System.out.printf("Dados atualizados: Matrícula: %d, Aluno: %s, Saldo Devedor: R$ %.2f%n",
                aluno.getMatricula(), aluno.getNome(), aluno.getSaldoDevedor());

        sc.close();
    }
}
