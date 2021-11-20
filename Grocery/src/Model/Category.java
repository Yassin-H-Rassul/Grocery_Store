package Model;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
      int categoryID;
      String categoryType;
      String categoryDescription;



    public Category(int categoryID, String categoryType, String categoryDescription){
        super();
        this.categoryID=categoryID;
        this.categoryType=categoryType;
        this.categoryDescription=categoryDescription;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryID == category.categoryID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID);
    }

    @Override
    public String toString() {
        return
                "\n              Category Infromation          \n------------------------------------------"+"\nScategoryID : " + categoryID +
                "\ncategoryType : " + categoryType +
                "\ncategoryDescription : " + categoryDescription +"\n------------------------------------------";
    }
}
