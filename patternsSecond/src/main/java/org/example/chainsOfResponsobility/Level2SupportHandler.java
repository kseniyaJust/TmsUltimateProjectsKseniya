package org.example.chainsOfResponsobility;

public class Level2SupportHandler implements SupportHandler{
    private SupportHandler nextHandler;
    @Override
    public void handleRequest(int severity) {
        if(severity ==2){
            System.out.println("Level 2 Support handled the request");
        }
        else if (nextHandler !=null){
            nextHandler.handleRequest(severity);
        }

    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
