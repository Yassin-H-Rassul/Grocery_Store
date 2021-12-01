package Controller;

import Model.Category;
import Model.Product;
import Model.employee;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class socketController {
    public static ArrayList<employee> employees = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static Socket socket;
    private static PrintWriter pw;
    private static BufferedReader br;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private static int Port = 4444;
    public static void startConnection() {

        try {
            socket = new Socket("127.0.0.1", 4444);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream(), true);// for client terminal
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (UnknownHostException e) {
            System.out.println("host is not known.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ConnectionController(String ms) throws IOException, ClassNotFoundException ,NullPointerException{
        // product staff
        if (ms.contains("500")) {
            // get data
            pw.println(ms);
            pw.flush();
            products = (List<Product>) in.readObject();
            ProductFunctionality.setProducts(products);
        }
        if (ms.contains("501")) {
            pw.println(ms);
            pw.flush();
            products= ProductFunctionality.getProducts();
            out.writeObject(products);
            System.out.println("data Uploaded");
        }
        // employee sockets
        if (ms.contains("502")) {
            // get data
            pw.println(ms);
            pw.flush();
            employees = (ArrayList<employee>) in.readObject();
            EmployeeFunctionality.setEmployees(employees);
        }
        if (ms.contains("503")) {
            // send data
            pw.println(ms);
            pw.flush();
            employees= EmployeeFunctionality.getEmployees();
            out.writeObject(employees);
            System.out.println("data Uploaded");
        }
        //category
        if (ms.contains("504")) {
            // get data
            pw.println(ms);
            pw.flush();
            categories = (ArrayList<Category>) in.readObject();
            CategoryFunctionality.setCategories(categories);
        } if (ms.contains("505")) {
            // send data
            pw.println(ms);
            pw.flush();
            categories= CategoryFunctionality.getCategories();
            out.writeObject(categories);
            System.out.println("data Uploaded");
        }

    }

    public static void endConnection() throws IOException {
        pw.close();
        br.close();
        out.close();
        in.close();
        socket.close();
    }

}
