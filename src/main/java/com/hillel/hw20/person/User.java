package com.hillel.hw20.person;

public class User extends Entity {
    private String username;
    private Role role;
    private String password;

    public User() {

    }

    public User(String username, String password) {

        this.username = username;

        this.password = password;
    }

    public User(int id, String username, Role role, String password) {
        super(id);
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
