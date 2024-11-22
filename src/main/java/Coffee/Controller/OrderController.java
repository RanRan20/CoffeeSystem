/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coffee.Controller;

import Coffee.model.Coffee;
import Coffee.model.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranxl
 */
public class OrderController {

    private List<Order> listOrder = new ArrayList<>();

    public void AddOrder(Order order) {
        listOrder.add(order);
    }

    public void removeOrder(int ind) {
        if (ind >= 0 && ind < listOrder.size()) {
            listOrder.remove(ind);
            System.out.println("Order removed");
        } else {
            System.out.println("Invalid index");
        }
    }
    
    public void updateOrder(int ind, Order updatedOrder) {
        if (ind >= 0 && ind < listOrder.size()) {
            listOrder.set(ind, updatedOrder);
            System.out.println("Order updated");
        } else {
            System.out.println("Invalid index");
        }
    }

    public List<Order> showOrders() {
        return listOrder;
    }
}