package com.example.testing.model;

public class Anime {
    private String name;
    private String  description;
    private  String rating;
    private String dateReleased;
    private  String categories;
    private String studio;
    private String image_url;

    public Anime(){};

    public Anime(String name, String description, String rating, String dateReleased, String categories, String studio, String image_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.dateReleased=dateReleased;
        this.categories = categories;
        this.studio = studio;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }


    public String getCategories() {
        return categories;
    }

    public String getStudio() {
        return studio;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
