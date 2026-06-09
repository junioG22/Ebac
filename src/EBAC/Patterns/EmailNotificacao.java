package EBAC.Patterns;

public class EmailNotificacao implements CanalNotificacao {

    @Override
    public void enviar(Notificacao notificacao) {

        System.out.println("EMAIL ENVIADO\n" + notificacao);
    }
}