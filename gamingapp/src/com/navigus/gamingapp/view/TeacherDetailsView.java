package com.navigus.gamingapp.view;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.navigus.gamingapp.dto.TeacherDetailsDTO;
import com.navigus.gamingapp.repo.ITeacherDetailsRepo;
import com.navigus.gamingapp.repo.TeacherDetailsRepo;

public class TeacherDetailsView {

private static Scanner scanner= new Scanner(System.in);
	
	
	private static void addTeacherDetails() {
		
		
		System.out.println("Enter your Id: ");
		int teacherId= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your name: ");
		String teacherName= scanner.nextLine();
		System.out.println("Enter your designation: ");
		String teacherDesignation= scanner.nextLine();
		System.out.println("Enter your Department: ");
		String teacherDepartment= scanner.nextLine();
		
		TeacherDetailsDTO td= new TeacherDetailsDTO(teacherId, teacherName, teacherDesignation, teacherDepartment);
		ArrayList<TeacherDetailsDTO> details= null;
		String result=" Details Not Added.";
		
		try {
			ITeacherDetailsRepo repo= TeacherDetailsRepo.getInstance();
			
			try {
				details= repo.printTeacherDetail();
			}catch(EOFException e) {
				System.out.println(" The file is empty. Please enter teacher details!");
			}
			
			if(details!=null && details.size()>0) {
				details.add(td);
			}
			else {
				details= new ArrayList<>();
				details.add(td);
			}
			result= repo.addTeacherDetail(details)?"Details Added Successfully :->": " Details not Added :-<";
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);	
	}
	
	private static void printTeacherDetails() {
		try {
			ITeacherDetailsRepo repo= TeacherDetailsRepo.getInstance();
			ArrayList<TeacherDetailsDTO> details= repo.printTeacherDetail();
			for(TeacherDetailsDTO detail: details) {
				System.out.println(detail);
			}
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
    public static void editCourseDetails() {
		
		// Ask teacher to edit courses
		System.out.println("Do you want to edit any course: Y/N  ");
		String choice= scanner.nextLine();
		
		// Details are entered in a list
		System.out.println("List you can make changes on");
		teacherView();
	}
	
	private static void teacherView() {
		outer:
			while(true) {
				System.out.println("1. Add Teacher Details");
				System.out.println("2. Print Teacher Deatils ");
				System.out.println("3. Print Student Details");
				System.out.println("4. Exit");
				System.out.println("Enter your choice");
				
				int choice= scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter your details");
					addTeacherDetails();
					break;
				case 2:
					printTeacherDetails();
					break;
				case 3:
	                StudentDetailsView.callingMethod();
					break;
				case 4:
					System.out.println("Exit Successfull");
					break outer;
				default:
					System.out.println("Invalid choice");
				}
			}
		
		// Ask for the type of changes they want to make in the course
		System.out.println("What changes do you want to make");
		GamingView.gameView();
		scanner.close();
	}
}

