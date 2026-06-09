package EBAC.Patterns;

public class NotificacaoFactory {

    public static CanalNotificacao criarCanal(String tipo) {

        if (tipo.equalsIgnoreCase("EMAIL")) {

            return new EmailNotificacao();
        }

        if (tipo.equalsIgnoreCase("SMS")) {

            return new SmsNotificacao();
        }

        if (tipo.equalsIgnoreCase("WHATSAPP")) {

            return new WhatsappNotificacao();
        }

        throw new IllegalArgumentException(
                "Tipo de canal inválido."
        );
    }
}