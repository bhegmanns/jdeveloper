package servletClient;

import de.hegmanns.ejb.session.MathematikEJB;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Hashtable;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MathematikEJBClient {
    public static void main(String[] args) throws IOException{
        try {
            BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
            final Context context = getInitialContext();
            MathematikEJB mathematikEJB =
                (MathematikEJB) context.lookup("Application2-Project1-MathematikEJB#de.hegmanns.ejb.session.MathematikEJB");
            int zaehlerstand = mathematikEJB.getZaehlerstand();
            System.out.print("Input ...");bin.readLine();
            for (int i = 0 ; i < 100 ; i++){
            mathematikEJB.inkrement();
            }
            System.out.println("Zaehlerstand = " + mathematikEJB.getZaehlerstand());
            System.out.print("Input ...");bin.readLine();
            for (int i = 0 ; i < 100 ; i++){
            mathematikEJB.inkrement();
            }
            System.out.println("Zaehlerstand = " + mathematikEJB.getZaehlerstand());
            if (mathematikEJB.getZaehlerstand() - zaehlerstand != 200){
                System.out.println("Uups");
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
