package servletClient;

import de.hegmanns.ejb.session.HalloWeltSession;

import java.util.Hashtable;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HalloWeltSessionClient1 {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            HalloWeltSession halloWeltSession =
                (HalloWeltSession) context.lookup("Application2-Project1-HalloWeltSession#de.hegmanns.ejb.session.HalloWeltSession");
            System.out.println("" + halloWeltSession.sayHello());
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }
}
