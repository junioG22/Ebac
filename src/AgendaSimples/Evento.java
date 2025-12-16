package AgendaSimples;

import java.time.LocalDateTime;

public class Evento {

    private String nome;
    private LocalDateTime dataHora;
    private DiaDaSemana diaDaSemana;

    public Evento(String nome, LocalDateTime dataHora, DiaDaSemana diaDaSemana) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.diaDaSemana = diaDaSemana;
    }

    public void exibirEvento() {
        System.out.println("Evento: " + nome);
        System.out.println("Data e Hora: " + dataHora);
        System.out.println("Dia da Semana: " + diaDaSemana);
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
