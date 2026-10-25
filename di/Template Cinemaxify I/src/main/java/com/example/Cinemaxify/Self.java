
package com.example.Cinemaxify;

// Implement the User interface
public class Self implements User {

    private String name;
    private String memberName = "self";
    private int age;
    private Long contact;
    private String address;

    @Override
    public void setUserDetails(
            String name, int age, Long contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public void getUserDetails() {
        System.out.println("Name: " + name);
        System.out.println("Member Type: " + memberName);
        System.out.println("Age: " + age);
        System.out.println("Contact: " + contact);
        System.out.println("Address: " + address);
    }
}
