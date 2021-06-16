/*****************************************************
*Author: Marx Young, Capella University              * 
*Course: ITEC 5020-Database & App Development        *   
*Assignment: Course Project - Capestra Order Entry   *   
*File: CapestraApp.java                              *   
*Description: Main program for Capestra              *   
*Input: Reads from MySQL database                    *   
*Output: Updates MySQL database                      *   
*Created: 8/02/2020                                  *  
******************************************************/



package capestra;

//Import list
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class CapestraApp extends Application {

//scenes for the application
 private Scene ea_scene, ac_scene, ao_scene, el_scene, cr_scene, or_scene, vp_scene;
private int employeeID= 0;
    @Override
    public void start(Stage primaryStage) {
//Setting the title of the application
        primaryStage.setTitle("Capestra Order Entry - Marx Young");

//Employee Account Scene Setup
        createEmployeeAccountScene(primaryStage);
    
//Add Customer  Scene Setup
        createAddCustomerScene(primaryStage);

//Add Order  Scene Setup
         createAddOrderScene(primaryStage);

//Customer Report  Scene Setup
        createEmployeeListReportScene(primaryStage);
         
//Customer Report  Scene Setup
        createCustomerReportScene(primaryStage);
        

//Order Report  Scene Setup
        createOrderReportScene(primaryStage);
        
//Product Report  Scene Setup
        createProductReportScene(primaryStage);
        

        primaryStage.setScene(ea_scene);
        primaryStage.show();
    }

    //Menu Setup
        public MenuBar addMenu(Stage primaryStage) {
        Menu menu1 = new Menu("Action");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu1);
        MenuItem menu11 = new MenuItem("Login");
        MenuItem menu12 = new MenuItem("Add Customer");
        MenuItem menu13 = new MenuItem("Place Order");

        Menu menu2 = new Menu("Report");
        menuBar.getMenus().add(menu2);
        MenuItem menu21 = new MenuItem("Employee List Report");
        MenuItem menu22 = new MenuItem("Customer Report");
        MenuItem menu23 = new MenuItem("Order Report");
        MenuItem menu24 = new MenuItem("Product Report");

        menu1.getItems().addAll(menu11, menu12, menu13);
        menu2.getItems().addAll(menu21, menu22, menu23, menu24);

        menu11.setOnAction(e -> primaryStage.setScene(ea_scene));
        menu12.setOnAction(e -> primaryStage.setScene(ac_scene));
        menu13.setOnAction(e -> primaryStage.setScene(ao_scene));
        menu21.setOnAction(e -> primaryStage.setScene(el_scene));
        menu22.setOnAction(e -> primaryStage.setScene(cr_scene));
        menu23.setOnAction(e -> primaryStage.setScene(or_scene));
        menu24.setOnAction(e -> primaryStage.setScene(vp_scene));

        return menuBar;
    }
    
