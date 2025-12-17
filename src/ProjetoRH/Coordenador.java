package ProjetoRH;

public class Coordenador extends Funcionario implements RegistravelPonto {

    public Coordenador(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void registrarPonto(int entrada, int saida) {
        if (entrada < 6 || saida > 22 || saida <= entrada) {
            System.out.println("Horário inválido.");
            return;
        }

        int horas = (saida - entrada) - 1;
        if (horas > 13) {
            System.out.println("Excedeu limite de horas extras.");
            return;
        }

        System.out.println("Ponto registrado. Horas trabalhadas: " + horas);
    }

    @Override
    public String getTipo() {
        return "Coordenador";
    }
}
