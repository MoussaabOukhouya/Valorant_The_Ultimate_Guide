package com.ProGuides.Valorant;

public class myskin {
    String name;
    String Price;
    String Howtounlock;
    String img;

    public myskin(String name, String price, String howtounlock, String img) {
        this.name = name;
        Price = price;
        Howtounlock = howtounlock;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getHowtounlock() {
        return Howtounlock;
    }

    public void setHowtounlock(String howtounlock) {
        Howtounlock = howtounlock;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
