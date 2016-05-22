package de.hegmanns.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.interceptor.Interceptors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "UserRegistryService", mappedName = "UserApplikation-Project1-UserRegistryService")
@Interceptors(LoggingInterceptor.class)
public class RegistryServiceBean implements UserRegistryService, UserRegistryServiceLocal {
    @Resource
    SessionContext sessionContext;

    @PersistenceContext(name = "XX")
    private EntityManager em;
    
    @EJB
    private UserRepsoitory userRepository;

    public RegistryServiceBean() {
    }

    private Map<Long, User> id2Users = new HashMap<>();
    private Map<String, User> string2Users = new HashMap<>();
    private Map<String, List<User>> lastName2Users = new HashMap<>();

    
    public User addUser(String firstName, String lastName, Long id) {
        return userRepository.persistUser(firstName, lastName);
    }

    public User findUser(String firstName, String lastName) {
        return userRepository.findUser(firstName, lastName);
    }

    public java.util.List<User> findUserByRole(String rolename) {
        return userRepository.findUserByRole(rolename);
    }

    public java.util.List<User> findUser(String lastName) {
        return userRepository.findUserByLastName(lastName);
    }

    public User findUser(long id) {
        
        return userRepository.findUser(id);
    }

    public ServiceResult deleteUser(User user) {
        User persistedUser = findUser(user.getId());
        if (persistedUser == null){
            return ServiceResult.NOK;
        }
        userRepository.removeUser(persistedUser);
        return ServiceResult.OK;
    }
}
