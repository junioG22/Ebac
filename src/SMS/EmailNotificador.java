package SMS;

public class EmailNotificador implements Notificador {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Email enviado: " + mensagem);
    }
}
