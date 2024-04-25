import java.io.File;
import java.util.Scanner;

class hw1 {
    public static void main(String[] args) { // main function
        FileContent contents = new FileContent();   //  create a new FileContent object
        contents.fillArrays();  // fill the arrays as the function says
        Order[] orders = contents.getOrders();  //  get the orders from the contents
        RetailCustomer[] retailCustomers = contents.getRetailCustomers();   //  get the retail customers from the contents
        CorporateCustomer[] corporateCustomers = contents.getCorporateCustomers();  //  get the corporate customers from the contents
        Operator[] operators = contents.getOperators(); //  get the operators from the contents

        for (int i = 0;i < retailCustomers.length;i++){ // looking at all the retail customers and orders in order to match the orders with the customers
            Order[] temporders = new Order[100];    // temporary array to store the orders
            int tempindex = 0;  // temporary index to store the size of the temporary array
            for (int j = 0;j < orders.length;j++) {
                if (retailCustomers[i] != null && orders[j] != null){   // checking if the destination and source are null or not
                    if (retailCustomers[i].getId() == orders[j].getCustomerId()) {  //  if the customer id and the order id are the same
                        temporders[tempindex++] = orders[j];    //  add the order to the temporary array
                        retailCustomers[i].increaseorderindex();    //  increase the order array size of the customer
                    }
                }
            }
            if(retailCustomers[i] != null)  //  if the customer is not null
                retailCustomers[i].setOrders(temporders);   //  set the orders of the customer
        }
        /*
        After here all i did is the same as the above code but for the corporate customers and operator
        */

        for (int i = 0;i < corporateCustomers.length;i++){
            Order[] temporders = new Order[100];
            int tempindex = 0;
            for (int j = 0;j < orders.length;j++) {
                if (corporateCustomers[i] != null && orders[j] != null){
                    if (corporateCustomers[i].getId() == orders[j].getCustomerId()) {
                        temporders[tempindex++] = orders[j];
                        corporateCustomers[i].increaseorderindex();
                    }
                }
            }
            if(corporateCustomers[i] != null)
                corporateCustomers[i].setOrders(temporders);
        }
            
        
        for (int i = 0;i < operators.length;i++) {
            Customer[] tempcustomers = new Customer[100];
            int tempindex = 0;
            for (int j = 0;j < retailCustomers.length;j++) {
                if (operators[i] != null && retailCustomers[j] != null){
                    if (operators[i].getId() == retailCustomers[j].getOperatorId()) {
                        tempcustomers[tempindex++] = retailCustomers[j];
                        operators[i].increasecustomerindex();
                    }
                }
            }
            for (int j = 0;j < corporateCustomers.length;j++) {
                if (operators[i] != null && corporateCustomers[j] != null){
                    if (operators[i].getId() == corporateCustomers[j].getOperatorId()) {
                        tempcustomers[tempindex++] = corporateCustomers[j];
                        operators[i].increasecustomerindex();
                    }
                }
            }
            if(operators[i] != null)
                operators[i].define_customers(tempcustomers);
        }
        // take input from user
        int inputid = 0;
        try{
            Scanner input = new Scanner(System.in); // getting the input
            System.out.println("Please enter your id: ");
            inputid = input.nextInt();  // input must be an integer
            input.close();
        }
        catch(Exception e){
            System.err.println("Id entered is not valid!"); // if input is not an integer, program will print this and terminate
            return;
        }
        int flag = 0;   // flag is used to check if the id is found or not
                        // and even it is found, it will not be checked again
        for (int i = 0;i < operators.length;i++) {
            if (operators[i] != null) {
                if (operators[i].getId() == inputid) {  // if the id is found
                    operators[i].print_operator();  // print the operator
                    flag = 1;   // set the flag to 1
                }
            }
        }
        // below that is same as above for different types of classes
        if (flag == 0) {
            for(int i = 0;i < retailCustomers.length;i++) {
                if (retailCustomers[i] != null) {
                    if (retailCustomers[i].getId() == inputid) {
                        System.out.println("*** Customer Screen ***");
                        retailCustomers[i].print_customer();
                        flag = 1;
                    }
                }
            }
        }
        if(flag == 0) {
            for(int i = 0;i < corporateCustomers.length;i++) {
                if (corporateCustomers[i] != null) {
                    if (corporateCustomers[i].getId() == inputid) {
                        System.out.println("*** Customer Screen ***");
                        corporateCustomers[i].print_customer();
                        flag = 1;
                    }
                }
            }
        }
        if (flag == 0) {    // if still the flag is 0 and the id is not found, print this
            System.out.println("No operator/customer was found with ID " + inputid + ". Please try again.");
        }
    }
}

