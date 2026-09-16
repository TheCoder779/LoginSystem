package org.thecoder779.Users;

public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    private final int ID;

    public int getID() {
        return ID;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public User(String username, String password, int ID){
        this.username = username;
        this.password = password;
        this.ID = ID;
        IO.print("NEW ");
        display();
    }

    private void display(){
        System.out.println("USER " + ID +": " + username + ", " + password);
    }
}
