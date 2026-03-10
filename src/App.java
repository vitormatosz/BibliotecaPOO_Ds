import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        Livro existente1 = new Livro("Dom Casmurro", "Machado de Assis", "1899");
        Livro existente2 = new Livro("Pantano de Sangue", "Pedro Bandeira", "1987");
        Usuario vitor = new Usuario("Vitor Matos", "96365697129", "vitorqsmatos");

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Livro> acervo = new ArrayList<>();

        acervo.add(existente1);
        acervo.add(existente2);
        usuarios.add(vitor);

        System.out.println("╔══════════════════════════╗");
        System.out.println("║        BEM-VINDO!        ║");
        System.out.println("╚══════════════════════════╝");

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║           MENU           ║");
            System.out.println("╚══════════════════════════╝");
            System.out.println("╔══════════════════════════╗");
            System.out.println("║  1. Listar Acervo        ║");
            System.out.println("║  2. Listar Usúarios      ║");
            System.out.println("║  3. Emprestar Livro      ║");
            System.out.println("║  4. Devolver Livro       ║");
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
                        System.out.println((i + 1) + ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao()+ ")" + " - " + acervo.get(i).getAutor() + " - L" + (i + 1) + status);
                    }
                    break;

                case "2":
                    System.out.println("\n╔═══════════════════════╗");
                    System.out.println("║    LISTAR USUÁRIOS    ║");
                    System.out.println("╚═══════════════════════╝");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println((i + 1) + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());

                        System.out.println("Livros Emprestados:");
                        usuarios.get(i).mostrarLivros();
                        System.out.println("------------------");
                    }
                    break;

                case "3":
                    System.out.println("\n╔════════════════════════╗");
                    System.out.println("║    EMPRESTAR LIVROS    ║");
                    System.out.println("╚════════════════════════╝\n");

                    System.out.println("===USUÁRIOS===");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println((i + 1) + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());
                    }

                    if (usuarios.size() == 0) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    }

                    System.out.println("Escolha um usuário: ");
                    int opcaoUser = ler.nextInt();

                    ler.nextLine();

                    if (opcaoUser < 1 || opcaoUser > usuarios.size()) {
                        System.out.println("Usuário inválido!");
                        break;
                    }

                    Usuario escolhido = usuarios.get(opcaoUser - 1); // cria objeto da classe/construtor Usuario quepega
                                                                     // o usuario selecionado pelo indice/numero

                    System.out.println("Confirme o Documento do Usuário: " + escolhido.getNome());
                    String docConfirmar = ler.nextLine();

                    if (docConfirmar.equals(escolhido.getDocumento())) {
                        System.out.println("Documento Confirmado!\n");
                    } else {
                        System.out.println("Documento Negado!");
                        break;
                    }

                    System.out.println("===LIVROS===");

                    for (int i = 0; i < acervo.size(); i++) {
                        System.out.println((i + 1) + ". " + acervo.get(i).getNome() + " (" + acervo.get(i).getPublicacao()+ ")" + " - " + acervo.get(i).getAutor() + " - L" + (i + 1));
                    }

                    if (acervo.size() == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                        break;
                    }

                    System.out.println("Escolha uma opção de Livro para empréstimo:");
                    int opcaoLivro = ler.nextInt();

                    ler.nextLine();

                    if (opcaoLivro < 1 || opcaoLivro > acervo.size()) {
                        System.out.println("Livro inválido!");
                        break;
                    }

                    int indice = (opcaoLivro - 1);
                    Livro livroEscolhido = acervo.get(indice); // cria objeto da classe Livro que é atribuido ao livro
                                                               // escolhido do acervo apartir do numero escolhido

                    if (livroEscolhido.estaEmprestado() == false) {

                        livroEscolhido.emprestar(); // declara livro como emprestado
                        escolhido.pegarLivros(livroEscolhido); // adiciona o livro escolhido no ArrayList livrosPegos
                        if (escolhido.getLivrosPegos().size() > 2) {
                            System.out.println("Limite de Livros Atingido!");
                            livroEscolhido.devolver();
                            escolhido.getLivrosPegos().remove(livroEscolhido);
                            break;
                        }
                        System.out.println("Livro '" + acervo.get(indice).getNome() + "' emprestado para: " + escolhido.getNome());
                    } else {
                        System.out.println("Livro já emprestado!");
                    }
                    break;

                case "4":
                    System.out.println("\n╔═══════════════════════╗");
                    System.out.println("║    DEVOLVER LIVROS    ║");
                    System.out.println("╚═══════════════════════╝\n");

                    System.out.println("===USUÁRIOS===");

                    for (int i = 0; i < usuarios.size(); i++) {

                        System.out.println((i + 1) + ". " + usuarios.get(i).getNome() + " - ID:" + usuarios.get(i).getCodigo());
                    }

                    if (usuarios.size() == 0) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    }

                    System.out.println("Escolha um usuário: ");
                    int opcaoUsuario = ler.nextInt();

                    ler.nextLine();

                    if (opcaoUsuario < 1 || opcaoUsuario > usuarios.size()) {
                        System.out.println("Usuário inválido!");
                        break;
                    }

                    Usuario Uescolhido = usuarios.get(opcaoUsuario - 1); // cria objeto da classe/construtor Usuario que
                                                                         // pega o usuario selecionado pelo
                                                                         // indice/numero

                    System.out.println("Confirme o Documento do Usuário: " + Uescolhido.getNome());
                    String docConfirme = ler.nextLine();

                    if (docConfirme.equals(Uescolhido.getDocumento())) {
                        System.out.println("Documento Confirmado!\n");
                    } else {
                        System.out.println("Documento Negado!");
                        break;
                    }

                    System.out.println("===LIVROS===");

                    System.out.println("Livros Emprestados: ");
                    Uescolhido.mostrarLivros();

                    if (Uescolhido.getLivrosPegos().size() == 0) {
                        System.out.println("Usuário sem livros emprestados!");
                        break;
                    }

                    System.out.println("Digite o nome do livro para devolução:");
                    String opcaoDeLivro = ler.nextLine();

                    boolean oplivro = false;

                    for (int i = 0; i < Uescolhido.getLivrosPegos().size(); i++) {

                        Livro Lescolhido = Uescolhido.getLivrosPegos().get(i); // cria objeto da classe Livro que é
                                                                               // atribuido ao livro escolhido do acervo
                                                                               // apartir de seu nome

                        if (Lescolhido.getNome().equals(opcaoDeLivro)) {
                            oplivro = true;

                            if (Lescolhido.estaEmprestado() == true) {

                                Lescolhido.devolver(); // usa o método devolver para declarar emprestado comofalse(livro disponivel pra emprestimo)
                                Uescolhido.devolverLivros(Lescolhido); // retira o livro escolhido do ArrayListlivrosPegos

                                System.out.println("Livro '" + Lescolhido.getNome() + "' devolvido pelo usuário: "+ Uescolhido.getNome());
                                break;
                            }
                        }
                    }

                    if (oplivro == false) {
                        System.out.println("Não é possivel devolver esse livro! / Ou nome do livro incorreto! ");
                    }
                    break;

                case "5":
                    System.out.println("\n╔════════════════════════╗");
                    System.out.println("║    CADASTRAR LIVROS    ║");
                    System.out.println("╚════════════════════════╝\n");

                    System.out.print("Nome do livro: ");
                    String nameLivro = ler.nextLine();

                    System.out.print("Autor: ");
                    String autor = ler.nextLine();

                    System.out.print("Data de Publicacao: ");
                    String publi = ler.nextLine();

                    if (publi.length() < 4) {
                        System.out.println("Data digitada incorretamente!");
                        break;
                    }

                    Livro novo = new Livro(nameLivro, autor, publi);
                    acervo.add(novo);

                    System.out.println("Livro: '" + novo.getNome() + "' Cadastrado!");
                    break;

                case "6":
                    System.out.println("\n╔══════════════════════════╗");
                    System.out.println("║    CADASTRAR USUÁRIOS    ║");
                    System.out.println("╚══════════════════════════╝\n");

                    System.out.print("Nome: ");
                    String name = ler.nextLine();

                    System.out.print("CPF: ");
                    String document = ler.nextLine();

                    if (document.length() < 11) {
                        System.out.println("CPF digitado incorretamente!");
                        break;
                    }
                    boolean cpfExiste = false;

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getDocumento().equals(document)) {
                            cpfExiste = true;
                            System.out.println("CPF ja cadastrado!");
                            break;
                        }
                    }

                    if (cpfExiste == false) {
                        System.out.print("Email: ");
                        String email = ler.nextLine();

                        usuarios.add(new Usuario(name, document, email));

                        System.out.println("Usuário Cadastrado!");
                    }
                     break;

                case "7":
                    System.out.println("\n╔════════════════════════╗");
                    System.out.println("║    DELETAR USUÁRIOS    ║");
                    System.out.println("╚════════════════════════╝\n");

                    System.out.println("Digite o ID do usuário");
                    String infoUser = ler.nextLine();

                    boolean user = false;

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getCodigo().equals(infoUser)) {
                            user = true;

                            System.out.println("Usuário confirmado!\n");

                            System.out.println("Digite o email do usuário: ");
                            String emailUser = ler.nextLine();

                            if (usuarios.get(i).getEmail().equals(emailUser)) {
                                System.out.println("Email confirmado!\n");

                                System.out.println("Digite o documento do usuário: ");
                                String docUser = ler.nextLine();

                                if (usuarios.get(i).getDocumento().equals(docUser)) {
                                    System.out.println("Documento confirmado!\n");

                                    if (usuarios.get(i).getLivrosPegos().size() > 0) {
                                        System.out.println("Usuário ainda possui livros emprestados!");
                                        break;
                                    }

                                    System.out.println("Adeus " + usuarios.get(i).getNome() + "!");
                                    usuarios.remove(usuarios.get(i));
                                    break;
                                } else {
                                    System.out.println("Documento não encontrado!");
                                }
                            } else {
                                System.out.println("Email não encontrado!");
                            }
                        }
                    }

                    if (user == false) {
                        System.out.println("Usuário não encontrado!");
                    }

                    break;

                case "8":
                    System.out.println("\n╔══════════════════════╗");
                    System.out.println("║    DELETAR LIVROS    ║");
                    System.out.println("╚══════════════════════╝\n");

                    System.out.println("Digite o nome do livro");
                    String infoLivro = ler.nextLine();

                    boolean Lencontrado = false;

                    for (int i = 0; i < acervo.size(); i++) {
                        if (acervo.get(i).getNome().equals(infoLivro)) {
                            Lencontrado = true;
                            Livro livroSelecionado = acervo.get(i);
                            System.out.println("Livro existente!\n");

                            System.out.println("Deseja excluir livro do acervo (Sim ou Não)");
                            String resposta = ler.nextLine();

                            if (resposta.equalsIgnoreCase("Sim")) {
                                System.out.println("\nLivro '" + livroSelecionado.getNome() + "' Removido do Acervo");
                                acervo.remove(livroSelecionado);
                            } else {
                                break;
                            }
                        }
                    }
                    if (Lencontrado == false) {
                        System.out.println("Livro não encontrado!");
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
