package AgendaSimples;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {

        // Data e hora atual
        LocalDateTime agora = LocalDateTime.now();

        Evento evento = new Evento(
                "Reunião de Estudo",
                agora,
                DiaDaSemana.QUARTA
        );

        System.out.println("=== EVENTO ORIGINAL ===");
        evento.exibirEvento();

        // Adicionando 5 dias
        evento.setDataHora(evento.getDataHora().plusDays(5));

        System.out.println("\n=== EVENTO + 5 DIAS ===");
        evento.exibirEvento();

        // Conversão de fuso horário
        ZonedDateTime saoPaulo = evento.getDataHora()
                .atZone(ZoneId.systemDefault())
                .withZoneSameInstant(ZoneId.of("America/Sao_Paulo"));

        ZonedDateTime gmt = saoPaulo.withZoneSameInstant(ZoneId.of("GMT"));

        System.out.println("\n=== FUSOS HORÁRIOS ===");
        System.out.println("São Paulo (BRT): " + saoPaulo);
        System.out.println("GMT: " + gmt);
    }
}
