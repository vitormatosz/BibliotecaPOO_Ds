public class Usuario {
    private String nome;
    private String documento;

    public Usuario(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String getDocumento(){
        return documento;
    }
}
