package com.rzzkan.sistempakar;

/**
 * Created by Rzzkan on 28/10/2020.
 */
public class Score {
    String name;
    Double value;

    public Score(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
