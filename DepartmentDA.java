import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {
    private HashMap<String, Employee> employeeMap;

    public DepartmentDA() throws FileNotFoundException {
        Scanner deptFile = new Scanner(new FileReader("dep.csv"));
        employeeMap = new HashMap<>();

        deptFile.nextLine();

        while (deptFile.hasNext()) {
            String depRow = deptFile.nextLine();
            String[] depRowSpecific = depRow.split(",");

            Department department = new Department();
            department.setDepCode(depRowSpecific[0]);
            department.setDepName(depRowSpecific[1].trim());

            readDepEmp(department);
            department.setEmployeeMap(employeeMap);

            Double totalSalary = 0.00;
            for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
                totalSalary += entryMap.getValue().getSalary();
            }
            department.setDepTotalSalary(totalSalary);

            printDepartment(department);
        }
        deptFile.close();
    }

    private void printDepartment(Department department) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        System.out.println("Department code: " + department.getDepCode() +
                           "\nDepartment name: " + department.getDepName() +
                           "\nDepartment total salary: " + df.format(department.getDepTotalSalary()) +
                           "\n---------------------Details -------------------------" +
                           "\nEmpNo\t\tEmployee Name\tSalary");

        for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
            Employee employee = entryMap.getValue();
            System.out.println(employee.getEmpNo() + "\t" +
                               employee.getLastName() + "," + employee.getFirstName() + "\t" +
                               df.format(employee.getSalary()));
        }
        System.out.println();
    }

    private void readDepEmp(Department department) throws FileNotFoundException {
        Scanner deptEmpFile = new Scanner(new FileReader("deptemp.csv"));
        employeeMap.clear();
        deptEmpFile.nextLine();

        while (deptEmpFile.hasNext()) {
            String deptEmpRow = deptEmpFile.nextLine();
            String[] deptEmpRowSpecific = deptEmpRow.split(",");

            if (department.getDepCode().equals(deptEmpRowSpecific[0])) {
                EmployeeDA employeeDA = new EmployeeDA(deptEmpRowSpecific[1].trim(), Double.parseDouble(deptEmpRowSpecific[2].trim()));
                employeeMap.put(deptEmpRowSpecific[1].trim(), employeeDA.getEmployee());
            }
        }
        deptEmpFile.close();
    }
}
