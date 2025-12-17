package ProjetoRH;

public abstract class Funcionario {

    private int id;
    private String nome;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {   // ← ESSE MÉTODO ESTÁ FALTANDO
        return nome;
    }

    public abstract String getTipo();
}
