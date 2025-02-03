package Session2.Task2Employee;

import java.util.HashMap;
import java.util.Map;

public class Org {
    int org_id;
    String org_name;

    static Map<Integer, String> orgMap = new HashMap<>();

    Org(int org_id, String name) {  // set a value od organization
        this.org_id = org_id;
        this.org_name = name;
    }

    public void addOrg(int org_id, String name) {
        this.org_id = org_id;
        this.org_name = name;

        if (orgMap.containsKey(org_id)) {                   // check if data present or not
            System.out.println("Data already present");
        } else {
            orgMap.put(org_id, name);                       // data add in hash map
            System.out.println("Data added successfully");
        }
    }
}
