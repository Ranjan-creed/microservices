package com.example.student.playerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.data.StudentTeam;
import com.example.student.service.StudentTeamService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {
	
	private final StudentTeamService studentTeamService;

	@PostMapping(path = "saveTeamDetails")
	public StudentTeam saveTeamDetails(@RequestBody(required = true) StudentTeam team)
	{
		return studentTeamService.saveTeamDetails(team);
	}
}
