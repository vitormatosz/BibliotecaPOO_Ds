import java.util.Random;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String codigo = "";
    private String documento;
    private String email;
    ArrayList<Livro> livrosPegos = new ArrayList<>();

    Random gerador = new Random();
    int code;

    public Usuario(String nome, String email, String documento) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }

    public void pegarLivros(Livro livro) { // metodo pra atribuir livro ao usuario
        livrosPegos.add(livro); // adiciona pra ArrayList livrosPegos
    }

    public void devolverLivros(Livro livro) { // metodo pra atribuir livro ao usuario
        livrosPegos.remove(livro); // adiciona pra ArrayList livrosPegos
    }

    public String getNome() {
        return nome;
    }

    public void mostrarLivros() { // metodo que mostra os livros emprestados dos usuairos

        for (int i = 0; i < livrosPegos.size(); i++) {
            System.out.println("- " + livrosPegos.get(i).getNome());
        }

    }

    public String getCodigo() {
        for (int j = 0; j < 5; j++) {
            code = gerador.nextInt(10);
        }

        codigo = codigo + code;
        return codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

}
