package Filtro;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Lista de nomes
        List<String> nomes = Arrays.asList(
                "Ana", "Bruno", "Carlos", "Amanda", "Beatriz"
        );

        // 2. Instância da interface funcional usando Lambda
        FiltroNome filtro = nome -> nome.startsWith("A");

        // 3. Stream + filter + lambda
        nomes.stream()
                .filter(filtro::testar)
                .forEach(System.out::println);
    }
}
