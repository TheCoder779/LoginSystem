package org.thecoder779.Users;

import java.io.*;
import java.util.*;

public class UserHandler {
    private ArrayList<User> users;
    private Scanner scanner;
    File userFile = new File("src/main/resources/USERS.txt");

    public UserHandler() throws FileNotFoundException {
        users = new ArrayList<>();
        scanner = new Scanner(userFile);
        updateUsers();
    }

    private void updateUsers(){
        users = new ArrayList<>();

        while(!scanner.nextLine().equals("END")){
            if(scanner.nextLine().contains("USER")){
                String name = scanner.nextLine();
                String pswd = scanner.nextLine();
                users.add(new User(name, pswd));
            }
        }
    }
}
