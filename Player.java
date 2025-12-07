public class Player{
    
    //instance variables for palyer name and symbol
    private String name;
    private char symbol;

//player constructor
public Player(String name, char symbol){
    this.name = name;
    this.symbol = symbol;
}


//returns player name
public String getName(){
    return name;
}

//returns player
public char getSymbol(){
    return symbol; 
}
}