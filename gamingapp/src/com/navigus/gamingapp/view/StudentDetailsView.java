package com.navigus.gamingapp.view;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.navigus.gamingapp.dto.StudentDetailsDTO;
import com.navigus.gamingapp.repo.IStudentDetailsRepo;
import com.navigus.gamingapp.repo.QuizAttempt;
import com.navigus.gamingapp.repo.StudentDetailsRepo;


public class StudentDetailsView {

private static Scanner scanner= new Scanner(System.in);
	
	
	private static void addStudentDetails() {
		
		
		System.out.println("Enter your Roll No ");
		int rollNo= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your Name ");
		String studentName= scanner.nextLine();
		System.out.println("Enter your Age ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your Stream ");
		String streamD= scanner.nextLine();
		System.out.println("Enter your College Name");
		String collegeName= scanner.nextLine();
		
		StudentDetailsDTO td= new StudentDetailsDTO(rollNo, studentName, age , streamD ,collegeName);
		ArrayList<StudentDetailsDTO> details= null;
		String result=" Details Not Added.";
		
		try {
			IStudentDetailsRepo repo= StudentDetailsRepo.getInstance();
			
			try {
				details= repo.printStudentDetail();
			}catch(EOFException e) {
				System.out.println(" The file is empty. Please enter student details!");
			}
			
			if(details!=null && details.size()>0) {
				details.add(td);
			}
			else {
				details= new ArrayList<>();
				details.add(td);
			}
			result= repo.addStudentDetail(details)?"Details Added Successfully :->": " Details not Added :-<";
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);	
	}
	
	private static void printStudentDetails() {
		try {
			IStudentDetailsRepo repo= StudentDetailsRepo.getInstance();
			ArrayList<StudentDetailsDTO> details= repo.printStudentDetail();
			for(StudentDetailsDTO detail: details) {
				System.out.println(detail);
			}
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void callingMethod() {
		printStudentDetails();
	}
	
	public static void studentView() {
		outer:
			while(true) {
				System.out.println("1. Add Student Details");
				System.out.println("2. Attempt Quiz");
				System.out.println("3. Exit");
				System.out.println("Enter your choice");
			
				int choice= scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter your details");
					addStudentDetails();
					break;
				case 2:
					try {
						QuizAttempt.attemptQuiz();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Exit Successfull");
					break outer;
				default:
					System.out.println("Invalid choice");
				}
			}
	
		scanner.close();
	}
}
