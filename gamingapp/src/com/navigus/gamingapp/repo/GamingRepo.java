package com.navigus.gamingapp.repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.navigus.gamingapp.dto.GamingDTO;
import static com.navigus.gamingapp.utils.Constants.PATH;

public class GamingRepo implements IGamingRepo{
	
	private File file;
	private static GamingRepo gamingRepo;
	
	private GamingRepo() throws IOException {
		file= new File(PATH);
		file.createNewFile();
	}
	public static GamingRepo getInstance() throws IOException {
		if(gamingRepo==null) {
			gamingRepo= new GamingRepo();
		}
		return gamingRepo;
	}

	@Override
	public boolean addCourse(ArrayList<GamingDTO> courses) throws IOException {
		
		FileOutputStream fo=null;
		ObjectOutputStream os=null;
		try {
			fo = new FileOutputStream(file);
			os = new ObjectOutputStream(fo);
			os.writeObject(courses);
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
	public ArrayList<GamingDTO> printCourse() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<GamingDTO> list=new ArrayList<>();
		try(FileInputStream fi= new FileInputStream(file)){
			try(ObjectInputStream oi= new ObjectInputStream(fi)){
				list= (ArrayList<GamingDTO>)oi.readObject();
			}
			
		}
		return list;
	}

}
