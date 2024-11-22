/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coffee.Controller;

import Coffee.View.LoginView;
import Coffee.View.OrderView;
import Coffee.model.User;
import javax.swing.JOptionPane;
import Coffee.Controller.OrderController;
/**
 *
 * @author ranxl
 */
public class LoginController {
    private LoginView loginView;
    private User adminUser;
    private OrderController orderController;
    
    public LoginController(OrderController orderController) {
        this.orderController = orderController; 
        loginView = new LoginView(orderController); 
        adminUser = new User("admin", "admin4321"); 

       
        loginView.getBtnLogin().addActionListener(e -> loginUser());
    }
    
    private void loginUser() {
        String username = loginView.getFieldUsername().getText();
        String password = new String(loginView.getFieldPassword().getPassword());

        
        if (adminUser.validate(username, password)) {
            JOptionPane.showMessageDialog(null, "Login successful");
            loginView.getFrame().setVisible(false); 
            new OrderView(orderController);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid login, try again.");
        }
    }
}