/****************************************
 * Methods to setup each of the screens
 * 
*****************************************/

    //Employee Account Scene Setup
    public void createEmployeeAccountScene(Stage primaryStage){
        Label ea_label1 = new Label("Login");
        
           //made a change marx note
        Label ea_username_label = new Label("Enter UserName");
        TextField ea_username_textField = new TextField();
        ea_username_textField.setPromptText("Enter the Employee Username.");
        
        HBox hboxUN = new HBox(30, ea_username_label, ea_username_textField);
        //add label and textField for password
Label li_password_label = new Label("Enter Password ");
TextField li_password_textField = new TextField();
li_password_textField.setPromptText("Enter passoword ");

  HBox hboxPW = new HBox(30, li_password_label, li_password_textField);
        Button ea_button = new Button(" Login ");
        
         Label ea_status_label = new Label("");

        ea_button.setOnAction(e -> employeeSignIn(ea_username_textField, li_password_textField, ea_status_label));

        VBox ea_layout = new VBox(20);
        ea_layout.getChildren().addAll(addMenu(primaryStage), ea_label1, hboxUN, hboxPW, ea_button, ea_status_label);
        ea_scene = new Scene(ea_layout, 800, 500);
        ea_scene.getStylesheets().add(CapestraApp.class.getResource("CapestraApp3.css").toExternalForm());
        
         //primaryStage.setTitle("Login Screen");
    }

    //Add Customer  Scene Setup
   public void createAddCustomerScene(Stage primaryStage){
        Label ac_label1 = new Label("Add Customer Screen");
        
                // Create label and input field for "first name"
            //primaryStage.setTitle("Add customer");
    
     
    
    
    


   /*
//add the label and textfield for first name
        Label ac_firstName_label = new Label("First Name");
        TextField ac_firstName_textField = new TextField();
        ac_firstName_textField.setPromptText("Enter customer's first name.");
        // add the label and textfield for last name
        Label ac_lastName_label = new Label("Last Name");
        TextField ac_lastName_textField = new TextField();
        ac_lastName_textField.setPromptText("Enter customer's last name.");
       */ 
            
         Pair firstNameField = makeField("first name", 235);
         Pair lastNameField = makeField("last name", 235);
          Pair addressField = makeField("address", 335);
         Pair cityField = makeField("city", 135);
         Pair stateField = makeField("state", 235);
         Pair zipField = makeField("zip", 235);
         Pair phoneField = makeField("phone", 235);
         Pair emailField = makeField("email", 235);
        

    // add the button to press or submit information    
        Button ac_button = new Button("Add Customer");
        ac_button.setOnAction(e -> addCustomer( firstNameField.grab(), lastNameField.grab(), addressField.grab(), cityField.grab(), stateField.grab(), zipField.grab(), phoneField.grab(), emailField.grab()));
       
       

        VBox ac_layout = new VBox(20);
        ac_layout.getChildren().addAll( ac_label1, 
        firstNameField.getHb(),
        lastNameField.getHb(),
        addressField.getHb(),
        cityField.getHb(),
        stateField.getHb(),
        zipField.getHb(),
        phoneField.getHb(),
        emailField.getHb(),
         
      ac_button);
          ac_layout.setPadding(new Insets(15, 12, 15, 70));

        // Create VBox for outer layer of the layout
        VBox vboxOL = new VBox(15, addMenu(primaryStage), ac_layout);
        
        ac_scene = new Scene(vboxOL, 800, 500);
       ac_scene.getStylesheets().add(CapestraApp.class.getResource("CapestraApp3.css").toExternalForm());

        
    }
     // This "worker method" creates and lays out a Label-TextField pair
    //    label = text for the label
    //    width = width of the textField
    // Using this method saves duplicating lots of code for each pair
    private Pair makeField(String label, int width) {
        Label lbl = new Label(makeLabel(label));
        lbl.setPrefWidth(70);
        TextField tf = new TextField();
        tf.setPromptText(makePrompt(label));
        tf.setPrefWidth(width);
        HBox hbox = new HBox(5, lbl, tf);
        hbox.setAlignment(Pos.BASELINE_LEFT);
        return new Pair(hbox, tf);
    } // end makeField()
  // Create "Label:" from "label"
    private String makeLabel(String label) {
        return label.substring(0, 1).toUpperCase() + label.substring(1) + ":";
    }

    // Create a prompt string for use in a TextField
    private String makePrompt(String str) {
        return "Enter " + str;
    }
    
    
