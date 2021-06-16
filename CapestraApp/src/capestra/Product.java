/*****************************************************
*Author: Marx Young, Capella University              * 
*Course: ITEC 5020-Database & App Development        *   
*Assignment: Course Project - Capestra Order Entry   *   
*File: Product.java                              *   
*Description: Main program for Capestra              *   
*Input: Reads from MySQL database                    *   
*Output: Updates MySQL database                      *   
*Created: 8/02/2020                                  *  
******************************************************/

package capestra;

public class Product {
    private int id_product;
    private String product_name;
    private String product_description;
    private String unit_price;
    private int category_key;
    private String quantity;

    public Product() {
    }

    Product(int id_product, String productName, String productDescription, String unitPrice, int categoryKey, String quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public int getCategory_key() {
        return category_key;
    }

    public void setCategory_key(int category_key) {
        this.category_key = category_key;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id_product=" + id_product + ", product_name=" + product_name + ", product_description=" + product_description + ", unit_price=" + unit_price + ", category_key=" + category_key + ", quantity=" + quantity + '}';
    }


    }
    
    
    

    
  
    
    


