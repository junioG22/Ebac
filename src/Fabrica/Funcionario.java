package Fabrica;

public class Funcionario {
    private String nome;
    private int anoNascimento;
    private double salario;
    private boolean clt;

    public Funcionario(String nome, int anoNascimento, double salario, boolean clt) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.salario = salario;
        this.clt = clt;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public boolean isClt() {
        return clt;
    }

    @Override
    public String toString() {
        return nome + " - " + anoNascimento + " - " + salario;
    }
}
