package EBAC.SistemaBiblioteca;

import java.io.Serializable;

public class Livro implements Serializable, Comparable<Livro> {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean emprestado;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public int compareTo(Livro outro) {
        return this.titulo.compareToIgnoreCase(outro.titulo);
    }

    @Override
    public String toString() {
        return """
                Título: %s
                Autor: %s
                Ano: %d
                Emprestado: %s
                """.formatted(
                titulo,
                autor,
                anoPublicacao,
                emprestado ? "Sim" : "Não"
        );
    }
}