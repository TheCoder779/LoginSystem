package org.thecoder779.Users;

class User {
    private String username;

    public int getID() {
        return ID;
    }

    private final int ID;
    private String password;

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
