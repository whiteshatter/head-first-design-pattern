package com.mint.disignpattern.jdk;

public interface PersonBean {
    String getName();
    String getGender();
    String getInterests();
    double getHostOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHostOrNotRating(int rating);
}
