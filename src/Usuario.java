import java.util.Random;

public class Usuario {
    private String nome;
    private String codigo = "";
    private String documento;
    private String email;

    Random gerador = new Random();
    int code;

    public Usuario(String nome, String email, String documento) {
    this.nome = nome;
    this.documento = documento;
    this.email = email;
}

    public String getNome(){
        return nome;
    }

    public String getCodigo(){
        for (int j = 0; j < 5; j++) {
            code = gerador.nextInt(10);
            codigo = codigo + code;
        }
        
        return codigo;
    }

    public String getDocumento(){
        return documento;
    }

    public String getEmail(){
        return email;
    }

}

