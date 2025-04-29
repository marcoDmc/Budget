package com.budget.configurationServer;
import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class ConfigurationServer{
    public static HttpServer server() throws IOException{
        HttpServer server =  HttpServer.create(new InetSocketAddress(5000), 0);
        return server;
    }
}