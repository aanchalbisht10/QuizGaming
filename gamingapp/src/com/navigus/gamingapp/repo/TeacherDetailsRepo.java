package com.navigus.gamingapp.repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.navigus.gamingapp.dto.TeacherDetailsDTO;
import static com.navigus.gamingapp.utils.Constants.PATHT;
public class TeacherDetailsRepo implements ITeacherDetailsRepo {

	private File file;
	private static TeacherDetailsRepo teacherDetailsRepo;
	
	private TeacherDetailsRepo() throws IOException {
		file= new File(PATHT);
		file.createNewFile();
	}
	
	public static TeacherDetailsRepo getInstance() throws IOException {
		if(teacherDetailsRepo==null) {
			teacherDetailsRepo=new TeacherDetailsRepo();
		}
		return teacherDetailsRepo;
	}
	
	@Override
	public boolean addTeacherDetail(ArrayList<TeacherDetailsDTO> details) throws IOException {
		
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
	public ArrayList<TeacherDetailsDTO> printTeacherDetail() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<TeacherDetailsDTO> list= new ArrayList<>();
		try(FileInputStream fi=new FileInputStream(file)){
			try(ObjectInputStream oi=new ObjectInputStream(fi)){
				list=(ArrayList<TeacherDetailsDTO>)oi.readObject();
			}
		}
		return list;
	}

}
