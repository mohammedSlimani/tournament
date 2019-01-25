/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author rick
 */

//A Match played between two players
public class Match {
	private Player p1;	// = new Player("bye", Integer.MAX_VALUE);  for debugging
	private Player p2;	// = new Player("bye", Integer.MAX_VALUE);  for debugging
        private int p1Goals;
        private int p2Goals;  
        private Player winner;
        private Player loser;
	
	public Match(Player p1, Player p2) {	//a match is started with two players, p1 and p2
		this.p1 = p1;
		this.p2 = p2;
	}
        
        public Match(beans.Match m){
            this.p1 = new Player(m.getTeamA());
            this.p2 = new Player(m.getTeamB());
            this.p1Goals = m.getScoreA();
            this.p2Goals = m.getScoreB();
            
        }
	
	public Player setResults() {		//returns winner of the match
		if (p1.getTag().equals("bye"))		//if p1 is a bye,
			return p2;					//p2 is automatically the winner
		else if (p2.getTag().equals("bye"))	//if p2 is a bye,
			return p1;					//p1 is automatically the winner
		
		if (p1Goals >= p2Goals) {//Come one someone has to win. p1 wins I know it can be draw but
			p1.addWin();
			p2.addLoss();
                        winner =  p1;
                        loser = p2;
		} else {		//p2 wins
			p2.addWin();
			p1.addLoss();
                        loser = p1; 
                        winner  =p2;
		}
		return winner;		//return winner of the match
	}
	
	public Player getWinner() {	//returns winner of the match
		return winner;
	}
	
	public Player getLoser() {	//returns loser of the match
		return loser;
	}
	
	public String toString() {
		return p1 + "(" + p1.getSeed() + ")" + " vs. " + p2 + "(" + p2.getSeed() + ")";	//ex. Fox McCloud(1) vs. Kirby(26)
	}
}
