package com.ProGuides.Valorant.weapons;

import java.io.Serializable;

public class weapon implements Serializable {
    private String name;
    private String price;
    private String type;
    private String firemode;
    private String firerate;
    private String wallpenetration;
    private String head_dmg;
    private String torso_dmg;
    private String leg_dmg;
    private String alt_firemode;
    private String alt_firerate;
    private int img ;
    private String video;
    private String capacity;

    public weapon(String name, String firemode, String firerate, String wallpenetration, String head_dmg, String torso_dmg, String leg_dmg, String alt_firemode, String alt_firerate, String video, String capacity) {
        this.name = name;
        this.firemode = firemode;
        this.firerate = firerate;
        this.wallpenetration = wallpenetration;
        this.head_dmg = head_dmg;
        this.torso_dmg = torso_dmg;
        this.leg_dmg = leg_dmg;
        this.alt_firemode = alt_firemode;
        this.alt_firerate = alt_firerate;
        this.video = video;
        this.capacity = capacity;
    }



    public String getHead_dmg() {
        return head_dmg;
    }

    public void setHead_dmg(String head_dmg) {
        this.head_dmg = head_dmg;
    }

    public String getTorso_dmg() {
        return torso_dmg;
    }

    public void setTorso_dmg(String torso_dmg) {
        this.torso_dmg = torso_dmg;
    }

    public String getLeg_dmg() {
        return leg_dmg;
    }

    public void setLeg_dmg(String leg_dmg) {
        this.leg_dmg = leg_dmg;
    }

    public String getAlt_firemode() {
        return alt_firemode;
    }

    public void setAlt_firemode(String alt_firemode) {
        this.alt_firemode = alt_firemode;
    }

    public String getAlt_firerate() {
        return alt_firerate;
    }

    public void setAlt_firerate(String alt_firerate) {
        this.alt_firerate = alt_firerate;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }



    public weapon(){}

    public weapon(String name, String price, String type, String firemode, String firerate, String wallpenetration, int img) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.firemode = firemode;
        this.firerate = firerate;
        this.wallpenetration = wallpenetration;
        this.img = img;
    }

    public weapon(String name, String price, String firemode, String firerate, int img) {
        this.name = name;
        this.price = price;
        this.firemode = firemode;
        this.firerate = firerate;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFiremode() {
        return firemode;
    }

    public void setFiremode(String firemode) {
        this.firemode = firemode;
    }

    public String getFirerate() {
        return firerate;
    }

    public void setFirerate(String firerate) {
        this.firerate = firerate;
    }

    public String getWallpenetration() {
        return wallpenetration;
    }

    public void setWallpenetration(String wallpenetration) {
        this.wallpenetration = wallpenetration;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
