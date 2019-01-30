package beans;
// Generated 24-Jan-2019 17:29:26 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Match generated by hbm2java
 */
public class Match implements java.io.Serializable {

    private Integer id;
    private Tournament tournament;
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;
    private Date date;

    public Match() {
    }

    public Match(Tournament tournament, String teamA, String teamB, Date date) {
        this.tournament = tournament;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return this.tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getTeamA() {
        return this.teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return this.teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getScoreA() {
        return this.scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return this.scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
