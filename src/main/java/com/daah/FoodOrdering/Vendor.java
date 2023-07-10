package com.daah.FoodOrdering;

import java.util.LinkedList;

public class Vendor {
    private String name;
    private String email;
    private String password;
    private int noOfRating;

    private String shopPic;
    private String qrCode;
    private float rating;
    private boolean openClose;
    private String location;
   /* LinkedList<Item> menu = new LinkedList<Item>();
    LinkedList<Order> vendorOrder = new LinkedList<Order>();*/

    public Vendor(String name, String email,String password, int noOfRating,String shopPic, String qrCode,float rating, boolean openClose, String location) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.noOfRating = noOfRating;
        this.shopPic = shopPic;
        this.rating = rating;
        this.openClose = openClose;
        this.location = location;
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoOfRating() {
        return noOfRating;
    }

    public void setNoOfRating(int noOfRating) {
        this.noOfRating = noOfRating;
    }

    public String getShopPic() {
        return shopPic;
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isOpenClose() {
        return openClose;
    }

    public void setOpenClose(boolean openClose) {
        this.openClose = openClose;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
