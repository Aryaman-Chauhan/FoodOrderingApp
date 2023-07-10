package com.daah.FoodOrdering;

import java.util.LinkedList;

public class Vendor {
    private String anme;
    private String password;
    private String id;
    private String shopName;
    private int noOfRating;

    private String shopPic;
    private float rating;
    private boolean openClose;
    private String location;
   /* LinkedList<Item> menu = new LinkedList<Item>();
    LinkedList<Order> vendorOrder = new LinkedList<Order>();*/

    public Vendor(String anme, String password, String id, String shopName, int noOfRating, String shopPic, float rating, boolean openClose, String location) {
        this.anme = anme;
        this.password = password;
        this.id = id;
        this.shopName = shopName;
        this.noOfRating = noOfRating;
        this.shopPic = shopPic;
        this.rating = rating;
        this.openClose = openClose;
        this.location = location;
    }

    public String getAnme() {
        return anme;
    }

    public void setAnme(String anme) {
        this.anme = anme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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
