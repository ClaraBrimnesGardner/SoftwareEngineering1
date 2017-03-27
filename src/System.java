/**
 * Created by clarabrimnesgardner on 27/03/2017.
 */

import java.util.*;
public class System {
    private List<Employee> EmployeeList=new ArrayList<Employee>();

    public void addEmployee(String ID){
        Employee Worker =new Employee(ID);
        EmployeeList.add(Worker);
    }

    public List<Employee> getEmployeeList(){
        return EmployeeList;
    }




}
