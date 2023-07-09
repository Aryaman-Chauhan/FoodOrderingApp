package com.daah.FoodOrdering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class Item {
    private String name;
    private String type;
    private float price;
    private String prepTime;
    private String itemPic;
    private String itemId;

    public Item(String name, String type, float price, String prepTime, String itemPic, String itemId) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.prepTime = prepTime;
        this.itemPic = itemPic;
        this.itemId = itemId;
    }

    Item(Item a){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getItemPic() {
        return itemPic;
    }

    public void setItemPic(String itemPic) {
        this.itemPic = itemPic;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void showDetail(){};
public void editItem(){};
}
