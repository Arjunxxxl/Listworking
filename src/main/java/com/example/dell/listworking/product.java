package com.example.dell.listworking;

/**
 * Created by dell on 9/10/2016.
 */
public class product {
    private  String id,name;
    private int price,qty;

    public product(  String name, String id,int price,int qty) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setQty(qty);


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
