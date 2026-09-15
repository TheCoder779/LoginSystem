package org.thecoder779.Gui;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;
import org.thecoder779.Users.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class LoginGui implements Runnable {
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private UserHandler userHandler;

    final int WIDTH = 400;
    final int HEIGHT = 400;



    private Thread thread;

    JFrame frame;

    public LoginGui(String name) throws FileNotFoundException {
        userHandler = new UserHandler();
        //Set up the atom one dark theme
        FlatArcDarkOrangeIJTheme.setup();

        /*
        * JComponent Initialization
        *
        *
        *
        * */
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
        /*loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (
                        Arrays.equals(passwordField.getPassword(), "ss".toCharArray()) &&
                                (textField.getText().equals("sss"))
                ) {
                    System.out.println("login successful");
                }
            }
        });*/
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

        try {
            userHandler = new UserHandler();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Start the thread
        startThread();
    }

    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            if(i % 1000000000 == 0) System.out.println("running thread");
            i++;
        }
    }

    public void startThread(){
        if(this.thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
}
