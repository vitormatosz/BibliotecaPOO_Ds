public class Livro {
    private String nome;
    private String publicacao;
    private String autor;
    private boolean emprestado;

    public Livro(String nome, String autor, String publicacao) {
        this.nome = nome;
        this.autor = autor;
        this.publicacao = publicacao;
        this.emprestado = false;
    }

    public boolean estaEmprestado() { // ta verificando se o livro ta emprestado
        return emprestado;
    }

    public void emprestar() { // metodo pra declarar livro como emprestado
        emprestado = true;
    }

    public void devolver() { // metodo pra devolver livro
        emprestado = false;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getPublicacao() {
        return publicacao;
    }
}
