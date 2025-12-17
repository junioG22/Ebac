package SMS;

public class SmsNotificador implements Notificador {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("SMS enviado: " + mensagem);
    }
}
