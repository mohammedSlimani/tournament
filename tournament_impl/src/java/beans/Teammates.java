package beans;
// Generated 24-Jan-2019 17:29:26 by Hibernate Tools 4.3.1



/**
 * Teammates generated by hbm2java
 */
public class Teammates  implements java.io.Serializable {


     private Integer id;
     private UserAcc userAcc;
     private String name;

    public Teammates() {
    }

    public Teammates(UserAcc userAcc, String name) {
       this.userAcc = userAcc;
       this.name = name;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public UserAcc getUserAcc() {
        return this.userAcc;
    }
    
    public void setUserAcc(UserAcc userAcc) {
        this.userAcc = userAcc;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


