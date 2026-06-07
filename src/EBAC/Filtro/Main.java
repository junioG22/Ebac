package EBAC.Filtro;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> nomes = Arrays.asList("Ana", "Bruno", "Carlos", "Amanda", "Beatriz");

        FiltroNome filtro = nome -> nome.startsWith("A");

        nomes.stream().filter(filtro::testar).forEach(System.out::println);
    }
}
