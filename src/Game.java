package src;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private int pieces;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);

    //Sets up the game with a random amount of pieces between 10 and 50
    //Sets up the players so they can be accessed
    public Game(Player p1, Player p2){
        pieces = (int)(Math.random()*41)+10;
        this.p1 = p1;
        this.p2 = p2;
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece(){
        int take = 999;
        while (!isLegal(take)){
            System.out.println("<!!> There are \033[1m"+pieces+"\033[0m pieces remaining! <!!>\n");
            System.out.println("--------------");

            //Grab the user amount of pieces and repeat if it not allowed.
            System.out.println("\033[45m<??> \033[1m"+currentPlayer.getName()+"\033[0m\033[45m, tell me how many pieces you want to take. <??>\033[0m");
            System.out.println(">           <");
            System.out.print("\033[F\r>    \033[1m");

            try {
                take = sc.nextInt();
                if (!isLegal(take)){
                    System.out.println("\033[0m--------------");
                    System.out.println("\n\033[41m<!!> Please enter a valid number at or below "+(String.valueOf((int)((double) pieces/2)))+"! <!!>\033[0m");
                    System.out.println("-----------------------------");
                }
            }
            catch (InputMismatchException e){
                sc.next();
                System.out.println("\033[0m--------------");
                System.out.println("\n\033[41m<!!> You bozo, enter an actual number! <!!>\033[0m");
                System.out.println("-----------------------------");
            }
        }

        // Adjust pieces
        pieces -= take;
        System.out.println("-----------------------------");
        return take;
    }
    
    public Player getNextPlayer(){
    //Changes which players turn it is and returns the current player.
        currentPlayer = currentPlayer == p1 ? p2 : p1;
        return currentPlayer;
    }

    //Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x){
        int half = pieces == 1 ? 1 : (int) ((double) pieces/2);
        return x <= half;
    }


    //DO (NOT) CHANGE
    public boolean isComplete(){
        return pieces == 0;
    }

    //DO NOT CHANGE
    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }
}
