/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Tournament;
import java.util.List;

/**
 *
 * @author rick
 */
public interface TournamentDao {

    boolean addTournament(Tournament trn);

    boolean deleteTournament(Tournament trn);

    boolean editTournament(Tournament trn);

    List<Tournament> getOngoingTournament();

    List<Tournament> getEndedTournament();
}
