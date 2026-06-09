package EBAC.Patterns;

public class NotificacaoBuilder {

    private String destinatario;
    private String mensagem;
    private String assunto;

    public NotificacaoBuilder destinatario(String destinatario) {

        this.destinatario = destinatario;

        return this;
    }

    public NotificacaoBuilder mensagem(String mensagem) {

        this.mensagem = mensagem;

        return this;
    }

    public NotificacaoBuilder assunto(String assunto) {

        this.assunto = assunto;

        return this;
    }

    public Notificacao build() {

        return new Notificacao(
                destinatario,
                mensagem,
                assunto
        );
    }
}