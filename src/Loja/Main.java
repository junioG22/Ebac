package Loja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Produto[] produtos = {
                new Televisao(),
                new Radio(),
                new Videogame(),
                new Tablet(),
                new Celular()
        };

        Produto[] carrinho = new Produto[50];
        int[] quantidades = new int[50];
        int totalItens = 0;

        System.out.println("=== Bem-vindo à Loja ===");

        while (true) {
            System.out.println("\nProdutos disponíveis:");
            for (int i = 0; i < produtos.length; i++) {
                System.out.println((i + 1) + " - " + produtos[i].getNome()
                        + " | R$ " + produtos[i].getPreco());
            }
            System.out.println("0 - Finalizar compra");

            System.out.print("Escolha um produto: ");
            int opcao = sc.nextInt();

            if (opcao == 0) {
                break;
            }

            if (opcao < 1 || opcao > produtos.length) {
                System.out.println("Produto inválido!");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd = sc.nextInt();

            if (qtd <= 0) {
                System.out.println("Quantidade inválida!");
                continue;
            }

            carrinho[totalItens] = produtos[opcao - 1];
            quantidades[totalItens] = qtd;
            totalItens++;

            System.out.println("Produto adicionado ao carrinho!");
        }

        double total = 0;

        System.out.println("\n=== RESUMO DA COMPRA ===");
        for (int i = 0; i < totalItens; i++) {
            Produto p = carrinho[i];
            int q = quantidades[i];
            double subtotal = p.getPreco() * q;

            System.out.println(p.getNome() + " x" + q + " = R$ " + subtotal);
            total += subtotal;
        }

        System.out.println("\nTOTAL A PAGAR: R$ " + total);

        sc.close();
    }
}
