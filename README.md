# Lab-Assignment-5
You are required to present a department report that accesses csv files. You must put the data on the domain composition of the objects.
dep.csv contains the following

deptCode, deptName, location
IT, Information Tech, 2nd floor
HR, Human Resource, 3rd floor
FNC, Finance, 4th floor

The deptemp.csv is referenced to get the salary  of the employees per department:

deptCode, empNo, salary
IT, E123, 30000
IT, E124, 45000
IT, E125, 51000
HR, E251, 66000
HR, E252, 25000
FNC, E370, 42000
FNC, E371, 29000
FNC, E372, 37000

To get the details of the employee you must access the emp.csv:

empNo, lastName, firstName, job
E123, Maxwell, John, Developer
E124, Delos Reyes, Ernesto, Analyst
E125, Ortiz, Manuel, Tester
E251, Natividad, Lisa, HR Manager
E252, Rosanto, Margareth, HR Specialist
E370, Baldo, Jason, Team Leader
E371, Hernandez, Timothy, Junior Accountant
E372, Cruz, Ricardo, CPA
This will be the sample generated report:
Department code: IT
Department name: Information Tech
Department total salary: 126,000.00
---------------------Details -------------------------
EmpNo		 Employee Name	Salary
E123		Maxwell, John			30,000.00
E125		Ortiz, Manuel			51,000.00
E124		Delos Reyes, Ernesto		45,000.00

Department code: HR
Department name: Human Resource
Department total salary: 91,000.00
---------------------Details -------------------------
EmpNo		 Employee Name	Salary
E252		Rosanto, Margareth		25,000.00
E251		Natividad, Lisa		66,000.00

Department code: FNC
Department name: Finance
Department total salary: 108,000.00
---------------------Details -------------------------
EmpNo		 Employee Name	Salary
E370		Baldo, Jason			42,000.00
E371		Hernandez, Timothy		29,000.00
E372		Cruz, Ricardo			37,000.00

INSTRUCTIONS:
You are not allowed to alter the composition of the domain objects.  Stick to the design. Disregard the data in the csv if it is not necessary to the object.
Adhere to correct naming conventions in naming variables and objects.
Use hashmap as your solution to the problem.
Use the department.setDepTotalSalary() in putting the aggregated value into the object.  Do not just use the salary accumulation approach in the printing process to get the depTotalSalary.
Submit the Github solution link provided in NEUVLE.
