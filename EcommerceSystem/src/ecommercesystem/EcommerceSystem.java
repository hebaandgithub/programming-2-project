/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package ecommercesystem;
import java.util.Scanner;
public class EcommerceSystem {
    public static void main(String[] args) {
        ElectronicProduct electronicproduct = new ElectronicProduct("smartphone", 1, 1, "Samsung", 599.99f);
        ClothingProduct clothingproduct = new ClothingProduct("Medium","Cotton", 2,"T-shirt", 19.99f);
        BookProduct bookproduct = new BookProduct("O’Reilly", "X Publications", 3,"OOP", 39.99f );
        
        Scanner cs=new Scanner(System.in);
        
        System.out.println("Welcome to the E-Commerce System!");
        System.out.println("Please enter your ID:");
        int id=cs.nextInt();
        cs.nextLine();
        
        System.out.println("Please enter your name:");
        String name=cs.nextLine();
        
        System.out.println("Please enter your address:");
        String address=cs.nextLine();
                
        System.out.println("How many products you want to add to your cart?");
        int nProducts=cs.nextInt();
        Product[] products = new Product[nProducts];
        
        Customer customer = new Customer(id, name, address);
        Cart cart = new Cart(id, nProducts, products);
        
        for (int i=0; i<nProducts; i++) {
            System.out.println("Which product would you like to add? 1- Smartphones 2- T-shirt 3- OOP");
            int choice = cs.nextInt();
            cs.nextLine(); 
            switch (choice) {
                case 1:
                    cart.addProduct(electronicproduct);
                    break;
                case 2:
                    cart.addProduct(clothingproduct);
                    break;
                case 3:
                    cart.addProduct(bookproduct);
                    break;
                default:
                    System.out.println("Invalid choice!,choose from 1 to 3.");
                    i--;
                    continue;
            }
        }
            float totalPrice = cart.calculatePrice();
            System.out.println("Your total is $"+totalPrice+" Would you like to place the order? 1-Yes 2- No");
            int choice=cs.nextInt();
            if(choice==1){
                Order order=new Order(customer.getCustomerId(),1,cart.getProducts(),cart.calculatePrice());
                order.printOrderInfo();
                cart.placeOrder();
            }else 
                System.out.println("Order wasn't placed");
            System.out.println("Would you like to remove a product from your cart? 1-Yes 2- No");
            
        int removeChoice = cs.nextInt();
        if (removeChoice == 1) {
            System.out.println("Enter the index of the product you want to remove:");
            int indexToRemove = cs.nextInt();
            cart.removeProduct(indexToRemove);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("No products were removed.");
        }
    }
}
