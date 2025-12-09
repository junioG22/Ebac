package ExerciciosVetoresEbac;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números deseja digitar? ");
        int n = sc.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {

                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }

            }
        }

        System.out.println("\nVetor ordenado:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        sc.nextLine();

        System.out.print("\n\nDigite um nome: ");
        String nome = sc.nextLine().toLowerCase();

        int vogais = 0;
        char[] letras = nome.toCharArray();

        for (char c : letras) {
            if (c == 'a' || c =