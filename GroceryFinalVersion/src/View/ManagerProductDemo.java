package View;

import Controller.socketController;
import Controller.ProductFunctionality;
import java.util.*;

public class ManagerProductDemo {
    public static void ProductDemo() throws Exception {
        System.out.println("welcome manager to Product managing :");
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        socketController.ConnectionController("500");
        while (true) {

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
                            ProductFunctionality.AddingProduct(proid, product, quantity, price);
                        }
                        System.out.println("--------------------------------------------------");
                        break;

                    case 2:
                        ProductFunctionality.showProduct();
                        break;
                    case 3:
                        System.out.print("Enter the Product id to Find :");
                        int prod = input.nextInt();
                        ProductFunctionality.findProduct(prod);
                        break;
                    case 4:
                        System.out.print("Enter the Product Id to Delete : ");
                        int proID = input.nextInt();
                        ProductFunctionality.DelProduct(proID);
                        break;
                    case 5:
                        System.out.print("Enter the Product id to Update : ");
                        int Proid = input.nextInt();
                        if (ProductFunctionality.validProductID(Proid)) {
                            System.out.print("Enter the Product  :");
                            String product = sc.nextLine();
                            System.out.print("Enter the Product Quantity :");
                            int quantity = input.nextInt();
                            System.out.print("Enter the Product Price of each :");
                            double price = input.nextDouble();
                            System.out.println("--------------------------------------------------");
                            ProductFunctionality.UpProduct(Proid, product, quantity, price);
                        }

                        break;
                    case 6:
                        ProductFunctionality.SortProductById();
                        break;

                    case 7:
                        ProductFunctionality.SortProductByName();

                        break;
                    case 0:
                        System.out.println("Have a nice Day Manager.");
                        break;
                    default:
                        System.out.println("This chose is is not valide : " + choose);
                        break;
                }
            } while (choose != 0);
            if (choose == 0) break;
            socketController.ConnectionController("501");
        }
    }

}
