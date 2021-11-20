import Model.Category;
import Model.Product;
import Model.employee;
import controller.DataBase;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable{
    private Socket clientSocket;
    private ObjectInputStream ins;
    private ObjectOutputStream outs;
    private BufferedReader in;
    private PrintWriter out;
    private static ArrayList<ClientHandler> clients;
    public ClientHandler(Socket client , ArrayList<ClientHandler> clients) throws IOException {
        this.clientSocket=client;
        this.clients=clients;
        out= new PrintWriter(clientSocket.getOutputStream(), true);// for client terminal
        in= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outs =new ObjectOutputStream(clientSocket.getOutputStream() );
        ins= new ObjectInputStream(clientSocket.getInputStream());

    }
    @Override
    public void run() {
        List<Product> products;
        List<employee> employees;
        List<Category> categories;

        try {
            while (true) {
                String request=null;
                request = in.readLine();
               // product
                if(request.contains("500")){
                    products = (List<Product>) DataBase.LoadDataOfFile("product", "src\\controller\\Files\\Product.txt");
                    outs.writeObject(products);
                }
                if (request.contains("501")){
                    products= (List<Product>) ins.readObject();
                    System.out.println("file saved");
                    DataBase.SaveDataToFile("src\\controller\\Files\\Product.txt",products);
                }
                // employees
                if(request.contains("502")){
                    employees = (List<employee>) DataBase.LoadDataOfFile("employee", "src\\controller\\Files\\Employee.txt");
                    outs.writeObject(employees);
                }
                if (request.contains("503")){
                    employees= (List<employee>) ins.readObject();
                    System.out.println("file saved");
                    DataBase.SaveDataToFile("src\\controller\\Files\\Employee.txt",employees);
                }

                //
                if(request.contains("504")){
                    categories = (List<Category>) DataBase.LoadDataOfFile("cat", "src\\controller\\Files\\categories.txt");
                    outs.writeObject(categories);
                }
                if (request.contains("505")){
                    categories= (List<Category>) ins.readObject();
                    System.out.println("file saved");
                    DataBase.SaveDataToFile("src\\controller\\Files\\categories.txt",categories);
                }
                if(request.contains("0000"))break;
                else{
                    out.println("type the save command was wrong to show in the command");
                }

            }

        }catch (FileNotFoundException | ClassNotFoundException exception) {
            System.err.println("there is FileNotFoundException or ClassNotFoundException ");
            products = new ArrayList<>();
            employees = new ArrayList<>();
            categories = new ArrayList<>();
            System.out.println("the File / Class  Not found !. ");
        } catch (EOFException exception) {
            System.err.println("there is EOFException");
            products = new ArrayList<>();
            employees = new ArrayList<>();
            categories = new ArrayList<>();

        } catch (SocketException e){
            System.err.println("there is IO Exception");
            System.err.println(e.getStackTrace());
        } catch (IOException ioException) {
            System.err.println("there is IO Exception");
            ioException.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();

        }

    }
}
