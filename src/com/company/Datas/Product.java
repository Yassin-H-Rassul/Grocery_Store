package com.company.Datas;

import java.io.Serializable;

public class Product implements Serializable {

     int productID;
     String addProduct;
     int addQuantity;
     double addPrice;


    public Product(int productID, String addProduct, int addQuantity, double addPrice){

        setProductID(productID);
        setAddProduct(addProduct);
        setAddQuantity(addQuantity);
        setAddPrice(addPrice);

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
