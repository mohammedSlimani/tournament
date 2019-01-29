/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Match;
import beans.UserAcc;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rick
 */
public interface MatchService {

    /**
     * this method will pair teams against each other
     *
     * @return
     */
    boolean MatchTeams();

    /**
     * The responsible will enter the Result of each match after that match ends
     *
     * @param teamA
     * @param teamB
     * @return
     */
    boolean enterResult(HttpServletRequest request);

    /**
     * get the matches that have been played
     *
     * @return
     */
    List<Match> getMatchHistory();

    /**
     * Get the match that has been played and awaits for the responsible to fill
     * the match results
     *
     * @return
     */
    List<Match> getAppendingForResults();

    /**
     * adds future matches.
     *
     * @return
     */
    boolean scheduleMatches(List<UserAcc> avalible);

    /**
     * get future matches
     *
     * @return
     */
    List<Match> getFutureMatches();

}
