import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        System.out.println("========================");
        System.out.println("====   Bem Vindo!   ====");
        System.out.println("========================");

        boolean rodando = true;

        while (rodando) {
            System.out.println("========================");
            System.out.println("===       Menu       ===");
            System.out.println("= 1. listar acervo     =");
            System.out.println("= 2. listar usúarios   =");
            System.out.println("= 3. Emprestar livro   =");
            System.out.println("= 4. Devolver item     =");
            System.out.println("= 5. Cadastrar Livro   =");
            System.out.println("= 6. Cadastrar Usúario =");
            System.out.println("= 0. Sair              =");

            System.out.println("Escolha uma opção:");
            String opcao = ler.nextLine().trim();

            switch (opcao) {
                case "1":
                    
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
