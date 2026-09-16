package org.thecoder779.Users;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class UserHandler {
    private ArrayList<User> users;
    private final Path path = Paths.get("db/USERS.txt");

    public UserHandler() throws FileNotFoundException {
        users = new ArrayList<>();
        updateUsers();
    }

    private void updateUsers(){
        try {
            // 1. Read all lines from the file
            List<String> lines = Files.readAllLines(path);

            // 3. Write the modified lines back to the file
            //Files.write(path, lines);

            for (int i = 0; i < lines.size(); i++) {
                addUser(lines.get(i).toCharArray());
            }

        } catch (IOException e) {
            System.err.println("An error occurred while editing the file: " + e.getMessage());
        }
    }


    public User findUser(String uname){
        for (User user : users) {
            if (uname.equals(user.getUsername())) {
                return user;
            }
        }
        System.out.println("ERROR - could not find user");
        return null;
    }

    /**
     * Updates DB/users.txt
     */
    private void createUser(String uname, String pswd){
        int ID = users.getLast().getID();

    }
    /**
     * Updates the user array
     */
    private void addUser(char[] line){
        users = new ArrayList<>();
        int i = 0;

        StringBuilder username = new StringBuilder();
        StringBuilder ID = new StringBuilder();
        StringBuilder password = new StringBuilder();

        while (!(line[i] == ' ')){
            i++;
        }
        i++;
        while (!(line[i] == ' ')){
            ID.append(line[i]);
            i++;
        }
        i++;
        while (!(line[i] == ' ')){
            username.append(line[i]);
            i++;
        }
        i++;
        while (!(line[i] == ';')) {
            password.append(line[i]);
            i++;
        }

        User user = new User(username.toString(), password.toString(), Integer.parseInt(ID.toString()));
        users.add(user);
    }
}
