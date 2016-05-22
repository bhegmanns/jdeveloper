package de.hegmanns.ejb.session;

import javax.ejb.Remote;

@Remote
public interface MathematikEJB {
    void dekrement();

    void inkrement();
    
    int getZaehlerstand();
}
