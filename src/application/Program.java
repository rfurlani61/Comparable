package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		String path = "C:\\temp\\nomes.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		String EmployeeCSV = br.readLine();
		while (EmployeeCSV != null) {
			String[] fields = EmployeeCSV.split(",");
			list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
			EmployeeCSV = br.readLine();
		}
		Collections.sort(list);
		for (Employee e : list) {
		System.out.println(e.getName() + " , R$ " + e.getSalary());
		}
		} catch (IOException e) {
		System.out.println("Error: " + e.getMessage());
		}
	}

}
