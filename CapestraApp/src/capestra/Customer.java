/*****************************************************
*Author: Marx Young, Capella University              * 
*Course: ITEC 5020-Database & App Development        *   
*Assignment: Course Project - Capestra Order Entry   *   
*File: Customer.java                              *   
*Description: Main program for Capestra              *   
*Input: Reads from MySQL database                    *   
*Output: Updates MySQL database                      *   
*Created: 8/02/2020                                  *  
******************************************************/





package capestra;

public class Customer {
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public Customer() {
    }
    
    

    public Customer(int id, String first_name, String last_name, String address, String city, String state, String zip, String phone, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + '}';
    }
    
    
}
