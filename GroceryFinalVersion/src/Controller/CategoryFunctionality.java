package Controller;

import Model.Category;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;

public class CategoryFunctionality {
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ListIterator<Category> li;

    public static void AddingCategory(int CatEid, String CatType, String CatDes) {
        if (validCategoryID(CatEid)) {
            System.out.println("this id valid try another one");
            return;
        } else {
            categories.add(new Category(CatEid, CatType, CatDes));
        }

    }
    public static Boolean validCategoryID(int CatEid) {
        boolean found = false;
        li = categories.listIterator();
        while (li.hasNext()) {
            Category e = (Category) li.next();
            if (e.getCategoryID() == CatEid) {
                found = true;
            }
        }
        return found;
    }

    public static void showCategory() {
        if (!categories.isEmpty()) {
            categories.forEach(System.out::println);
        } else {
            System.out.println("--------------------------------------------------" + "\nFile Doesn't Exist....!" + "\n--------------------------------------------------");
        }
    }

    public static void findCategory(int cate) {
        if (!categories.isEmpty()) {
            boolean found = false;
            li = categories.listIterator();
            while (li.hasNext()) {
                Category e = (Category) li.next();
                if (e.getCategoryID() == cate) {
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


    public static void DelCategory(int cat) {
        if (!categories.isEmpty()) {
            boolean found = false;
            li = categories.listIterator();
            while (li.hasNext()) {

                Category e = (Category) li.next();
                if (e.getCategoryID() == cat) {
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

    public static void UpCategory(int CatEid, String CatType, String CatDes) {
        try {
            li.set(new Category(CatEid,CatType,CatDes));
        } catch (InputMismatchException exception) {
            System.out.println("There a problem with Input of data  ");

        }
    }

    public static void setCategories(ArrayList<Category> categories) {
        CategoryFunctionality.categories = categories;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }
}
