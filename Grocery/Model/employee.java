package Model;

import java.io.Serializable;
import java.util.Objects;

public class employee implements Serializable {
        int Eid;
        String name;
        String gender;
        int age;
        String phone;
        String pass;

    public employee() {
        super();
    }

    public employee(int Eid, String name, String gender, int age, String phone, String pass) {
        super();
        this.Eid=Eid;
        this.age=age;
        this.gender=gender;
        this.phone=phone;
        this.pass=pass;
        this.name=name;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public int getEid() {
        return Eid;
    }



    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getPass() {
        return pass;
    }





        public void setFname(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return Eid == employee.Eid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Eid);
    }

    public void setGender(String gender) {
            this.gender = gender;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public void setPhone(String phone) {this.phone = phone;}

    public String toString(){
         return  ("\n              Employee Infromation          \n"+"--------------------------------------------------"+"\nEmployee Eid : "+Eid+"\nName : "+name+"\nAge : "+age+"\nPhone : "+phone+"\nGender : "+gender+"\n--------------------------------------------------");
    }


    }
