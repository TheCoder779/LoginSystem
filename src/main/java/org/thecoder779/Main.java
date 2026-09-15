package org.thecoder779;

import org.thecoder779.Gui.*;

import java.io.FileNotFoundException;

public class Main {
    static void main() {
        LoginGui gui = null;
        try {
            gui = new LoginGui("Login");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
