package org.example.fabricMethod;

public class WinDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }
}
