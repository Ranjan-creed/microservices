package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.data.StudentTeam;
import com.example.student.service.StudentTeamService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team")
@Slf4j
public class StudentTeamController {

	@Autowired
	private StudentTeamService studentTeamService;

	@GetMapping(path = "getTeamDetails")
	public StudentTeam getStudentTeam() {
		return studentTeamService.getStudentTeam();
	}

	@GetMapping(path = "getTeamDetailsByName/{name}")
	public StudentTeam getTeamDetailsByName(@PathVariable String name) {
		log.info("Name ==== {}", name);
		return studentTeamService.getTeamDetailsByName(name);
	}
	
	@GetMapping(path = "getTeamDetailsByQueryName")
	public StudentTeam getTeamDetailsByQueryName(@RequestParam(name = "name",required = true) String name) {
		log.info("Name ==== {}", name);
		return studentTeamService.getTeamDetailsByName(name);
	}

}
