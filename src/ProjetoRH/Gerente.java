package ProjetoRH;

public class Gerente extends Funcionario {

    public Gerente(int id, String nome) {
        super(id, nome);
    }

    @Override
    public String getTipo() {
        return "Gerente";
    }
}
