package EBAC.Patterns;

public class WhatsappNotificacao implements CanalNotificacao {

    @Override
    public void enviar(Notificacao notificacao) {

        System.out.println("WHATSAPP ENVIADO\n" + notificacao);
    }
}