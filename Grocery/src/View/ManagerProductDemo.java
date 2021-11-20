package View;

import Model.Product;

import javax.management.MBeanServerConnection;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.*;

public class ManagerProductDemo {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 4444);
        System.out.println("connected to the server");
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        PrintWriter PW = new PrintWriter(socket.getOutputStream(), true);// for client terminal
        BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              ListIterator li;
        List<Product> products = null;
        try {
            while (true) {
                String ms = null;
                System.out.println("write 500 to Load the previous data \nTo exit Write 0000");
                ms = sc.nextLine();
                if (ms.contains("500")){
                PW.println(ms);}
                if (ms.contains("0000")) break;
                else{
                    try {
                        if (ms.contains("500"))
                        products = (List<Product>) in.readObject();
                    } catch (FileNotFoundException | ClassNotFoundException exception) {
                        products = new ArrayList<>();
                    } catch (EOFException exception) {
                        products = new ArrayList<>();

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    int choose = -1;
                    do {
                        System.out.println(" \nWelcome manager Enter your choice you : ");
                        System.out.println("1.add New Product: ");
                        System.out.println("2.Display Product Information : ");
                        System.out.println("3.Search for a  Product : ");
                        System.out.println("4.Delete a  Product :");
                        System.out.println("5.Update a  Product :");
                        System.out.println("6.Sorting Product Using  id :");
                        System.out.println("7.Sorting Product Using  name :");
                        System.out.println("0.Exit from Product: ");
                        choose = input.nextInt();
                        int protype;
                        switch (choose) {
                            case 1:
                                System.out.println("--------------------------------------------------\nWelcome manager how many Products you will add");
                                protype = input.nextInt();
                                for (int i = 0; i < protype; i++) {
                                    System.out.print("Enter the Product Id Using Numbers :");
                                    int proid = input.nextInt();
                                    System.out.print("Enter the Product  :");
                                    String product = sc.nextLine();
                                    System.out.print("Enter the Product Quantity :");
                                    int quantity = input.nextInt();
                                    System.out.print("Enter the Product Price of each :");
                                    double price = input.nextDouble();
                                    System.out.println("--------------------------------------------------");
                                    try {
                                        products.add(new Product(proid, product, quantity, price));
                                    } catch (InputMismatchException e) {
                                        System.out.println("There a problem with Input of data  ");
                                    } catch (NullPointerException exception) {
                                        products = new ArrayList<>();
                                        products.add(new Product(proid, product, quantity, price));
                                    }

                                }

                                System.out.println("--------------------------------------------------");
                                break;

                            case 2:
                                if (!products.isEmpty()) {
                                    li = products.listIterator();
                                    while (li.hasNext()) {
                                        System.out.println(li.next());
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------" + "\nFile Doesn't Exist....!" + "\n--------------------------------------------------");
                                }
                                break;
                            case 3:
                                if (!products.isEmpty()) {

                                    boolean found = false;
                                    System.out.print("Enter the Employee id to Find :");
                                    int pro = input.nextInt();
                                    li = products.listIterator();

                                    while (li.hasNext()) {
                                        Product e = (Product) li.next();
                                        if (e.getProductID() == pro) {
                                            found = true;
                                            System.out.println(e);
                                        }
                                    }
                                    if ((!found)) {
                                        System.out.println("--------------------------------------------------" + "\nRecord not Found....!" + "\n--------------------------------------------------");
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------" + "\nFile Doesn't Exist....!" + "\n--------------------------------------------------");
                                }
                                break;
                            case 4:
                                if (!products.isEmpty()) {
                                    boolean found = false;
                                    System.out.print("Enter the Employee id to Find :");
                                    int pro = input.nextInt();
                                    li = products.listIterator();
                                    while (li.hasNext()) {
                                        Product e = (Product) li.next();
                                        if (e.getProductID() == pro) {
                                            found = true;
                                            li.remove();
                                            System.out.println(e);
                                        }
                                    }
                                    if ((found)) {

                                        System.out.println("The Record Delete Successfully" + "\n--------------------------------------------------");
                                    } else {
                                        System.out.println("Record not Found....!" + "\n--------------------------------------------------");
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "--------------------------------------------------");

                                }
                                break;
                            case 5:
                                if (!products.isEmpty()) {
                                    boolean found = false;
                                    System.out.print("Enter the Employee id to Update : ");
                                    int proid = input.nextInt();
                                    li = products.listIterator();
                                    while (li.hasNext()) {
                                        Product e = (Product) li.next();
                                        if (e.getProductID() == proid) {
                                            found = true;
                                            System.out.print("Enter the Product  :");
                                            String product = sc.nextLine();
                                            System.out.print("Enter the Product Quantity :");
                                            int quantity = input.nextInt();
                                            System.out.print("Enter the Product Price of each :");
                                            double price = input.nextDouble();
                                            System.out.println("--------------------------------------------------");
                                            try {
                                                li.set(new Product(proid, product, quantity, price));
                                            } catch (InputMismatchException exception) {
                                                System.out.println("There a problem with Input of data  ");
                                            }
                                            System.out.println(li.next());
                                        }
                                    }
                                    if ((found)) {
                                        System.out.println("--------------------------------------------------");
                                        System.out.println("The Record Update Successfully\n--------------------------------------------------");
                                    } else {
                                        System.out.println("--------------------------------------------------\nRecord not Found....!\n--------------------------------------------------");
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "--------------------------------------------------");
                                }

                                break;
                            case 6:
                                if (!products.isEmpty()) {

                                    Collections.sort(products, new Comparator<Product>() {
                                        @Override
                                        public int compare(Product o1, Product o2) {
                                            return o1.getProductID() - o2.getProductID();
                                        }
                                    });
                                    //   DataBase.SaveDataToFile(path,products);
                                    li = products.listIterator();

                                    while (li.hasNext()) {
                                        System.out.println(li.next());
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "\n--------------------------------------------------");
                                }

                                break;

                            case 7:
                                if (!products.isEmpty()) {

                                    Collections.sort(products, new Comparator<Product>() {
                                        @Override
                                        public int compare(Product o1, Product o2) {
                                            return o1.getAddProduct().compareTo(o2.getAddProduct());
                                        }
                                    });
                                    li = products.listIterator();
                                    while (li.hasNext()) {
                                        System.out.println(li.next());
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "\n--------------------------------------------------");
                                }

                                break;
                            case 0:
                                System.out.println("Have a nice Day Manager.");
                                break;
                            default:
                                System.out.println("This chose is is not valide : " + choose);
                                break;
                        }


                    } while (choose != 0);


                }
                System.out.println("Do you want to save the data wite 501");
                ms=null;
                ms = sc.nextLine();
                PW.println(ms);
                if (ms.contains("501")){
                    out.writeObject(products);
                    System.out.println("data Uploaded");
                }

            }

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }catch (ConnectException exception) {
            System.err.println("there is no server to connect");
            exception.printStackTrace();
        }
        finally {
            PW.close();
            BR.close();
            in.close();
            out.close();

        }

    }
}
