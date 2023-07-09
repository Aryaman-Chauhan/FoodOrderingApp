package com.daah.FoodOrdering;

import java.util.UUID;
import java.util.LinkedList;
public class Order {
    private float totalCost;
    private String orderId;
    private int status;
    private int otp;
    private int rating;
    LinkedList<OrderItem> orderList;

    Order(){

    };

    public void placeOrder(){};
    public void cancelOrder(){};
    public void showBill(){};
    public void genOtp(){};
    public void showStatus(){};
    public void rateOrder(){};


}
