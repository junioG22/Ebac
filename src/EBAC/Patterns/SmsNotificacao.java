package EBAC.Patterns;

public class SmsNotificacao implements CanalNotificacao {

    @Override
    public void enviar(Notificacao notificacao) {

        System.out.println("SMS ENVIADO\n" + notificacao);
    }
}