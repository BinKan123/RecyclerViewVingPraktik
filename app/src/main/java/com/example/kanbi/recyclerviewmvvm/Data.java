package com.example.kanbi.recyclerviewmvvm;

/**
 * Created by kanbi on 05/10/2017.
 */

public class Data {
    private String imageURL;
    private String text;
    private String details;

    public Data (String text,String imageURL,String details){
        this.text=text;
        this.imageURL=imageURL;
        this.details=details;
    }


//testryshsdfhsfhsfdh


    public String getText(){
        return text;
    }

    public String getImageURL(){
        return imageURL;
    }

    public String getDetails(){
        return details;
    }

    public void setText(String text){
        this.text=text;

    }

    public void setImageURL(String imageURL){
        this.imageURL= imageURL;
    }

    public void setDetails(String imageURL){
        this.details= imageURL;
    }



}
