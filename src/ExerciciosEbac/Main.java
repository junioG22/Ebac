package ExerciciosEbac;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade &&
                Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {

        Set<Pessoa> pessoas = new HashSet<>();

        pessoas.add(new Pessoa("Ana", 25));
        pessoas.add(new Pessoa("João", 30));
        pessoas.add(new Pessoa("Ana", 25));   // duplicado
        pessoas.add(new Pessoa("João", 30));  // duplicado
        pessoas.add(new Pessoa("Maria", 40));

        System.out.println("Quantidade final de pessoas no sistema: " + pessoas.size());
        System.out.println("\nPessoas cadastradas:");

        for (Pessoa p : pessoas) {
            System.out.println(p);
        }

        System.out.println(
                "\nExplicação: Pessoas com o mesmo nome e idade não foram duplicadas, " +
                        "pois os métodos equals() e hashCode() foram sobrescritos. " +
                        "O HashSet usa esses métodos para impedir elementos duplicados."
        );
    }
}
