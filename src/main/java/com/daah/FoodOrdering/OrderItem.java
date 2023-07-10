package com.daah.FoodOrdering;

public class OrderItem extends Item{
    private int quantity;
    OrderItem(Item a,int quan)
    {super(a);
    }

    public void showOrder(){};
    public void editOrder(){};
    public void delOrder(){};
}
