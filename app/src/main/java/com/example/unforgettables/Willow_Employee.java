package com.example.unforgettables;

public class Willow_Employee {

    String url;
    String first_name;
    String last_name;

    public Willow_Employee(String fn, String ln, String link){
        this.url = url;
        this.first_name = fn;
        this.last_name = ln;

    }

    public String get_first_name(){
        return this.first_name;

    }

    public String get_last_name(){
        return this.last_name;
    }

    public String get_img_url(){
        return this.url;
    }
}
