package Session2.Task2EmployeeJDBC;

import java.util.Scanner;

public class MainClassJDBC {

    public static void main(String[] args) {
        boolean temp = true;

        while (temp) {
            try { // handle the wrong input exception
                System.out.println("Enter the data if you want to add Dept for 1, Organization for 2 and Employee for 3"); // use to get input from user
                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt();

                switch (i) {
                    case 1 -> {
                        sc.nextLine();
                        System.out.println("Enter department name: ");
                        String dept_name = sc.nextLine();
                        System.out.println("Enter the organization id: ");
                        int org_id = sc.nextInt();
                        DeptJDBC dept = new DeptJDBC(dept_name, org_id);
                        dept.addDept(dept.dept_name, org_id); // for department data add
                    }
                    case 2 -> {
                        sc.nextLine();
                        System.out.println("Enter the organization name: ");
                        String org_name = sc.nextLine();
                        OrgJDBC org = new OrgJDBC(org_name);
                        org.addOrg(org.org_name); // for Organization data add
                    }
                    case 3 -> {
                        sc.nextLine();
                        System.out.println("Enter employee name: ");
                        String employee_name = sc.nextLine();
                        System.out.println("Enter the organization id: ");
                        int org_id = sc.nextInt();
                        System.out.println("Enter the department id: ");
                        int dept_id = sc.nextInt();
                        EmployeeJDBC employee = new EmployeeJDBC(employee_name, dept_id, org_id);
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
        EmployeeJDBC.countEmployeeByOrgId();
        EmployeeJDBC.countEmployeeByDeptId();
    }
}
