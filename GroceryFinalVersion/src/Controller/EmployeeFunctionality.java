package Controller;

import Model.employee;
import java.util.*;

public class EmployeeFunctionality {
    public static ArrayList<employee> employees = new ArrayList<>();
    private static ListIterator<employee> li;

    //       Employee staff
    public static void AddingEmployee(int EmpEid, String EmpName, String EmpGen, int EmpAg, String EmpPhon, String EmpPass) {
        if (validEmployeeID(EmpEid)) {
            System.out.println("this id valid try another one");
            return;
        } else {
            employees.add(new employee(EmpEid, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass));
        }

    }
    public static Boolean validEmployeeID(int emp) {
        boolean found = false;
        li = employees.listIterator();
        while (li.hasNext()) {
            employee e = (employee) li.next();
            if (e.getEid() == emp) {
                found = true;
            }
        }
        return found;
    }

    public static void showEmployee() {
        if (!employees.isEmpty()) {
            employees.forEach(System.out::println);

        } else {
            System.out.println("--------------------------------------------------" + "\nFile Doesn't Exist....!" + "\n--------------------------------------------------");
        }
    }

    public static void findEmployee(int emplo) {
        if (!employees.isEmpty()) {
            boolean found = false;
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
    }


    public static void DelEmployeee(int emplo) {
        if (!employees.isEmpty()) {
            boolean found = false;
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
                System.out.println("The Record Delete Successfully" + "\n--------------------------------------------------");
            } else {
                System.out.println("Record not Found....!" + "\n--------------------------------------------------");
            }
        } else {
            System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "--------------------------------------------------");

        }
    }

    public static void UpEmployee(int EmpEid, String EmpName, String EmpGen, int EmpAg, String EmpPhon, String EmpPass) {
        try {
            li.set(new employee(EmpEid, EmpName, EmpGen, EmpAg, EmpPhon, EmpPass));
        } catch (InputMismatchException exception) {
            System.out.println("There a problem with Input of data  ");

        }
        System.out.println(li.next());
    }

    public static void SortEmployeeByName() {
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
    }

    public static void SortEmployeeById() {
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
    }

    public static void filterEmplByAge(int ages) {
        employees.stream().filter(S -> S.getAge() > ages).forEach(t -> System.out.println("name: " + t.getName() + " - age: " + t.getAge()));
        System.out.println("--------------------------------------------------");
    }


    // category function



    public static ArrayList<employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<employee> employees) {
        EmployeeFunctionality.employees = employees;
    }


}


