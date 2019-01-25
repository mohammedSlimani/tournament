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

import java.util.ArrayList;

//A participant in the tournament
public class Player  {
	private String tag;		//String identifier of the team
	private int win = 0;		//number of wins
	private int loss = 0;		//number of losses
	private int place = 1;		//final placement in elim tournament, updated after team is knocked out or after tournament ends
	public ArrayList<Player> history = new ArrayList<Player>();	//list of opponents already played, used in Swiss format only
	
	public Player(String tag) {		//constructor for unseeded player
		this.tag = tag;
	}
	
	public String getTag() {		//returns player's tag
		return tag;
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
	
	
	public String toString() {		//returns player's tag
		return tag;
	}
}
