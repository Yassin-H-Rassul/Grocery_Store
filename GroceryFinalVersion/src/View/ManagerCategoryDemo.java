package View;
import Controller.CategoryFunctionality;
import Controller.socketController;
import java.util.*;

public class ManagerCategoryDemo {

    public static void cateDome() throws Exception {
        System.out.println("welcome manager to Category managing :");
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int choose;
        while (true) {
            // Loading the data
            socketController.ConnectionController("504");
            choose = -1;
            do {
                System.out.println(" \nWelcome manager Enter your choice you : ");
                System.out.println("1.add New Category: ");
                System.out.println("2.Display Ctaegoey Information : ");
                System.out.println("3.Search for a  Category : ");
                System.out.println("4.Delete a  Category :");
                System.out.println("5.Update a  Ctaegory :");
                System.out.println("0.Exit from Category: ");
                choose = input.nextInt();
                int CateTimes;
                switch (choose) {
                    case 1:
                        System.out.println("--------------------------------------------------\nWelcome manager how many category you will add");
                        CateTimes = input.nextInt();
                        for (int i = 0; i < CateTimes; i++) {
                            System.out.print("Enter the Category Id Using Numbers :");
                            int CatEid = input.nextInt();
                            System.out.print("Enter the Category type :");
                            String CatType = sc.nextLine();
                            System.out.print("Enter the Category Descrepstion :");
                            String CatDes = sc.nextLine();
                            System.out.println("--------------------------------------------------");
                            CategoryFunctionality.AddingCategory(CatEid, CatType, CatDes);}
                        break;
                    case 2:
                        CategoryFunctionality.showCategory();
                        break;
                    case 3:
                        System.out.print("Enter the Category id to Find :");
                        int category = input.nextInt();
                        CategoryFunctionality.findCategory(category);
                        break;
                    case 4:
                        System.out.print("Enter the Category Id to Delete : ");
                        int categorys = input.nextInt();
                        CategoryFunctionality.DelCategory(categorys);

                        break;
                    case 5:
                        System.out.print("Enter the Employee id to Update : ");
                        int cat = input.nextInt();
                        if (CategoryFunctionality.validCategoryID(cat)) {
                            System.out.print("Enter the Category type :");
                            String CatType = sc.nextLine();
                            System.out.print("Enter the Category Descrepstion :");
                            String CatDes = sc.nextLine();
                            CategoryFunctionality.UpCategory(cat, CatType, CatDes);}
                        break;
                    case 0:
                        System.out.println("Have a nice Day Manager.");
                        break;
                    default:
                        System.out.println("This chose is is not valide : " + choose);
                }
            } while (choose != 0);
            if (choose == 0) break;
        }
        socketController.ConnectionController("505");
    }


}