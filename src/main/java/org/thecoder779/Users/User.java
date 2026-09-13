package org.thecoder779.Users;

class User {
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        IO.print("NEW ");
        display();
    }

    public void display(){
        System.out.println("USER: " + username + ", " + password);
    }
}
