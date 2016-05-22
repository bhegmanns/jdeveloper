package de.hegmanns.ejb;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "u_applicationlogin")
public class ApplikationLogin {
    public ApplikationLogin() {
        super();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Applikation applikation;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date zeitpunkt;


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setApplikation(Applikation applikation) {
        this.applikation = applikation;
    }

    public Applikation getApplikation() {
        return applikation;
    }

    public void setZeitpunkt(Date zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    public Date getZeitpunkt() {
        return zeitpunkt;
    }
}
