package com.navigus.gamingapp.repo;

import static com.navigus.gamingapp.utils.Constants.PATHS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.navigus.gamingapp.dto.StudentDetailsDTO;

public class StudentDetailsRepo implements IStudentDetailsRepo {
	
	private File file;
	private static StudentDetailsRepo studentDetailsRepo;
	
	private StudentDetailsRepo() throws IOException {
		file= new File(PATHS);
		file.createNewFile();
	}
	
	public static StudentDetailsRepo getInstance() throws IOException {
		if(studentDetailsRepo==null) {
			studentDetailsRepo=new StudentDetailsRepo();
		}
		return studentDetailsRepo;
	}
	
	@Override
	public boolean addStudentDetail(ArrayList<StudentDetailsDTO> details) throws IOException {
		
		FileOutputStream fo=null;
		ObjectOutputStream os= null;
		try {
			fo= new FileOutputStream(file);
			os= new ObjectOutputStream(fo);
			os.writeObject(details);
		}
		finally {
			if(os!=null) {
				os.close();
			}
			if(fo!=null) {
				fo.close();
			}
		}
		return true;
	}

	@Override
	public ArrayList<StudentDetailsDTO> printStudentDetail() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<StudentDetailsDTO> list= new ArrayList<>();
		try(FileInputStream fi=new FileInputStream(file)){
			try(ObjectInputStream oi=new ObjectInputStream(fi)){
				list=(ArrayList<StudentDetailsDTO>)oi.readObject();
			}
		}
		return list;
	}

}
