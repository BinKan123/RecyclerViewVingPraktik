package com.example.kanbi.recyclerviewmvvm.searchBar;

/**
 * Created by 5261 on 2017-11-07.
 */

/*
//Test for String array
public class searchModel {
    private final String mText;

    public searchModel(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

}*/


public class searchModel {


    private String hotelName;
    private String hotelType;
    private String hotelImgURL;
    //private String hotelStar;
    private String hotelDetails;
    private String webURL;

    public searchModel( String hotelName,String hotelType, String hotelImgURL, String hotelDetails, String webURL) {
        this.hotelImgURL = hotelImgURL;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
       // this.hotelStar = hotelStar;
        this.hotelDetails = hotelDetails;
        this.webURL = webURL;
    }

    public String getHotelImgURL() {
        return hotelImgURL;
    }

    public void setHotelImgURL(String hotelImgURL) {
        this.hotelImgURL = hotelImgURL;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    /*public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }*/

    public String getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(String hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String newURL) {
        this.webURL = newURL;
    }

}





