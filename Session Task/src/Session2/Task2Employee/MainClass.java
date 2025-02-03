package Session2.Task2Employee;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        boolean temp = true;

        while (temp) {
            try { // handle the wrong input exception
                System.out.println("Enter the data if you want to add  Organization for1, Dept for  2 and Employee for 3"); // use to get input from user
                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt();

                switch (i) {
                    case 1 -> { // for Organization data add
                        System.out.println("Enter organization id ");
                        int org_id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the organization name: ");
                        String org_name = sc.nextLine();
                        Org org = new Org(org_id, org_name);
                        org.addOrg(org_id, org.org_name);
                    }
                    case 2 -> { // department data add
                        System.out.println("Enter Department id ");
                        int dept_Id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter department name: ");
                        String dept_name = sc.nextLine();
                        System.out.println("Enter the organization id ");
                        int org_id = sc.nextInt();
                        Dept dept = new Dept(dept_name, dept_Id, org_id);
                        dept.addDept(dept.dept_name, dept.dept_id, org_id); // for department data add
                    }

                    case 3 -> { // employee data add
                        sc.nextLine();
                        System.out.println("Enter employee name: ");
                        String employee_name = sc.nextLine();
                        System.out.println("Enter the employee id: ");
                        int employee_id = sc.nextInt();
                        System.out.println("Enter the organization id: ");
                        int org_id = sc.nextInt();
                        System.out.println("Enter the department id: ");
                        int dept_id = sc.nextInt();
                        Employee employee = new Employee(employee_name, employee_id, org_id, dept_id);
                        employee.addEmployee(employee); // for employee data add
                    }
                    default -> System.out.println("You enter the wrong number");
                }
                System.out.println("Do you want to add more data? If yes, press 1; if no, press 2"); // if user wants to add more data
                int temp2 = sc.nextInt();
                if (temp2 != 1) {
                    temp = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter valid data with proper datatype");
            }
        }
        System.out.println("Loop end");
        System.out.println("Employee count by organization ID: " + Employee.countEmployeeByOrgId()); // Example org ID
        System.out.println("Employee count by department ID: " + Employee.countEmployeeByDeptId()); // Example dept ID
    }
}
