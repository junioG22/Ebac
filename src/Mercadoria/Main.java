package Mercadoria;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Celular", 2500.00));
        produtos.add(new Produto("Notebook", 4500.00));
        produtos.add(new Produto("Fone", 300.00));
        produtos.add(new Produto("Teclado", 150.00));

        ListaUtil.ordenarExibir(produtos);
    }
}
