package com.example.phonestore.models;

public class Phone {
    private int id;
    private String name;
    private String img;
    private String manufacture;
    private double price;
    private int quantity;
    private float size;
    private String color;
    private int ram;
    private int batery;

    public Phone() {
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Phone(int id, String name, String img, String manufacture, double price, int quantity, float size, String color, int ram, int batery) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.manufacture = manufacture;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.ram = ram;
        this.batery = batery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getBatery() {
        return batery;
    }

    public void setBatery(int batery) {
        this.batery = batery;
    }

}
