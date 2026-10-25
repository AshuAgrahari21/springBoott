
package com.example.Customers;

public class QueryDepartment implements CustomerCare {

    private String department = "Query Department";
    private String customerName;
    private String issue;
    private double refId;

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public void getService() {
        System.out.println("Welcome " + customerName
                + ", you have reached the query department.");
        System.out.println("Please describe your issue:");
    }

    @Override
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    @Override
    public void setProblem(String problem) {
        this.issue = problem;
        this.refId = 100000 + Math.random() * 900000;
    }

    @Override
    public void getProblem() {
        System.out.println("Dear " + customerName
                + ", your issue '" + issue
                + "' is registered with Query Department.");
        System.out.println("Reference ID: "
                + String.format("%.0f", refId));
    }
}
