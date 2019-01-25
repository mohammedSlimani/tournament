package thescheduler;

//A Match played between two players
public class Match {
	private Player p1;	// = new Player("bye", Integer.MAX_VALUE);  for debugging
	private Player p2;	// = new Player("bye", Integer.MAX_VALUE);  for debugging
	private Player winner;	//winner of match
	private Player loser;	//loser of match
	
	public Match(Player p1, Player p2) {	//a match is started with two players, p1 and p2
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Player setResults(int p) {		//returns winner of the match
		if (p1.getTag().equals("bye"))		//if p1 is a bye,
			p = 0;					//p2 is automatically the winner
		else if (p2.getTag().equals("bye"))	//if p2 is a bye,
			p = 1;					//p1 is automatically the winner
		
		if (p > 0) {		//p1 wins
			winner = p1;
			p1.addWin();
			loser = p2;
			p2.addLoss();
		} else {		//p2 wins
			winner = p2;
			p2.addWin();
			loser = p1;
			p1.addLoss();
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
