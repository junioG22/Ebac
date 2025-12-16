package POJO;

import POJO.Aluno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos? ");
        int qtdAlunos = sc.nextInt();

        System.out.print("Quantas provas por aluno? ");
        int qtdNotas = sc.nextInt();

        Aluno[] alunos = new Aluno[qtdAlunos];
        sc.nextLine();

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.print("\nNome do aluno: ");
            String nome = sc.nextLine();

            alunos[i] = new Aluno(nome, qtdNotas);

            for (int j = 0; j < qtdNotas; j++) {
                double nota;
                while (true) {
                    System.out.print("Nota " + (j + 1) + ": ");
                    nota = sc.nextDouble();

                    if (nota >= 0 && nota <= 10) {
                        break;
                    }
                    System.out.println("Nota inválida! Digite entre 0 e 10.");
                }
                alunos[i].setNota(j, nota);
            }
            sc.nextLine();
        }

        System.out.println("\n=== RESULTADO ===");
        for (Aluno a : alunos) {
            System.out.println("Aluno: " + a.getNome());
            System.out.println("Média: " + a.calcularMedia());
            System.out.println("------------------");
        }

        sc.close();
    }
}
