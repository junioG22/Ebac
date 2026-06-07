package EBAC.SistemaBiblioteca;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.carregarDados();

        biblioteca.cadastrarLivro(
                new Livro("Java", "João", 2020));

        biblioteca.cadastrarLivro(
                new Livro("Spring", "Maria", 2022));

        biblioteca.cadastrarLivro(
                new Livro("POO", "João", 2018));

        biblioteca.cadastrarUsuario(
                new Usuario("Carlos", "carlos@gmail.com"));

        biblioteca.cadastrarUsuario(
                new Usuario("Marlon", "marlon@gmail.com"));

        System.out.println("\n=== TODOS OS LIVROS ===");
        biblioteca.listarLivros();

        System.out.println("\n=== BUSCA POR TÍTULO ===");
        biblioteca.buscarLivroPorTitulo("POO");

        System.out.println("\n=== ORDENADOS POR ANO ===");
        biblioteca.ordenarPorAno();

        System.out.println("\n=== ORDENADOS POR TÍTULO ===");
        biblioteca.ordenarPorTitulo();

        System.out.println("\n=== TODOS OS USUÁRIOS ===");
        biblioteca.listarUsuarios();

        System.out.println("\n=== BUSCAR USUÁRIO POR EMAIL ===");
        biblioteca.buscarUsuarioPorEmail("carlos@gmail.com");

        System.out.println("\n=== FILTRAR AUTOR ===");
        biblioteca.filtrarPorAutor("João");

        System.out.println("\n=== AGRUPAR POR AUTOR ===");
        biblioteca.agruparPorAutor();

        System.out.println("\n=== EMPRESTAR ===");

        try {

            biblioteca.emprestarLivro(
                    "Java",
                    "carlos@gmail.com"
            );

        } catch (LivroIndisponivelException e) {

            System.out.println(e.getMessage());

        }

        System.out.println("\n=== TENTAR EMPRESTAR LIVRO JA EMPRESTADO ===");

        try {

            biblioteca.emprestarLivro(
                    "Java",
                    "marlon@gmail.com"
            );

        } catch (LivroIndisponivelException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }

        System.out.println("\n=== DEVOLUÇÃO ===");
        biblioteca.devolverLivro("Java");

        biblioteca.salvarDados();
    }
}