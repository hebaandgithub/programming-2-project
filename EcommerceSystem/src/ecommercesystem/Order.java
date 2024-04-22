/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommercesystem;


public class Order {
    private int customerId;
    private int orderId;
    private Product[]products;
    private float totalPrice;

    public Order(int customerId, int orderId ,Product[] products, float totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = Math.abs(totalPrice);
    }
    
    public void printOrderInfo(){
        System.out.println("Here's your order's summary:");
        System.out.println("Order's ID: "+orderId);
        System.out.println("Custommer's ID: "+customerId);
        System.out.println("Products: ");
         for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        }
        System.out.println("Total price: $" + totalPrice);
    }

}
