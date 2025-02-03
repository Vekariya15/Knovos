package Session2.Task2Employee;

import java.util.HashMap;
import java.util.Map;

public class Dept {
    int dept_id;
    int org_id;
    String dept_name;

    static Map<Integer, String> deptMap = new HashMap<>();

    Dept(String name, int dept_id, int org_id) {
        this.dept_name = name;
        this.dept_id = dept_id;
        this.org_id = org_id;
    }

    public void addDept(String deptName, int deptId, int org_id) {
        this.dept_name = deptName;
        this.dept_id = deptId;
        this.org_id = org_id;

        if (deptMap.containsKey(deptId)) {
            System.out.println("Data already present");
        } else {
            deptMap.put(deptId, deptName);
            System.out.println("Data added successfully");
        }
    }
}
