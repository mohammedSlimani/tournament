package beans;
// Generated 24-Jan-2019 17:29:26 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tournament generated by hbm2java
 */
public class Tournament implements java.io.Serializable {

    private Integer id;
    private Date dateStart;
    private Date dateEnd;
    private Date registrationEnd;
    private Integer state;
    private Set matches = new HashSet(0);

    public Tournament() {
    }

    public Tournament(Date dateStart, Date registrationEnd) {
        this.dateStart = dateStart;
        this.registrationEnd = registrationEnd;
    }

    public Tournament(Date dateStart, Date dateEnd, Date registrationEnd, Set matches) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.registrationEnd = registrationEnd;
        this.matches = matches;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getRegistrationEnd() {
        return this.registrationEnd;
    }

    public void setRegistrationEnd(Date registrationEnd) {
        this.registrationEnd = registrationEnd;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set getMatches() {
        return this.matches;
    }

    public void setMatches(Set matches) {
        this.matches = matches;
    }

}
