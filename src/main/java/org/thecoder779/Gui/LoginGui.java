package org.thecoder779.Gui;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import org.thecoder779.Users.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class LoginGui implements Runnable {
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private ActionListener actionlistener;

    private boolean credentialsCorrect = false;

    private UserHandler userHandler;

    final int WIDTH = 400;
    final int HEIGHT = 400;

    final int UPDATE_TIME = 60;

    private Thread thread;

    JFrame frame;

    public LoginGui(String name) throws FileNotFoundException {
        try {
            userHandler = new UserHandler();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Set up the atom one dark theme
        FlatArcDarkOrangeIJTheme.setup();

        /*
        * JComponent Initialization
        */
        //Object initialization
        frame = new JFrame(name);
        panel = new JPanel(new GridBagLayout(), true);
        GridBagConstraints constraints = new GridBagConstraints();

        //Constraint setting
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.NONE;

        //Username Label
        JLabel label1 = new JLabel("Username");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 8;
        panel.add(label1, constraints);

        //Username Input
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 8;
        panel.add(textField, constraints);

        //Password Label
        JLabel label2 = new JLabel("Password");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 8;
        panel.add(label2, constraints);

        //Password Input
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 8;
        panel.add(passwordField, constraints);

        //Login Button
        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(80, 30));

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.weightx = 0.1;
        panel.add(loginButton, constraints);

        //JFrame setup
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(frame.getX() - WIDTH / 2, frame.getY() - HEIGHT / 2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
        //Start the thread
        startThread();

        loginButton.addActionListener((ActionEvent e) -> {
            if(credentialsCorrect) {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }
        });
    }

    @Override
    public void run() {
        while (!thread.isInterrupted()){
            long time = System.nanoTime();
            long wantedTime = time + (long) 1.0e9 / UPDATE_TIME;
            try {
                Thread.sleep((wantedTime - System.nanoTime()) / 1000000);
                update();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update(){
        User user = userHandler.findUser(textField.getText());
        if (user!=null) {
            System.out.println("User found");
            if(textField.getText().equals(user.getUsername())){
                if (Arrays.equals(passwordField.getPassword(), user.getPassword().toCharArray())){
                    System.out.println("User pswd match");
                    credentialsCorrect = true;
                }
            }
        }

    }

    public void startThread(){
        if(this.thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
}
