package de.hegmanns.ejb;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "u_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"firstName", "lastName"})})
@NamedQueries({
    @NamedQuery(name="user.firstNameAndLastName", query = "select u from User u where u.firstName = :firstName and u.lastName = :lastName"),
    @NamedQuery(name="user.role", query = "select u from User u where u.role = :role"),
    @NamedQuery(name="user.lastName", query = "select u from User u where u.lastName = :lastName")
}
)
public class User implements Serializable{
    public User() {
        super();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 100)
    private String firstName;
    
    @Column(length = 100)
    private String lastName;
    
    @Temporal(TemporalType.DATE)
    private java.util.Date registrationDate;
    
    @Column(length = 100)
    private String role;
    
    @ManyToMany
    private List<Applikation> berechtigungenFuer;
   

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public void setBerechtigungenFuer(List<Applikation> berechtigungenFuer) {
        this.berechtigungenFuer = berechtigungenFuer;
    }

    public List<Applikation> getBerechtigungenFuer() {
        return berechtigungenFuer;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof User)) {
            return false;
        }
        final User other = (User) object;
        if (!(firstName == null ? other.firstName == null : firstName.equals(other.firstName))) {
            return false;
        }
        if (!(lastName == null ? other.lastName == null : lastName.equals(other.lastName))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = PRIME * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }
}
