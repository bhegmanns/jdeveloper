package de.hegmanns.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Singleton
@Startup 
public class SessionEJBBean {
    private static final Logger LOG = Logger.getLogger(SessionEJBBean.class.getName());
    @Resource
    SessionContext sessionContext;
    
    @PersistenceUnit(name = "XX")
    private EntityManagerFactory emf;

    public SessionEJBBean() {
    }
    
    @PostConstruct
    public void initialisiere(){
        LOG.log(Level.SEVERE, "Initialisiere Applikation.");
        emf.createEntityManager();
        emf.close();
        LOG.info("Applikation steht nun bereit.");
    }
}