//Place Order  Scene Setup
  private String[] customerNames;
  private int[] customerIDs;
  private String[] productNames;
  private int[] productIDs;
    public void createAddOrderScene(Stage primaryStage){
        Label ad_label = new Label("Place Order Screen");
        
        Label ad_name_label = new Label("Customer Name");
        ComboBox<String> cust_name = new ComboBox();
        cust_name.setMinWidth(200);
        cust_name.setPromptText("Select customer");
       getCustomerData();
       cust_name.getItems().addAll(customerNames);
        
        HBox hboxCN = new HBox(10);
        hboxCN.getChildren().addAll(ad_name_label, cust_name);
        
        //Marx note: Made label and combobox
        Label ao_product_label = new Label("product name");
        ComboBox<String> prod_name = new ComboBox();
        prod_name.setMinWidth(200);
        prod_name.setPromptText("Select product");
        getProductData();
        prod_name.getItems().addAll(productNames);
      
       
        HBox hboxPN= new HBox(10);
        hboxPN.getChildren().addAll(ao_product_label, prod_name);
        
         Label ao_quantity_label = new Label("Quantity");
        TextField ao_quantity_textField = new TextField();
         ao_quantity_textField.setMinWidth(200);
        ao_quantity_textField.setPromptText("What is the quantity?");
        
         HBox hboxQ = new HBox(20);
        hboxQ.getChildren().addAll(ao_quantity_label, ao_quantity_textField);
        
    Button ad_button = new Button("Place Order");
    ad_button.setOnAction(new EventHandler<ActionEvent> () {
        @Override
        public void handle(ActionEvent e){
           int selectedId = cust_name.getSelectionModel().getSelectedIndex();
           System.out.println("idex = " + selectedId);    //Foo
           int cid = customerIDs[selectedId];
           System.out.println("  cid = " + cid);   //Foo
           int pid = 3;         //TODO
           int quantity = 17; //TODO
           //TODO Look up the actual quantity available: if ok, proceed
           //TODO if not, issue Alert and Don't call 'placeOrder'
           java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
           placeOrder(cid, date, pid, quantity); 
           
        }
    });
    VBox ad_layout = new VBox(20);
        ad_layout.getChildren().addAll(addMenu(primaryStage), ad_label, hboxCN, hboxPN, hboxQ,  ad_button);
        ao_scene = new Scene(ad_layout, 800, 500);
        ao_scene.getStylesheets().add(CapestraApp.class.getResource("CapestraApp3.css").toExternalForm());
        
        //primaryStage.setTitle("Place Order");
            }
    private void placeOrder(int cid, java.sql.Date date, int pid, int quantity) {
      //System.out.println("\ncid=" + cid + "  date=" + date + " pid=" + pid 
        //      + " quantity=" + quantity);   
      CapestraDB myDB = new CapestraDB();
      myDB.addOrder(cid, date, "pending",  pid, quantity, employeeID);
    }
    
    
    //Load the customerNames array with name from the database
    //Load the customerIDs array with customer IDs from the database
    private void getCustomerData() {
       /* customerNames = new String[3];
        customerNames[0] = "abc";
        customerNames[1] = "def";
        customerNames[2]= "def";*/
       CapestraDB myDB = new CapestraDB();
       //ObservableList<Customer> custs = FXCollections.observableArrayList();
      ObservableList<Customer> custs= myDB.getCustomers();
       customerNames =new String[custs.size()];
       customerIDs = new int[custs.size()];
       int nc = 0;
       for (Customer c : custs) {
           customerNames[nc] = c.getFirst_name() + " " + c.getLast_name();
           customerIDs[nc++] = c.getId();
    }
    }
    
       private void getProductData() {
           CapestraDB myDB = new CapestraDB();
           ObservableList<Product> prods = myDB.getProducts();
           productNames = new String[prods.size()];
           productIDs = new int[prods.size()];
           int np = 0;
           for(Product p : prods) {
               productNames[np] = p.getProduct_name();
               productIDs[np++] = p.getId_product();
           }
       }

    
    public void createEmployeeListReportScene(Stage primaryStage){
 
        Label el_label = new Label("Employee List Screen");

//create the table
        TableView<Employee> employeeTable;

//create each individual column and map them to the corresponding attribute in the Employee class
        TableColumn<Employee,Integer> employeeIdColumn = new TableColumn<>("Employee ID");
        employeeIdColumn.setMinWidth(100);
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Employee,String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setMinWidth(200);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee,String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee,String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(300);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

//set the data of the table and add in each of the columns
        employeeTable = new TableView();
        employeeTable.setItems(getEmployeeList());
        employeeTable.getColumns().addAll(employeeIdColumn,firstNameColumn,lastNameColumn,emailColumn);
        
        VBox el_layout = new VBox(20);
        el_layout.getChildren().addAll(addMenu(primaryStage), el_label, employeeTable);
        el_scene = new Scene(el_layout, 800, 500); 
        el_scene.getStylesheets().add(CapestraApp.class.getResource("CapestraApp3.css").toExternalForm());
    }
