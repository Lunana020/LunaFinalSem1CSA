public class Board{
    private char[][] grid;
//1
    public Board(){
        grid = new char[6][7];
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                grid[r][c] = ' ';
            }
        }
    }


//2
    public void printBoard(){
       for(int r = 0; r<6; r++){
        for(int c = 0; c<7; c++){
            System.out.print(grid[r][c] + " ");
        }
        System.out.println();
       }
    }

//3
    public boolean dropPiece(int col, char symbol ){

        if(col<0 || col>=grid[0].length){
            System.out.println("This column does not exist.");
            return false;
        }

        for(int r = grid.length-1; r>=0; r--){
            if(grid[r][col]==' '){
                grid[r][col] = symbol; 
                return true;
            }
        }
        System.out.println("This column is full. Please try other column");
        return false;
    }


//4

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

//5
    public boolean isColFul(int col){
        //code
        for(int r = 0; r<grid.length; r++){
            if(grid[r][col] == ' '){
                return false;
            }
        }
        return true;
    }


//6
    public boolean isFull(){
        //code
        for(int c = 0; c<grid[0].length; c++){
                if(grid[0][c]==' '){
                    return false;
                }
            }
            return true;
        }


}