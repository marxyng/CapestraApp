/*****************************************************
*Author: Marx Young, Capella University              * 
*Course: ITEC 5020-Database & App Development        *   
*Assignment: Course Project - Capestra Order Entry   *   
*File: Order.java                              *   
*Description: Main program for Capestra              *   
*Input: Reads from MySQL database                    *   
*Output: Updates MySQL database                      *   
*Created: 8/02/2020                                  *  
******************************************************/
package capestra;

/**
 *
 * @author Owner
 */
public class Order {
         private int id;
    private String order_date;
    private String status;
    private int customer_id;
    
    
    
    

    public Order(int id, String order_date, String status, int customer_id) {
        this.id = id;
        this.order_date = order_date;
        this.status = status;
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", order_date=" + order_date + ", status=" + status + ", customer_id=" + customer_id + '}';
    }
    
    
    
    
    
}



    

