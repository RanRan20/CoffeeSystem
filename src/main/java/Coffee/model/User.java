/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coffee.model;

/**
 *
 * @author ranxl
 */
public class User {
    private String name;
    private String password;
    
    
    public User(String name, String password){
        this.name = name;
        this.password = password;
        
    }
    
     public boolean validate(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }
}
