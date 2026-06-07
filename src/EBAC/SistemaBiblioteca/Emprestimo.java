package EBAC.SistemaBiblioteca;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Emprestimo implements Serializable {

    private Usuario usuario;
    private Livro livro;
    private LocalDateTime data;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.data = LocalDateTime.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    @Override
    public String toString() {
        return """
                Empréstimo:
                Usuário: %s
                Livro: %s
                Data: %s
                """.formatted(
                usuario.getNome(),
                livro.getTitulo(),
                data
        );
    }
}