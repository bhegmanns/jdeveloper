package de.hegmanns.ejb;

import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Singleton(name = "UserRepsoitory", mappedName = "UserApplikation-Project1-UserRepsoitory")
public class UserRepsoitoryBean implements UserRepsoitory, UserRepsoitoryLocal {
    @Resource
    SessionContext sessionContext;

    @PersistenceContext(unitName = "XX")
    private EntityManager em;

    public UserRepsoitoryBean() {
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public User persistUser(User user) {
        em.persist(user);
        return user;
    }

    public User persistUser(String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRegistrationDate(new Date());
        user.setRole("user");
        try {
            em.persist(user);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public User mergeUser(User user) {
        return em.merge(user);
    }

    public User findUser(long id) {
        return em.find(User.class, id);
    }

    public User findUser(String firstName, String lastName) {
        Query query = em.createNamedQuery("user.firstNameAndLastName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        List<User> users = query.getResultList();
        if (users.size() == 0) {
            return null;
        } else
            return users.get(0);
    }

    public List<User> findUserByRole(String role) {
        Query query = em.createNamedQuery("user.role");
        query.setParameter("role", role);
        return query.getResultList();
    }

    public List<User> findUserByLastName(String lastName) {
        Query query = em.createNamedQuery("user.lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    public void removeUser(User user) {
        user = em.find(User.class, user.getId());
        em.remove(user);
    }


}
