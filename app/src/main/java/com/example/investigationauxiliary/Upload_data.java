package com.example.investigationauxiliary;

public class Upload_data {
    public String imageName;
    public String imageURL;
    public Upload_data(){}

    public Upload_data(String name, String url) {
        this.imageName = name;
        this.imageURL = url;
    }

    public String getImageName() {
        return imageName;
    }
    public String getImageURL() {
        return imageURL;
    }
}

