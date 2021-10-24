package com.company.Model;
import java.io.Serializable;
import java.util.Objects;

public class employee {
        int Eid;
        String userName;
        String name;
        String gender;
        int age;
        String phone;
        String pass;

    public employee() {
        super();
    }

    public employee(String userName, String name, String gender, int age, String phone, String pass, int Eid) {
        super();
        this.Eid=Eid;
        this.age=age;
        this.userName=userName;
        this.gender=gender;
        this.phone=phone;
        this.pass=pass;
        this.name=name;
    }

    public String getUserName() {
        return userName;
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

    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }


    public void setUserName(String uid) {userName = userName;}

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

    protected void ToString(){
        System.out.println("              Employee Infromation          \n"+"*************************************************"+"name : "+name+"\n age : "+age+"\n phone : "+phone+"\n gender : "+gender+"\n Eid : "+Eid+"\n************************************************* ");
    }


    }
