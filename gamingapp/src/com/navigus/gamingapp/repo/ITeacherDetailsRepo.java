package com.navigus.gamingapp.repo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.navigus.gamingapp.dto.TeacherDetailsDTO;

public interface ITeacherDetailsRepo {

	public boolean addTeacherDetail(ArrayList<TeacherDetailsDTO> details) throws FileNotFoundException, IOException;
	public ArrayList<TeacherDetailsDTO> printTeacherDetail() throws FileNotFoundException, IOException, ClassNotFoundException;
}
 