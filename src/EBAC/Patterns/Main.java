package EBAC.Patterns;

public class Main {

    public static void main(String[] args) {

        Notificacao notificacao = Notificacao.builder()
                .destinatario("Carlos")
                .assunto("Promoção")
                .mensagem("Você ganhou desconto!")
                .build();

        CanalNotificacao canal = NotificacaoFactory
                .criarCanal("EMAIL");

        canal.enviar(notificacao);
    }
}