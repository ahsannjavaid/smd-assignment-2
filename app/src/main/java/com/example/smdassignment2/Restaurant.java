package com.example.smdassignment2;

public class Restaurant {
    private String rating;
    private String name;
    private String location;
    private String phone;
    private String description;

    public Restaurant(String rating, String name, String location, String phone, String description) {
        this.rating = rating;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
