package io.captivecow.jchat.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JChatView implements Runnable, ModelObserver {

    private JFrame frame;
    private ChatController controller;
    private JPanel loginPanel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JButton connectButton;

    public JChatView(ChatController controller){
        this.controller = controller;
        frame = new JFrame("JChat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void createAndShowLoginView(){
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints constraints = new GridBagConstraints();

        nameLabel = new JLabel("<html><B>Name:</B></html>", JLabel.CENTER);
        nameTextField = new JTextField(10);
        nameTextField.setTransferHandler(null);
        nameTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (nameTextField.getText().length() >= 10 ){
                    e.consume();
                }
            }
        });

        connectButton = new JButton("Connect");
        connectButton.addActionListener(e -> controller.connect());


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 0, 5);
        loginPanel.add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        loginPanel.add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        loginPanel.add(connectButton, constraints);

        frame.setContentPane(loginPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void setConnectingView(){
        connectButton.setEnabled(false);
        nameTextField.setEnabled(false);
        nameTextField.setEditable(false);
    }

    @Override
    public void run() {
        createAndShowLoginView();
    }

    @Override
    public void updateState(ChatState state) {
        state.update(this);
    }
}
