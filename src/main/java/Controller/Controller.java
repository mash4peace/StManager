package Controller;

import GUI.StoreGUI;

/**
 * Created by mash4 on 5/2/2017.
 */
public class Controller {
    static StoreGUI gui;

    public static void main(String[] args) {
        Controller cntl = new Controller();
        cntl.startApp();
    }

    private void startApp() {
        gui = new StoreGUI(this);

    }
}
