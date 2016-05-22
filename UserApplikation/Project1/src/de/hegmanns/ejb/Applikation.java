package de.hegmanns.ejb;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "u_applikation")
public class Applikation implements Serializable{
    public Applikation() {
        super();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 100, unique = true, nullable = false)
    private String name;
    
    @ManyToMany(mappedBy = "berechtigungenFuer")
    private List<User> berechtigteUser;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBerechtigteUser(List<User> berechtigteUser) {
        this.berechtigteUser = berechtigteUser;
    }

    public List<User> getBerechtigteUser() {
        return berechtigteUser;
    }
}
