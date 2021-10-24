package collection;

import com.company.Model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ManagerDemo implements Serializable {

    public static void CategoryDemo() throws Exception {
        List<Category> categoryList = new ArrayList<Category>();
        managerTaskService service = new ManagerSTaskService();
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        ListIterator li = null;
        File file = new File("Categoey.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            categoryList = (ArrayList<Category>) ois.readObject();
            ois.close();
        }
        int choose = -1;
        do {

            System.out.println("************************************************** \nWelcome manager Enter your choice you : ");
            System.out.println("1.add New Category: ");
            System.out.println("2.Delete a Category: ");
            System.out.println("3.Update a Category: ");
            System.out.println("4.Show all Category: ");
            System.out.println("0.Exit from Category: ");
            choose = input.nextInt();
            int CateTimes;

            switch (choose) {
                case 1:
                    System.out.println("************************************************** \nWelcome manager how many category you will add");
                    System.out.println("**************************************************");
                    CateTimes = input.nextInt();
                    for (int i = 0; i < CateTimes; i++) {
                        System.out.println("Enter the Category id :");
                        int catid = input.nextInt();
                        System.out.println("Enter the Category name :");
                        String catNam = sc.nextLine();
                        System.out.println("Enter the Category description :");
                        String catDes = sc.nextLine();
                        //   service.addCategory(new Category(catid, catNam, catDes));
                        categoryList.add(new Category(catid, catNam, catDes));
                    }
                    System.out.println("**************************************************");
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(categoryList);
                    oos.close();
                    break;
                case 2:

                    System.out.println("**************************************************");
                    System.out.println("how many category you will delete : ");
                    CateTimes = input.nextInt();
                    for (int i = 0; i < CateTimes; i++) {
                        System.out.println("Enter the Category id :");
                        int catid = input.nextInt();
                        Category delete = new Category(catid);
                        service.deleteCategory(delete);
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(categoryList);
                    oos.close();
                    System.out.println("**************************************************");
                    break;
                case 3:
                    System.out.println("**************************************************");
                    System.out.println("how many category you will update : ");
                    CateTimes = input.nextInt();
                    for (int i = 0; i < CateTimes; i++) {
                        System.out.println("Enter the Category id :");
                        int catid = input.nextInt();
                        System.out.println("Enter the Category name :");
                        String catNam = sc.nextLine();
                        System.out.println("Enter the Category description :");
                        String catDes = sc.nextLine();
                        Category update = new Category(catid, catNam, catDes);
                        // categoryList.updateCategory(update);
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(categoryList);
                    oos.close();
                    System.out.println("**************************************************");
                    break;

                case 4:
                    System.out.println("**************************************************");
                    List<Category> catList = service.showAllCategory();
                    li = categoryList.listIterator();
                    while (li.hasNext())
                        System.out.println(li.next());

                    System.out.println("**************************************************");
                    break;
                case 0:
                    System.out.println("Have a nice day.");
                    break;

                default:
                    System.out.println("This chose is is not valide : " + choose);

            }
        } while (choose != 0);
    }

}
