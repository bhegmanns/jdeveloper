package de.hegmanns.ejb;

import javax.ejb.Remote;

@Remote
public interface UserRegistryService {
    User addUser(String firstName, String lastName, Long id);
}
