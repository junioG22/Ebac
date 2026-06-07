package EBAC.SistemaBiblioteca;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // CADASTRAR LIVRO
    public void cadastrarLivro(Livro livro) {

        boolean existe = livros.stream()
                .anyMatch(l ->
                        l.getTitulo()
                                .equalsIgnoreCase(livro.getTitulo()));

        if (!existe) {

            livros.add(livro);

        } else {

            System.out.println("Livro já cadastrado.");

        }
    }

    // CADASTRAR USUARIO
    public void cadastrarUsuario(Usuario usuario) {

        boolean existe = usuarios.stream()
                .anyMatch(u ->
                        u.getEmail()
                                .equalsIgnoreCase(usuario.getEmail()));
        if (!existe) {
            usuarios.add(usuario);
        }
    }

    public void buscarUsuarioPorEmail(String email) {

        usuarios.stream()
                .filter(u ->
                        u.getEmail()
                                .equalsIgnoreCase(email))
                .map(u ->
                        "Usuário encontrado: "
                                + u.getNome()
                                + " | Email: "
                                + u.getEmail())
                .forEach(System.out::println);
    }

    // LISTAR LIVROS
    public void listarLivros() {
        livros.forEach(System.out::println);
    }

    // LISTAR USUARIOS
    public void listarUsuarios() {
        usuarios.forEach(System.out::println);
    }

    // BUSCAR LIVRO POR TITULO
    public Optional<Livro> buscarLivro(String titulo) {

        return livros.stream()
                .filter(l ->
                        l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    // IMPRIMIR LIVRO POR TITULO
    public void buscarLivroPorTitulo(String titulo) {

        Optional<Livro> resultado = buscarLivro(titulo);

        resultado.ifPresentOrElse(

                livro -> System.out.println(livro),

                () -> System.out.println("Livro não encontrado.")
        );
    }

    // EMPRESTAR
    public void emprestarLivro(
            String tituloLivro,
            String emailUsuario)
            throws LivroIndisponivelException {

        Optional<Livro> resultadoLivro = buscarLivro(tituloLivro);

        Optional<Usuario> resultadoUsuario =
                usuarios.stream()
                        .filter(u ->
                                u.getEmail()
                                        .equalsIgnoreCase(emailUsuario))
                        .findFirst();

        if (resultadoLivro.isEmpty()) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (resultadoUsuario.isEmpty()) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        Livro livro = resultadoLivro.get();

        if (livro.isEmprestado()) {
            throw new LivroIndisponivelException(
                    "Livro já emprestado."
            );
        }

        livro.setEmprestado(true);

        Emprestimo emprestimo =
                new Emprestimo(
                        resultadoUsuario.get(),
                        livro
                );

        emprestimos.add(emprestimo);

        System.out.println(
                "Livro emprestado com sucesso para "
                        + resultadoUsuario.get().getNome()
                        + " de email: "
                        + resultadoUsuario.get().getEmail()
        );
    }

    // DEVOLVER
    public void devolverLivro(String titulo) {

        Optional<Livro> resultado = buscarLivro(titulo);

        resultado.ifPresentOrElse(

                livro -> {

                    if (!livro.isEmprestado()) {

                        System.out.println(
                                "O livro já estava disponível."
                        );

                        return;
                    }

                    Optional<Emprestimo> resultadoEmprestimo =
                            emprestimos.stream()
                                    .filter(e ->
                                            e.getLivro()
                                                    .getTitulo()
                                                    .equalsIgnoreCase(titulo))
                                    .findFirst();

                    livro.setEmprestado(false);

                    resultadoEmprestimo.ifPresent(e ->

                            System.out.println(
                                    "Livro \"" + livro.getTitulo()
                                            + "\" devolvido com sucesso por "
                                            + e.getUsuario().getNome()
                                            + " de email: "
                                            + e.getUsuario().getEmail()
                            )
                    );

                },

                () -> System.out.println("Livro não encontrado.")
        );
    }
    // ORDENAR POR TITULO
    public void ordenarPorTitulo() {

        Collections.sort(livros);

        livros.forEach(System.out::println);
    }

    // ORDENAR POR ANO
    public void ordenarPorAno() {

        livros.stream()
                .sorted(Comparator.comparingInt(
                        Livro::getAnoPublicacao))
                .forEach(System.out::println);
    }

    // FILTRAR POR AUTOR
    public void filtrarPorAutor(String autor) {

        livros.stream()
                .filter(l ->
                        l.getAutor()
                                .equalsIgnoreCase(autor))
                .forEach(System.out::println);
    }

    // AGRUPAR POR AUTOR
    public void agruparPorAutor() {

        Map<String, List<Livro>> agrupados =
                livros.stream()
                        .collect(Collectors.groupingBy(
                                Livro::getAutor
                        ));

        agrupados.forEach((autor, lista) -> {

            System.out.println("\nAutor: " + autor);

            lista.forEach(System.out::println);
        });
    }

    // SERIALIZAR
    public void salvarDados() {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("biblioteca.dat"))) {

            out.writeObject(livros);
            out.writeObject(usuarios);

            System.out.println("Dados salvos.");

        } catch (IOException e) {

            System.out.println("Erro ao salvar.");

        }
    }

    // DESSERIALIZAR
    public void carregarDados() {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("biblioteca.dat"))) {

            livros = (List<Livro>) in.readObject();
            usuarios = (List<Usuario>) in.readObject();

            System.out.println("Dados carregados.");

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Nenhum arquivo encontrado.");

        }
    }
}