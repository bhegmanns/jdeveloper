package de.hegmanns.ejb.session;

import javax.ejb.Remote;

@Remote
public interface HalloWeltSession {
    String sayHello();
}
