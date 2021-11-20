
import Model.Product;
import controller.DataBase;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server  {

    private static int port = 4444;
    private static ArrayList<ClientHandler> clients=new ArrayList<>();
    private static ExecutorService pool= Executors.newFixedThreadPool(5);


    public static void main(String[] args) throws IOException, NullPointerException {
        ServerSocket serverSocket= new ServerSocket(port);
        // write your code here
        while (true) {

        System.out.println("Waiting for a client ");
        Socket clientSocket = serverSocket.accept();
        System.out.println("A client Connected ");
        ClientHandler clientHandlers=new ClientHandler(clientSocket,clients);
        clients.add(clientHandlers);
        pool.execute(clientHandlers);
        }




    }


}




