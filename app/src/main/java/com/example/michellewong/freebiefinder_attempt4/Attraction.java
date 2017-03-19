package com.example.michellewong.freebiefinder_attempt4;

/**
 * Created by michellewong on 2017-03-19.
 */

public class Attraction {
    private long id;
    private String name;
    private float latitude;
    private float longitude;
    private Type type;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public enum Type {
        BUSINESS,
        ARTS,
        TECH,
        HEALTH,
        FOOD,
        SPORTS,
        SOCIAL,
        OTHER,
        GAME
    }
}
