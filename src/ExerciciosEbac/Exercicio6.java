package ExerciciosEbac;

import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos carros deseja cadastrar? (máx 50): ");
        int qtd = sc.nextInt();

        if (qtd > 50) {
            qtd = 50;
        }

        Carro[] carros = new Carro[qtd];
        double somaPrecos = 0;

        sc.nextLine();

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nCarro " + (i + 1));

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            carros[i] = new Carro(nome, preco);
            somaPrecos += preco;
        }

        System.out.println("\n--- RESULTADO ---");
        System.out.println("Quantidade de carros: " + qtd);

        for (Carro c : carros) {
            System.out.println("Carro: " + c.nome);
        }

        System.out.println("Soma total dos preços: R$ " + somaPrecos);

        sc.close();
    }
}

/* Classe SEM public */
class Carro {
    String nome;
    double preco;

    Carro(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
