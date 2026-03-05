import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        Usuario u1;
        Livro l1;

        System.out.println("\n========================");
        System.out.println("====   Bem Vindo!   ====");
        System.out.println("========================");

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n========================");
            System.out.println("===       Menu       ===");
            System.out.println("= 1. listar acervo     =");
            System.out.println("= 2. listar usúarios   =");
            System.out.println("= 3. Emprestar livro   =");
            System.out.println("= 4. Devolver item     =");
            System.out.println("= 5. Cadastrar Livro   =");
            System.out.println("= 6. Cadastrar Usúario =");
            System.out.println("= 0. Sair              =");

            System.out.println("\nEscolha uma opção:");
            String opcao = ler.nextLine().trim();

            switch (opcao) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    System.out.print("Nome do livro: ");
                    String nameLivro = ler.nextLine();

                    System.out.print("Autor: ");
                    String autor = ler.nextLine();

                    l1 = new Livro(nameLivro, autor);

                    System.out.println("Livro: '" +l1.getNome()+"' Cadastrado!");
                    break;
                case "6":
                    System.out.print("Nome: ");
                    String name = ler.nextLine();

                    System.out.print("Documento: ");
                    String document = ler.nextLine();

                    System.out.print("Email: ");
                    String email = ler.nextLine();

                    u1 = new Usuario(name, document, email);

                    System.out.println("Usuário: " + u1.getNome() + " Cadastrado!");
                    break;
                case "0":
                    rodando = false;
                    System.out.println("Até a próxima!");
                    break;

                default:
                    System.out.println("Opção Inválida.");
                    break;
            }

        }

    }

}
