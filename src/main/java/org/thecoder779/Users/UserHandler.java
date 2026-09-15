package org.thecoder779.Users;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class UserHandler {
    private ArrayList<User> users;
    private Scanner scanner;
    File userFile = new File("db/USERS.txt");

    public UserHandler() throws FileNotFoundException {
        users = new ArrayList<>();
        scanner = new Scanner(userFile);
        updateUsers();
    }

    private void updateUsers(){
        Path path = Paths.get("db/USERS.txt");

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
        while (!(line[i] == ';')){
            password.append(line[i]);
            i++;
        }

        User user = new User(username.toString(), password.toString(), Integer.parseInt(ID.toString()));
        users.add(user);
    }
}
