package Model;

import java.io.Serializable;

public class packet implements Serializable {
   String message;
   public packet(String message){
      this.message=message;
   }

   @Override
   public String toString() {
      return "messagem : " + message ;
   }
}