// Creates a list to set to the table
    public ObservableList<Employee> getEmployeeList(){
	ObservableList<Employee> employees = FXCollections.observableArrayList();
        CapestraDB myDB = new CapestraDB();
        employees = myDB.getEmployeeList();
        return employees;
}
    
    //Customer Report  Scene Setup
  
 
    public void createCustomerReportScene(Stage primaryStage){
    Label cr_label = new Label("View Customer Report Screen");
    
    //create the table
        TableView<Customer> customerTable;

//create each individual column and map them to the corresponding attribute in the Employee class
        TableColumn<Customer,Integer> customerIdColumn = new TableColumn<>("Customer ID");
        customerIdColumn.setMinWidth(100);
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Customer,String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setMinWidth(200);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));

        TableColumn<Customer,String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        
        TableColumn<Customer,String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(200);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        
        TableColumn<Customer,String> cityColumn = new TableColumn<>("City");
        cityColumn.setMinWidth(200);
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        
        TableColumn<Customer,String> stateColumn = new TableColumn<>("State");
        stateColumn.setMinWidth(200);
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
        
        TableColumn<Customer,String> zipColumn = new TableColumn<>("Zip");
        zipColumn.setMinWidth(200);
        zipColumn.setCellValueFactory(new PropertyValueFactory<>("zip"));
        
        TableColumn<Customer,String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setMinWidth(200);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        TableColumn<Customer,String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        //set the data of the table and add in each of the columns
        customerTable = new TableView();
        customerTable.setItems(getCustomers());
        customerTable.getColumns().addAll(customerIdColumn,firstNameColumn,lastNameColumn,addressColumn, cityColumn, stateColumn, zipColumn, phoneColumn, emailColumn);
        
        VBox cr_layout = new VBox(20);
        cr_layout.getChildren().addAll(addMenu(primaryStage), cr_label, customerTable);
        cr_scene = new Scene(cr_layout, 800, 500); 
        cr_scene.getStylesheets().add(CapestraApp.class.getResource("CapestraApp3.css").toExternalForm());     
         //primaryStage.setTitle("Customer Report Screen");
    }
