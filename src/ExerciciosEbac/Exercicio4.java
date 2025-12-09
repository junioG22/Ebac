package ExerciciosEbac;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para ver a tabuada: ");
        int num = scanner.nextInt();

        int i = 1;
        System.out.println("\nTabuada de " + num + ":");

        while (i <= 10) {
            System.out.println(num + " x " + i + " = " + (num * i));
            i++;
        }

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Continuar");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar ENTER

            if (opcao == 1) {
                System.out.print("Digite uma palavra ou frase: ");
                String frase = scanner.nextLine();
                System.out.println("Você digitou: " + frase);

            } else if (opcao == 2) {
                System.out.println("Obrigado por utilizar o nosso sistema, espero que tenha gostado.");

            } else {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 2);

        scanner.close();
    }
}
