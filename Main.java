import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    System.out.print("Please enter your name for P1: ");
    String name1 = sc.nextLine();

    System.out.print("Please enter your name for P2: ");
    String name2 = sc.nextLine();

    Player p1 = new Player(name1, 'X');
    Player p2 = new Player(name2, 'O');

    Board board = new Board();

    Player current = p1;

    while(true){
        board.printBoard();
        System.out.println("Current player is" + current);
        System.out.println(current.getName() + ", " + "please select column.");
        int col = sc.nextInt();
        
        if(!board.dropPiece(col, current.getSymbol())){
            System.out.println("This column is invalid. Please try another column.");
            continue;
        }
        if(board.checkWinner(current.getSymbol())){
             System.out.println(current.getName() + " wins!");
             board.printBoard();
             break;
        }
        if(current==p1){
            current = p2;
        }
        else{
            current = p1;
        }    
    }
    sc.close();
    }
}

