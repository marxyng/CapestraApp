/*****************************************************
*Author: Marx Young, Capella University              * 
*Course: ITEC 5020-Database & App Development        *   
*Assignment: Course Project - Capestra Order Entry   *   
*File: Employee.java                              *   
*Description: Main program for Capestra              *   
*Input: Reads from MySQL database                    *   
*Output: Updates MySQL database                      *   
*Created: 8/02/2020                                  *  
******************************************************/
package capestra;

/**
 *
 * @author Vincent
 */
public class Employee{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee(){
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
	}
	
	public Employee(int id, String firstName, String lastName, String email){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
}