class Person {
    // name;surname;role;address;id;phone
    private String name;
    private String surname;
    private String role;
    private String address;
    private int id;
    private String phone;

    // getters and setters for the class
    // setters are private in order to prevent the user to change the values because they will be taken only from text file
    
    public String getName() {   
        return name;
    }

    private void setName(String aName) {
        aName = aName.toLowerCase();
        name = aName;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String aSurname) {
        aSurname = aSurname.toLowerCase();
        surname = aSurname;
    }

    public String getRole() {
        return role;
    }

    private void setRole(String aRole) {
        aRole = aRole.toLowerCase();
        role = aRole;
    }

    public String getAdress() {
        return address;
    }

    private void setAdress(String aAddress) {
        aAddress = aAddress.toLowerCase();
        address = aAddress;
    }

    public int getId() {
        return id;
    }

    private void setId(int anId) {
        id = anId;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String aPhone) {
        this.phone = aPhone;
    }

    // constructor for the class
    Person(String aRole, String aName, String aSurname, String aAddress, String aPhone, int anId) {
        setName(aName);
        setSurname(aSurname);
        setAdress(aAddress);
        setId(anId);
        setPhone(aPhone);
        setRole(aRole);
    }
    // default constructor
    Person() {
        this.name = "";
        this.surname = "";
        this.role = "";
        this.address = "";
        this.id = 0;
        this.phone = "";
    }
}

class Customer extends Person {
    // role;name;surname;address;phone;id;operator_id
    private int operatorId;
    private Order[] orders = new Order[100];
    private int orderindex = 0;

    // getters and setters for the class
    public Order[] getOrders() {
        return orders;
    }

    public int getOrderCount() {
        return orderindex;
    }

    public void setOrders(Order[] anOrders) {
        this.orders = anOrders;
    }
    public void increaseorderindex() {
        this.orderindex++;
    }

    public void addOrder(Order anOrder) {
        orders[orderindex++] = anOrder;
    }

    public int getOperatorId() {
        return operatorId;
    }

    private void setOperatorId(int anOperatorId) {
        this.operatorId = anOperatorId;
    }

    public void print_orders(){
        for(int i = 0; i < orderindex; i++){
            Order order = orders[i];
            System.out.print("\nOrder #" + (i + 1) + " => ");order.print_order(); 
        }
    }
    // constructor for the class
    Customer(String aRole, String aName, String aSurname, String aAddress, String aPhone, int anId, int anOperatorId) {
        super(aRole, aName, aSurname, aAddress, aPhone, anId);
        setOperatorId(anOperatorId);
    }
    // default constructor
    Customer() {
        super();
        setOperatorId(0);
    }
}

class RetailCustomer extends Customer {
    // role;name;surname;address;phone;id;operator_id
    // same as the Customer class

    RetailCustomer(String aName, String aSurname, String aAddress, String aPhone, int anId, int anOperatorId) {
        super("retail_customer", aName, aSurname, aAddress, aPhone, anId, anOperatorId);
    }
    // print the customer
    public void print_customer() {
        System.out.println(
                "Name & Surname: " + getName() + " " + getSurname() + "\n" + //
                "Address: " + getAdress() + "\n" +//
                "Phone: " + getPhone() + "\n" + //
                "ID: " + getId() + "\n" + //
                "Operator ID: " + getOperatorId());//;
                
        print_orders(); // print the orders of the customer
    }
}

