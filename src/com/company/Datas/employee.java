package com.company.Datas;

public class employee {
        String Uid;
        String fname;
        String lname;
        String address;
        String gender;
        int age;
        String email;
        String phone;
        String pass;

    public employee(String uid, String fname, String lname, String address, String gender, int age, String email,String phone, String pass) {
        setUid(uid);
        setAddress(address);
        setAge(age);
        setEmail(email);
        setFname(fname);
        setLname(lname);
        setGender(gender);
        setPass(pass);
        setPhone(phone);
    }

    public String getUid() {
        return Uid;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getGender() {
        return gender;
    }

    public String getLname() {
        return lname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPass() {
        return pass;
    }

    public void setUid(String uid) {Uid = uid;}

        public void setFname(String fname) {
            this.fname = fname;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public void setPhone(String phone) {this.phone = phone;}

    protected void ToString(){
        System.out.println("              Employee Infromation          \n"+"*************************************************"+"name : "+fname+lname+"\n age : "+age+"\n address : "+address+"\n email : "+email+"\n phone : "+phone+"\n gender : "+gender+"\n************************************************* ");
    }


    }
