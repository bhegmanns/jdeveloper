package de.hegmanns.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserRepsoitoryLocal {
    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    User persistUser(User user);

    User mergeUser(User user);

    void removeUser(User user);

    User persistUser(String firstName, String lastName);

    User findUser(String firstName, String lastName);

    List<User> findUserByRole(String role);

    List<User> findUserByLastName(String lastName);

    User findUser(long id);
}
