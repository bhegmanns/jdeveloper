package servletClient;

import de.hegmanns.ejb.session.AsynchronService;

import java.util.Hashtable;

import java.util.concurrent.Future;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AsynchronServiceClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            AsynchronService asynchronService =
                (AsynchronService) context.lookup("Application2-Project1-AsynchronService#de.hegmanns.ejb.session.AsynchronService");
            
            asynchronService.doLog("Hier ist der Text", 5);
            
            Future<Long> ergebnis = asynchronService.add(10, 10, 5);
            System.out.println("" + ergebnis.isDone());
            Thread.sleep(6000);
            System.out.println("" + ergebnis.isDone());
            if (ergebnis.isDone()){
                System.out.println("" + ergebnis.get());
            }else{
                System.out.println("noch nicht fertig :(");
            }
            
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
