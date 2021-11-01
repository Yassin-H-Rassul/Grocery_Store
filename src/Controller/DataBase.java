package Controller;

import Model.Category;
import Model.employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase  {

    public static void SaveDataToFile(String path, Object list) throws IOException{
        if(path.equals("src\\Files\\Employee.txt")) {
            saveEmplo(path, (List<employee>) list);
        }
        else if(path.equals("src\\Files\\categories.txt")) {
            saveCat(path, (List<Category>) list);
        }


    }

    private static void saveEmplo(String path,List<employee> employeeList) throws IOException {
        File file= new File(path);
        FileOutputStream FOS=new FileOutputStream(file);
        ObjectOutputStream oos =new ObjectOutputStream(FOS);
        oos.writeObject(employeeList);
        oos.close();

    }
    private static void saveCat(String path,List<Category> categoryList) throws IOException {
        File file= new File(path);
        FileOutputStream FOs=new FileOutputStream(file);
        ObjectOutputStream oos =new ObjectOutputStream(FOs);
        oos.writeObject(categoryList);
        oos.close();

    }

    public static Object LoadDataOfFile(String type,String Path) throws IOException, ClassNotFoundException {
        Object list = null;
        if (type.equals("employee")) {
             list = LoadEmploye(Path);
        }
        else if(type.equals("cat")) {
           list= LoadCat(Path);
        }
       return  list;
    }
    private static Object LoadCat(String path) throws IOException, ClassNotFoundException {
        File file=new File(path);
        FileInputStream FIS=new FileInputStream(file);
        ObjectInputStream OIS=new ObjectInputStream(FIS);
        List<Category> categories= (List<Category>)OIS.readObject();
        OIS.close();
        return categories;
    }
    private static Object LoadEmploye(String path) throws IOException, ClassNotFoundException {
        File file=new File(path);
        FileInputStream FIs=new FileInputStream(file);
        ObjectInputStream OIs=new ObjectInputStream(FIs);
        List<employee> employees= (ArrayList<employee>)OIs.readObject();
        OIs.close();
        return employees;
    }


}
