import Controller.viewController;
import Model.packet;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

class clientn implements Serializable {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        ObjectOutputStream out=null;
        ObjectInputStream in= null;
        Socket socket = null;

           socket=new Socket("127.0.0.1",5678,true);
            out=new ObjectOutputStream(socket.getOutputStream());
            in=new ObjectInputStream(socket.getInputStream());
            System.out.println("connected");

                String a=(String) in.readLine();
                packet massege = new packet("start");
                out.writeObject(massege);
                viewController.ViewController();

        in.close();
        out.close();
        socket.close();

    }
}
