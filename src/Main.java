package src;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        // clear terminal and move to top
        System.out.println("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);

        // Asks the user to input their name for the player
        System.out.print("<??> What is \033[1mPlayer 1's\033[0m name? <??>\n> \033[1m");
            
        // Player 1
        Player playerOne = new Player(sc.nextLine());

        //Asks the user to input their name for the player.
        System.out.print("\033[0m<??> What is \033[1mPlayer 2's\033[0m name? <??>\n> \033[1m");
       
        // Player 2
        Player playerTwo = new Player(sc.nextLine());

        if ((playerOne.getName()).equals(playerTwo.getName())){
            playerOne.setName(playerOne.getName()+"-1");
            playerTwo.setName(playerTwo.getName()+"-2");
            System.out.println("\033[43m<!!> \033[1mPlayer 1\033[0m\033[43m and \033[1mPlayer 2\033[0m\033[43m had the same name, so you were both renamed. <!!>\033[0m");
            System.out.println("-----------------------------");
        }

        // Vars
        String again = "Literally any string";
        Player currentPlayer;
        
        // Runs the game
        while (!again.equals("q")){
            //Generates the game
            Game game = new Game(playerOne, playerTwo);
            
            // Set Player + Divine Intervention
            switch(playerOne.getName()){
                case "Mr. J 1":
                    currentPlayer = playerOne;
                
                case "Mr. J 2":
                    currentPlayer = playerTwo;
                default:
                    int rand = (int)(Math.random()*100);
                    currentPlayer = rand <= 49 ? playerOne : playerTwo;
            }

            game.setFirstPlayer(currentPlayer);

            //This is the loop in which the game will be played
            while(!game.isComplete()){
                currentPlayer.adjustScore(game.takePiece());
                currentPlayer = game.getNextPlayer();
            }
            System.out.println("\033[42m<!!> \033[1m"+currentPlayer.getName()+ "\033[0m\033[42m Won!! <!!>\033[0m");
            System.out.println("<!!> "+playerOne.getName() +" had removed "+ playerOne.getScore()+" pieces! <!!>");
            System.out.println("<!!> "+playerTwo.getName() +" had removed "+ playerTwo.getScore()+" pieces! <!!>");
            System.out.println("------------------------------------------");
            System.out.println("<??> TO EXIT: Enter \"q\" | TO REPLAY: Enter anything! <??>");
            again = sc.nextLine();
            System.out.println("------------------------------------------");
        }
        System.out.println("<!!> Thank you for playing! <!!>");
        sc.close();
    }
}
