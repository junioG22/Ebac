package EBAC.Patterns;

public class Notificacao {

    private final String destinatario;
    private final String mensagem;
    private final String assunto;

    public Notificacao(String destinatario, String mensagem, String assunto) {
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.assunto = assunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getAssunto() {
        return assunto;
    }

    @Override
    public String toString() {

        return """
                Destinatário: %s
                Assunto: %s
                Mensagem: %s
                """.formatted(
                destinatario,
                assunto,
                mensagem
        );
    }

    public static NotificacaoBuilder builder() {

        return new NotificacaoBuilder();
    }
}
