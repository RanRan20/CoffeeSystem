/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Coffee;

import Coffee.Controller.LoginController;
import Coffee.Controller.OrderController;
import Coffee.View.LoginView;
import Coffee.View.OrderView;

/**
 *
 * @author ranxl
 * @version 1.0
 */
public class CoffeeSystem {

    
    public static void main(String[] args) {
         
       OrderController orderController = new OrderController();
       LoginController loginController = new LoginController(orderController);
       
    }
}
