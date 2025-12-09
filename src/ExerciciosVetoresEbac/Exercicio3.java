package ExerciciosVetoresEbac;

import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um nome: ");
        String nome = scanner.nextLine();

        char[] letras = nome.toCharArray();

        int inicio = 0;
        int fim = letras.length - 1;

        while (inicio < fim) {
            char temp = letras[inicio];
            letras[inicio] = letras[fim];
            letras[fim] = temp;

            inicio++;
            fim--;
        }

        System.out.print("Nome invertido: ");
        for (char c : letras) {
            System.out.print(c);
        }
    }
}
