package Dados;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public String toXML() {
        return """
            <pessoa>
                <id>%d</id>
                <nome>%s</nome>
                <idade>%d</idade>
            </pessoa>
        """.formatted(id, nome, idade);
    }
}
