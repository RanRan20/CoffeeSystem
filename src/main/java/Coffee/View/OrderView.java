/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coffee.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Coffee.Controller.OrderController;
import Coffee.model.Coffee;
import Coffee.model.Order;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import Coffee.Controller.OrderController;
import java.awt.Image;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author ranxl
 */
public class OrderView {

    private JFrame frame;
    private JPanel panelRight; 
    private JPanel panelLeft;  
    private JTextField fieldCoffeeName;
    private JTextField fieldPrice;
    private JTextField fieldClient;
    private DefaultListModel<String> modelListOrder;  
    private JList<String> listOrder;
    private OrderController orderController;
    private int selectedIndex = -1;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;

    public OrderView(OrderController orderController) {
        this.orderController = orderController;
        initialize();
    }

    public void initialize() {

        frame = new JFrame("Coffee System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
        frame.setIconImage(icon.getImage());

        panelRight = new JPanel(new GridBagLayout());
        panelRight.setBackground(Color.decode("#9A7959")); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel labelNameCoffee = new JLabel("Name of coffee:");
        fieldCoffeeName = new JTextField(15);
        JLabel labelPriceCoffee = new JLabel("Price:");
        fieldPrice = new JTextField(15);
        JLabel labelClient = new JLabel("Client:");
        fieldClient = new JTextField(15);

        panelRight.add(labelNameCoffee, gbc);
        gbc.gridy++;
        panelRight.add(fieldCoffeeName, gbc);
        gbc.gridy++;
        panelRight.add(labelPriceCoffee, gbc);
        gbc.gridy++;
        panelRight.add(fieldPrice, gbc);
        gbc.gridy++;
        panelRight.add(labelClient, gbc);
        gbc.gridy++;
        panelRight.add(fieldClient, gbc);

        addButton = new JButton("Add Order");
        gbc.gridy++;
        panelRight.add(addButton, gbc); 
        
        deleteButton = new JButton("Delete");
        gbc.gridy++;
        panelRight.add(deleteButton, gbc);
        
        editButton = new JButton("Edit Order");  
        gbc.gridy++;
        panelRight.add(editButton, gbc); 

        panelLeft = new JPanel(new BorderLayout());
        panelLeft.setBackground(Color.decode("#C29A71")); 

        modelListOrder = new DefaultListModel<>();
        listOrder = new JList<>(modelListOrder);
        listOrder.setBackground(Color.decode("#C29A71")); 

        JScrollPane scrollPane = new JScrollPane(listOrder);
        scrollPane.setBackground(Color.decode("#B7906A")); 
        scrollPane.getViewport().setBackground(Color.decode("#B7906A")); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        panelLeft.add(new JLabel("Orders", JLabel.CENTER), BorderLayout.NORTH);
        panelLeft.add(scrollPane, BorderLayout.CENTER);

        frame.add(panelRight, BorderLayout.EAST);  
        frame.add(panelLeft, BorderLayout.CENTER); 

        frame.setVisible(true);

        
        listOrder.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectedIndex = listOrder.getSelectedIndex();
                if (selectedIndex != -1) {
                    Order selectedOrder = orderController.showOrders().get(selectedIndex);
                    fieldCoffeeName.setText(selectedOrder.getCoffee().getName());
                    fieldPrice.setText(String.valueOf(selectedOrder.getCoffee().getPrice()));
                    fieldClient.setText(selectedOrder.getClient());
                }
            }
        });
    }

    private void saveOrderToFile(Order order) {
        File folder = new File("orders");
        if (!folder.exists()) {
            folder.mkdir();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(new Date());
        String fileName = "orders-" + date + ".txt";
        File file = new File(folder, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(order.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    private void updateOrderInFile() {
        File folder = new File("orders");
        if (!folder.exists()) {
            folder.mkdir();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(new Date());
        String fileName = "orders-" + date + ".txt";
        File file = new File(folder, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < modelListOrder.size(); i++) {
                writer.write(orderController.showOrders().get(i).toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    


