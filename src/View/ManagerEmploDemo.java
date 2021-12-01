package View;

import Model.employee;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.*;


public class ManagerEmploDemo  {

    public static void demo( ObjectOutputStream out, ObjectInputStream in, PrintWriter PW, BufferedReader BR) throws Exception {
        System.out.println("welcome manager to Employee managing :");
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        List<employee> employees =new ArrayList<>();
        try {
            while (true) {
        // Loading the data
                String ms = null;
                System.out.println("write 502 to Load the previous data \nTo exit Write 0000 ");
                ms = sc.nextLine();

                if (ms.contains("502")){
                    PW.println(ms);
                }
                if (ms.contains("0000")) break;
                else {
                        if (ms.contains("502")) {
                            employees = (List<employee>) in.readObject();
                        }


                    ListIterator li = null;
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
                                    try {
                                        employees.add(new employee(EmpEid, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass));
                                    } catch (InputMismatchException e) {
                                        System.out.println("There a problem with Input of data  ");
                                    } catch (NullPointerException exception) {
                                        employees.add(new employee(EmpEid, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass));
                                    }
                                }

                                System.out.println("--------------------------------------------------");

                                break;
                            case 2:
                                if (!employees.isEmpty()) {
                                    employees.forEach(System.out::println);
                                    li = employees.listIterator();
                                    while (li.hasNext()) {
                                        System.out.println(li.next());
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------" + "\nFile Doesn't Exist....!" + "\n--------------------------------------------------");
                                }
                                break;

                            case 3:
                                if (!employees.isEmpty()) {

                                    boolean found = false;
                                    System.out.print("Enter the Employee id to Find :");
                                    int emplo = input.nextInt();
                                    li = employees.listIterator();

                                    while (li.hasNext()) {
                                        employee e = (employee) li.next();
                                        if (e.getEid() == emplo) {
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
                                if (!employees.isEmpty()) {

                                    boolean found = false;

                                    System.out.print("Enter the Employee Id to Delete : ");
                                    int emplo = input.nextInt();
                                    li = employees.listIterator();

                                    while (li.hasNext()) {

                                        employee e = (employee) li.next();
                                        if (e.getEid() == emplo) {
                                            found = true;
                                            li.remove();
                                            System.out.println(e);
                                        }
                                    }
                                    if ((found)) {
                                        //  DataBase.SaveDataToFile(path,employees);
                                        System.out.println("The Record Delete Successfully" + "\n--------------------------------------------------");
                                    } else {
                                        System.out.println("Record not Found....!" + "\n--------------------------------------------------");
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "--------------------------------------------------");

                                }
                                break;

                            case 5:
                                if (!employees.isEmpty()) {
                                    boolean found = false;
                                    System.out.print("Enter the Employee id to Update : ");
                                    int emplo = input.nextInt();
                                    li = employees.listIterator();

                                    while (li.hasNext()) {
                                        employee e = (employee) li.next();
                                        if (e.getEid() == emplo) {
                                            found = true;
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
                                                li.set(new employee(emplo, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass));
                                            } catch (InputMismatchException exception) {
                                                System.out.println("There a problem with Input of data  ");

                                            }


                                            System.out.println(li.next());
                                        }
                                    }
                                    if ((found)) {
                                        System.out.println("--------------------------------------------------");
                                        // DataBase.SaveDataToFile(path,employees);
                                        System.out.println("The Record Update Successfully\n--------------------------------------------------");
                                    } else {
                                        System.out.println("--------------------------------------------------\nRecord not Found....!\n--------------------------------------------------");
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "--------------------------------------------------");
                                }
                                break;
                            case 6:
                                if (!employees.isEmpty()) {

                                    Collections.sort(employees, new Comparator<employee>() {
                                        @Override
                                        public int compare(employee o1, employee o2) {
                                            return o1.getEid() - o2.getEid();
                                        }
                                    });
                                    li = employees.listIterator();

                                    while (li.hasNext()) {
                                        System.out.println(li.next());
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "\n--------------------------------------------------");
                                }
                                break;

                            case 7:
                                if (!employees.isEmpty()) {

                                    Collections.sort(employees, new Comparator<employee>() {
                                        @Override
                                        public int compare(employee o1, employee o2) {
                                            return o1.getName().compareTo(o2.getName());
                                        }
                                    });
                                    li = employees.listIterator();

                                    while (li.hasNext()) {
                                        System.out.println(li.next());
                                    }
                                } else {
                                    System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "\n--------------------------------------------------");
                                }
                                break;

                            case 8:
                                employees = (List<employee>) in.readObject();
                                System.out.println("Enter the age to filter :");
                                int ages = input.nextInt();
                                employees.stream().filter(S -> S.getAge() > ages).forEach(t -> System.out.println("name: " + t.getName() + " - age: " + t.getAge()));
                                System.out.println("--------------------------------------------------");
                                break;
                            case 0:
                                System.out.println("Have a nice Day Manager.");
                                break;
                            default:
                                System.out.println("This chose is is not valide : " + choose);
                                break;
                        }
                    } while (choose != 0);
                }  System.out.println("Do you want to save the data write 503");
                ms=null;
                ms = sc.nextLine();
                PW.println(ms);
                if (ms.contains("503")){
                    out.writeObject(employees);
                    System.out.println("data Uploaded");
                }

            }

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }catch (ConnectException exception) {
            System.err.println("there is no server to connect");
            exception.printStackTrace();
        } catch (FileNotFoundException | ClassNotFoundException exception) {
            employees = new ArrayList<>();
        } catch (EOFException exception) {
            employees = new ArrayList<>();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }



    }


}