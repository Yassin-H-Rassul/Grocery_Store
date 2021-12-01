package Controller;

import Model.Product;

import java.util.*;


public class ProductFunctionality {
    private static List<Product> products = new ArrayList<>();
    private static ListIterator<Product> lis;
    ///   Product Function
    public static void AddingProduct(int proid, String product, int quantity, double price) {
        if (validProductID(proid)) {
            System.out.println("this id valid try another one");
            return;
        } else {
            products.add(new Product(proid, product, quantity, price));
        }

    }

    public static Boolean validProductID(int pro) {
        boolean found = false;
        lis = products.listIterator();
        while (lis.hasNext()) {
            Product e = (Product) lis.next();
            if (e.getProductID() == pro) {
                found = true;
            }
        }
        return found;
    }

    public static void showProduct() {
        if (!products.isEmpty()) {
            products.forEach(System.out::println);

        } else {
            System.out.println("--------------------------------------------------" + "\nFile Doesn't Exist....!" + "\n--------------------------------------------------");
        }
    }

    public static void findProduct(int prod) {
        if (!products.isEmpty()) {
            boolean found = false;
            lis = products.listIterator();

            while (lis.hasNext()) {
                Product e = (Product) lis.next();
                if (e.getProductID() == prod) {
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

    public static void DelProduct(int prod) {
        if (!products.isEmpty()) {
            boolean found = false;
            lis = products.listIterator();
            while (lis.hasNext()) {
                Product e = (Product) lis.next();
                if (e.getProductID() == prod) {
                    found = true;
                    lis.remove();
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

    public static void UpProduct(int proid, String product, int quantity, double price) {
        try {
            lis.set(new Product(proid, product, quantity, price));
        } catch (InputMismatchException exception) {
            System.out.println("There a problem with Input of data  ");

        }
        System.out.println(lis.next());
    }

    public static void SortProductByName() {
        if (!products.isEmpty()) {
            Collections.sort(products, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getAddProduct().compareTo(o2.getAddProduct());
                }
            });
            lis = products.listIterator();
            while (lis.hasNext()) {
                System.out.println(lis.next());
            }
        } else {
            System.out.println("--------------------------------------------------\n" + "File Doesn't Exist....!" + "\n--------------------------------------------------");
        }
    }

    public static void SortProductById() {

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getProductID() - o2.getProductID();
            }
        });
        lis = products.listIterator();
        while (lis.hasNext()) {
            System.out.println(lis.next());
        }
    }

    public static void setProducts(List<Product> products) {
        ProductFunctionality.products = products;
    }

    public static List<Product> getProducts() {
        return products;
    }
}
