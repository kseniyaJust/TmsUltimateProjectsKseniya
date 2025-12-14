package org.example.fabricMethod;

public abstract class Dialog {
    public void render() {
        Button okButton = createButton();
        okButton.render();
    }

    abstract Button createButton();
}
