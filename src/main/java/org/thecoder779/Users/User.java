package org.thecoder779.Users;

public class User {
    private String username;

    protected String getUsername() {
        return username;
    }

    private final int ID;

    protected int getID() {
        return ID;
    }

    protected String password;

    protected String getPassword() {
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

    public boolean checkCredentials(String uname, String pswd){
        return uname.equals(username) && pswd.equals(password);
    }
}
