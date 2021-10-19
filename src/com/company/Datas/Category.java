package com.company.Datas;

public class Category {
    private int categoryID;
    private   String categoryType;
    private String categoryDescription;

    public Category(int categoryID, String categoryDescription, String categoryType){

        setCategoryDescription(categoryDescription);
        setCategoryID(categoryID);
        setCategoryType(categoryType);
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
