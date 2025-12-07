public class Board{
    private char[][] grid;
//1. Make a 6x7 2D array board filled with '_' (no symbols filled in yet)
    public Board(){
        grid = new char[6][7];
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                grid[r][c] = '_';
            }
        }
    }


//2. Prints out the board when called
    public void printBoard(){
       for(int r = 0; r<6; r++){
        for(int c = 0; c<7; c++){
            System.out.print(grid[r][c]);
        }
        System.out.println();
       }
    }

/*3. Drops piece in column given by parameter.
- if the column is out of bound, it returns false
- if the column is full, it returns false
- if the column isn't full or out of bound, it places symbol and returns true
*/
    public boolean dropPiece(int col, char symbol ){

        if(col<0 || col>=grid[0].length){
            System.out.println("This column does not exist.");
            return false;
        }

        for(int r = grid.length-1; r>=0; r--){
            if(grid[r][col]=='_'){
                grid[r][col] = symbol; 
                return true;
            }
        }
        System.out.println("This column is full. Please try other column");
        return false;
    }


/* check horizontal, vertical, diagonal 1 (right down), diagonal 2 (left down) to see
if there are 4 of the same symbols in each direction
- if there is winner, it declares the winner and returns true
- if not, it returns false
 */

    public boolean checkWinner(char symbol){
        //code
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                //horizontal
                if(c+3<grid[0].length){
                    if(grid[r][c] == symbol && grid[r][c+1]==symbol
                        && grid[r][c+2]==symbol && grid[r][c+3]==symbol
                    ){
                        return true;
                    }
                }
                //vertical
                if(r+3<grid.length){
                    if(grid[r][c]==symbol && grid[r+1][c]==symbol && grid[r+2][c]==symbol && grid[r+3][c]==symbol){
                        return true;
                    }
                }
                //diagonal right down
                if(r+3<grid.length && c+3<grid[0].length){
                    if(grid[r][c]==symbol && grid[r+1][c+1]==symbol && grid[r+2][c+2]==symbol && grid[r+3][c+3]==symbol){
                        return true;
                    }
                }
                //diagonal left down
                if(r+3<grid.length && c-3>=0){
                    if(grid[r][c]==symbol &&
                        grid[r+1][c-1]==symbol &&
                        grid[r+2][c-2] == symbol &&
                        grid[r+3][c-3]==symbol
                    ){
                        return true;
                    }
                }
            }
        }
        return false;
    }


/* check the columns of row 1 to see if the board is full
 */
    public boolean isFull(){
        //code
        for(int c = 0; c<grid[0].length; c++){
                if(grid[0][c]=='_'){
                    return false;
                }
            }
            return true;
        }


}