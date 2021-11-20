package View;
import Model.Category;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.*;

public class ManagerCategoryDemo {

    public static  void main(String args[]) throws IOException{
    Scanner sc = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
        Socket socket =new Socket("127.0.0.1",4444);
        ObjectOutputStream out =new ObjectOutputStream(socket.getOutputStream() );
        ObjectInputStream in= new ObjectInputStream(socket.getInputStream());
        PrintWriter PW = new PrintWriter(socket.getOutputStream(), true);// for client terminal
        BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    List<Category> categories = null;
    ListIterator li ;

        try {
            while (true) {
                // Loading the data
                String ms = null;
                System.out.println("write 504 to Load the previous data \nTo exit Write 0000 ");
                ms = sc.nextLine();
                if (ms.contains("504")) {
                    PW.println(ms);
                }
                if (ms.contains("0000")) break;
                else {
                    try {
                        if (ms.contains("504"))
                        categories = (List<Category>) in.readObject();
                    } catch (FileNotFoundException | ClassNotFoundException exception) {
                        categories = new ArrayList<>();
                    } catch (EOFException exception) {
                        categories = new ArrayList<>();

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

    int choose = -1;
       do{
        System.out.println(" \nWelcome manager Enter your choice you : ");
        System.out.println("1.add New Category: ");
        System.out.println("2.Display Ctaegoey Information : ");
        System.out.println("3.Search for a  Category : ");
        System.out.println("4.Delete a  Category :");
        System.out.println("5.Update a  Ctaegory :");
        System.out.println("0.Exit from Category: ");
        choose = input.nextInt();
        int CateTimes;
        switch (choose) {
            case 1:
                System.out.println("--------------------------------------------------\nWelcome manager how many category you will add");
                CateTimes = input.nextInt();
                for (int i = 0; i < CateTimes; i++) {
                    System.out.print("Enter the Category Id Using Numbers :");
                    int CatEid = input.nextInt();
                    System.out.print("Enter the Category type :");
                    String CatType = sc.nextLine();
                    System.out.print("Enter the Category Descrepstion :");
                    String CatDes = sc.nextLine();
                    System.out.println("--------------------------------------------------");
                    try {
                        categories.add(new Category(CatEid, CatType, CatDes));
                    } catch (InputMismatchException e) {
                        System.out.println("There a problem with Input of data  ");

                    }catch (NullPointerException exception){
                categories =new ArrayList<>();
                categories.add(new Category(CatEid, CatType, CatDes));
                 }
                }

                break;
            case 2:
                if (!categories.isEmpty()) {
                        li = categories.listIterator();
                        while (li.hasNext()) {
                            System.out.println(li.next());
                        }
                }
                else {
                    System.out.println("--------------------------------------------------"+"\nFile Doesn't Exist....!"+"\n--------------------------------------------------");
                }
                break;
            case 3:
            if (!categories.isEmpty()) {

                boolean found = false;
                System.out.print("Enter the Category id to Find :");
                int CatID = input.nextInt();
                li = categories.listIterator();
                while (li.hasNext()) {
                    Category e = (Category) li.next();
                    if (e.getCategoryID() == CatID) {
                        found = true;
                        System.out.println(e);
                    }
                } if ((!found)) {
                    System.out.println("--------------------------------------------------" + "\nRecord not Found....!" + "\n--------------------------------------------------");
                }
            }else{

                System.out.println("--------------------------------------------------"+"\nFile Doesn't Exist....!"+"\n--------------------------------------------------");

            }
            break;

            case 4:
                if (!categories.isEmpty()) {
                    boolean found = false;
                    System.out.print("Enter the Category Id to Delete : ");
                    int CatId = input.nextInt();
                    li = categories.listIterator();
                    while (li.hasNext()) {
                        Category e = (Category) li.next();
                        if (e.getCategoryID() == CatId) {
                            found = true;
                            li.remove();
                            System.out.println(e);
                        }
                    }
                    if((found)) {

                        System.out.println("The Record Delete Successfully\n--------------------------------------------------");
                    }
                    else{
                        System.out.println("Record not Found....!\n--------------------------------------------------");
                    }
                }
                else{
                    System.out.println("--------------------------------------------------\nFile Doesn't Exist....!--------------------------------------------------");

                }
                break;
            case 5:
                if (!categories.isEmpty()) {

                    boolean found = false;
                    System.out.print("Enter the Category id to Update : ");
                    int CatId = input.nextInt();
                    li = categories.listIterator();
                    while (li.hasNext()) {
                        Category e = (Category) li.next();
                        if (e.getCategoryID() == CatId) {
                            li.remove();
                            found = true;
                            System.out.print("Enter the Category type :");
                            String CatType = sc.nextLine();
                            System.out.print("Enter the Category Descrepstion :");
                            String CatDes = sc.nextLine();
                            System.out.println("--------------------------------------------------");
                            try {
                                li.add(new Category(CatId, CatType, CatDes));
                            } catch (InputMismatchException exception) {
                                System.out.println("There a problem with Input of data  ");
                            }
                            System.out.println(e);
                        }
                    }if ((found)) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("The Record Update Successfully");
                            System.out.println("--------------------------------------------------");
                        } else{
                            System.out.println("--------------------------------------------------\nRecord not Found....!\n--------------------------------------------------");
                        }
                    }else{
                        System.out.println("--------------------------------------------------\nFile Doesn't Exist....!--------------------------------------------------");
                    }
                break;
            case 0:
                System.out.println("Have a nice Day Manager.");
                break;
            default:
                System.out.println("This chose is is not valide : " + choose);
        }
    }while(choose !=0);
            }  System.out.println("Do you want to save the data write 505");
                ms=null;
                ms = sc.nextLine();
                PW.println(ms);
                if (ms.contains("503")){
                    out.writeObject(categories);
                    System.out.println("data Uploaded");
                }

            }

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }catch (ConnectException exception) {
            System.err.println("there is no server to connect");
            exception.printStackTrace();
        }
        finally {
            PW.close();
            BR.close();
            in.close();
            out.close();

        }


    }


}