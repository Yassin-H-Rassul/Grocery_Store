package Controller;


import View.ManagerCategoryDemo;
import View.ManagerEmploDemo;
import View.ManagerProductDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class viewController {

    public static void ViewController(ObjectOutputStream outs,ObjectInputStream ins,PrintWriter PWs, BufferedReader BRs) throws Exception {

        Scanner Input=new Scanner(System.in);
        ObjectOutputStream out =outs;
        ObjectInputStream in= ins;
        PrintWriter pw = PWs;// for client terminal
        BufferedReader br = BRs;

        int chosen;

        do {
            System.out.println("--------------------------------------------------\n     Grocery Shop System     \n--------------------------------------------------");
            System.out.println("1.Go to Employee\n2.Go to Category\n3.Go to Product\n0.To Exit");
            chosen= Input.nextInt();
            switch (chosen) {

                case 1:
                   ManagerEmploDemo.demo(out,in,pw,br);
                    break;
                case 2:
                  ManagerCategoryDemo.demo(out,in,pw,br);
                    break;
                case 3:
                    ManagerProductDemo.demo(out,in,pw,br);
                    break;
                case 0:
                    System.out.println("Good bye manager .");
                    break;
                default:
                    System.out.println("This chose is is not valid : " + chosen);
            }
        }while(chosen !=0);

    }

}
