package Session2.BeautySaloon;

import java.util.Date;

/**
 * In this class extend a customer class for use their methods and variables
 */
//class Visit extends Customer {
//    Date date;
//    double serviceExpense;
//    double productExpense;
//    Customer customer;
//
//    Visit(String name, Date date) {
//
//        super(name);        // Call the superclass constructor
//        this.date = date;
//    }
//
//    DiscountRate discountObj = new DiscountRate(); // Create object of discount rate class
//
//    @Override
//    public String getName() {
//        return super.getName(); // Call the superclass method
//    }
//
//    double getServiceExpense() {
//        return serviceExpense;
//    }
//
//    double getProductExpense() {
//        return productExpense;
//    }
//
//    void setServiceExpense(double serviceExpense) {
//
//        if (isMember()) {
//            this.serviceExpense = serviceExpense - (serviceExpense * discountObj.getServiceDiscountRate(getMemberType()));   // calculate service expenses with discount
//            System.out.println(discountObj.getServiceDiscountRate(membertype));
//        } else {
//            this.serviceExpense = serviceExpense;
//        }
//    }
//
//    void setProductExpense(double productExpense) {
//
//        if (isMember()) {
//            System.out.println(getMemberType());
//            this.productExpense = productExpense - (productExpense * discountObj.getProductDiscountRate(getMemberType()));
//            System.out.println(discountObj.getProductDiscountRate(membertype));
//        } else {
//            this.productExpense = productExpense - (productExpense * 0.1); // we give every customer to 10% discount of every product
//
//        }
//    }
//
//    double getTotalExpense() {
//        return serviceExpense + productExpense;
//    }
//
//    @Override
//    public String toString() {  // print Customer class variables and also visit class variable
//        return "Visit{" +
//                "date=" + date +
//                ", serviceExpense=" + serviceExpense +
//                ", productExpense=" + productExpense +
//                ", name=" + getName() +
//                ", member=" + isMember() +
//                ", membertype=" + getMemberType() +
//                '}';
//    }
//}

/**
 * in this class we can create a customer class object and use that object to perform various task
 */
class Visit {
    private  Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, Date date) {  // set the data
        this.customer = customer;
        this.date = date;
    }

    public String getName() {      // get the customer name
        return customer.getName();
    }

    public double getServiceExpense() {  // get the service expenses
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {   // calculate the service expense and set the data
        if (customer.isMember()) {
            this.serviceExpense = serviceExpense - (serviceExpense * DiscountRate.getServiceDiscountRate(customer.getMemberType()));   // calculate service expenses with discount

        } else {
            this.serviceExpense = serviceExpense;
        }
    }

    public double getProductExpense() {  // get the product expense
        return productExpense;
    }

    public void setProductExpense(double productExpense) {  // calculate the product expense and set the data
        if (customer.isMember()) {

            this.productExpense = productExpense - (productExpense * DiscountRate.getProductDiscountRate(customer.getMemberType()));
            this.productExpense = productExpense - (productExpense * DiscountRate.getProductDiscountRate(customer.getMemberType()));

        } else {
            this.productExpense = productExpense - (productExpense * 0.1); // we give every customer to 10% discount of every product

        }
    }

    public double getTotalExpense() {   // calculate the total expense
        return serviceExpense + productExpense;
    }


    public String toString() {    // override from toString method for get all data parallel
        return "Visit{" +
                "customer=" + customer +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }
}
