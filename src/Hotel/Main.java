package Hotel;

import Hotel.Reserva;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Reserva[] reservas = new Reserva[10];
    static int contador = 0;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Nova reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Buscar reserva por nome");
            System.out.println("4 - Ordenar por dias (decrescente)");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    novaReserva();
                    break;
                case 2:
                    listarReservas();
                    break;
                case 3:
                    buscarReserva();
                    break;
                case 4:
                    ordenarPorDias();
                    break;
                case 5:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        sc.close();
    }

    static void novaReserva() {
        if (contador >= reservas.length) {
            System.out.println("Limite de reservas atingido.");
            return;
        }

        System.out.print("Nome do hóspede: ");
        String nome = sc.nextLine();

        System.out.print("Tipo do quarto: ");
        String tipo = sc.nextLine();

        int dias;
        do {
            System.out.print("Número de dias: ");
            dias = sc.nextInt();
            if (dias < 1) {
                System.out.println("Dias inválidos.");
            }
        } while (dias < 1);

        double diaria;
        do {
            System.out.print("Valor da diária: ");
            diaria = sc.nextDouble();
            if (diaria <= 0) {
                System.out.println("Valor inválido.");
            }
        } while (diaria <= 0);

        sc.nextLine();

        reservas[contador] = new Reserva(nome, tipo, dias, diaria);
        contador++;

        System.out.println("Reserva cadastrada com sucesso!");
    }

    static void listarReservas() {
        if (contador == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            System.out.println(reservas[i]);
        }
    }

    static void buscarReserva() {
        System.out.print("Digite parte do nome: ");
        String busca = sc.nextLine().toLowerCase();

        boolean encontrou = false;

        for (int i = 0; i < contador; i++) {
            if (reservas[i].getNomeHospede().toLowerCase().contains(busca)) {
                System.out.println(reservas[i]);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada.");
        }
    }

    static void ordenarPorDias() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {
                if (reservas[j].getNumeroDias() < reservas[j + 1].getNumeroDias()) {
                    Reserva temp = reservas[j];
                    reservas[j] = reservas[j + 1];
                    reservas[j + 1] = temp;
                }
            }
        }
        System.out.println("Reservas ordenadas por dias (decrescente).");
    }
}
