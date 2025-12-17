package ProjetoRH;

public class Estagiario extends Funcionario {

    public Estagiario(int id, String nome) {
        super(id, nome);
    }

    @Override
    public String getTipo() {
        return "Estagiário";
    }
}
