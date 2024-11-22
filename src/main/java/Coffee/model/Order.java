/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coffee.model;

/**
 *
 * @author ranxl
 */
public class Order {
    private Coffee coffee;
    private String client;
    
    
    public Order(Coffee coffee, String client) {
        this.coffee = coffee;
        this.client = client;
    }
    
    public Coffee getCoffee(){
        return coffee;
    }
    
    public void setCoffee(Coffee coffee){
        this.coffee = coffee;
    }
    
    public String getClient(){
        return client;
    }
    
    public void setClient(String client){
        this.client = client;
    }
    
    public String toString() {
        return "Coffee: " + coffee.getName() + ", Price: " + coffee.getPrice() + ", Client: " + client;
    }
    
}
