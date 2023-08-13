package io.captivecow.jchat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatGui {

    private JFrame frame;

    public ChatGui(){}

    public void createAndShowGui(){
        frame = new JFrame("JChat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel connectMainPanel = new JPanel(new GridBagLayout());
        connectMainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel nameLabel = new JLabel("<html><B>Name:</B></html>", JLabel.CENTER);
        JTextField nameTextField = new JTextField(10);
        JButton connectButton = new JButton("Connect");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 0, 5);
        connectMainPanel.add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        connectMainPanel.add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        connectMainPanel.add(connectButton, constraints);

        frame.setContentPane(connectMainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
