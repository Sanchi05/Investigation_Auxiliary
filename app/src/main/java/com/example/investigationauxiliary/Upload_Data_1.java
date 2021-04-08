package com.example.investigationauxiliary;

public class Upload_Data_1 {

    String imgDetails;
    Integer img_no;

    public Upload_Data_1(){

    }
    public Upload_Data_1(String imgDetails, Integer img_no) {
        this.imgDetails = imgDetails;
        this.img_no = img_no;
    }

    public String getImgDetails() {
        return imgDetails;
    }

    public void setImgDetails(String imgDetails) {
        this.imgDetails = imgDetails;
    }

    public Integer getImg_no() {
        return img_no;
    }

    public void setImg_no(Integer img_no) {
        this.img_no = img_no;
    }
}
