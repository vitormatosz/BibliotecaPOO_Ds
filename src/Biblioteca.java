import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Livro> acervo = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Livro> getAcervo() {
        return acervo;
    }

    public void listarAcervo() {
        System.out.println("\n╔══════════════╗");
        System.out.println("║    ACERVO    ║");
        System.out.println("╚══════════════╝");

        String status;

        for (int i = 0; i < acervo.size(); i++) {

            if (acervo.get(i).estaEmprestado() == true) {
                status = " - Em uso";
            } else {
                status = " - Disponivel para empréstimo";
            }
            System.out.println((i + 1) + ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao() + ")"
                    + " - " + acervo.get(i).getAutor() + " - L" + (i + 1) + status);
        }
    }
}
