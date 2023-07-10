package com.daah.FoodOrdering;

/*import java.util.LinkedList;*/

public class Student {
    private String name;
    private String email;
    private String pass;
    private String ID;
    //LinkedList<Order> orders = new LinkedList<Order>();
Student(String email, String pass)
{this.email = email;
    this.pass = pass;
    this.name = null;
    this.ID = null;
}
    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public LinkedList<Order> getOrders() {
        return orders;
    }

    public void setOrders(LinkedList<Order> orders) {
        this.orders = orders;
    }*/

    public void showVendor(){};
    public void showPdetail(){};
    public void editPdetail(){};
    public void useQr(){};
    public void showOrder(){};
}
