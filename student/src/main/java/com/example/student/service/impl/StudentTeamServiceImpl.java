package com.example.student.service.impl;

import org.springframework.stereotype.Service;

import com.example.student.data.StudentTeam;
import com.example.student.service.StudentTeamService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class StudentTeamServiceImpl implements StudentTeamService {

	@Override
	public StudentTeam getStudentTeam() {
		StudentTeam team=new StudentTeam();
		team.setName("Bulls");
		team.setSection("Nw2");
		
		return team;
	}

	@Override
	public StudentTeam getTeamDetailsByName(String name) {
		StudentTeam team=new StudentTeam();
		team.setName(name);
		team.setSection("Nw2");
		
		return team;
	}

	@Override
	public StudentTeam saveTeamDetails(StudentTeam team) {
		log.info("Student Team {}",team);
		StudentTeam teamnew=new StudentTeam();
		teamnew.setName(team.getName()+" new Player");
		teamnew.setSection(team.getSection() + "Nw2");
		
		return teamnew;
	}

}
