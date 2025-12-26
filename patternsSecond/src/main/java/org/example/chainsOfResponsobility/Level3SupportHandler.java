package org.example.chainsOfResponsobility;

public class Level3SupportHandler implements SupportHandler{
    private SupportHandler nextHandler;
    @Override
    public void handleRequest(int severity) {
        if(severity == 3){
            System.out.println("Level 3 Support handled the request");
        }
        else{
            System.out.println("Request cannot be handled.");
        }
    }

    @Override
    public void setNextHandler(SupportHandler supportHandler) {
        //No handlers left
    }
}
