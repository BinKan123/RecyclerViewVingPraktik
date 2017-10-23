package com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView;

/**
 * Created by 5261 on 2017-10-23.
 */

public class climateData {
    private String destination;
    private String sunHours;
    private String waterTemp;
    private String heighTemp;
    private String lowTemp;
    private String newURL;

    public climateData(String destionation, String sunHours, String waterTemp, String heighTemp,String lowTemp,String newURL){
        this.destination=destionation;
        this.sunHours=sunHours;
        this.waterTemp=waterTemp;
        this.heighTemp=heighTemp;
        this.lowTemp=lowTemp;
        this.newURL=newURL;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSunHours() {
        return sunHours;
    }

    public void setSunHours(String sunHours) {
        this.sunHours = sunHours;
    }

    public String getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(String waterTemp) {
        this.waterTemp = waterTemp;
    }

    public String getHeighTemp() {
        return heighTemp;
    }

    public void setHeighTemp(String heighTemp) {
        this.heighTemp = heighTemp;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getNewURL() {
        return newURL;
    }

    public void setNewURL(String newURL) {
        this.newURL = newURL;
    }
}
