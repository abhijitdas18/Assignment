package com.abhi.csvprocess;

public class Employee {
    private int userId;
    private String userName;

    private  String email;
    private String location;
    private String organization;

    public Employee(int userId, String userName, String email, String location, String organization) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.location = location;
        this.organization = organization;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (userId != employee.userId) return false;
        if (!userName.equals(employee.userName)) return false;
        if (!email.equals(employee.email)) return false;
        if (!location.equals(employee.location)) return false;
        return organization.equals(employee.organization);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + userName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + organization.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
