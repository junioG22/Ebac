package ProjetoRH;

public class Assistente extends Analista {
    public Assistente(int id, String nome) {
        super(id, nome);
    }

    @Override
    public String getTipo() {
        return "Assistente";
    }
}
