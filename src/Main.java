import Controller.viewController;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception {
        //View Controller to change between the different screen
        Socket socket =new Socket("127.0.0.1",4444);
        ObjectOutputStream out =new ObjectOutputStream(socket.getOutputStream() );
        ObjectInputStream in= new ObjectInputStream(socket.getInputStream());
        PrintWriter PW = new PrintWriter(socket.getOutputStream(), true);// for client terminal
        BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        viewController.ViewController(out,in,PW,BR);

    }
}
