import java.util.Scanner;

public class App {
    static final Scanner input = new Scanner(System.in);
    static final Board board = new Board();

    public static void main(String[] args) throws Exception {
        int option;
        board.init();
        do{
            System.out.println("1 - Adicionar número");
            System.out.println("2 - Editar número");
            System.out.println("3 - Visualizar tabuleiro atualizdo");
            System.out.println("4 - Verificar se o jogo foi finalizado");
            System.out.println("5 - Limpar tabuleiro");
            System.out.println("5 - Sair");
            option = input.nextInt();
            
            switch (option) {
                case 1 -> includeNumber();
                case 2 -> editNumber();
                case 3 -> board.showBoard();
                case 4 -> System.out.println(board.checkGame() ? "Parabéns! Você concluiu o jogo" : "O jogo ainda não foi concluído"); 
                case 5 -> board.clear();
                case 6 -> System.exit(6);
                default -> System.out.println("Opção inválida");
            }
        }while (true);
    }
    public static void includeNumber(){
        int number, i, j;
        System.out.println("Digite os índices");
        System.out.println("Linha: ");
        i = input.nextInt();
        System.out.println("Coluna:");
        j = input.nextInt();
        System.out.println("Número que irá inserir");
        number = input.nextInt();
        board.addNumber(number, i, j);   
    }

    public static void editNumber(){
        int number, i, j;
        System.out.println("Digite os índices");
        System.out.println("Linha: ");
        i = input.nextInt();
        System.out.println("Coluna:");
        j = input.nextInt();
        System.out.println("Número que irá inserir");
        number = input.nextInt();
        board.editNumber(number, i, j);

        
    }
}
