package com.mint.disignpattern.jdk;

public class PersonBeanImpl implements PersonBean{
    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount = 0;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public double getHostOrNotRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return rating * 1.0 / ratingCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHostOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}
