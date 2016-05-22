package de.hegmanns.ejb;

import javax.ejb.Local;

@Local
public interface UserRegistryServiceLocal {
    User addUser(String firstName, String lastName, Long id);
}