class CorporateCustomer extends Customer {
    // role;name;surname;address;phone;id;operator_id;corporate_name
    // same as the RetailCustomer class but corporate_name added

    private String corporateName;

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
    // constructor for the class
    CorporateCustomer(String aName, String aSurname, String aAddress, String aPhone, int anId, int anOperatorId,
            String corporateName) {
        super("corporate_customer", aName, aSurname, aAddress, aPhone, anId, anOperatorId);
        setCorporateName(corporateName);
    }   
    // default constructor
    CorporateCustomer() {
        super();
        corporateName = "";
    }
    // print the customer
    public void print_customer() {
        System.out.println(
                "Name & Surname: " + getName() + " " + getSurname() + "\n" + //
                "Address: " + getAdress() + "\n" +//
                "Phone: " + getPhone() + "\n" + //
                "ID: " + getId() + "\n" + //
                "Operator ID: " + getOperatorId() + "\n" + //;
                "Corporate Name: " + getCorporateName()); //;
                
        print_orders(); // print the orders of the customer
    }
}

class Operator extends Person {
    // role;name;surname;address;phone;id;wage
    // same as the Person class but wage added
    private Customer[] customers = new Customer[100];
    private int customerindex = 0;
    private int wage;

    public void increasecustomerindex() {
        this.customerindex++;
    }

    public void define_customers(Customer[] aCustomers){
        this.customers = aCustomers;
    }

    private void setWage(int aWage) {
        this.wage = aWage;
    }

    public int getWage() {
        return wage;
    }
    // constructor for the class
    Operator() {
        super();
        setWage(0);
    }
    // print the customers
    public void print_customers(){
        for(int i = 0; i < customerindex; i++){
            Customer customer = customers[i];
            System.out.println("\n----------------------------\nCustomer #" + (i + 1) + " (a " + customer.getRole().replace("_"," ") + ")\n");
            if (customer.getRole().equals("retail_customer")) { // if the customer is retail customer
                RetailCustomer retailCustomer = (RetailCustomer) customer;  // cast the customer to retail customer
                retailCustomer.print_customer();    //then print the customer
            } else if (customer.getRole().equals("corporate_customer")) {   // else is the same as above but for corporate customer
                CorporateCustomer corporateCustomer = (CorporateCustomer) customer;
                corporateCustomer.print_customer();
            }
        }
        System.out.println("\n----------------------------");   // print the end of the customers
    }
    // constructor for the class
    Operator(String aName, String aSurname, String aAddress, String aPhone, int anId, int aWage) {
        super("operator", aName, aSurname, aAddress, aPhone, anId);
        setWage(aWage);
    }
    // print the operator
    public void print_operator() {
        System.out.println("*** Operator Screen ***\n----------------------------\n" + //
                "Name & Surname: " + getName() + " " + getSurname() + "\n" + //
                "Address: " + getAdress() + "\n" +//
                "Phone: " + getPhone() + "\n" + //
                "ID: " + getId() + "\n" + //
                "Wage: " + getWage()); //;
                
        print_customers();  // print the customers of the operator
        if (customerindex == 0) {
            System.out.println("This operator doesn't have any customer.\n----------------------------");
        }

    }
}

class Order {
    // product_name;count;total_price;status;customer_id
    private String productName;
    private int count;
    private int totalPrice;
    private int status;
    private int customerId;
    // getters and setters for the class

