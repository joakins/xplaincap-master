package com.xplaincap;

/**
 * Created by User on 27/05/2018.
 */

public class Books {

    private String name;
    private String description;
    private String image;


    public Books(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;

    }

    public Books(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
