package SMS;

public class Main {
    public static void main(String[] args) {

        new UsuarioService(new EmailNotificador()).registrar("João");
        System.out.println();

        new UsuarioService(new WhatsappNotificador()).registrar("Maria");
        System.out.println();

        new UsuarioService(new SmsNotificador()).registrar("Carlos");
    }
}
