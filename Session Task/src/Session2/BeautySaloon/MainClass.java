package Session2.BeautySaloon;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is main class to perform all operation
 */
public class MainClass {
    /**
     * First create visit class object
     *
     * @param args it is a saloon management system for calculate a product cost and membership cost
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the customer name: ");
            String name = sc.nextLine();

//        Visit visit = new Visit(name, new Date());   // create visit class object for if we use  inheritance for all activity
            Customer customer = new Customer(name);
            Visit visit = new Visit(customer, new Date());

            System.out.println("Do you want to buy our membership plan? (true/false)");  // if customer want to buy any membership so,
            boolean s1 = sc.nextBoolean();
            sc.nextLine();

            if (s1) {
                System.out.println("Which type: Premium, Gold, Silver?");
                String str = sc.nextLine();

                customer.setMember(true);          // set the data into customer object
                customer.setMemberType(str);
                System.out.println(customer.getMemberType());
            } else {
                customer.setMember(false);
                System.out.println(customer.getMemberType());
            }

            int service_expense;
            int product_expense;

            System.out.println("Enter the service expense : ");
            service_expense = sc.nextInt();
            visit.setServiceExpense(service_expense);
            System.out.println("Enter the product expense : ");
            product_expense = sc.nextInt();
            visit.setProductExpense(product_expense);
            System.out.println("Product Expense " + visit.getProductExpense());
            System.out.println("Service Expense " + visit.getServiceExpense());
            System.out.println("Total Expense " + visit.getTotalExpense());
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid data with proper Datatype ");
        }
    }
}
