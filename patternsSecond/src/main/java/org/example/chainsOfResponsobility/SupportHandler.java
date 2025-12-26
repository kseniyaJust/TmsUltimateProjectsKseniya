package org.example.chainsOfResponsobility;

import com.sun.net.httpserver.Request;

public interface SupportHandler {
    void handleRequest(int severity);
    void setNextHandler(SupportHandler supportHandler);
}
