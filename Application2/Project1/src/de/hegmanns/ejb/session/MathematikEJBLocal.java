package de.hegmanns.ejb.session;

import javax.ejb.Local;

@Local
public interface MathematikEJBLocal {
    void dekrement();

    void inkrement();
    
    int getZaehlerstand();
}
