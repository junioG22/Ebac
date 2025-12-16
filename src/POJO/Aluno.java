package POJO;

public class Aluno {

    private String nome;
    private double[] notas;

    public Aluno(String nome, int qtdNotas) {
        this.nome = nome;
        this.notas = new double[qtdNotas];
    }

    public void setNota(int index, double valor) {
        this.notas[index] = valor;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / notas.length;
    }

    public String getNome() {
        return nome;
    }

    public double[] getNotas() {
        return notas;
    }
}
