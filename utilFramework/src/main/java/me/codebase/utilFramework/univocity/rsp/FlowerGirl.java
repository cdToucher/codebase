package me.codebase.utilFramework.univocity.rsp;

import com.univocity.parsers.annotations.Parsed;


public class FlowerGirl {

    @Parsed(index = 2)
    private String gender;

    @Parsed
    private String name;

    @Parsed
    private Integer age;

    @Parsed
    private String placeOfProduction;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPlaceOfProduction() {
        return placeOfProduction;
    }

    public void setPlaceOfProduction(String placeOfProduction) {
        this.placeOfProduction = placeOfProduction;
    }

}
