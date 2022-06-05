package com.example.student.service;

import com.example.student.data.StudentTeam;

public interface StudentTeamService {
	
	StudentTeam getStudentTeam();

	StudentTeam getTeamDetailsByName(String name);

	StudentTeam saveTeamDetails(StudentTeam team);

}
