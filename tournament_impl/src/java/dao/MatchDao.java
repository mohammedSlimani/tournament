/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Match;
import java.util.List;

/**
 *
 * @author rick
 */
public interface MatchDao {

    boolean addMatch(Match match);

    boolean deleteMatch(Match match);

    List getAllmatches();//and I filter this in my Matchservice

    boolean editMatch(Match match);
    
    Match getCloseMatch();
    
    List getMatchHistory();
    
    List getAppendingForResults();
    
     List<Match> getFutureMatches();
     
     boolean enterResult(Match match, int scoreA, int scoreB);
}
