package Model;

import java.io.IOException;

public interface ManageEmplo {


    abstract Object getEmployee(String id) throws IOException;

    abstract void getList() throws IOException;

    abstract Object addToList(employee employees) throws IOException;

    abstract Object removeFromList(String id) throws IOException;
}
