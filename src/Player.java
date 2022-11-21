package src;
public class Player {
    private int score = 0;
    private String name;

    //DO NOT CHANGE
    public Player(String name){

        this.name = name;
        System.out.println("\033[0m-----------------------------");
    }

    public int getScore(){
        return score;
    }


    public String getName(){
        return name;
    }
    
    public void setName(String n){
        this.name = n;
    }

    public void adjustScore(int x){
        score +=x;
    }
}
