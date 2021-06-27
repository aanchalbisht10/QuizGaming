package com.navigus.gamingapp.repo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.navigus.gamingapp.utils.Constants.PATHQ;

public class QuizCreateRepo {
	
	static String courseName;
	static String teacherName;
	
	public QuizCreateRepo(String nameCourse, String teacherName){
		this.courseName=nameCourse;
		this.teacherName=teacherName;
	}
	
	private static Scanner scanner=new Scanner(System.in);  
	private static File file= new File(PATHQ);

	public static void addQuizQuestion(){
		try {
			   
				if(file.createNewFile()) {
					System.out.println("File Created "+ file.getName());
				}else {
					System.out.println("File Already Exists");
				}	
		}catch(IOException e) {
			System.out.println("An error occured. File Not created");
			e.printStackTrace();
		}	
	}
	
	
	public static void writeQuestionToFile() {
		int marks=0;  
		try{ 
				   FileWriter fw=new FileWriter(PATHQ,true);
				   
		           System.out.println("Enter the number of questions you want to enter");
		           int noOfQuestion= scanner.nextInt();
		           fw.write("COURSE NAME: "+courseName+"\n");
		           fw.write("EDITED BY:"+teacherName+"\n");
		      
		           for(int i=0;i<noOfQuestion;i++) {
		        	   scanner.nextLine();
		        	   System.out.println("Enter question No: ");
		        	   String str=scanner.nextLine();
		        	   String strA=scanner.nextLine();
		        	   String strB=scanner.nextLine();
		        	   String strC=scanner.nextLine();
		        	   String strD=scanner.nextLine();
		        	   fw.write(str+"\n");
		        	   fw.write(strA+"\n");
		        	   fw.write(strB+"\n");
		        	   fw.write(strC+"\n");
		        	   fw.write(strD+"\n");
		        	   
		        	   System.out.println("Enter the marks for the question: ");
		        	   marks= scanner.nextInt(); 
		        	   fw.write(String.valueOf(marks)+" Points"+"\n\n");
		           }
		           
		           fw.close();     
			   
		   }  catch(Exception e){ 
				   System.out.println(e);
				 }      
	          System.out.println("Added to the file!");        
	 }    
	  
	public static void printQuizQuestion() throws IOException {
		FileReader fr= new FileReader(PATHQ);
		int i;
		while((i=fr.read())!=-1) {
			System.out.print((char)i);
		}
		fr.close();
	}

}
