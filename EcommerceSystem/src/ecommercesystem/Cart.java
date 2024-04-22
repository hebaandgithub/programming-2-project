/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package ecommercesystem;
public class Cart {
    private int customerId;
    private int nProducts;
    private Product[] products;

    public Cart(int customerId, int nProducts, Product[] products) {
        this.customerId = Math.abs(customerId);
        this.nProducts = Math.abs(nProducts);
        this.products = products;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int Id) {
       if (Id>0){
            customerId=Id;
        }
        else {
            customerId= Math.abs(Id);
        }
    }
    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int n) {
       if (n>0){
            nProducts=n;
        }
        else {
            nProducts= Math.abs(n);
        }
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    public void addProduct (Product pr){
        for(int i =0 ; i<products.length ;i++){
            if (products[i]==null){
                products[i]=pr;
                break;
            }
        }
    }
    public void removeProduct(int index) {if (index >= 0 && index < nProducts) {
        for (int i = index; i < nProducts - 1; i++) {
            products[i] = products[i + 1];
        }
        products[nProducts - 1] = null;
        nProducts--;
        
    } else {
        System.out.println("Invalid index. Product not removed.");
    }
    }
    public float calculatePrice(){
        float totalPrice=0;
        for(int i =0; i<nProducts;i++){
            totalPrice+= products[i].getPrice();
        }
        return totalPrice;
    }
    
    public void placeOrder(){
        System.out.println("your order is placed successfully!");
    }
}
    

