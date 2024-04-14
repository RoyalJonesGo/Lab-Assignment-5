import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeDA(String empNo, Double salary) throws FileNotFoundException {
        Scanner employeeFile = new Scanner(new FileReader("emp.csv"));

        employeeFile.nextLine();

        while (employeeFile.hasNext()) {
            String employeeRow = employeeFile.nextLine();
            String[] employeeRowSpecific = new String[3];
            employeeRowSpecific = employeeRow.split(",");

            if (empNo.equals(employeeRowSpecific[0])) {
                employee = new Employee();
                employee.setEmpNo(employeeRowSpecific[0]);
                employee.setLastName(employeeRowSpecific[1].trim());
                employee.setFirstName(employeeRowSpecific[2]);
                employee.setSalary(salary);
            }

        }
        employeeFile.close();
    }
}
