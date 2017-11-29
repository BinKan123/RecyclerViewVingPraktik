package com.example.kanbi.recyclerviewmvvm.searchBar;

/**
 * Created by 5261 on 2017-11-07.
 */



public class searchModel {


    private String hotelName;
    private String hotelType;
    private String hotelImgURL;
   // private String hotelRating;
    private String hotelDetails;
    private String webURL;

    public searchModel( String hotelName,String hotelType,String hotelRating, String hotelImgURL, String hotelDetails, String webURL) {
        this.hotelImgURL = hotelImgURL;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
      //  this.hotelRating = hotelRating;
        this.hotelDetails = hotelDetails;
        this.webURL = webURL;
    }

 /*   public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }*/

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





