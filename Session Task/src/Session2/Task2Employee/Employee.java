package Session2.Task2Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee {
    String E_name;
    int dept_id;
    int org_id;
    int employee_id;

    static Map<Integer, Employee> EmployeeMap = new HashMap<>();
    static Map<Integer, Integer> deptEmployeeCount = new HashMap<>();
    static Map<Integer, Integer> orgEmployeeCount = new HashMap<>();

    Employee(String e_name, int employee_id, int dept_id, int org_id) {
        this.E_name = e_name;
        this.employee_id = employee_id;
        this.dept_id = dept_id;
        this.org_id = org_id;
    }

    public void addEmployee(Employee employee) {
        if (EmployeeMap.containsKey(employee.employee_id)) {
            System.out.println("Data already present");
        } else {
            EmployeeMap.put(employee.employee_id, employee);
            deptEmployeeCount.put(employee.dept_id, deptEmployeeCount.getOrDefault(employee.dept_id, 0) + 1);
            orgEmployeeCount.put(employee.org_id, orgEmployeeCount.getOrDefault(employee.org_id, 0) + 1);
            System.out.println("Data added successfully");
        }
    }

    public static int countEmployeeByOrgId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter organization id: ");
        int orgId = sc.nextInt();
        return orgEmployeeCount.getOrDefault(orgId, 0);
    }

    public static int countEmployeeByDeptId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department id: ");
        int deptId = sc.nextInt();
        return deptEmployeeCount.getOrDefault(deptId, 0);
    }
}
