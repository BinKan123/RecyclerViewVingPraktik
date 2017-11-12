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

    private String hotelImgURL;
    private String hotelName;
    private String hotelStar;
    private String hotelDetails;
    private String webURL;

    public searchModel(String hotelImgURL, String hotelName, String hotelStar, String hotelDetails, String webURL) {
        this.hotelImgURL = hotelImgURL;
        this.hotelName = hotelName;
        this.hotelStar = hotelStar;
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

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

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





