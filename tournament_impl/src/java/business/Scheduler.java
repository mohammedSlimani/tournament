/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rick
 */
public class Scheduler {

    /**
     * return the list of players with additional "bye" players that Are going
     * to move to the next phase automatically
     *
     * @param players
     * @return
     */
    private LinkedList<Player> players;
    private int entrants; //this is the number of reel players + number of bye players.

    public Scheduler(LinkedList<Player> players) {
        this.players = players;//Not sure if this is quite good :')
        this.entrants = players.size();
    }

    public List addByePleayers(LinkedList<Player> players) {
        //Maybe I dont need a return value, since this function is going to mutate
        //the original array. 
        Collections.sort(players);
        int entrants = players.size();	//number of entrants
        if ((entrants & (entrants - 1)) != 0) {			//check if # of entrants is not a power of 2
            int i = 2;	//i = sequential powers of 2
            while (true) {
                if (Math.pow(2, i) > entrants) //2^i is nearest superior power of 2
                {
                    break;
                } else //2^i is still less than number of entrants
                {
                    i++;
                }
            }
            int add = (int) Math.pow(2, i) - entrants;			//number of byes to add = (nearest superior power of 2) - (number of entrants)

            for (int j = 0; j < add; j++) {
                players.add(new Player("bye"));	//add byes to player list
            }
        }
        return players;
    }

    /**
     * Return the Next round of matches.
     *
     * @param players
     * @return
     */
    public List<Match> getNextRound(LinkedList<Player> players) {
        LinkedList<Match> round = new LinkedList<Match>();	//round is list of matches
        while (!players.isEmpty()) {//if list of players isn't empty, 
            round.addLast(new Match(players.pollFirst(), players.pollLast()));	//assign them a match
        }
        return round;
    }

    ;
    
    /**
     * The round I am going to get it from the database. Leave it to the Service module
     * it represents the Already played matches
     * @param round
     * @return 
     */
    public LinkedList<Player> getResults(LinkedList<Match> round) {
        LinkedList<Player> results = new LinkedList<Player>();  //player placings to be updated as matches end

        int roundSize = round.size();			//number of matches in the round
        for (int i = 0; i < roundSize; i++) {
            Match m = round.pollFirst();			//the match to be scored
            players.addLast(m.setResults());	//set results of the match

            //update loser's placement
            int place = (int) Math.pow(2, 32 - Integer.numberOfLeadingZeros(entrants - results.size() - 1) - 1) + 1;	//nearest lower power of 2, + 1
            m.getLoser().setPlace(place);				//sets player's placement in the tournament
            results.addFirst(m.getLoser());			//adds player to the front of results list to keep it sorted by higher placement
        }
        return results;
    }

    public boolean tournamentEned() {
        return players.size() > 1;
    }

}
