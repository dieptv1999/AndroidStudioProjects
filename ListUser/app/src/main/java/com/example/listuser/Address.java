package com.example.listuser;

import com.google.gson.annotations.SerializedName;

public class Address {
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    @SerializedName("geo")
    public geometry geo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public geometry getGeo() {
        return geo;
    }

    public void setGeo(geometry geo) {
        this.geo = geo;
    }
}
