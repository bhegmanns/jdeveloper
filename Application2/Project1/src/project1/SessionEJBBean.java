package project1;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Singleton;

@Singleton(name = "SessionEJB", mappedName = "Application2-Project1-SessionEJB")
public class SessionEJBBean implements SessionEJB, SessionEJBLocal {
    @Resource
    SessionContext sessionContext;

    public SessionEJBBean() {
    }
}
