package com.navigus.gamingapp.view;

import java.io.IOException;
import java.util.Scanner;

public class Launch {

	private static Scanner scanner= new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Please enter you are a -- Student(S) / Teacher(T)");
		String choice= scanner.nextLine();
		
		if(choice.equalsIgnoreCase("S")) {
			StudentDetailsView.studentView();
		}
		
		if(choice.equalsIgnoreCase("T")) {
			TeacherDetailsView.editCourseDetails();  
		}
		
		if(!(choice.equalsIgnoreCase("S") | choice.equalsIgnoreCase("T")) ) {
			System.out.println("You cannot access this as you are neither a student nor a teacher! ");
		}
		
	}
}
