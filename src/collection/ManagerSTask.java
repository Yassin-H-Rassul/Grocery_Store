package collection;

import com.company.Model.Category;
import com.company.Model.Product;
import com.company.Model.employee;

import java.util.ArrayList;
import java.util.List;

public class ManagerSTask implements managerTask {

    List<employee> employeeList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();



    @Override
    public void addEmployee(employee employees) {
        employeeList.add(employees);
    }

    @Override
    public void removeEmployee(employee employees) {
        if (!employeeList.contains(employees)) {
            try {
                throw new NotFoundExeption(employees.getEid());
            } catch (NotFoundExeption e) {
                e.printStackTrace();
            }
        }
        employeeList.remove(employees);
    }

    @Override
    public void updateEmployee(employee employees) {
        if (!employeeList.contains(employees)) {
            try {
                throw new NotFoundExeption(employees.getEid());
            } catch (NotFoundExeption e) {
                e.printStackTrace();
            }
        }
        int index = employeeList.indexOf(employees);
        employeeList.set(index, employees);
    }

    @Override
    public List<employee> showAllEmployee() {

        return employeeList;
    }


    @Override
    public void addCategory(Category category) {
        categoryList.add(category);
    }

    @Override
    public void deleteCategory(Category category) {
        if (!categoryList.contains(category)) {
            try {
                throw new NotFoundExeption(category.getCategoryID());
            } catch (NotFoundExeption e) {
                e.printStackTrace();
            }
        }
        categoryList.remove(category);
    }

    @Override
    public void updateCategory(Category category) {
        if (!categoryList.contains(category)) {
            try {
                throw new NotFoundExeption(category.getCategoryID());
            } catch (NotFoundExeption e) {
                e.printStackTrace();
            }
        }
        int index = categoryList.indexOf(category);
        categoryList.set(index, category);
    }

    @Override
    public List<Category> showAllCategory() {

        return categoryList;
    }


    @Override
    public void addProduct(Product products) {
        productList.add(products);
    }

    @Override
    public void removeProduct(Product products) {
        if (!productList.contains(products)) {
            try {
                throw new NotFoundExeption(products.getProductID());
            } catch (NotFoundExeption e) {
                e.printStackTrace();
            }
        }
        productList.remove(products);
    }

    @Override
    public void updateProduct(Product products) {
        if (!productList.contains(products)) {
            try {
                throw new NotFoundExeption(products.getProductID());
            } catch (NotFoundExeption e) {
                e.printStackTrace();
            }
        }
        int index = productList.indexOf(products);
        productList.set(index, products);
    }

    @Override
    public void searchProduct(Product products) {

    }

    @Override
    public List<Product> showAllProduct() {

        return productList;
    }

}



