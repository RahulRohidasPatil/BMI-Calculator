package com.rahulpatil.bmi.models;

public class BmiModel {
    int id;
    String name;
    float weight;
    float height;
    float bmi;
    
    public BmiModel(int id, String name, float weight, float height, float bmi) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return "BmiModel [id=" + id + ", name=" + name + ", weight=" + weight + ", height=" + height + ", bmi=" + bmi
                + "]";
    }
}
