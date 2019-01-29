package business;

import java.util.ArrayList;

//A participant in the tournament
public class Player implements Comparable<Player> {

    private String tag;		//String identifier of the player
    private int win = 0;		//number of wins
    private int loss = 0;		//number of losses
    private int seed;		//seed for proper placement in bracket
    private int place = 1;		//final placement in elim tournament, updated after player is knocked out or after tournament ends
    public ArrayList<Player> history = new ArrayList<Player>();	//list of opponents already played, used in Swiss format only

    public Player(String tag) {		//constructor for unseeded player
        this.tag = tag;
    }

    public Player(String tag, int seed) {	//constructor for seeded player
        this.tag = tag;
        this.seed = seed;
    }

    public String getTag() {		//returns player's tag
        return tag;
    }

    public int getSeed() {			//returns player's seed
        return seed;
    }

    public void setSeed(int seed) {		//sets player's seed 
        this.seed = seed;
    }

    public int getWin() {			//returns player's win count
        return win;
    }

    public void addWin() {			//increments player's win count
        win++;
    }

    public int getLoss() {			//returns player's loss count
        return loss;
    }

    public void addLoss() {			//increments player's loss count
        loss++;
    }

    public int getPlace() {			//returns player's placement in the tournament
        return place;
    }

    public void setPlace(int place) {	//sets players placement in the tournament
        this.place = place;
    }

    @Override
    public int compareTo(Player p) {	//used for sorting player by seed
        if (this.seed > p.seed) {
            return 1;
        } else if (this.seed == p.seed) {
            return 0;
        } else {
            return -1;
        }
    }

    public String toString() {		//returns player's tag
        return tag;
    }
}
