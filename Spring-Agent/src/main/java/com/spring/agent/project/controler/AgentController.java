package com.spring.agent.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.agent.project.service.AgentService;

@RestController
@RequestMapping("/agent")
public class AgentController {
	
	@Autowired
	private AgentService agent;

	@GetMapping("/ask")
	public ResponseEntity<?> askWeather(@RequestParam("q") String question){
		String res = "";
		try {
			res = agent.execute(question);
			return ResponseEntity.ok(res);
		}catch(Exception e) {
			return ResponseEntity.internalServerError()
					.body("Error getting weather information: " + e.getMessage());
		}
	}
}
