package de.hegmanns.ejb.session;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateful(name = "MathematikEJB", mappedName = "Application2-Project1-MathematikEJB")
//@Stateless(name = "MathematikEJB", mappedName = "Application2-Project1-MathematikEJB")
public class MathematikEJBBean implements MathematikEJB, MathematikEJBLocal {
    @Resource
    SessionContext sessionContext;

    public MathematikEJBBean() {
    }

    private int zaehlerstand = 0;

    public void inkrement() {
        zaehlerstand++;
    }

    public void dekrement() {
        zaehlerstand--;
    }

    public int getZaehlerstand() {
        return zaehlerstand;
    }
}
