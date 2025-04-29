package  com.budget.controllers;
import java.io.IOException;

import com.budget.configurationServer.ConfigurationServer;
import com.budget.handlers.HandlerGetUser;
import com.sun.net.httpserver.HttpServer;

public class Signin {
    public static void getUser() throws IOException {
        HttpServer server = new ConfigurationServer().server();
        server.createContext("/signin", new HandlerGetUser());
        server.start();
    }
}
