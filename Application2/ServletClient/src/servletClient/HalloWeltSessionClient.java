package servletClient;

import de.hegmanns.ejb.session.HalloWeltSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "HalloWeltSessionClient", urlPatterns = { "HalloWeltSessionClient" })
public class HalloWeltSessionClient extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    @EJB
    private HalloWeltSession halloWeltSession;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>HalloWeltSessionClient</title></head>");
        out.println("<body>");
        try {
            // TODO: Invoke Session Bean's business methods here. E.g.
            //out.println(sessionEJB.helloWorld());
            out.println(halloWeltSession.sayHello());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        out.println("</body></html>");
        out.close();
    }
}
