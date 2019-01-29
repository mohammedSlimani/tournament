/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Tournament;
import beans.UserAcc;

/**
 *
 * @author rick
 */
public interface TournamentService {

    /**
     * getting the winner of each tournament
     *
     * @param id_trnmt
     * @return
     */
    UserAcc getWinner(int id_trnmt);

    /**
     *
     * @return
     */
    boolean startNewTournament(Tournament trnmt);

    boolean endTournament(Tournament trnmt);

}
