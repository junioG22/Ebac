package ProjetoRH;

public class Analista extends Funcionario implements RegistravelPonto {

    public Analista(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void registrarPonto(int entrada, int saida) {
        validarHorario(entrada, saida, 3);
    }

    private void validarHorario(int entrada, int saida, int maxExtra) {
        if (entrada < 6 || saida > 22 || saida <= entrada) {
            System.out.println("Horário inválido.");
            return;
        }

        int horas = (saida - entrada) - 1;
        if (horas > 8 + maxExtra) {
            System.out.println("Excedeu limite de horas extras.");
            return;
        }

        System.out.println("Ponto registrado. Horas trabalhadas: " + horas);
    }

    @Override
    public String getTipo() {
        return "Analista";
    }
}
