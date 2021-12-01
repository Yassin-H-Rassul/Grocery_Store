import Controller.viewController;

import Controller.socketController;

public class Main {

    public static void main(String[] args) throws Exception {
        socketController.startConnection();
        viewController.ViewController();
    }
}
