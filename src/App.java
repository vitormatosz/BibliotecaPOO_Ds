import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Livro> acervo = new ArrayList<>();

        int contUser = 1;
        int contLivro = 1;

        System.out.println("╔══════════════════════════╗");
        System.out.println("║        BEM-VINDO!        ║");
        System.out.println("╚══════════════════════════╝");

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║           MENU           ║");
            System.out.println("╚══════════════════════════╝");
            System.out.println("╔══════════════════════════╗");
            System.out.println("║  1. listar acervo        ║");
            System.out.println("║  2. listar usúarios      ║");
            System.out.println("║  3. Emprestar livro      ║");
            System.out.println("║  4. Devolver livro       ║");
            System.out.println("║  5. Cadastrar Livro      ║");
            System.out.println("║  6. Cadastrar Usúario    ║");
            System.out.println("║  0. Sair                 ║");
            System.out.println("╚══════════════════════════╝");

            System.out.println("\nEscolha uma opção:");
            String opcao = ler.nextLine().trim();

            switch (opcao) {
                case "1":
                    System.out.println("\n================");
                    System.out.println("===  ACERVO  ===");
                    System.out.println("================");
                    for (int i = 0; i < acervo.size(); i++) {
                        System.out.println(
                                contLivro + ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao() + ")"
                                        + " - " + acervo.get(i).getAutor() + " - L" + contLivro);

                        contLivro++;
                    }

                    break;

                case "2":
                    System.out.println("\n=========================");
                    System.out.println("===  LISTAR USUÁRIOS  ===");
                    System.out.println("=========================");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(
                                contUser + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());

                        contUser++;
                    }
                    break;

                case "3":
                    System.out.println("\n=========================");
                    System.out.println("===  EMPRESTAR LIVRO  ===");
                    System.out.println("=========================");

                    break;

                case "4":
                    System.out.println("\n========================");
                    System.out.println("===  DEVOLVER LIVRO  ===");
                    System.out.println("========================");

                    break;

                case "5":
                    System.out.println("\n==========================");
                    System.out.println("===  CADASTRAR LIVROS  ===");
                    System.out.println("==========================");

                    System.out.print("Nome do livro: ");
                    String nameLivro = ler.nextLine();

                    System.out.print("Autor: ");
                    String autor = ler.nextLine();

                    System.out.print("Data de Publicacao: ");
                    String publi = ler.nextLine();

                    acervo.add(new Livro(nameLivro, autor, publi));

                    for (int i = 0; i < acervo.size(); i++) {
                        System.out.println("Livro: '" + acervo.get(i).getNome() + "' Cadastrado!");
                    }
                    break;

                case "6":
                    System.out.println("\n============================");
                    System.out.println("===  CADASTRAR USUÁRIOS  ===");
                    System.out.println("============================");

                    System.out.print("Nome: ");
                    String name = ler.nextLine();

                    System.out.print("Documento: ");
                    String document = ler.nextLine();

                    System.out.print("Email: ");
                    String email = ler.nextLine();

                    usuarios.add(new Usuario(name, document, email));

                    System.out.println("Usuário Cadastrado!");
                    break;

                case "0":
                    rodando = false;
                    System.out.println("\n╔══════════════════════════╗");
                    System.out.println("║      ATÉ A PROXIMA!      ║");
                    System.out.println("╚══════════════════════════╝");
                    break;

                default:
                    System.out.println("Opção Inválida.");
                    break;
            }

        }

    }

}
