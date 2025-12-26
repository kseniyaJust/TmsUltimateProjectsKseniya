package org.example.chainsOfResponsobility;

import com.sun.net.httpserver.Request;

public class Level1SupportHandler implements SupportHandler{
    private SupportHandler nextHandler;
    @Override
    public void handleRequest(int severity) {
        if (severity == 1) {
            System.out.println("Level 1 Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(severity);
        }
        else{
            System.out.println("Handler 2");

        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {

        this.nextHandler = nextHandler;
    }
}
