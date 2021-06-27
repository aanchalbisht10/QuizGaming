package com.navigus.gamingapp.repo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.navigus.gamingapp.dto.StudentDetailsDTO;

public interface IStudentDetailsRepo {

	public boolean addStudentDetail(ArrayList<StudentDetailsDTO> details) throws FileNotFoundException, IOException;
	public ArrayList<StudentDetailsDTO> printStudentDetail() throws FileNotFoundException, IOException, ClassNotFoundException;
}
