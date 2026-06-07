package EBAC.SistemaBiblioteca;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Email: %s
                """.formatted(nome, email);
    }
}