    public String getProductName() {
        return productName;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        if (status == 0) {
            return "Initialized";
        } else if (status == 1) {
            return "Processing";
        } else if (status == 2) {
            return "Completed";
        } else if (status == 3) {
            return "Cancelled";
        } else {
            return "status_alinamadi";
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    private void setStatus(int aStatus) {
        this.status = aStatus;
    }

    private void setProductName(String aProductName) {
        aProductName = aProductName.toLowerCase();
        this.productName = aProductName;
    }

    private void setCount(int aCount) {
        this.count = aCount;
    }

    private void setTotalPrice(int aTotalPrice) {
        this.totalPrice = aTotalPrice;
    }

    private void setCustomerId(int aCustomerId) {
        this.customerId = aCustomerId;
    }
    // default constructor
    Order() {
        setCount(0);
        setCustomerId(0);
        setProductName("");
        setStatus(0);
        setTotalPrice(0);
    }
    // constructor for the class
    Order(String aProductName, int aCount, int aTotalPrice, int aStatus, int aCustomerId) {
        setProductName(aProductName);
        setCount(aCount);
        setTotalPrice(aTotalPrice);
        setStatus(aStatus);
        setCustomerId(aCustomerId);
    }
    public void print_order() { // print the order
        System.out.print("Product Name: " + getProductName() + " - " +//
                "Count: " + getCount() + " - " +//
                "Total Price: " + getTotalPrice() + " - " +//
                "Status: " + getStatus());
    }
}

class FileContent {
    // create the arrays
    // order;retail_customer;corporate_customer;operator
    private Order[] orders = new Order[100];
    private RetailCustomer[] retailCustomers = new RetailCustomer[100];
    private CorporateCustomer[] corporateCustomers = new CorporateCustomer[100];
    private Operator[] operators = new Operator[100];

    // keep their sizes
    private int orderindex = 0;
    private int retailindex = 0;
    private int corporateindex = 0;
    private int operatorindex = 0;

    public void fillArrays() {  // fill the arrays
        File file = new File("content.txt");
        // temp variables to store the values
        String tempProductName;
        int tempCount;
        int tempTotalPrice;
        int tempStatus;
        int tempCustomerId;
        // count is used to check the ';' count, i could have give it a better name actually
        int count = 0;
        try {
            Scanner contents = new Scanner(file);   // read the file
            int[] allids = new int[100];    // array to store all the ids to prevent the same id to be used again
            int allidsindex = 0;    // size of the allids array
            while (contents.hasNextLine()) {    // read the file line by line
                try{
                    String fileData = new String(contents.nextLine());  // read the line
                    if(fileData.indexOf(";") == -1){    // if there is no ';' in the line, continue
                        throw new Exception();
                    }
                    String[] line = fileData.split(";");    // split the line by ';'
                    for (String str : line) {
                        if (str.equals("")) {   // if there is an empty string, continue
                            throw new Exception();
                        }
                    }
                    if (line[0].equals("order")) {  // if the first element of the line is order
                        try {
                            count = 0;
                            // check the ';' count
                            for(int i=0; i < fileData.length(); i++) {
                                if(fileData.charAt(i) == ';')
                                    count++;
                            }
                            if (count != 5) {
                                throw new Exception();
                            }
                            if (line.length != 6) { // if the line length is not 6, continue
                                throw new Exception();
                            }
                            // fill the temp variables with the values
                            tempProductName = line[1];
                            tempCount = Integer.parseInt(line[2]);
                            tempTotalPrice = Integer.parseInt(line[3]);
                            tempStatus = Integer.parseInt(line[4]);
                            tempCustomerId = Integer.parseInt(line[5]);
                            // check if the values are valid or not
                            if((tempStatus < 0 || tempStatus > 3) || tempCount < 0 || tempTotalPrice < 0 || tempCustomerId < 0 || tempCount == 0){
                                throw new Exception();
                            }
                            //create a new Order object and add it to the orders array
                            Order tempOrder = new Order(tempProductName, tempCount, tempTotalPrice, tempStatus, tempCustomerId);
                            orders[orderindex++] = tempOrder;

                        } catch (Exception e) {
                            continue;
                        }

                    }
                    // same for all classes actually nothing special
                    else if (line[0].equals("retail_customer")) {
                        try {
                            count = 0;
                            // check the ';' count
                            for(int i=0; i < fileData.length(); i++) {
                                if(fileData.charAt(i) == ';')
                                    count++;
                            }
                            if(count != 6){
                                throw new Exception();
                            }
                            if (line.length != 7) {
                                throw new Exception();
                            }
                            String tempName = line[1];
                            String tempSurname = line[2];
                            String tempAddress = line[3];
                            String tempPhone = line[4];
                            int tempId = Integer.parseInt(line[5]);
                            int tempOperatorId = Integer.parseInt(line[6]);
                            if(tempId < 0 || tempOperatorId < 0 || tempId == tempOperatorId){
                                throw new Exception();
                            }
                            RetailCustomer tempRetailCustomer = new RetailCustomer(tempName, tempSurname, tempAddress, tempPhone, tempId, tempOperatorId);
                            for(int i = 0;i < allids.length;i++){
                                if(allids[i] == tempRetailCustomer.getId()){
                                    throw new Exception();
                                }
                            }
                            allids[allidsindex++] = tempRetailCustomer.getId();
                            
                            retailCustomers[retailindex++] = tempRetailCustomer;
                        } catch (Exception e) {
                            continue;
                        }
                    } else if (line[0].equals("corporate_customer")) {
                        try {
                            count = 0;
                            // check the ';' count
                            for(int i=0; i < fileData.length(); i++) {
                                if(fileData.charAt(i) == ';')
                                    count++;
                            }
                            if(count != 7){
                                throw new Exception();
                            }
                            if (line.length != 8) {
                                throw new Exception();
                            }
                            String tempName = line[1];
                            String tempSurname = line[2];
                            String tempAddress = line[3];
                            String tempPhone = line[4];
                            int tempId = Integer.parseInt(line[5]);
                            int tempOperatorId = Integer.parseInt(line[6]);
                            if(tempId < 0 || tempOperatorId < 0 || tempId == tempOperatorId){
                                throw new Exception();
                            }
                            String tempCorporateName = line[7];
                            CorporateCustomer tempCorporateCustomer = new CorporateCustomer(tempName, tempSurname, tempAddress, tempPhone, tempId, tempOperatorId, tempCorporateName);
                            for(int i = 0;i < allids.length;i++){
                                if(allids[i] == tempCorporateCustomer.getId()){
                                    throw new Exception();
                                }
                            }
                            allids[allidsindex++] = tempCorporateCustomer.getId();
                            corporateCustomers[corporateindex++] = tempCorporateCustomer;
                        } catch (Exception e) {
                            continue;
                        }
                    } else if (line[0].equals("operator")) {
                        try {
                            count = 0;
                            // check the ';' count
                            for(int i=0; i < fileData.length(); i++) {
                                if(fileData.charAt(i) == ';')
                                    count++;
                            }
                            if(count != 6){
                                throw new Exception();
                            }
                            if (line.length != 7) {
                                throw new Exception();
                            }
                            String tempName = line[1];
                            String tempSurname = line[2];
                            String tempAddress = line[3];
                            String tempPhone = line[4];
                            int tempId = Integer.parseInt(line[5]);
                            int tempWage = Integer.parseInt(line[6]);
                            if(tempId < 0 || tempWage < 0){
                                throw new Exception();
                            }
                            Operator tempOperator = new Operator(tempName, tempSurname, tempAddress, tempPhone, tempId, tempWage);
                            for(int i = 0;i < allids.length;i++){
                                if(allids[i] == tempOperator.getId()){
                                    throw new Exception();
                                }
                            }
                            allids[allidsindex++] = tempOperator.getId();
                            
                            operators[operatorindex++] = tempOperator;
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    else{
                        continue;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            contents.close();   // close the file
        } catch (Exception e) {
            System.out.println(e);  // if there is an exception, print it
        }
    }

    // getters for the arrays

    public Order[] getOrders() {
        return orders;
    }

    public RetailCustomer[] getRetailCustomers() {
        return retailCustomers;
    }

    public CorporateCustomer[] getCorporateCustomers() {
        return corporateCustomers;
    }

    public Operator[] getOperators() {
        return operators;
    }
}