package Controller;

import View.ManagerCategoryDemo;
import View.ManagerEmploDemo;
import View.ManagerProductDemo;
import java.util.InputMismatchException;
import java.util.Scanner;
public class viewController {
    public static void ViewController() throws Exception, InputMismatchException {
        Scanner Input=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        boolean check=false;
        int chosen;
        do {

            while (!check) {
                System.out.println("\"--------------------------------------------------\n          Welcome User          \n---------------------------------------------------");
                System.out.println("Welcome pls enter username :");
                String user = sc.nextLine();
                System.out.println("Welcome pls enter password :");
                String pass = sc.nextLine();
                if ((user.equals("admin") && pass.equals("admin"))) {
                    check = true;
                    System.out.println("there is a problem with user name or password pls check");
                }
            }
            System.out.println("--------------------------------------------------\n     Grocery Shop System     \n--------------------------------------------------");
            System.out.println("1.Go to Employee\n2.Go to Category\n3.Go to Product\n0.To Exit");
            chosen = Input.nextInt();

                switch (chosen) {
                    case 1:
                        ManagerEmploDemo.demo();
                        break;
                    case 2:
                         ManagerCategoryDemo.cateDome();
                        break;
                    case 3:
                        ManagerProductDemo.ProductDemo();
                        break;
                    case 0:
                        System.out.println("Good bye manager .");

                        break;
                    default:
                        System.out.println("This chose is is not valid : " + chosen);
                }

            } while (chosen != 0) ;

     System.exit(0);
    }

}
