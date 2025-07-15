import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Square>> board = new ArrayList<>();

    public List<List<Square>> getBoard() {
        return board;
    }
    public void init(){
        Values values = new Values();
        for (int i = 0; i < 9; i++) {
        List<Square> linha = new ArrayList<>();
        for (int j = 0; j < 9; j++) {
            linha.add(new Square(null)); // ou null, se preferir preencher depois
        }
        board.add(linha);
    }
        for(int[] entrada : values.getValoresIniciais()){
            int col = entrada[0];
            int row = entrada[1];
            int value = entrada[2];
            int expectednumber = entrada[3];
            board.get(row).set(col, new Square(value, expectednumber));
        }


        for (int[] entrada : values.getValoresFixos()) {
        int col = entrada[0];
        int row = entrada[1];
        int value = entrada[2];
        board.get(row).set(col, new Square(value));
    }
    }


    public void addNumber(int number, int i, int j){
        if(board.get(i).get(j).getNumber() != 0 && board.get(i).get(j).isFixed() == false){
            System.out.println("Erro: A posição já está ocupada");
            return;
        }
        if(number < 1 || number > 8){
            System.out.println("Erro: O número deve ser de 1 a 9");
            return;
        }
        if(i < 0 || i > 8){
            System.out.println("Erro: O número da linha deve estar entre 1 e 9");
            return;
        }else if(j < 0 || j > 8){
            System.out.println("Erro: O número da coluna deve estar entre 1 e 9");
            return;
        }
        if(board.get(i).get(j).isFixed() == true){
            System.out.println("Está posição é fixa");
            return;
        }
        System.out.println("Antes: " + board.get(i).get(j).getNumber());
        board.get(i).get(j).setNumber(number);
        System.out.println("Depois: " + board.get(i).get(j).getNumber());
    }

    public void editNumber(int number, int i, int j){
        if(number < 1 || number > 9){
            System.out.println("Erro: O número deve ser de 1 a 9");
            return;
        }
        if(i < 0 || i > 9){
            System.out.println("Erro: O número da linha deve estar entre 1 e 9");
            return;
        }else if(j < 0 || j > 9){
            System.out.println("Erro: O número da coluna deve estar entre 1 e 9");
            return;
        }
        if(board.get(i).get(j).isFixed() == true){
            System.out.println("Está posição é fixa");
            return;
        }
        if(board.get(i).get(j).getNumber() != 0 && board.get(i).get(j).isFixed() == false){
            // board.remove(i).remove(j);
            board.get(i).get(j).setNumber(number);
        }else{
            System.out.println("Erro: para editar uma posição é necessário primerio adicionar um número");
        }
    }

    public void showBoard(){
        board.forEach(i -> System.out.println(i+"\n"));
    }

    public void clear(){
        for(List<Square> row : board){
            for(Square column: row){
                if(column.isFixed() == false && column.getNumber() != 0){
                    System.out.println(column.getNumber());
                    column.setNumber(0);
                }
            }
        }
    }

   public boolean checkGame(){
        for(List<Square> row : board){
            for(Square column : row){
                // System.out.println("número digitado:"+column.getNumber()+"\nNúmero esperado:"+column.getExpectednumber());
                if(column.isFixed() == false && column.getNumber() != column.getExpectednumber()){
                        // System.out.println("O jogo não está finalizado");
                        return false;
                    
                }else if(!check3x3()){
                    // System.out.println("O jogo não está finalizado");
                    return false;
                }
            }
        }
        // System.out.println("O jogo está finalizado");
        return true;
   }

   private boolean check3x3(){
        List<Integer> numbers = new ArrayList<>();
         for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {

            for (int i = boxRow * 3; i < boxRow * 3 + 3; i++) {
                for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                    int num = board.get(i).get(j).getNumber();
                    if (num != 0) numbers.add(num);
                }
            }
                Long qtdeNumbers = numbers.stream().distinct().count();
                // System.out.println("qtde números por 3x3:"+duplicates);
                // System.out.println("tamanho de números:"+numbers.size());
                if(qtdeNumbers != numbers.size()){
                    return false;
                }
                numbers.clear();
            }
            
        }
        return true;
        }
    }
   

    



