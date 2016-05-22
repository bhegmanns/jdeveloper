package de.hegmanns.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "UUser.findAll", query = "select o from UUser o") })
@Table(name = "U_USER")
public class UUser implements Serializable {
    private static final long serialVersionUID = 8019087494467285809L;
    @Column(nullable = false, length = 100)
    private String firstname;
    @Id
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String lastname;
    @Column(nullable = false)
    private Timestamp registrationdate;
    @Column(nullable = false, length = 100)
    private String role;

    public UUser() {
    }

    public UUser(String firstname, Integer id, String lastname, Timestamp registrationdate, String role) {
        this.firstname = firstname;
        this.id = id;
        this.lastname = lastname;
        this.registrationdate = registrationdate;
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Timestamp getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Timestamp registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
