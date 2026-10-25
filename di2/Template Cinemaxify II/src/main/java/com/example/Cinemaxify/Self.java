
package com.example.Cinemaxify;

public class Self implements User {

    private String name;
    private int age;
    private Long contact;
    private String address;
    private Plan plan;

    public Self(Plan plan) {
        this.plan = plan;
    }

    @Override
    public void setUserDetails(String name, int age, Long contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public void getUserDetails() {
        System.out.println("Hello " + name
                + " you have entered the following details:");
        System.out.println("age: " + age
                + "\ncontact: " + contact
                + "\naddress: " + address);
        System.out.println("Plan: " + plan.getPlanName());
    }

    @Override
    public Plan getUserPlan() {
        return plan;
    }
}


