import java.util.Scanner;

public class Usuario {
    private String nome;
    private String codigo;
    private String documento;
    private String email;

    public Usuario(String nome, String email, String documento) {
    this.nome = nome;
    this.documento = documento;
    this.email = email;
}

    public String getNome(){
        return nome;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getDocumento(){
        return documento;
    }

    public String getEmail(){
        return email;
    }

}

