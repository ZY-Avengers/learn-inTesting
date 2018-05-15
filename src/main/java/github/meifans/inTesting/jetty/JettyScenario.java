package github.meifans.inTesting.jetty;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pengfei.zhao
 */
public class JettyScenario {

    public static void main(String[] args) throws Exception {
        int w = 4; // worker
        QueuedThreadPool workers = new QueuedThreadPool(w);

        Server server = new Server(workers);

        int a = 1, s = 2; // acceptor selector
        //executors's nums must >= a+s,if not executors, worker will shared by default.
        ExecutorService executors = Executors.newFixedThreadPool(a + s);
        ServerConnector connector = new NetworkTrafficServerConnector
                                            (server, executors, null, null, a, s, new HttpConnectionFactory());
        connector.setHost("127.0.0.1");
        connector.setPort(8989);

        server.addConnector(connector);
        server.setHandler(getHandlerColl());

        server.start();
        server.join();
        System.out.println("jetty start");
    }

    private static ContextHandlerCollection getHandlerColl() {
        ContextHandler abcHandler = new ContextHandler("/abc");
        abcHandler.setHandler(new CustomHandler());

        ContextHandlerCollection handlers = new ContextHandlerCollection();
        handlers.addHandler(abcHandler);
        return handlers;
    }

    public static class CustomHandler extends AbstractHandler {

        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            out.printf("<h1>hello %s</h1>", "meifans");
            baseRequest.setHandled(true);
        }
    }
}
