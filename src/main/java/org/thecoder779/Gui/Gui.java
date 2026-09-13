package org.thecoder779.Gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class Gui {
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    final int WIDTH = 600;
    final int HEIGHT = 600;

    JFrame frame;

    public Gui(String name){
        FlatMTAtomOneDarkIJTheme.setup();

        SwingUtilities.invokeLater(() -> {
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
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(
                            Arrays.equals(passwordField.getPassword(), "ss".toCharArray()) &&
                            (textField.getText().equals("sss"))
                    ){
                        System.out.println("login successful");
                    }
                }
            });
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
        });
    }
}
