package Controller;

////import View.ManagerEmploDemo;
//import View.ManagerEmploDemo;
//import View.ManagerProductDemo;
////import View.MnagerCategoryDemo;

import java.util.Scanner;

public class viewController {
    public static void ViewController() throws Exception {
        Scanner sc=new Scanner(System.in);
        Scanner Input=new Scanner(System.in);


        int chosen;

        do {
            System.out.println("--------------------------------------------------\n     Grocery Shop System     \n--------------------------------------------------");
            System.out.println("1.Go to Employee\n2.Go to Category\n3.Go to Product\n0.To Exit");
            chosen= Input.nextInt();
            switch (chosen) {

                case 1:
                  //  ManagerEmploDemo.main();
                    break;
                case 2:
                //    MnagerCategoryDemo.ManageCatDemo();
                    break;
                case 3:
                //    ManagerProductDemo.product();
                    break;
                case 0:
                    System.out.println("Good bye manager .");
                default:
                    System.out.println("This chose is is not valid : " + chosen);
            }
        }while(chosen !=0);

    }

}
