import java.util.Scanner;

public class Livro {
    private String nome;
    private String publicacao;
    private String autor;

    public Livro(String nome, String autor, String publicacao){
        this.nome = nome;
        this.autor = autor;
        this.publicacao = publicacao;
    }

    public String getNome(){
        return nome;
    }

    public String getAutor(){
        return autor;
    }

    public String getPublicacao(){
        return publicacao;
    }
}


