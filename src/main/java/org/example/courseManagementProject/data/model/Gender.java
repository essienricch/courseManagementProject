package org.example.courseManagementProject.data.model;

public enum Gender {

    MALE(1),
    FEMALE(2);


    private int gender;

    Gender(int gender){
        this.gender = gender;
    }

    public int getGender(){
        return this.gender;
    }
}
