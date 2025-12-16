package ExerciciosEbac;

public class Escadaria {

    public static int subirEscada(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return subirEscada(n - 1) + subirEscada(n - 2);
    }

    public static void main(String[] args) {
        int n = 4; // pode trocar o valor
        System.out.println(subirEscada(n));
    }
}
