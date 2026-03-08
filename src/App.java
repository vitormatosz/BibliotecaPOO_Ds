import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Livro> acervo = new ArrayList<>();

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
            System.out.println("║  7. Deletar Usúario      ║");
            System.out.println("║  8. Deletar Livro        ║");
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

                        if (acervo.get(i).estaEmprestado() == true) {
                            status = " - Em uso";
                        } else {
                            status = " - Disponivel para empréstimo";
                        }

                        System.out.println(
                                (i + 1) + ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao() + ")"
                                        + " - " + acervo.get(i).getAutor() + " - L" + (i + 1) + status);
                    }

                    break;

                case "2":
                    System.out.println("\n=========================");
                    System.out.println("===  LISTAR USUÁRIOS  ===");
                    System.out.println("=========================");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(
                                (i + 1) + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());

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
                                (i + 1) + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());
                    }

                    if (usuarios.size() == 0) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    }

                    System.out.println("Escolha um usuário: ");
                    int opcaoUser = ler.nextInt();

                    Usuario escolhido = usuarios.get(opcaoUser - 1); // cria objeto da classe/construtor Usuario que
                                                                     // pega o usuario selecionado pelo indice/numero

                    ler.nextLine();

                    System.out.println("Confirme o Documento do Usuário: " + escolhido.getNome());
                    String docConfirmar = ler.nextLine();

                    if (docConfirmar.equals(escolhido.getDocumento())) {
                        System.out.println("Documento Confirmado!\n");
                    } else {
                        System.out.println("Documento Negado!");
                        break;
                    }

                    for (int i = 0; i < acervo.size(); i++) {
                        System.out.println(
                                (i + 1) + ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao() + ")"
                                        + " - " + acervo.get(i).getAutor() + " - L" + (i + 1));
                    }

                    if (acervo.size() == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                        break;
                    }

                    System.out.println("Escolha uma opção de Livro para empréstimo:");
                    int opcaoLivro = ler.nextInt();

                    ler.nextLine();

                    int indice = (opcaoLivro - 1);

                    Livro livroEscolhido = acervo.get(indice); // cria objeto da classe Livro que é atribuido ao livro
                                                               // escolhido do acervo apartir do numero escolhido

                    if (livroEscolhido.estaEmprestado() == false) {

                        livroEscolhido.emprestar(); // declara livro como emprestado
                        escolhido.pegarLivros(livroEscolhido); // adiciona o livro escolhido no ArrayList livrosPegos
                        System.out.println(
                                "Livro '" + acervo.get(indice).getNome() + "' emprestado para: " + escolhido.getNome());

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
                                (i + 1) + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());

                    }

                    if (usuarios.size() == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                        break;
                    }

                    System.out.println("Escolha um usuário: ");
                    int opcaoUsuario = ler.nextInt();

                    Usuario Uescolhido = usuarios.get(opcaoUsuario - 1); // cria objeto da classe/construtor Usuario que
                                                                         // pega o usuario selecionado pelo
                                                                         // indice/numero

                    ler.nextLine();

                    System.out.println("Confirme o Documento do Usuário: " + Uescolhido.getNome());
                    String docConfirme = ler.nextLine();

                    if (docConfirme.equals(Uescolhido.getDocumento())) {
                        System.out.println("Documento Confirmado!\n");
                    } else {
                        System.out.println("Documento Negado!");
                        break;
                    }

                    System.out.println("Livros Emprestados: ");
                    Uescolhido.mostrarLivros();

                    System.out.println("Digite o nome do livro para devolução:");
                    String opcaoDeLivro = ler.nextLine();

                    ler.nextLine();

                    for (int i = 0; i < acervo.size(); i++) {

                        if (acervo.get(i).getNome().equals(opcaoDeLivro)) {

                            Livro Lescolhido = acervo.get(i); // cria objeto da classe Livro que é atribuido ao livro
                                                              // escolhido do acervo apartir de seu nome

                            if (Lescolhido.estaEmprestado() == true) {

                                Lescolhido.devolver(); // usa o método devolver para declarar emprestado como
                                                       // false(livro disponivel pra emprestimo)
                                Uescolhido.devolverLivros(Lescolhido); // retira o livro escolhido do ArrayList
                                                                       // livrosPegos

                                System.out.println("Livro '" + Lescolhido.getNome() + "' devolvido pelo usuário: "
                                        + Uescolhido.getNome());
                                break;

                            } else {
                                System.out.println("Livro disponivel para empréstimo!");
                            }
                        }
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

                    Livro novo = new Livro(nameLivro, autor, publi);
                    acervo.add(novo);

                    System.out.println("Livro: '" + novo.getNome() + "' Cadastrado!");

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

                case "7":
                    System.out.println("\n==========================");
                    System.out.println("===  DELETAR USUÁRIOS  ===");
                    System.out.println("==========================");

                    System.out.println("Digite o ID do usuário");
                    String infoUser = ler.nextLine();

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getCodigo().equals(infoUser)) {
                            System.out.println("Usuário confirmado!");

                            System.out.println("Digite o email do usuário: ");
                            String emailUser = ler.nextLine();

                            if (usuarios.get(i).getEmail().equals(emailUser)) {
                                System.out.println("Email confirmado!");

                                System.out.println("Digite o documento do usuário: ");
                                String docUser = ler.nextLine();

                                if (usuarios.get(i).getDocumento().equals(docUser)) {
                                    System.out.println("Documento confirmado!\n");

                                    System.out.println("Adeus " + usuarios.get(i).getNome() + "!");
                                    usuarios.remove(usuarios.get(i));
                                    break;
                                } else {
                                    System.out.println("Documento não encontrado!");
                                }
                            } else {
                                System.out.println("Email não encontrado!");
                            }
                        } else {
                            System.out.println("Usuário não encontrado!");

                        }
                    }

                    break;

                case "8":
                    System.out.println("\n========================");
                    System.out.println("===  DELETAR LIVROS  ===");
                    System.out.println("========================");

                    System.out.println("Digite o nome do livro");
                    String infoLivro = ler.nextLine();

                    for (int i = 0; i < acervo.size(); i++) {

                        if (acervo.get(i).getNome().equals(infoLivro)) {
                            Livro livroSelecionado = acervo.get(i); 
                            System.out.println("Livro existente!");

                            System.out.println("Deseja excluir livro do acervo (Sim ou Não)");
                            String resposta = ler.nextLine();

                            if (resposta.equals("Sim")) {
                                System.out.println("Livro '"+livroSelecionado.getNome()+"' Removido do Acervo");
                                acervo.remove(livroSelecionado);
                                break;
                            } else {
                                break;
                            }

                        } else {
                            System.out.println("Usuário não encontrado!");

                        }
                    }

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
