package de.hegmanns.ejb.session;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "HalloWeltSession", mappedName = "Application2-Project1-HalloWeltSession")
@Local
public class HalloWeltSessionBean implements HalloWeltSession {
    @Resource
    SessionContext sessionContext;

    public HalloWeltSessionBean() {
    }

    public String sayHello() {
        return "hello world";
    }
}
