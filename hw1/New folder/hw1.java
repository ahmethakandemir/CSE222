import java.io.File;
import java.util.Scanner;

class hw1 {
    public static void main(String[] args) {
        FileContent contents = new FileContent();
        contents.fillArrays();
        Order[] orders = contents.getOrders();
        RetailCustomer[] retailCustomers = contents.getRetailCustomers();
        CorporateCustomer[] corporateCustomers = contents.getCorporateCustomers();
        Operator[] operators = contents.getOperators();

        for (int i = 0;i < retailCustomers.length;i++){
            Order[] temporders = new Order[100];
            int tempindex = 0;
            for (int j = 0;j < orders.length;j++) {
                if (retailCustomers[i] != null && orders[j] != null){
                    if (retailCustomers[i].getId() == orders[j].getCustomerId()) {
                        temporders[tempindex++] = orders[j];
                        retailCustomers[i].increaseorderindex();
                    }
                }
            }
            if(retailCustomers[i] != null)
                retailCustomers[i].setOrders(temporders);
        }
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
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your id: ");
            inputid = input.nextInt();
            input.close();
        }
        catch(Exception e){
            System.err.println("Id entered is not valid!");
            return;
        }
        int flag = 0;
        for (int i = 0;i < operators.length;i++) {
            if (operators[i] != null) {
                if (operators[i].getId() == inputid) {
                    operators[i].print_operator();
                    flag = 1;
                }
            }
        }
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
        if (flag == 0) {
            System.out.println("No operator/customer was found with ID " + inputid + ". Please try again.");
        }
    }
}

class Person {
    private String name;
    private String surname;
    private String role;
    private String address;
    private int id;
    private String phone;

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

    Person(String aRole, String aName, String aSurname, String aAddress, String aPhone, int anId) {
        setName(aName);
        setSurname(aSurname);
        setAdress(aAddress);
        setId(anId);
        setPhone(aPhone);
        setRole(aRole);
    }

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
    private int operatorId;
    private Order[] orders = new Order[100];
    private int orderindex = 0;

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

    Customer(String aRole, String aName, String aSurname, String aAddress, String aPhone, int anId, int anOperatorId) {
        super(aRole, aName, aSurname, aAddress, aPhone, anId);
        setOperatorId(anOperatorId);
    }

    Customer() {
        super();
        setOperatorId(0);
    }
}

class RetailCustomer extends Customer {

    RetailCustomer(String aName, String aSurname, String aAddress, String aPhone, int anId, int anOperatorId) {
        super("retail_customer", aName, aSurname, aAddress, aPhone, anId, anOperatorId);
    }
    public void print_customer() {
        System.out.println(
                "Name & Surname: " + getName() + " " + getSurname() + "\n" + //
                "Address: " + getAdress() + "\n" +//
                "Phone: " + getPhone() + "\n" + //
                "ID: " + getId() + "\n" + //
                "Operator ID: " + getOperatorId());//;
                
        print_orders();
    }
}

class CorporateCustomer extends Customer {
    private String corporateName;

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    CorporateCustomer(String aName, String aSurname, String aAddress, String aPhone, int anId, int anOperatorId,
            String corporateName) {
        super("corporate_customer", aName, aSurname, aAddress, aPhone, anId, anOperatorId);
        setCorporateName(corporateName);
    }

    CorporateCustomer() {
        super();
        corporateName = "";
    }
    public void print_customer() {
        System.out.println(
                "Name & Surname: " + getName() + " " + getSurname() + "\n" + //
                "Address: " + getAdress() + "\n" +//
                "Phone: " + getPhone() + "\n" + //
                "ID: " + getId() + "\n" + //
                "Operator ID: " + getOperatorId() + "\n" + //;
                "Corporate Name: " + getCorporateName()); //;
                
        print_orders();
    }
}

class Operator extends Person {
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

    Operator() {
        super();
        setWage(0);
    }
    public void print_customers(){
        for(int i = 0; i < customerindex; i++){
            Customer customer = customers[i];
            System.out.println("\n----------------------------\nCustomer #" + (i + 1) + " (a " + customer.getRole().replace("_"," ") + ")\n");
            if (customer.getRole().equals("retail_customer")) {
                RetailCustomer retailCustomer = (RetailCustomer) customer;
                retailCustomer.print_customer();
            } else if (customer.getRole().equals("corporate_customer")) {
                CorporateCustomer corporateCustomer = (CorporateCustomer) customer;
                corporateCustomer.print_customer();
            }
        }
        System.out.println("\n----------------------------");
    }

    Operator(String aName, String aSurname, String aAddress, String aPhone, int anId, int aWage) {
        super("operator", aName, aSurname, aAddress, aPhone, anId);
        setWage(aWage);
    }
    public void print_operator() {
        System.out.println("*** Operator Screen ***\n----------------------------\n" + //
                "Name & Surname: " + getName() + " " + getSurname() + "\n" + //
                "Address: " + getAdress() + "\n" +//
                "Phone: " + getPhone() + "\n" + //
                "ID: " + getId() + "\n" + //
                "Wage: " + getWage()); //;
                
        print_customers();
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

    Order() {
        setCount(0);
        setCustomerId(0);
        setProductName("");
        setStatus(0);
        setTotalPrice(0);
    }

    Order(String aProductName, int aCount, int aTotalPrice, int aStatus, int aCustomerId) {
        setProductName(aProductName);
        setCount(aCount);
        setTotalPrice(aTotalPrice);
        setStatus(aStatus);
        setCustomerId(aCustomerId);
    }
    public void print_order() {
        System.out.print("Product Name: " + getProductName() + " - " +//
                "Count: " + getCount() + " - " +//
                "Total Price: " + getTotalPrice() + " - " +//
                "Status: " + getStatus());
    }
}

class FileContent {
    private Order[] orders = new Order[100];
    private RetailCustomer[] retailCustomers = new RetailCustomer[100];
    private CorporateCustomer[] corporateCustomers = new CorporateCustomer[100];
    private Operator[] operators = new Operator[100];

    private int orderindex = 0;
    private int retailindex = 0;
    private int corporateindex = 0;
    private int operatorindex = 0;

    void fillArrays() {
        File file = new File("content.txt");
        String tempProductName;
        int tempCount;
        int tempTotalPrice;
        int tempStatus;
        int tempCustomerId;
        int count = 0;
        try {
            Scanner contents = new Scanner(file);
            int[] allids = new int[100];
            int allidsindex = 0;
            while (contents.hasNextLine()) {
                try{
                    String fileData = new String(contents.nextLine());
                    if(fileData.indexOf(";") == -1){
                        throw new Exception();
                    }
                    String[] line = fileData.split(";");
                    for (String str : line) {
                        if (str.equals("")) {
                            throw new Exception();
                        }
                    }
                    if (line[0].equals("order")) {
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
                            if (line.length != 6) {
                                throw new Exception();
                            }
                            tempProductName = line[1];
                            tempCount = Integer.parseInt(line[2]);
                            tempTotalPrice = Integer.parseInt(line[3]);
                            tempStatus = Integer.parseInt(line[4]);
                            tempCustomerId = Integer.parseInt(line[5]);
                            if((tempStatus < 0 || tempStatus > 3) || tempCount < 0 || tempTotalPrice < 0 || tempCustomerId < 0 || tempCount == 0){
                                throw new Exception();
                            }
                            Order tempOrder = new Order(tempProductName, tempCount, tempTotalPrice, tempStatus, tempCustomerId);
                            orders[orderindex++] = tempOrder;

                        } catch (Exception e) {
                            continue;
                        }

                    }
                    // same for all classes with try except block
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
            contents.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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