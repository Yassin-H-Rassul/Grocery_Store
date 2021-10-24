package collection;

import java.io.Serializable;

public interface seller extends Serializable {

    public abstract void addItem( );
    public abstract void removeItem( );
    public abstract void updateItem( );
    public abstract void searchItem( );
    public abstract void showAllItem( );

}
