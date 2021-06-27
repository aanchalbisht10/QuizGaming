package com.navigus.gamingapp.view;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.navigus.gamingapp.dto.GamingDTO;
import com.navigus.gamingapp.repo.GamingRepo;
import com.navigus.gamingapp.repo.IGamingRepo;
import com.navigus.gamingapp.repo.QuizCreateRepo;

import static com.navigus.gamingapp.utils.Constants.PENDING;
import static com.navigus.gamingapp.utils.Constants.COMPLETE;

public class GamingView {
	
	private static Scanner scanner= new Scanner(System.in);
	
	private static void addCourse() {
		
		scanner.nextLine();
		System.out.println("Enter the course id you want to create: ");
		String courseId= scanner.nextLine();
		
		System.out.println("Enter the course name you want to create: ");
		String courseName= scanner.nextLine();
		
		System.out.println("Enter the course description you want to create: ");
		String courseDesc= scanner.nextLine();
		
		GamingDTO gaming= new GamingDTO(courseName, courseDesc, courseId);
		String result= "Course Not Added";
		
		ArrayList<GamingDTO> courses=null;
		try {
			IGamingRepo repo= GamingRepo.getInstance(); 
		
		try {
			courses=repo.printCourse();
		}catch(EOFException e) {
			System.out.println("The file is empty. Please add courses!");	
		}
		
		if(courses!=null && courses.size()>0) {
			courses.add(gaming);
		}
		else {
			courses= new ArrayList<>();
			courses.add(gaming);
		}
		result=  repo.addCourse(courses)?"Course Added": "Course Not Added";
			
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	private static void printCourse() {
		try {
			IGamingRepo repo= GamingRepo.getInstance();
			ArrayList<GamingDTO> courses= repo.printCourse();
			for(GamingDTO course: courses) {
				System.out.println(course);
			}
		}catch(ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
	}
	
	private static void deleteCourse() {
		int flag=0;
		IGamingRepo repo=null;
		try {
			repo= GamingRepo.getInstance();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<GamingDTO> courses=null;
		try {
			courses= repo.printCourse();
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		scanner.nextLine();
		System.out.println("Enter the course which you want to delete: ");
		String delete_name= scanner.nextLine();
		for(GamingDTO course: courses) {
			if(delete_name.replaceAll("//s", "").equalsIgnoreCase(course.getCourseName().replaceAll("//s", ""))){
				System.out.println("Course removed ");
				flag=1;
				continue;
			}
			else {
				try {
					repo.addCourse(courses);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(flag!=1) {
			System.out.println("Course Not Found");
		}
	}
	
	private static void updateCourse() {
		IGamingRepo repo=null;
		int flag=0;
		try {
			repo= GamingRepo.getInstance();
		}catch(IOException e) {
			e.printStackTrace();
		}
		ArrayList<GamingDTO> courses=null;
		try {
			courses= repo.printCourse();
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		String result= null;
		scanner.nextLine();
		System.out.println("Enter name of course you want to edit: ");
		String name= scanner.nextLine();
		
		for(GamingDTO course: courses) {
			if(name.equalsIgnoreCase(course.getCourseName())) {
				outer:
					while(true) {
						result = "Not Updated";
						System.out.println("1. Update Name");
						System.out.println("2. Update Description");
						System.out.println("3. Update Date");
						System.out.println("4. Update Course Id");
						System.out.println("5. Update Status");
						System.out.println("6. Exit");
						System.out.println("Enter your choice: ");
						int choice = scanner.nextInt();
						scanner.nextLine();
						switch (choice) {
							case 1:
								System.out.println("Update Course Name: ");
								String courseName = scanner.nextLine();
								course.setCourseName(courseName);
								result = "Course Name Updated";
								break;
							case 2:
								System.out.println("Update Course Description: ");
								String courseDesc = scanner.nextLine();
								course.setCourseDesc(courseDesc);
								result = "Course Description Updated";
								break;
							case 3:
								course.setDate(new Date());
								System.out.println("Update New Date");
								result = "Date Updated";
								break;
							case 4:
								System.out.println("Update Course Id: ");
								String courseId = scanner.nextLine();
								course.setCourseId(courseId);
								result = "Course Id Updated";
								break;
							case 5:
								if (course.getStatus().equals(PENDING)) {
									course.setStatus(COMPLETE);
								}
								else {
									course.setStatus(PENDING);
								}
								result = "Status Updated";
								System.out.println("The status has been updated to" + " " + course.getStatus());
								break;
							case 6:
								break outer;
							default:
								System.out.println("Invalid Choice");
						}
						System.out.println(result);
					}
				result = "Course Updated";
				flag=1;
				try {
					repo.addCourse(courses);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		if(flag!=1) {
			System.out.println("Course Not Found. Please Add course first");
			System.out.println("\n");
		}
		else {
			System.out.println(result);	
		}
		
	} 
	
	private static void createQuiz() {
		scanner.nextLine();

		System.out.println("Name the course for which you wish to create the quiz (Choose only one).");
		System.out.println("For course availabilty check the list from print option first by exit this section if you want");
		String nameCourse= scanner.nextLine();
		System.out.println("Enter your name: ");
		String nameTeacher=scanner.nextLine();
		QuizCreateRepo quizRepo= new QuizCreateRepo(nameCourse,nameTeacher);
		try {
			IGamingRepo repo= GamingRepo.getInstance();
			ArrayList<GamingDTO> courses= repo.printCourse();
			for(GamingDTO course: courses) {
				if(nameCourse.equalsIgnoreCase(course.getCourseName())) {
					// Creates a file
					QuizCreateRepo.addQuizQuestion();
					// Write questions to the file
					QuizCreateRepo.writeQuestionToFile(); 
					// Print the data entered to the file
					try {
						QuizCreateRepo.printQuizQuestion();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}catch(ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}	
	}
	public static void gameView() {
		
		outer:
			while(true) {
				System.out.println("1. Add Course");
				System.out.println("2. Delete Course");
				System.out.println("3. Print Course");
				System.out.println("4. Update Course");
				System.out.println("5. Create Quiz");
				System.out.println("6. Exit");
				System.out.println("Enter your choice");
				
				int choice=0;
				choice= scanner.nextInt();
			
				
				switch(choice) {
				case 1:
					addCourse();
					break;
				case 2:
					deleteCourse();
					break;
				case 3:
					printCourse();
					break;
				case 4:
					updateCourse();
					break;
				case 5:
					createQuiz();
					break;
				case 6:
					break outer;
				default:
					System.out.println("Invalid Choice");
				}
			}
		scanner.close();
	}		
}


