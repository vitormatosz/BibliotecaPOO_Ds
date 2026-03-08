import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Livro> acervo = new ArrayList<>();

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

                    String status;

                    for (int i = 0; i < acervo.size(); i++) {

                        if (acervo.get(i).estaEmprestado()) {
                            status = " - Em uso";
                        } else {
                            status = " - Disponivel";
                        }

                        System.out.println(
                                (i+1) + ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao() + ")"
                                        + " - " + acervo.get(i).getAutor() + " - L" + (i+1)+status);
                    }

                    break;

                case "2":
                    System.out.println("\n=========================");
                    System.out.println("===  LISTAR USUÁRIOS  ===");
                    System.out.println("=========================");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(
                                (i+1) + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());

                        System.out.println("Livros Emprestados:");
                        usuarios.get(i).mostrarLivros();
                        System.out.println("------------------");
                    }

                    break;

                case "3":
                    System.out.println("\n=========================");
                    System.out.println("===  EMPRESTAR LIVRO  ===");
                    System.out.println("=========================\n");

                    System.out.println("===USUÁRIOS===");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(
                                 (i+1)+ ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());

                    }

                    System.out.println("Escolha um usuário: ");
                    int opcaoUser = ler.nextInt();

                    Usuario escolhido = usuarios.get(opcaoUser - 1); //cria objeto da classe/construtor Usuario que pega o usuario selecionado pelo indice/numero

                    ler.nextLine();

                    System.out.println("confirme o Documento do usuario: "+escolhido.getNome());
                    String docConfirmar = ler.nextLine();

                    if (docConfirmar.equals(escolhido.getDocumento())) {
                        System.out.println("Documento Confirmado!");
                    } else {
                        System.out.println("Documento Negado!");
                        break;
                    }

                    for (int i = 0; i < acervo.size(); i++) {
                        System.out.println(
                                "\n"+(i+1)+ ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao() + ")"
                                        + " - " + acervo.get(i).getAutor() + " - L" + contLivro);

                        contLivro++;
                    }

                    System.out.println("Escolha uma opção de Livro:");
                    int opcaoLivro = ler.nextInt();

                    int indice = (opcaoLivro - 1);

                    Livro livroEscolhido = acervo.get(indice); //cria objeto da classe Livro que é atribuido ao livro escolhido do acervo apartir do numero escolhido
                    
                    if (livroEscolhido.estaEmprestado() == false){

                        livroEscolhido.emprestar(); //declara livro como emprestado
                        escolhido.pegarLivros(livroEscolhido); //adiciona o livro escolhido no ArrayList livrosPegos
                        System.out.println("Livro "+acervo.get(indice).getNome()+" Emprestado para "+escolhido.getNome());

                    } else {
                        System.out.println("Livro já emprestado!");
                    }
                

                    break;

                case "4":
                    System.out.println("\n========================");
                    System.out.println("===  DEVOLVER LIVRO  ===");
                    System.out.println("========================\n");

                    System.out.println("===USUÁRIOS===");

                    for (int i = 0; i < usuarios.size(); i++) {

                        System.out.println(
                                 (i+1)+ ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());

                    }

                    System.out.println("Escolha um usuário e digite seu dpcumento: ");
                    int opcaoUsuario = ler.nextInt();

                    Usuario Uescolhido = usuarios.get(opcaoUsuario - 1); //cria objeto da classe/construtor Usuario que pega o usuario selecionado pelo indice/numero

                    for (int i = 0; i < acervo.size(); i++) {
                        System.out.println(
                                "\n"+(i+1)+ ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao() + ")"
                                        + " - " + acervo.get(i).getAutor() + " - L" + (i+1));
                    }

                    System.out.println("Escolha uma opção de Livro:");
                    int opcaoDeLivro = ler.nextInt();

                    int ind = (opcaoDeLivro - 1);

                    Livro Lescolhido = acervo.get(ind); //cria objeto da classe Livro que é atribuido ao livro escolhido do acervo apartir do numero escolhido
                    
                    if (Lescolhido.estaEmprestado() == !false){

                        Lescolhido.devolver(); //declara livro como emprestado
                        Uescolhido.devolverLivros(Lescolhido); //adiciona o livro escolhido no ArrayList livrosPegos
                        System.out.println("Livro "+acervo.get(ind).getNome()+" Devolvido pelo Usuario: "+Uescolhido.getNome());

                    } else {
                        System.out.println("Livro disponivel para empréstimo!");
                    }

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
