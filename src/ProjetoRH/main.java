package ProjetoRH;

import java.util.*;

public class main {

    static Scanner sc = new Scanner(System.in);
    static List<Funcionario> funcionarios = new ArrayList<>();
    static int contadorId = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== PORTAL RH ===");
            System.out.println("1 - Criar funcionário");
            System.out.println("2 - Registrar ponto");
            System.out.println("3 - Listar funcionários");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) break;

            switch (opcao) {
                case 1 -> criarFuncionario();
                case 2 -> registrarPonto();
                case 3 -> listar();
                default -> System.out.println("Opção inválida");
            }
        }

        System.out.println("Sistema encerrado.");
    }

    static void criarFuncionario() {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Tipo (1-Gerente, 2-Coordenador, 3-Analista, 4-Assistente, 5-Estagiário):");
        int tipo = sc.nextInt();

        Funcionario f = switch (tipo) {
            case 1 -> new Gerente(contadorId++, nome);
            case 2 -> new Coordenador(contadorId++, nome);
            case 3 -> new Analista(contadorId++, nome);
            case 4 -> new Assistente(contadorId++, nome);
            case 5 -> new Estagiario(contadorId++, nome);
            default -> null;
        };

        if (f != null) {
            funcionarios.add(f);
            System.out.println("Funcionário criado com ID " + f.getId());
        }
    }

    static void registrarPonto() {
        System.out.println("ID do funcionário:");
        int id = sc.nextInt();

        Funcionario f = funcionarios.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

        if (f == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        if (!(f instanceof RegistravelPonto)) {
            System.out.println("Esse tipo NÃO bate ponto.");
            return;
        }

        System.out.println("Hora entrada:");
        int entrada = sc.nextInt();
        System.out.println("Hora saída:");
        int saida = sc.nextInt();

        ((RegistravelPonto) f).registrarPonto(entrada, saida);
    }

    static void listar() {
        funcionarios.forEach(f ->
                System.out.println(f.getId() + " - " + f.getNome() + " (" + f.getTipo() + ")")
        );
    }
}
