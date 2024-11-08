package com.example.project.model;

public class Courier extends Person {
    boolean available;
    double rate;

    Courier(String surname, String name, boolean available, double rate) {
        this.name = name;
        this.surname = surname;
        this.available = available;
        this.rate = rate;
    }

    public Courier() {
    }
}
