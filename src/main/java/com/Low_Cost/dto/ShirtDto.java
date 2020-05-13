package com.Low_Cost.dto;

/**
 * Created by Study on 30.06.2017.
 */
public class ShirtDto {

    private int id;
    private String shirtName;
    private String pathImage;

    public ShirtDto(){
    }

    public ShirtDto(int id, String shirtName, String pathImage) {
        this.id = id;
        this.shirtName = shirtName;
        this.pathImage = pathImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShirtName() {
        return shirtName;
    }

    public void setShirtName(String shirtName) {
        this.shirtName = shirtName;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
