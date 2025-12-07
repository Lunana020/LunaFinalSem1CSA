import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    //declare player name
    System.out.print("Please enter your name for P1: ");
    String name1 = sc.nextLine();

    System.out.print("Please enter your name for P2: ");
    String name2 = sc.nextLine();

    //sets symbol for each palyer
    Player p1 = new Player(name1, 'X');
    Player p2 = new Player(name2, 'O');

    //creates new board for the game
    Board board = new Board();

    Player current = p1;

/* plays game while there is no winner
- asks each player to place their symbol in the borad
- switches turn after each placement
- if there's winner the game ends
- if there's tie, the game ends
 */
    while(true){
        board.printBoard();
        System.out.println("Current player is" + current);
        System.out.println(current.getName() + ", " + "please select column.");
        int col = sc.nextInt();
        
        if(!board.dropPiece(col, current.getSymbol())){
            continue;
        }
        if(board.checkWinner(current.getSymbol())){
             System.out.println(current.getName() + " wins!");
             board.printBoard();
             break;
        }
        if (board.isFull()) {
            System.out.println("It's a tie!");
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

