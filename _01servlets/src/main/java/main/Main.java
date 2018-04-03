package main;

import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.EntranceServlet;
import servlets.InfoServlet;

public class Main {

    public static void main(String[] args) throws Exception {
        EntranceServlet entranceServlet = new EntranceServlet();
        InfoServlet infoServlet = new InfoServlet ();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(entranceServlet), "/");
        context.addServlet(new ServletHolder(infoServlet), "/info");

        Server server = new Server (8080);
        server.setHandler(context);

        server.start();
        Logger.getGlobal().info("SERVER STARTED");
        server.join();
    }

}
