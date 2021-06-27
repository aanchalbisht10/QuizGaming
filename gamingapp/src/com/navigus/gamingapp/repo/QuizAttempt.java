package com.navigus.gamingapp.repo;

import static com.navigus.gamingapp.utils.Constants.PATHQ;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuizAttempt {
	
	static String studentName;
	private static Scanner scanner= new Scanner(System.in);
	File file;
	
	public static void attemptQuiz() throws IOException {
		
		System.out.println("Enter your name to start the quiz ");
		studentName= scanner.nextLine();
		
		FileReader fr= new FileReader(PATHQ);
		int i;
		while((i=fr.read())!=-1) {
			System.out.print((char)i);
		}
		fr.close();
	}
}
