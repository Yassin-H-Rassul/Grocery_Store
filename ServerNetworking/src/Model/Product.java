package Model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class Product implements Serializable {

    int productID;
    String addProduct;
    int addQuantity;
    double addPrice;
    private static int inc = 97678;

    public Product() {
        super();
    }

    public Product(int productID, String addProduct, int addQuantity, double addPrice) {
        super();
        this.productID = productID;
        this.addProduct = addProduct;
        this.addQuantity = addQuantity;
        this.addPrice = addPrice;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model.Product product = (Model.Product) o;
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
        this.productID = Optional.of(productID).orElse(inc + 1);
    }

    public String getAddProduct() {
        return addProduct;
    }

    public void setAddProduct(String addProduct) {
        this.addProduct = Optional.of(addProduct).orElse(" there is no input");
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

    @Override
    public String toString() {
        return "\n              Product              \n" + "--------------------------------------------------\n" +
                "Product ID : " + productID +
                "\nProduct : " + addProduct +
                "\nQuantity : " + addQuantity +
                "\nPrice : " + addPrice + "\n--------------------------------------------------"
                ;
    }
}
