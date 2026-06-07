package EBAC.SistemaBiblioteca;

public class LivroIndisponivelException extends Exception {

    public LivroIndisponivelException(String mensagem) {
        super(mensagem);
    }
}