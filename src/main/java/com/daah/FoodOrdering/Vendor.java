package com.daah.FoodOrdering;

import java.util.LinkedList;

public class Vendor {
    private String anme;
    private String password;
    private int id;
    private String shopName;
    private int noOfRating;

    private String shopPic;
    private float rating;
    private boolean openClose;
    private String location;
    LinkedList<Item> menu = new LinkedList<Item>();
    LinkedList<Order> vendorOrder = new LinkedList<Order>();

    public void genQr(){};
    public void checkOtp(){};
    public void editInfo(){};
    public void showInfo(){};
    public void setRating(){};
    public void setopenClose(){};

    public void addItem(){};
    public void removeItem(){};
    public void editItem(){};


}
