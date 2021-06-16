/** ***************************************************
 *Author: Marx Young, Capella University              *
 *Course: ITEC 5020-Database & App Development        *
 *Assignment: Course Project - Capestra Order Entry   *
 *File: CapestraDB.java                              *
 *Description: Main program for Capestra              *
 *Input: Reads from MySQL database                    *
 *Output: Updates MySQL database                      *
 *Created: 8/02/2020                                  *
 ***************************************************** */
package capestra;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Vincent
 */
public class CapestraDB {

    private Statement stmt;
    private Connection connection;

    private void initializeDB() {
        try {
            //load the appropriate driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            String connectionName = "jdbc:mysql://localhost:3306/";
            String databaseName = "orderentrysystem";
            String databaseUserName = "root";
            String databasePassword = "root";

            // Establish a connection
            connection = DriverManager.getConnection(connectionName + databaseName, databaseUserName, databasePassword);
            System.out.println("Database connected");

            // Create a statement
            stmt = connection.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addCustomer(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {
        initializeDB();
        /*
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String address = addressField.getText();
    String city =    cityField.getText();
    String state =   stateField.getText();
    String zip =     zipField.getText();
    String phone =   phoneField.getText();
    String email =   emailField.getText();
         */
        try {
            String query = "insert into customer(first_name, last_name, address, city, state, zip, phone, email) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, state);
            ps.setString(6, zip);
            ps.setString(7, phone);
            ps.setString(8, email);

            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    // public void showEmployee(TextField employeeId_label, Label status_label) {
   
          
    public int showEmployee(TextField ea_username_textField, TextField li_password_textField, Label status_label) {
       int eid= -1;
        initializeDB();
        String userName = ea_username_textField.getText().trim();
        String password = li_password_textField.getText().trim();
        try {
            //  String queryString = "select firstName, lastName, email from employee where employeeId = '" + employeeId + "' ";
            String queryString = "select employeeId, firstName, lastName, email  from employee where userName = ' " + userName + " '  & password = ' " + password + " '"; 
          // String queryString = "select employeeId, firstName, lastName, email  from employee where userName = ' "  + userName + " '"; 
            ResultSet rset = stmt.executeQuery(queryString);
            if (rset.next()) {
                int employeeId = rset.getInt(1);
                String firstName = rset.getString(2);
                String lastName = rset.getString(3);
                    
                
               
                status_label.setText("Successful login: " + firstName + " " + lastName + " ID=" + employeeId);
                eid = employeeId;
                
            } else {

                status_label.setText("Not found");
                //ea_button.setDisable(true);

            
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        closeDB();
        return eid;
    }

   
    //return the list of employees based on the data from the database.
    public ObservableList<Employee> getEmployeeList() {
        initializeDB();
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        try {
            String queryString = "select employeeId, firstName, lastName, email from employee order by employeeId ";
            ResultSet rset = stmt.executeQuery(queryString);
            while (rset.next()) {
                int employeeId = rset.getInt(1);
                String firstName = rset.getString(2);
                String lastName = rset.getString(3);
                String email = rset.getString(4);
                employees.add(new Employee(employeeId, firstName, lastName, email));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        closeDB();
        return employees;
    }

    public ObservableList<Order> getOrderList() {
        initializeDB();
        ObservableList<Order> orders = FXCollections.observableArrayList();

        try {
            String queryString = "select id, customer_id, order_date, order_status from orders order by id ";
            ResultSet rset = stmt.executeQuery(queryString);
            while (rset.next()) {
                int id = rset.getInt(1);
                int customer_id = rset.getInt(2);
                String order_date = rset.getString(3);
                String order_status = rset.getString(4);
                orders.add(new Order(id, order_date, order_status, customer_id ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        closeDB();
        return orders;
    } //end getOrderList

    public ObservableList<Product> getProductList() {
        initializeDB();
        ObservableList<Product> products = FXCollections.observableArrayList();

        try {
            String queryString = "select id_product, productName, productDescription, unitPrice, categoryKey, quantity from product ORDER BY id_product ";
            ResultSet rset = stmt.executeQuery(queryString);
            while (rset.next()) {
                int id_product = rset.getInt(1);
                String productName = rset.getString(2);
                String productDescription = rset.getString(3);
                String unitPrice = rset.getString(4);
                int categoryKey = rset.getInt(5);
                String quantity = rset.getString(6);
                products.add(new Product(id_product, productName, productDescription, unitPrice, categoryKey, quantity));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        closeDB();
        return products;
    }

    public ObservableList<Customer> getCustomers() {
        initializeDB();
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        try {
            String queryString = "SELECT id, first_name, last_name, address, city, state, zip, phone, email FROM customer ORDER BY id ";

            ResultSet rset = stmt.executeQuery(queryString);
            while (rset.next()) {
                //Create a Customer object and load it up
                Customer customer = new Customer();
                customer.setId(rset.getInt("id"));
                customer.setFirst_name(rset.getString("first_name"));
                customer.setLast_name(rset.getString("last_name"));
                customer.setAddress(rset.getString("address"));
                customer.setCity(rset.getString("city"));
                customer.setState(rset.getString("state"));
                customer.setZip(rset.getString("zip"));
                customer.setPhone(rset.getString("phone"));
                customer.setEmail(rset.getString("email"));
                customers.add(customer);

                // employees.add(new Employee(employeeId, firstName, lastName, email));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        closeDB();
        return customers;
    } //end getCustomers()
    
    public ObservableList<Product> getProducts(){
        initializeDB();
         ObservableList<Product> products = FXCollections.observableArrayList();
         try {
             String queryString = "SELECT * FROM product ORDER BY product_name ";
             
             ResultSet rset = stmt.executeQuery(queryString);
             while (rset.next()) {
                 
                 Product product = new Product();
                 product.setId_product(rset.getInt("id"));
                 product.setProduct_name(rset.getString("product_name"));
                 product.setProduct_description(rset.getString("product_description"));
                 product.setUnit_price(rset.getString("unit_price"));
                 product.setCategory_key(rset.getInt("category_key"));
                 product.setQuantity(rset.getString("quantity"));   
                 products.add(product);
                    }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        closeDB();
        return products;
    } //end getProducts()
    
             
         
    

    public void addOrder(int cid, java.sql.Date date, String status,
            int pid, int quantity, int employeeID) {
        System.out.println("\ncid=" + cid + "  date=" + date + " pid=" + pid
                + " quantity=" + quantity + " status=" + status
        + " employee ID=" + employeeID);
        //TODO Must talk to MYSQL to actually add the order information
        //TODO Must INSERT order, INSERT order_details,
        //TODO Must UPDATE product quantity
    initializeDB();
      try {
          String query = "insert into orders(customer_id, order_date, employee_id, order_status) values(?, ?, ?, ?)";
          String query2= "insert into order_details(quantity, product_id) values(?, ?)";
          
          
          PreparedStatement ps = connection.prepareStatement(query);
          ps.setInt(1, cid);
          ps.setDate(2, date);
          ps.setInt(3, employeeID);
          ps.setString(4, status);
          /*
          ps.setInt(5, pid);
          ps.setInt(6, quantity);
          ps.setInt(6, employeeID);
          */
          
          
          ps.execute();
          } catch (Exception ex) {
            ex.printStackTrace();
        

    
          
                  
          
          
      }
      closeDB();
    }

    private void closeDB() {
        try {
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
