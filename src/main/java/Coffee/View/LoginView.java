/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coffee.View;

import Coffee.Controller.OrderController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ranxl
 */
public class LoginView {
    private JFrame frame;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JTextField fieldUsername;
    private JPasswordField fieldPassword;
    private JButton btnLogin;
    private OrderController orderController;

    public LoginView(OrderController orderController) {
        this.orderController = orderController; 
        initialize();
    }

    public void initialize() {
      
        frame = new JFrame("Login - Coffee System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(1, 2)); 
        
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
        frame.setIconImage(icon.getImage());
        
        panelLeft = new JPanel();
        panelLeft.setBackground(Color.LIGHT_GRAY); 
        
        ImageIcon coffeeImage = new ImageIcon("coffee.jpg");
        JLabel coffeeLabel = new JLabel(coffeeImage);
        panelLeft.add(coffeeLabel);
       
        
        panelRight = new JPanel();
        panelRight.setLayout(new GridBagLayout()); 
        panelRight.setBackground(Color.decode("#C29A71"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

       
        ImageIcon loginIcon = new ImageIcon("login.png"); 
        JLabel loginImageLabel = new JLabel(loginIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelRight.add(loginImageLabel, gbc);

       
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setForeground(Color.white);
        labelUsername.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelRight.add(labelUsername, gbc);

        fieldUsername = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelRight.add(fieldUsername, gbc);

       
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setForeground(Color.white);
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelRight.add(labelPassword, gbc);

        fieldPassword = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelRight.add(fieldPassword, gbc);

       
        btnLogin = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelRight.add(btnLogin, gbc);

       
        frame.add(panelLeft);
        frame.add(panelRight);

        frame.setVisible(true);
    }

   
    public JFrame getFrame() {
        return frame;
    }

    public JTextField getFieldUsername() {
        return fieldUsername;
    }

    public JPasswordField getFieldPassword() {
        return fieldPassword;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }
}