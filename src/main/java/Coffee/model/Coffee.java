/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coffee.model;

/**
 *
 * @author ranxl
 */
public class Coffee {
     private String name;
     private Double price;
     
     public Coffee(String name, Double price){
         this.name = name;
         this.price = price;
     }
     
     public String getName(){
         return name;
     }
     
     public void SetName(String name){
         this.name = name;
     }
     
     public Double getPrice(){
         return price;
     }
     
     public void setPrice(Double price){
         this.price = price;
     }
     
}
