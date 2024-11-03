package com.crudoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
	private int rollNo;
	private String name;
	private String department;

	public Student(int rollNo, String name, String department) {
		this.rollNo = rollNo;
		this.name = name;
		this.department = department;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", department=" + department + "]";
	}

}

public class StudentCrud {
	static List<Student> studentList = new ArrayList<>();

	public static void addStudent(Scanner scanner) {
		System.out.println("Enter student rollNo:");
		int rollNo = scanner.nextInt();
		System.out.println("Enter student name:");
		String name = scanner.next();
		System.out.println("Enter student department:");
		String department = scanner.next();

		Student newStudent = new Student(rollNo, name, department);
		studentList.add(newStudent);

	}

	public static void viewStudent() {
		if (studentList.isEmpty()) {
			System.out.println("students not their in the list");
		} else {
			System.out.println("students list:");
			for (Student stu : studentList) {
				System.out.println(stu);
			}
		}
	}

	public static Student findStudentByrollNo(int rollNo) {
		for (Student stu : studentList) {
			if (stu.getRollNo() == rollNo) {
				return stu;
			}
		}
		return null;
	}

	public static void updateStudent(Scanner scanner) {
		System.out.println("Enter student rollNo to update");
		int rollNo = scanner.nextInt();
		Student StudentToUpdate = findStudentByrollNo(rollNo);
		if (StudentToUpdate != null) {
			System.out.println("enter new rollNo");
			StudentToUpdate.setRollNo(scanner.nextInt());
			System.out.println("Enter new name:");
			StudentToUpdate.setName(scanner.nextLine());
			System.out.println("Enter new department:");
			StudentToUpdate.setDepartment(scanner.nextLine());
		} else {
			System.out.println("Student not found with this rollNo");
		}
	}

	public static void deleteStudent(Scanner scanner) {
		System.out.println("Enter student rollNo to delete");
		int rollNo = scanner.nextInt();
		Student StudentToDelete = findStudentByrollNo(rollNo);
		if (StudentToDelete != null) {
			studentList.remove(StudentToDelete);
		} else {
			System.out.println("Student not found with this rollNo");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("\nStudent Management System:");
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addStudent(scanner);
				break;
			case 2:
				viewStudent();
				break;
			case 3:
				updateStudent(scanner);
				break;
			case 4:
				deleteStudent(scanner);
				break;
			case 5:
				System.out.println("Exiting....");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}

}
