package ExerciciosVetoresEbac;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos numeros você quer inserir? ");
        int n = scanner.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o numero da posição " + i + ": ");
            vetor[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (vetor[i] % 2 == 0) {
                vetor[i] = vetor[i] * 2; // número par
            } else {
                vetor[i] = (int) Math.pow(vetor[i], 2); // número ímpar
            }
        }

        System.out.println("Novo vetor:");
        for (int i = 0; i < n; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}
