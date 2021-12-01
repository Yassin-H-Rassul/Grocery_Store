package View;

import Controller.EmployeeFunctionality;

import Controller.socketController;

import java.util.*;


public class ManagerEmploDemo {
    public static void demo() throws Exception {
        System.out.println("welcome manager to Employee managing :");
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        socketController.ConnectionController("502");
        while (true) {

            int choose = -1;
            do {

                System.out.println(" \nWelcome manager Enter your choice you : ");
                System.out.println("1.add New Employee: ");
                System.out.println("2.Display Employee Information : ");
                System.out.println("3.Search for a  Employee : ");
                System.out.println("4.Delete a  Employee :");
                System.out.println("5.Update a  Employee :");
                System.out.println("6.Sorting Employee Using  id :");
                System.out.println("7.Sorting Employee Using  name :");
                System.out.println("8.Filter Employee  by age :");
                System.out.println("0.Exit from Employee managing: ");
                choose = input.nextInt();
                int CateTimes;

                switch (choose) {
                    case 1:
                        System.out.println("\nWelcome manager how many category you will add");
                        CateTimes = input.nextInt();
                        for (int i = 0; i < CateTimes; i++) {
                            System.out.print("Enter the Employee Id Using Numbers :");
                            int EmpEid = input.nextInt();
                            System.out.print("Enter the Employee Password :");
                            String EmpPass = sc.nextLine();
                            System.out.print("Enter the Employee name :");
                            String EmpName = sc.nextLine();
                            System.out.print("Enter the Employee Gender :");
                            String EmpGen = sc.nextLine();
                            System.out.print("Enter the Employee Age ,pl Enter Number :");
                            int EmpAg = input.nextInt();
                            while (EmpAg < 18) {
                                System.out.print("Enter the Employee Age ,pl there is no employee below 18 :");
                                EmpAg = input.nextInt();
                            }
                            System.out.print("Enter the Employee Phone Number :");
                            String EmpPhon = sc.nextLine();
                            System.out.println("--------------------------------------------------");
                            EmployeeFunctionality.AddingEmployee(EmpEid, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass);

                        }

                        System.out.println("--------------------------------------------------");

                        break;
                    case 2:
                        EmployeeFunctionality.showEmployee();
                        break;

                    case 3:
                        System.out.print("Enter the Employee id to Find :");
                        int emplo = input.nextInt();
                        EmployeeFunctionality.findEmployee(emplo);
                        break;


                    case 4:
                        System.out.print("Enter the Employee Id to Delete : ");
                        int empl = input.nextInt();
                        EmployeeFunctionality.DelEmployeee(empl);
                        break;

                    case 5:
                        System.out.print("Enter the Employee id to Update : ");
                        int emp = input.nextInt();
                        if (EmployeeFunctionality.validEmployeeID(emp)) {
                            System.out.print("Enter the Employee Password :");
                            String EmpPass = sc.nextLine();
                            System.out.print("Enter the Employee name :");
                            String EmpName = sc.nextLine();
                            System.out.print("Enter the Employee Gender :");
                            String EmpGen = sc.nextLine();
                            System.out.print("Enter the Employee Age ,pl Enter Number :");
                            int EmpAg = input.nextInt();
                            System.out.print("Enter the Employee Phone Number :");
                            String EmpPhon = sc.nextLine();
                            EmployeeFunctionality.UpEmployee(emp, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass);
                        }

                        break;
                    case 6:
                        EmployeeFunctionality.SortEmployeeById();
                        break;

                    case 7:
                        EmployeeFunctionality.SortEmployeeByName();
                        break;

                    case 8:
                        System.out.println("Enter the age to filter :");
                        int ages = input.nextInt();
                        EmployeeFunctionality.filterEmplByAge(ages);
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
            socketController.ConnectionController("503");
        }

    }
}
