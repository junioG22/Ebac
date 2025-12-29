package Catalago;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Lista de produtos
        List<Produto> produtos = List.of(
                new Produto("Notebook", 3500.0),
                new Produto("Mouse", 80.0),
                new Produto("Teclado", 150.0),
                new Produto("Cadeira Gamer", 900.0),
                new Produto("Monitor", 1200.0)
        );

        // 1️⃣ Filtrar produtos com preço > 100
        List<Produto> caros = produtos.stream()
                .filter(p -> p.getPreco() > 100)
                .collect(Collectors.toList());

        System.out.println("Produtos com preço maior que 100:");
        caros.forEach(System.out::println);

        System.out.println("-----");

        // 2️⃣ Ordenar por nome (ordem alfabética)
        List<Produto> ordenados = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .collect(Collectors.toList());

        System.out.println("Produtos ordenados por nome:");
        ordenados.forEach(System.out::println);

        System.out.println("-----");

        // 3️⃣ Buscar produto pelo nome usando Optional
        String nomeBusca = "Monitor";

        Optional<Produto> resultado = produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nomeBusca))
                .findFirst();

        // 4️⃣ Trabalhar Optional com ifPresentOrElse
        resultado.ifPresentOrElse(
                p -> System.out.println("Produto encontrado: " + p.getNome() + " - R$ " + p.getPreco()),
                () -> System.out.println("Produto não encontrado.")
        );
    }
}
