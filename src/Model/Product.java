package Model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

     int productID;
     String addProduct;
     int addQuantity;
     double addPrice;

    public Product() {
        super();
    }

    public Product(int productID, String addProduct, int addQuantity, double addPrice){
        super();
        this.productID=productID;
        this.addProduct=addProduct;
        this.addQuantity=addQuantity;
        this.addPrice=addPrice;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getAddProduct() {
        return addProduct;
    }

    public void setAddProduct(String addProduct) {
        this.addProduct = addProduct;
    }

    public int getAddQuantity() {
        return addQuantity;
    }

    public void setAddQuantity(int addQuantity) {
        this.addQuantity = addQuantity;
    }

    public double getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(double addPrice) {
        this.addPrice = addPrice;
    }


}
