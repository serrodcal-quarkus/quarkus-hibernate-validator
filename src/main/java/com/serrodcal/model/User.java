package com.serrodcal.model;

public class User {

    private Long id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean admin;
    private String hashedPassword;

    public User() { }

    public User(Long id, String email, String username, String firstName, String lastName, Boolean admin, String hashedPassword) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.hashedPassword = hashedPassword;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

}
