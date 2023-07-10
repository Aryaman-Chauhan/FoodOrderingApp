package com.daah.FoodOrdering;

import java.util.UUID;
import java.util.LinkedList;
public class Order {
    private float totalCost;
    private String orderId;
    private int status;
    private int otp;
    private int rating;
    //LinkedList<OrderItem> orderList;


    public Order(float totalCost, String orderId, int status, int otp, int rating) {
        this.totalCost = totalCost;
        this.orderId = orderId;
        this.status = status;
        this.otp = otp;
        this.rating = rating;
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

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
}