// Creates a list to set to the table
    public ObservableList<Customer> getCustomers(){
	ObservableList<Customer> customers = FXCollections.observableArrayList();
        CapestraDB myDB = new CapestraDB();
        customers = myDB.getCustomers();
        return customers;
}
    
    public ObservableList<Product> getProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        CapestraDB myDB = new CapestraDB();
        products = myDB.getProducts();
        return products;
    }
    
    //Order Report  Scene Setup
    public void createOrderReportScene(Stage primaryStage){
    Label or_label = new Label("View Order Screen");
    
    
     
    

    
    //create the table
        TableView<Order> orderTable;

//create each individual column and map them to the corresponding attribute in the Employee class
        TableColumn<Order,Integer> orderIdColumn = new TableColumn<>(" ID");
        orderIdColumn.setMinWidth(100);
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Order,Integer> customerIDColumn = new TableColumn<>("Customer Id ");
        customerIDColumn.setMinWidth(200);
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customer_id"));

        TableColumn<Order,String>  orderDateColumn = new TableColumn<>(" Order date");
        orderDateColumn.setMinWidth(200);
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        
        TableColumn<Order,String>  statusColumn = new TableColumn<>("Order Status");
        statusColumn.setMinWidth(200);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        
       
        
     //set the data of the table and add in each of the columns
        orderTable = new TableView();
        orderTable.setItems(getOrderList());
        orderTable.getColumns().addAll(orderIdColumn, customerIDColumn, orderDateColumn, statusColumn );
        
        
        VBox or_layout = new VBox(20);
        or_layout.getChildren().addAll(addMenu(primaryStage), or_label, orderTable);
        or_scene = new Scene(or_layout, 800, 500); 
        or_scene.getStylesheets().add(CapestraApp.class.getResource("CapestraApp3.css").toExternalForm());   
        
        
           //primaryStage.setTitle("Order Report Screen");
    }
    
  // Creates a list to set to the table
    public ObservableList<Order> getOrderList(){
	ObservableList<Order> orders = FXCollections.observableArrayList();
        CapestraDB myDB = new CapestraDB();
        orders = myDB.getOrderList();
        return orders;
}
  
    
    //Product Report  Scene Setup
    public void createProductReportScene(Stage primaryStage){
    Label vp_label = new Label("View Product Screen");
    

    
    //create the table
        TableView<Product> productTable;

//create each individual column and map them to the corresponding attribute in the Employee class
        TableColumn<Product,Integer> productIdColumn = new TableColumn<>("Product ID");
        productIdColumn.setMinWidth(100);
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id_product"));

        TableColumn<Product,String> productNameColumn = new TableColumn<>("Product name");
        productNameColumn.setMinWidth(200);
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("product_name"));

        TableColumn<Product,String> productDescriptionColumn = new TableColumn<>("Product Description");
        productDescriptionColumn.setMinWidth(200);
        productDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("product_description"));
        
        TableColumn<Product,String> unitPriceColumn = new TableColumn<>("Unit_price");
        unitPriceColumn.setMinWidth(200);
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unit_price"));
        
        TableColumn<Product,Integer> categoryKeyColumn = new TableColumn<>("CategoryKey");
        categoryKeyColumn.setMinWidth(200);
        categoryKeyColumn.setCellValueFactory(new PropertyValueFactory<>("category_key"));
        
        TableColumn<Product,String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
     
        //set the data of the table and add in each of the columns
        productTable = new TableView();
          productTable.setItems(getProducts());
        productTable.getColumns().addAll(productIdColumn,productNameColumn, productDescriptionColumn, unitPriceColumn, categoryKeyColumn, quantityColumn );
        
        VBox vp_layout = new VBox(20);
        vp_layout.getChildren().addAll(addMenu(primaryStage), vp_label, productTable);
        vp_scene = new Scene(vp_layout, 800, 500); 
        vp_scene.getStylesheets().add(CapestraApp.class.getResource("CapestraApp3.css").toExternalForm());    
        
         //primaryStage.setTitle("Product Report Screen");
    }
    /*
    // Creates a list to set to the table
    public ObservableList<Product> getProducts(){
	ObservableList<Product> products = FXCollections.observableArrayList();
     
     
        return products;
}
    */
    
 /****************************************
 * Added Functionality
 * 
*****************************************/
    
    //Signing in as the employee
    public void employeeSignIn(TextField ea_username_textField, TextField li_password_textField, Label status_label) {
        CapestraDB myDB = new CapestraDB();
       employeeID = myDB.showEmployee(ea_username_textField, li_password_textField, status_label);
    }
    
    //adding a customer
    public void addCustomer(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {
        //add customer content with the DB

        CapestraDB myDB = new CapestraDB();
        myDB.addCustomer(firstName, lastName, address, city, state, zip, phone, email);
        
        /*
        Alert alert = new Alert(AlertType.INFORMATION, "Added Customer?", ButtonType.OK);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            //clear the form
*/
    
    }
    /*
    public void placeOrder(int cid, java.sql.Date date, String status,
            int pid, int quantity, int employeeID{
        
        CapestraDB myDB = new CapestraDB();
        myDB.placeOrder(productName);
    }
*/


    public static void main(String[] args) {
        launch(args);
    }

   

    

}

// The Pair class contains a Hbox-TextField pair for convenience
class Pair {

    private final HBox hb;
    private final TextField tf;

    public Pair(HBox hb, TextField tf) {
        this.hb = hb;
        this.tf = tf;
    }

    public HBox getHb() {
        return hb;
    }

    public TextField getTf() {
        return tf;
    }

    // Reduce the amount of typing: use this "worker method"
    public String grab() {
        return getTf().getText().trim();
    }

} // end class Pair

