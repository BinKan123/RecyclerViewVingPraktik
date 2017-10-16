package com.example.kanbi.recyclerviewmvvm.inspirationBooking;

/**
 * Created by kanbi on 15/10/2017.
 */

public class hotelDataSet {

        private String hotelImgURL;
        private String hotelGroup;
        private String hotelType;
        private String hotelDetails;
        private String newURL;

    public hotelDataSet(String hotelImgURL, String hotelGroup, String hotelType, String hotelDetails,String newURL){
        this.hotelImgURL=hotelImgURL;
        this.hotelGroup=hotelGroup;
        this.hotelType=hotelType;
        this.hotelDetails=hotelDetails;
        this.newURL=newURL;
    }

    public String getNewURL() {
        return newURL;
    }

    public void setNewURL(String newURL) {
        this.newURL = newURL;
    }

    public String getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(String hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public String getHotelGroup() {
        return hotelGroup;
    }

    public void setHotelGroup(String hotelGroup) {
        this.hotelGroup = hotelGroup;
    }

    public String getHotelImgURL() {
        return hotelImgURL;
    }

    public void setHotelImgURL(String hotelImgURL) {
        this.hotelImgURL = hotelImgURL;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }
}

