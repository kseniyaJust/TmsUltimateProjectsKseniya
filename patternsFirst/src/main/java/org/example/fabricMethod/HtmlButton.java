package org.example.fabricMethod;

public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button> Html button </button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Html button says - Hello from html");
    }
}
