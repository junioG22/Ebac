import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite um número positivo: ");
        int n = scanner.nextInt();

        // CRESCENTE
        System.out.println("\nOrdem crescente:");
        for (int i = 0; i <= n; i++) {
            System.out.print(i + " ");
        }

        // DECRESCENTE
        System.out.println("\n\nOrdem decrescente:");
        for (int i = n; i >= 0; i--) {
            System.out.print(i + " ");
        }

        // EXIBIR NOME
        System.out.println("\n");

        if (nome.length() > 6) {
            for (int i = 0; i < n; i++) {
                System.out.println(nome);
            }
        } else {
            System.out.println(nome);
        }

        scanner.close();
    }
}
