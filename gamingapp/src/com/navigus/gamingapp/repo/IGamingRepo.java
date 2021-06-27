package com.navigus.gamingapp.repo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.navigus.gamingapp.dto.GamingDTO;

public interface IGamingRepo {
	
	public boolean addCourse(ArrayList<GamingDTO> courses) throws IOException;
	public ArrayList<GamingDTO> printCourse() throws FileNotFoundException, IOException, ClassNotFoundException;

}
