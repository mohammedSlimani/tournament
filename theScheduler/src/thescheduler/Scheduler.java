package thescheduler;

import java.util.*;

public class Scheduler {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Player> players = new LinkedList<Player>();

        System.out.println("How many entrants will participate?");
        int entrants = valInt(input, 1, Integer.MAX_VALUE);

        System.out.println("\nFor each player, type their name and seed separated by a space, and press enter.");
        String name;
        int seed;
        for (int i = 0; i < entrants; i++) {
            name = input.next();
            seed = valInt(input, 1, Integer.MAX_VALUE);
            players.add(new Player(name, seed));
        }

        Collections.sort(players);				//sort players by seed

        int format;
        if (entrants < 3) {     //exclude double elim (only supports more than 2 entrants)
            System.out.println("\nWhich tournament format would you like to use?\n1. Round Robin\n2. Swiss\n3. Single Elimination");
            format = valInt(input, 1, 3);
        } else {    //entrants >= 3
            System.out.println("\nWhich tournament format would you like to use?\n1. Round Robin\n2. Swiss\n3. Single Elimination\n4. Double Elimination");
            format = valInt(input, 1, 4);
        }

        //indicate which tournament format to use
        System.out.println();
        if (format == 1) {
            roundRobin(players);
        } else if (format == 2) {
            swiss(players);
        } else if (format == 3) {
            singleElim(players);
        } else //format == 4
        {
            doubleElim(players);
        }
    }

    //validate integer input within a given range (min to max inclusive)
    public static int valInt(Scanner input, int min, int max) {
        boolean check = true; //boolean for try/catch block
        int num = -1;         //initialize num with placeholder
        do {
            try {
                num = input.nextInt();
                if (num < min || num > max) //if num is out of range
                {
                    throw new NumberFormatException("Input is out of range.");
                } else //num is in range
                {
                    check = false;  //exit loop
                }
            } catch (Exception e) {
                System.out.println("Please choose a valid option.");
                System.out.print("");
                input.nextLine();
            }
        } while (check);

        return num;
    }

    //single elimination tournament
    public static void singleElim(LinkedList<Player> players) {
        LinkedList<Player> results = new LinkedList<Player>();  //player placings to be updated as matches end
        int entrants = players.size();								//number of entrants
        Scanner input = new Scanner(System.in);				//scanner to read match results

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
                players.add(new Player("bye", (int) Math.pow(2, i) + 1));	//add byes to player list
            }
        }
        entrants = players.size();					//number of entrants with byes
        LinkedList<Match> round = new LinkedList<Match>();	//round is list of matches

        while (players.size() > 1) {	//if more than one player left, 
            while (!players.isEmpty()) {//if list of players isn't empty, 
                round.addLast(new Match(players.pollFirst(), players.pollLast()));	//assign them a match
            }

            System.out.println(round);				//display the matches in the current round

            int roundSize = round.size();			//number of matches in the round
            for (int i = 0; i < roundSize; i++) {
                Match m = round.pollFirst();			//the match to be scored
                players.addLast(m.setResults(input.nextInt()));	//set results of the match, 1 = p1 win and 0 = p2 win

                //update loser's placement
                int place = (int) Math.pow(2, 32 - Integer.numberOfLeadingZeros(entrants - results.size() - 1) - 1) + 1;	//nearest lower power of 2, + 1
                m.getLoser().setPlace(place);				//sets player's placement in the tournament
                results.addFirst(m.getLoser());			//adds player to the front of results list to keep it sorted by higher placement
            }
        }
        results.addFirst(players.pollFirst());	//adds winner of tournament to front of results list

        displayElimResults(results);						//displays final results
    }

    //double elimination tournament
    public static void doubleElim(LinkedList<Player> winners) {
        LinkedList<Player> toPlace = new LinkedList<Player>();      //list to set players' placing before being moved to results list
        LinkedList<Player> results = new LinkedList<Player>();			//player placings to be updated as matches end
        LinkedList<Player> losers = new LinkedList<Player>();				//loser's bracket
        int entrants = winners.size();										//number of entrants
        Scanner input = new Scanner(System.in);						//scanner to read match results

        if ((entrants & (entrants - 1)) != 0) {		//check if # of entrants is not a power of 2
            int i = 2;											        //i = sequential powers of 2
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
                winners.add(new Player("bye", (int) Math.pow(2, i) + 1));	//add byes to player list
            }
        }

        LinkedList<Match> round = new LinkedList<Match>();  //round is list of matches
        boolean winRnd = false;           //boolean switch, if true then play winners round & losers round, if false then only losers round
        int w = 0;      //winners bracket plays first two rounds, so extra variable to bypass the first "false" of winRnd
        while (winners.size() + losers.size() > 2) {       //if there are multiple players left in either bracket,
            int winMtc = 0;     //number of winners matches
            if (winRnd || w < 1) {                         //if this round includes a winners round,
                while (!winners.isEmpty()) {                   //if there are players in the winners bracket,
                    round.addLast(new Match(winners.pollFirst(), winners.pollLast()));  //assign them a match
                    winMtc++;
                }
            }

            while (!losers.isEmpty()) {                //if there are players in the winners bracket,
                round.addLast(new Match(losers.pollFirst(), losers.pollLast()));  //assign them a match
            }
            System.out.println(round);

            for (int i = 0; i < winMtc; i++) {  //score winners bracket matches
                Match m = round.pollFirst();      //match to be scored
                winners.addLast(m.setResults(input.nextInt()));   //set results of the match, 1 = p1 win and 0 = p2 win
                losers.addLast(m.getLoser());     //add loser of match to losers bracket
            }
            while (!round.isEmpty()) {           //score losers bracket matches
                Match m = round.pollFirst();      //match to be scored
                losers.addLast(m.setResults(input.nextInt()));    //set results of the match, 1 = p1 win and 0 = p2 win
                toPlace.addLast(m.getLoser());    //add loser to list to get placing
            }
            while (!toPlace.isEmpty()) {
                Player p = toPlace.pollFirst();
                p.setPlace(winners.size() + losers.size() + 1);   //placing is sum of players in winners and losers + 1
                results.addFirst(p);    //move player to results list
            }

            winRnd = !winRnd;       //if winners bracket played this round, they don't play next, & vice-versa
            w++;
        }

        //Grand Finals
        boolean reset = false;      //boolean for bracket reset
        int r = 0;                  //int for bracket reset so no more than one reset is played
        do {                        //do play at least one round of grand finals
            round.addLast(new Match(winners.peekFirst(), losers.peekFirst()));
            System.out.println(round);
            Match m = round.pollFirst();
            int win = input.nextInt();    //1 = p1 win, 0 = p2 win
            m.setResults(win);            //set winner/loser for the match
            if (win > 0) {                //if player from losers bracket loses, grand finals is over
                m.getLoser().setPlace(2);
                results.addFirst(m.getLoser()); //add 2nd place player to results list
                m.getWinner().setPlace(1);
                results.addFirst(m.getWinner());//add 1st place player to results list
                reset = false;         //grand finals is over
            } else {            //Bracket reset!!!!
                reset = true;
                r++;    //increments counter so no more than one reset is played
                if (r > 1) {  //if two rounds have been played, end grand finals and set results
                    m.getLoser().setPlace(2);
                    results.addFirst(m.getLoser()); //add 2nd place player to results list
                    m.getWinner().setPlace(1);
                    results.addFirst(m.getWinner());//add 1st place player to results list
                }
            }
        } while (reset && r < 2); //while conditions for bracket reset are met, and reset hasn't been played yet

        displayElimResults(results);		//displays final results
    }

    //round robin tournament
    public static void roundRobin(LinkedList<Player> pl) {
        ArrayList<Player> players = new ArrayList<Player>(pl);
        int entrants = players.size();
        Scanner input = new Scanner(System.in);

        if (entrants % 2 != 0) {						//number of entrants is odd
            entrants++;									//increment number of entrants
            players.add(new Player("bye", entrants));	//add a dummy player
        }

        LinkedList<Match> round = new LinkedList<Match>();		//round is list of matches
        for (int i = 0; i < entrants - 1; i++) {				//each round; number of rounds = entrants - 1
            for (int j = 0; j < entrants / 2; j++) {			//number of matches in each round = entrants / 2
                round.addLast(new Match(players.get(j), players.get(entrants - j - 1)));	//assign players a match
            }

            System.out.println(round);							//display the matches in the current round

            for (int j = 0; j < entrants / 2; j++) {
                Match m = round.pollFirst();			  //the match to be scored
                m.setResults(input.nextInt());			//set results of the match, 1 = p1 win and 0 = p2 win
            }

            Collections.rotate(players.subList(1, players.size()), 1);	//last element inserted at index 1
        }

        displayRRResults(players);				//displays final results
    }

    //swiss style tournament
    public static void swiss(LinkedList<Player> players) {			//make opponent history private, document
        Scanner input = new Scanner(System.in);
        int entrants = players.size();

        if (entrants % 2 != 0) {			//number of entrants is odd
            entrants++;									//increment number of entrants
            players.add(new Player("bye", entrants));	//add a dummy player
        }

        int nRounds = 32 - Integer.numberOfLeadingZeros(entrants - 1);	//power of 2 of entrants, rounded up
        LinkedList<Match> round = new LinkedList<Match>();				//round is list of matches
        for (int i = 0; i < nRounds; i++) {								//each round; number of rounds = nRounds
            System.out.println("Players: " + players.toString());
            round = swissPair(players);
            System.out.println(round);

            for (int j = 0; j < entrants / 2; j++) {
                Match m = round.pollFirst();
                m.setResults(input.nextInt());
                m.getWinner().history.add(m.getLoser());
                m.getLoser().history.add(m.getWinner());
            }
        }

        displayRRResults(players);
    }

    //swiss pairing algorithm
    public static LinkedList<Match> swissPair(LinkedList<Player> players) {
        LinkedList<Player> temp = new LinkedList<Player>(players);  //copy of players LinkedList
        LinkedList<Player> unpaired = new LinkedList<Player>();     //unpaired players
        LinkedList<Match> round = new LinkedList<Match>();          //round of matches
        boolean back = false;
        String tag = null;  //used for backtracking, indicates previously unpaired player
        do {
            while (!temp.isEmpty()) {
                Player p1 = temp.pollFirst();
                Player p2 = null;
                if (p1.getTag().equals(tag)) {    //if p1 is marked player (after backtrack), 
                    p2 = temp.peekFirst();          //p2 is highest seeded remaining player in list
                } else {            //either no backtracking yet or p1 is not marked player
                    Iterator<Player> desc = temp.descendingIterator();
                    boolean exit = false;
                    while (desc.hasNext() && !exit) {
                        p2 = desc.next();
                        if (p1.getWin() == p2.getWin() && p1.history.indexOf(p2) == -1) { //if p1 and p2 have same win count but haven't played before
                            exit = true;  //exit loop, p2 is specified player
                        } else {        //p1 & p2 have different win count or have played before
                            p2 = null;    //do not pair the specified player
                        }
                    }
                }
                if (p2 != null) {   //if p2 is specified
                    p2 = temp.remove(temp.indexOf(p2));
                    round.add(new Match(p1, p2));   //pair p1 and p2
                } else {            //p2 == null
                    unpaired.add(p1); //add p1 to unpaired
                }
            }
            if (tag != null) //if already backtracked once,
            {
                back = false;     //don't backtrack again
            }
            while (!unpaired.isEmpty() && !back) {
                Player p1 = unpaired.pollFirst();
                Player p2 = null;
                Iterator<Player> it = unpaired.iterator();
                boolean exit = false;
                while (it.hasNext() && !exit) {
                    p2 = it.next();
                    if (p1.history.indexOf(p2) == -1) {   //if p1 and p2 haven't played
                        exit = true;        //exit loop, p2 is specified player
                    } else {              //p1 and p2 have played
                        p2 = null;          //do not pair specified player
                    }
                }
                if (p2 == null) {     //if p2 is unspecified
                    back = true;          //set algorithm to backtrack
                    unpaired.clear();     //reset unpaired list
                    round.clear();        //reset round
                    temp = new LinkedList<Player>(players);   //reset temp list
                    tag = p1.getTag();    //mark player that caused backtrack
                } else {              //p2 is specified
                    p2 = unpaired.remove(unpaired.indexOf(p2));
                    round.add(new Match(p1, p2)); //pair p1 and p2
                }
            }
        } while (back);

        return round;
    }

    //display results of single/double elim tournament
    public static void displayElimResults(LinkedList<Player> results) {
        for (Player player : results) {
            System.out.println(player.getPlace() + ". " + player.getTag());
        }
    }

    //display results of round robin or swiss tournament
    public static void displayRRResults(List<Player> players) {
        players = sortByWins(players);

        System.out.println();
        for (Player player : players) {
            System.out.println(player.getTag() + ": " + player.getWin() + " wins, " + player.getLoss() + " losses");
        }
    }

    //sort players based on win count
    public static List<Player> sortByWins(List<Player> players) {
        Collections.sort(players, new Comparator<Player>() {
            public int compare(Player p1, Player p2) {
                if (p1.getWin() < p2.getWin()) {
                    return 1;
                } else if (p1.getWin() > p2.getWin()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        return players;
    }
}
