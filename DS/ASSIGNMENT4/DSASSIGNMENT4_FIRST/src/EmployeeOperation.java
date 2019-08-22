import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EmployeeOperation {
	Map<Integer, Employee> employeeList;

	EmployeeOperation() {
		employeeList = new HashMap<Integer, Employee>();
	}

	public boolean addEmployee(int id, String name, String address) {
		if (employeeList.containsKey(id)) {
			throw new AssertionError("Employee already exist!!");
		}
		Employee employee = new Employee(id, name, address);
		employeeList.put(id, employee);
		return true;
	}

	public boolean deleteEmployee(int id) {
		if (employeeList.containsKey(id)) {
			employeeList.remove(id);
			return true;
		}
		return false;
	}

	public void showEmployee() {
		System.out.println("Id \tName \t\tAddress");
		for (int idkey : employeeList.keySet()) {
			int id = employeeList.get(idkey).getEmpId();
			String name = employeeList.get(idkey).getName();
			String address = employeeList.get(idkey).getAddress();
			System.out.println(id + "\t" + name + "\t\t" + address);
		}
	}

	public void sortById() {
		System.out.println("\nAfter Sorting:-\n");
		System.out.println("Id \tName \t\tAddress");
		ArrayList<Integer> empList = new ArrayList<Integer>(
				employeeList.keySet());
		Collections.sort(empList);
		for (int index = 0; index < empList.size(); index++) {
			int id = empList.get(index);
			Employee emp = employeeList.get(empList.get(index));
			System.out.println(id + "\t" + emp.getName() + "\t\t"
					+ emp.getAddress());
		}
	}

	public void sortByName() {
		System.out.println("\nAfter Sorting:-\n");
		System.out.println("Id \tName \t\tAddress");
		ArrayList<Employee> empList = new ArrayList<Employee>(employeeList.values());
		Collections.sort(empList, sortAccordingToName);
		for (int index = 0; index < empList.size(); index++) {
			Employee emp = empList.get(index);
			System.out.println(emp.getEmpId() + "\t" + emp.getName() + "\t\t"
					+ emp.getAddress());
		}
	}

	public Comparator<Employee> sortAccordingToName = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			String name1 = e1.getName();
			String name2 = e2.getName();
			return name1.compareTo(name2);
		}
	};
}