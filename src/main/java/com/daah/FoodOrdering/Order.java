package com.daah.FoodOrdering;

import java.util.UUID;
import java.util.LinkedList;
public class Order {
    private float totalCost;
    private String orderId;
    private int status;
    private int otp;
    private int rating;

    private String studId;   //Student Email
    private String vendorId;  //Vendor Email
    //LinkedList<OrderItem> orderList;


    public Order(float totalCost, String orderId, int status, int otp, int rating, String studId,String vendorId) {
        this.totalCost = totalCost;
        this.orderId = UUID.randomUUID().toString();
        this.status = 0;
        this.otp = (int) Math.random();
        this.rating = rating;
        this.studId = studId;
        this.vendorId = vendorId;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
}
