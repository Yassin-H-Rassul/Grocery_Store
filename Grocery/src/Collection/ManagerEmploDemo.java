package Collection;

import Model.employee;


import java.io.*;
import java.util.*;
import java.util.Optional;

public class ManagerEmploDemo {


    public static void ManagerEmployee() throws Exception {

        Scanner sc = new Scanner(System.in);

        Scanner input = new Scanner(System.in);

        ArrayList<employee> employees =new ArrayList<employee>();

        ListIterator li=null;

        File file= new File("C:\\Users\\Click\\IdeaProjects\\Grocery\\src\\Files\\Employee.txt");

        ObjectOutputStream oos=null;

        ObjectInputStream ois=null;

        if (file.isFile()) {

            ois = new ObjectInputStream(new FileInputStream(file));

            employees = (ArrayList<employee>) ois.readObject();

            ois.close();

        }

        int choose=-1;
        do {

            System.out.println(" \nWelcome manager Enter your choice you : ");
            System.out.println("1.add New Employee: ");
            System.out.println("2.Display Employee Information : ");
            System.out.println("3.Search for a  Employee : ");
            System.out.println("4.Delete a  Employee :");
            System.out.println("5.Update a  Employee :");
            System.out.println("6.Sorting Employee Using  id :");
            System.out.println("7.Sorting Employee Using  name :");
            System.out.println("8.Sort by age :");
            System.out.println("0.Exit from Category: ");
            choose=input.nextInt();
            System.out.println("--------------------------------------------------");
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
                        System.out.print("Enter the Employee Phone Number :");
                        String EmpPhon = sc.nextLine();
                        System.out.println("--------------------------------------------------");

                        try {
                            employees.add(new employee(EmpEid, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass));
                        }catch (InputMismatchException e){
                            System.out.println("There a problem with Input of data  ");

                        }
                    }
                    System.out.println("--------------------------------------------------");
                    oos =new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(employees);
                    oos.close();
                    break;
                case 2:
                    if(file.isFile()) {
                        li = employees.listIterator();

                        while (li.hasNext()) {

                            System.out.println(li.next());

                        }
                    }
                    else{
                        System.out.println("--------------------------------------------------");

                        System.out.println("File Doesn't Exist....!");

                        System.out.println("--------------------------------------------------");
                    }

                    break;
                case 3:
                    if(file.isFile()) {

                        boolean found = false;

                        System.out.print("Enter the Employee id to Find :");

                        int emplo= input.nextInt();

                        li = employees.listIterator();

                        while (li.hasNext()) {

                            employee e = (employee) li.next();

                            if (e.getEid() == emplo) {

                                found = true;

                                System.out.println(e);
                            }
                        }
                        if ((!found)) {

                            System.out.println("--------------------------------------------------");

                            System.out.println("Record not Found....!");

                            System.out.println("--------------------------------------------------");

                        }

                    }

                    else{

                        System.out.println("--------------------------------------------------");

                        System.out.println("File Doesn't Exist....!");

                        System.out.println("--------------------------------------------------");

                    }
                    break;


                case 4:
                    if(file.isFile()) {

                        boolean found = false;

                        System.out.print("Enter the Employee Id to Delete : ");

                        int emplo=input.nextInt();

                        li = employees.listIterator();


                        while (li.hasNext()) {

                            employee e = (employee) li.next();

                            if (e.getEid() == emplo) {

                                found = true;

                                li.remove();

                                System.out.println(e);
                            }
                        }
                        System.out.println("--------------------------------------------------");
                        if((found)) {

                            oos =new ObjectOutputStream(new FileOutputStream(file));

                            oos.writeObject(employees);

                            oos.close();

                            System.out.println("The Record Delete Successfully");


                        }
                        else{

                            System.out.println("Record not Found....!");

                        }

                    }

                    else{

                        System.out.println("--------------------------------------------------");

                        System.out.println("File Doesn't Exist....!");

                    }
                    System.out.println("--------------------------------------------------");
                    break;

                case 5:
                    if(file.isFile()) {

                        boolean found = false;

                        System.out.print("Enter the Employee id to Update : ");

                        int emplo=input.nextInt();

                        li = employees.listIterator();

                        while (li.hasNext()) {

                            employee e = (employee) li.next();

                            if (e.getEid() == emplo) {

                                found = true;
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
                                System.out.print("Enter the Employee Phone Number :");
                                String EmpPhon = sc.nextLine();

                                try {
                                    li.set(new employee(EmpEid,EmpName,EmpGen,EmpAg,EmpPhon,EmpPass));
                                }catch (InputMismatchException exception){
                                    System.out.println("There a problem with Input of data  ");

                                }


                                System.out.println(e);
                            }
                        }
                        if ((found)) {
                            System.out.println("--------------------------------------------------");

                            oos =new ObjectOutputStream(new FileOutputStream(file));

                            oos.writeObject(employees);

                            oos.close();

                            System.out.println("The Record Update Successfully");

                            System.out.println("--------------------------------------------------");



                        }
                        else{
                            System.out.println("--------------------------------------------------");

                            System.out.println("Record not Found....!");

                            System.out.println("--------------------------------------------------");
                        }

                    }

                    else{

                        System.out.println("--------------------------------------------------");

                        System.out.println("File Doesn't Exist....!");

                        System.out.println("--------------------------------------------------");

                    }
                    break;
                case 6:
                    if (file.isFile()) {

                        Collections.sort(employees, new Comparator<employee>() {
                            @Override
                            public int compare(employee o1, employee o2) {
                                return o1.getEid()-o2.getEid();
                            }
                        });
                        oos =new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(employees);
                        oos.close();
                        li = employees.listIterator();

                        while (li.hasNext()) {

                            System.out.println(li.next());

                        }
                    }
                    else{
                        System.out.println("--------------------------------------------------");

                        System.out.println("File Doesn't Exist....!");

                        System.out.println("--------------------------------------------------");
                    }

                    break;
                case 7:
                    if (file.isFile()) {

                        Collections.sort(employees, new Comparator<employee>() {
                            @Override
                            public int compare(employee o1, employee o2) {
                                return o1.getName().compareTo(o2.getName());
                            }
                        });
                        oos =new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(employees);
                        oos.close();
                        li = employees.listIterator();

                        while (li.hasNext()) {

                            System.out.println(li.next());

                        }
                    }
                    else{
                        System.out.println("--------------------------------------------------");

                        System.out.println("File Doesn't Exist....!");

                        System.out.println("--------------------------------------------------");
                    }

                    break;
                case 0:
                    System.out.println("Have a nice Day Manager.");
                    break;
                case 8:
                    System.out.println("Enter the age to filter :");
                    int ages=input.nextInt();
                    employees.stream().filter(t->t.getAge() > ages).forEach(t->System.out.println("name: "+t.getName() + " - age: "+t.getAge()));
                    System.out.println("--------------------------------------------------");
                    break;
                default :
                    System.out.println("This chose is is not valide : " + choose);

            } }while(choose != 0);


    }
}