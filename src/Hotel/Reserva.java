package Hotel;

public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.numeroDias = numeroDias;
        this.valorDiaria = valorDiaria;
    }

    public Reserva(String nomeHospede, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
    }

    public double calcularValorTotal() {
        return numeroDias * valorDiaria;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    @Override
    public String toString() {
        return "Hóspede: " + nomeHospede +
                " | Quarto: " + tipoQuarto +
                " | Dias: " + numeroDias +
                " | Diária: R$ " + valorDiaria +
                " | Total: R$ " + calcularValorTotal();
    }
}
